package dungeon;

import java.util.Random;

public class Vampire {

    private Game game;
    private int x;
    private int y;
    private Random r = new Random();

    public Vampire(Game game, int x, int y) {
        this.game = game;
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move() {
        int direction = r.nextInt(4);
        int newX = x;
        int newY = y;

        if (direction == 0) {
            newX--;
        } else if (direction == 1) {
            newX++;
        } else if (direction == 2) {
            newY--;
        } else if (direction == 3) {
            newY++;
        }

        if (game.check(newX, newY)) {
            x = newX;
            y = newY;
        }
    }
}