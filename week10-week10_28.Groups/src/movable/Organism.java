package movable;

public class Organism implements Movable {

    private int x;
    private int y;

    public Organism(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    @Override
    public void move(int dx, int dy) {
        // changes the coordinates
        this.x += dx;
        this.y += dy;
    }

    @Override
    public String toString() {
        return "x: " + this.x + "; y: " + this.y;
    }
}