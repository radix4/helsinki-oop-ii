package wormgame.domain;

import wormgame.Direction;

import java.util.ArrayList;
import java.util.List;

public class Worm {
    private int x; // coordinates of the worm on the board
    private int y;
    private Direction direction;
    private List<Piece> pieces; // a list of instances of class Piece
    private boolean grow;

    public Worm(int originalX, int originalY, Direction originalDirection) {
        this.x = originalX;
        this.y = originalY;
        this.direction = originalDirection;
        this.pieces = new ArrayList<Piece>();
        this.pieces.add(new Piece(originalX, originalY)); // initial worm piece (the head)

    }

    /* moves the worm one piece forward */
    public void move(){
        int newX = pieces.get(pieces.size() -1).getX();
        int newY = pieces.get(pieces.size() -1).getY();

        if(getDirection() == Direction.UP){
            newY--;
        } else if (getDirection() == Direction.DOWN){
            newY++;
        } else if (getDirection() == Direction.LEFT) {
            newX--;
        } else if (getDirection() == Direction.RIGHT) {
            newX++;
        }


        /* if there are at least 3 pieces already and not growing
        * if the worm grows, do not remove the tail*/
        if (getLength() > 2 && !grow) {
            pieces.remove(0);
        } else {
            grow = false;
        }

        pieces.add(new Piece(newX, newY));
    }

    /* grows the worm by one piece
    * worm grows together with the following move method call
    * after the first move method, worm does not grow anymore*/
    public void grow(){
        grow = true;
    }

    /* checks if worm runs into parameter piece (apple) */
    public boolean runsInto(Piece piece){
        for (Piece p : pieces){
            if(p.getX() == piece.getX() && p.getY() == piece.getY()){
                return true;
            }
        }
        return false;
    }

    /* checks if worm runs into itself
    * true if yes, else false */
    public boolean runsIntoItself(){
        for (int i = 0; i < getLength(); i++){
            for (int j = i +1; j < getLength(); j++){
                if(sameSpot(pieces.get(i),pieces.get(j))){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean sameSpot(Piece p1, Piece p2){
        return p1.getX() == p2.getX() && p1.getY() == p2.getY();
    }

    // return a list of Piece instances
    public List<Piece> getPieces() {
        return pieces;
    }

    /* returns the length(number of pieces) of the worm */
    public int getLength(){
        return pieces.size();
    }

    // classic getter
    public Direction getDirection() {
        return direction;
    }

    /*set a new direction each time method move() is called */
    public void setDirection(Direction dir) {
        this.direction = dir;
    }
}
