package wormgame.domain;

public class Piece {
    private int x;
    private int y;

    public Piece(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean runsInto(Piece piece){
        return x == piece.getX() && y == piece.getY();
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
