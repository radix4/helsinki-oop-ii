package wormgame.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import wormgame.domain.Apple;
import wormgame.domain.Piece;
import wormgame.game.WormGame;

public class DrawingBoard extends JPanel implements Updatable {

    private WormGame game;
    private int side;

    public DrawingBoard(WormGame game, int pieceSideLength) {
        this.game = game;
        this.side = pieceSideLength;
    }

    @Override
    public void update() {
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        Apple o = game.getApple();
        g.fillOval(side * o.getX(), side * o.getY(), side, side);

        g.setColor(Color.BLACK);
        for (Piece p : game.getWorm().getPieces()) {
            g.fill3DRect(side * p.getX(), side * p.getY(), side, side, true);
        }

    }
}