package wormgame.gui;

import wormgame.Direction;
import wormgame.domain.Worm;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/** The listener class only do just that
 * which is to assign key pressed to do direction*/

public class KeyboardListener implements KeyListener {

    private Worm worm;

    public KeyboardListener(Worm worm) {
        this.worm = worm;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){
            worm.setDirection(Direction.UP);
        }else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            worm.setDirection(Direction.DOWN);
        }else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            worm.setDirection(Direction.RIGHT);
        }else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            worm.setDirection(Direction.LEFT);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
