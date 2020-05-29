package movingfigure;

import java.awt.*;

public class Circle extends Figure { //extends = inherits, implements = interface

    private int diameter;


    public Circle(int x, int y, int diameter) {
        super(x, y); //parent class
        this.diameter = diameter;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.fillOval(super.getX(),super.getY(),diameter,diameter);
    }
}
