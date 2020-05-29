package wormgame.gui;

import wormgame.domain.Apple;
import wormgame.domain.Piece;
import wormgame.domain.Worm;
import wormgame.game.WormGame;

import javax.swing.*;
import java.awt.*;

public class DrawingBoard extends JPanel implements Updatable{
    private WormGame wormGame;
    private int pieceLength;


    public DrawingBoard(WormGame wormGame, int pieceLength) {
        this.wormGame = wormGame;
        this.pieceLength = pieceLength;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.red);
        Apple apple = wormGame.getApple();
        g.fillOval(pieceLength * apple.getX(),pieceLength * apple.getY(),pieceLength,pieceLength);

        g.setColor(Color.BLACK);
        for(Piece p : wormGame.getWorm().getPieces()){
            g.fill3DRect(pieceLength * p.getX(),pieceLength * p.getY(),pieceLength, pieceLength,true);
        }
    }

    @Override
    public void update() {
        repaint();
    }
}
