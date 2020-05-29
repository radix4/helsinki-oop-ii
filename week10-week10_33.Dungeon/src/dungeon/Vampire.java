package dungeon;

import java.util.Random;

public class Vampire{
    private int x;
    private int y;
    private Game game;
    private Random random;

    public Vampire(int x, int y, Game game) {
        this.x = x;
        this.y = y;
        this.game = game;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(){ //vampires' moves are random
        int newX = x;
        int newY = y;

        int randomNum = random.nextInt(4); // 0 to 3

        if(randomNum == 0){
            newX++;
        }else if(randomNum == 1){
            newX--;
        }else if(randomNum == 2){
            newY++;
        }else {
            newY--;
        }

        if(game.isMoveLegal(newX,newY)){
            x = newX;
            y = newY;
        }

    }
}