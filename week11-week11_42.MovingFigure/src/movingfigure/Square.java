package movingfigure;

import java.awt.*;

public class Square extends Figure {

    private int sideLength;

    public Square(int x, int y, int sideLength) {
        super(x, y);
        this.sideLength = sideLength;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.fillRect(super.getX(),super.getY(),sideLength,sideLength);
    }
}
