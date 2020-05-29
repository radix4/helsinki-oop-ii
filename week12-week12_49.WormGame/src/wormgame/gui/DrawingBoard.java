package wormgame.gui;


import wormgame.domain.Apple;
import wormgame.domain.Piece;
import wormgame.domain.Worm;
import wormgame.game.WormGame;

import javax.swing.*;
import java.awt.*;

/** DrawingBoard class inherits JPanel
 * which allows to override paintComponent
 * paintComponent paints*/


public class DrawingBoard extends JPanel implements Updatable{

    private WormGame game;
    private int side; //dimensions of the pieces

    public DrawingBoard(WormGame game, int pieceLength) {
        this.game = game;
        this.side = pieceLength;
    }


    /* paints the apple and the worm separately*/
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.RED);
        Apple apple = game.getApple();
        g.fillOval(apple.getX() * side,apple.getY() * side, side, side);

        g.setColor(Color.BLACK);
        for(Piece p : game.getWorm().getPieces()){
            g.fill3DRect(p.getX() * side,p.getY() * side,side,side,true);
        }
    }

    @Override
    public void update() {
        repaint();
    }
}
