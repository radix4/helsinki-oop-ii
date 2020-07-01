package dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    private int length;
    private int height;
    private boolean vampiresMove;
    private List<Vampire> vampires = new ArrayList<Vampire>();
    private Player player;
    private boolean end;

    public Game(int length, int height, int numberOfVampires, int moves, boolean vampiresMove) {
        this.length = length;
        this.height = height;

        Random r = new Random();

        for (int i = 0; i < numberOfVampires; i++) {
            int x = r.nextInt(length);
            int y = r.nextInt(height);
            vampires.add(new Vampire(this, x, y));
        }

        this.player = new Player(this, 0, 0, moves);

        this.vampiresMove = vampiresMove;
    }

    public String situation() {
        StringBuilder sb = new StringBuilder();

        playerAndVampiresSituation(sb);
        createDungeon(sb);

        return sb.toString();
    }

    private void playerAndVampiresSituation(StringBuilder sb) {
        sb.append(player.numberOfMoves()).append("\n\n");
        sb.append("@ ").append(player.getX()).append(" ").append(player.getY()).append("\n");
        for (Vampire v : vampires) {
            sb.append("v ").append(v.getX()).append(" ").append(v.getY()).append("\n");
        }
        sb.append("\n");
    }

    private void createDungeon(StringBuilder sb) {
        char[][] dungeon = new char[height][length];

        for (int x = 0; x < length; x++) {
            for (int y = 0; y < height; y++) {
                dungeon[y][x] = '.';
            }
        }

        for (Vampire v : vampires) {
            dungeon[v.getY()][v.getX()] = 'v';
        }

        dungeon[player.getY()][player.getX()] = '@';

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < length; x++) {
                sb.append(dungeon[y][x]);
            }
            sb.append("\n");
        }
    }

    public void execute(String command) {
        for (char c : command.toCharArray()) {
            player.execute(c);
            killVampires();
            if (vampiresMove) {
                for (Vampire h : vampires) {
                    h.move();
                }
            }
            killVampires();
        }
        player.move();
        if (player.zeroMovesLeft() || vampires.isEmpty()) {
            end = true;
        }
    }

    public boolean finished() {
        return end;
    }

    public boolean didThePlayerWin() {
        return vampires.isEmpty();
    }

    boolean check(int newx, int newy) {
        return newx < length && newx >= 0 &&
                newy < height && newy >= 0;
    }

    private void killVampires() {
        List<Vampire> deadVampires = new ArrayList<Vampire>();
        for (Vampire v : vampires) {
            if (v.getX() == player.getX() && v.getY() == player.getY()) {
                deadVampires.add(v);
            }
        }
        vampires.removeAll(deadVampires);
    }
}