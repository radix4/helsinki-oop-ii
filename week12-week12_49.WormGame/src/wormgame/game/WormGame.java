package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.domain.Worm;
import wormgame.domain.Apple;
import wormgame.domain.Piece;
import wormgame.gui.Updatable;

public class WormGame extends Timer implements ActionListener {

    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;
    private Worm worm;
    private Apple apple;

    public WormGame(int width, int height) {
        super(1000, null);

        this.width = width;
        this.height = height;
        this.continues = true;

        addActionListener(this);
        setInitialDelay(2000);

        worm = new Worm(width / 2, height / 2, Direction.DOWN);
        newApple();
    }

    public Worm getWorm() {
        return worm;
    }

    public void setApple(Apple apple) {
        this.apple = apple;
    }

    public void setWorm(Worm worm) {
        this.worm = worm;
    }

    public Apple getApple() {
        return apple;
    }

    public boolean continues() {
        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!continues) {
            return;
        }

        worm.move();
        if (worm.runsInto(apple)) {
            worm.grow();
            newApple();
        }
        if (worm.runsIntoItself() || wormHitsBorder()) {
            continues = false;
        }

        updatable.update();
        setDelay(1000 / worm.getLength());
    }

    private void newApple() {
        while (true) {
            Random random = new Random();
            apple = new Apple(random.nextInt(width), random.nextInt(height));
            if (!worm.runsInto(apple)) {
                break;
            }
        }
    }

    private boolean wormHitsBorder() {
        for (Piece p : worm.getPieces()) {
            if (p.getY() == height || p.getX() == width || p.getX() == -1 || p.getY() == -1) {
                return true;
            }
        }
        return false;
    }
}