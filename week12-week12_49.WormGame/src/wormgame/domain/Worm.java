package wormgame.domain;

import wormgame.Direction;

import java.util.ArrayList;
import java.util.List;

public class Worm {
    private int x;
    private int y;
    private Direction direction;
    private List<Piece> pieces; /* list contains all Piece instances */
    private boolean grow;


    public Worm(int originalX, int originalY, Direction originalDirection) {
        this.x = originalX;
        this.y = originalY;
        this.direction = originalDirection;
        this.grow = true;
        this.pieces = new ArrayList<Piece>();
        pieces.add(new Piece(originalX,originalY));
    }

    /* moves one piece at a time
    * --> remove one tail, add one head
    * tail index = 0 , head index = last in list */
    public void move(){
        int newX = pieces.get(pieces.size() - 1).getX();
        int newY = pieces.get(pieces.size() - 1).getY();

        if (direction == Direction.UP){
            newY--;
        } else if (direction == Direction.DOWN){
            newY++;
        } else if (direction == Direction.RIGHT){
            newX++;
        } else if (direction == Direction.LEFT){
            newX--;
        }

        if(!grow && pieces.size() >= 3){ //minimum size = 3
            pieces.remove(0);
        } else {
            grow = false; // you don't want it continue to keep growing
        }

        pieces.add(new Piece(newX,newY));

    }

    public void grow(){
        grow = true;
    }

    // checks if worm runs into apple, not just the head, even body, tail, etc.
    public boolean runsInto(Piece piece){
        for (Piece p : getPieces()){
            if (p.getX() == piece.getX() && p.getY() == piece.getY()){
                return true;
            }
        }

        return false;
    }

    public boolean runsIntoItself(){
        for (int i = 0; i < pieces.size(); i++){
            for (int j = 1; j < pieces.size(); j++){
                if(i == j){
                    continue;
                }

                if (sameSpot(pieces.get(i),pieces.get(j))){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean sameSpot(Piece p1, Piece p2){
        return p1.getX() == p2.getX() && p1.getY() == p2.getY();
    }

    // worm's length
    public int getLength(){
        return pieces.size();
    }

    // worm's all individual pieces
    public List<Piece> getPieces(){
        return pieces;
    }

    // direction which worm moves
    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

}
