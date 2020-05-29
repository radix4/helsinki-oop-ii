package movingfigure;


import java.awt.*;
import javax.swing.JPanel;

public class DrawingBoard extends JPanel {

    private Figure figure;

    public DrawingBoard(Figure figure) {
        super.setBackground(Color.PINK);
        this.figure = figure;
    }

    @Override
    protected void paintComponent(Graphics g) { //JComponent, public is container
        super.paintComponent(g);
        figure.draw(g);
    }

}
