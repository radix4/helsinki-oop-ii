package dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game{
    private int length; //x
    private int height; //y
    private int numberOfVampires;
    private Player player;
    private List<Vampire> vampires;
    private boolean end;
    private boolean vampireMove;

    public Game(int length, int height, int numberOfVampires, int moves, boolean vampiresMove) {
        this.length = length;
        this.height = height;
        this.numberOfVampires = numberOfVampires;
        this.vampires = new ArrayList<Vampire>();
        this.player = new Player(0,0,this,moves);
        this.vampireMove = vampiresMove;

        addVampire();
    }

    public void start(StringBuffer sb){
        char[][] map = new char[height][length]; //first block is y, second is x

        for (int y = 0; y < height; y++){
            for (int x = 0; x < length; x++){
                map[y][x] = '.';
            }
        }

        for(Vampire v : vampires){
            map[v.getY()][v.getX()] = 'v';
        }


        map[player.getY()][player.getX()] = '@'; // player

        for (int y = 0; y < height; y++){ //reverse it to convert to string
            for (int x = 0; x < length; x++){ // add all the y to the list
                sb.append(map[y][x]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public void addVampire(){

        Random r = new Random();
        for (int i = 0; i < numberOfVampires; i++) {
            int x = r.nextInt(length);
            int y = r.nextInt(height);

            this.vampires.add(new Vampire(x,y,this));
        }
    }

    public boolean isMoveLegal(int newX, int newY){
        return (newX <= length) && (newX > 0)
                && (newY <= height && (newY > 0));
    }

    public boolean finished(){
        return end;
    }

    public boolean didThePlayerWin(){
        return vampires.isEmpty();
    }

    public void killVampires(){
        List<Vampire> deadVampires = new ArrayList<Vampire>();

        for(Vampire v : vampires){
            if (player.getX() == v.getX()
            && player.getY() == v.getY()){
                deadVampires.add(v);
            }
        }

        vampires.removeAll(deadVampires);
    }

    public void execute(String command){
        for (char c : command.toCharArray()){
            player.execute(c);
            killVampires();
            if(vampireMove){
                for (Vampire v : vampires){
                    v.move();
                }
            }
            killVampires();
        }
        player.move();
        if(player.zeroMovesLeft() || vampires.isEmpty()){
            end = true;
        }
    }

    public String situation(){
        StringBuffer sb = new StringBuffer();

        playerAndVampiresSituation(sb);
        start(sb);

        return sb.toString();

    }

    public void playerAndVampiresSituation(StringBuffer sb){
        sb.append(player.getMoves()).append("\n\n");
        sb.append("@ ").append(player.getX()).append(" ").append(player.getY()).append("\n");
        for (Vampire v : vampires) {
            sb.append("v ").append(v.getX()).append(" ").append(v.getY()).append("\n");
        }
        sb.append("\n");
    }
}




