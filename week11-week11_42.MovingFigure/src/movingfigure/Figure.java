package movingfigure;

import java.awt.Graphics;

public abstract class Figure {

    private int x;
    private int y;

    public Figure(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(int dx, int dy) {
        this.x = this.x + dx;
        this.y = this.y + dy;
    }

    public abstract void draw(Graphics graphics);
}