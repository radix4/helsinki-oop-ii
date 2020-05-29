package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.domain.Apple;
import wormgame.domain.Piece;
import wormgame.domain.Worm;
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

        this.worm = new Worm(width/2,height/2,Direction.DOWN);
        createNewApple();

        addActionListener(this);
        setInitialDelay(2000);

    }


    public boolean continues() {
        return continues;
    }

    public Worm getWorm() {
        return worm;
    }

    public Apple getApple() {
        return apple;
    }

    public void setWorm(Worm worm) {
        this.worm = worm;
    }

    public void setApple(Apple apple) {
        this.apple = apple;
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

    public void createNewApple(){
        while (true) {
            this.apple = new Apple(new Random().nextInt(width), new Random().nextInt(height));
            if(!worm.runsInto(apple)){
                break;
            }
        }
    }

    public boolean runsIntoBorder(){
        for(Piece p : worm.getPieces()){
            if (p.getX() == -1 || p.getY() == -1 ||
            p.getX() == width || p.getY() == height){
                return true;
            }
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!continues) {
            return;
        }

        worm.move();

        if (worm.runsInto(apple)){
            worm.grow();
            createNewApple();
        }

        if (worm.runsIntoItself() || runsIntoBorder()){
            continues = false;
        }

        updatable.update();
        setDelay(1000/worm.getLength());
    }

}
