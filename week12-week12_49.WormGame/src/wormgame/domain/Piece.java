package wormgame.domain;

public class Piece { // this is a super class
    private int x;
    private int y;

    public Piece(int x, int y) { //coordinates on the frame
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean runsInto(Piece piece){ // interesting, calling its own
        return x == piece.getX() && y == piece.getY();
    }

    @Override
    public String toString() {
        return "(" + getX() + "," + getY() + ")";
    }
}
