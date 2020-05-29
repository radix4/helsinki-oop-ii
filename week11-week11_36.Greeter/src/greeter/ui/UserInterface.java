package greeter.ui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class UserInterface implements Runnable {

    private JFrame frame; // never initiate an an object here

    @Override
    public void run() {
        frame = new JFrame("Swing on"); // 1
        frame.setPreferredSize(new Dimension(400,200)); // set PreferredSize takes Dimension object
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane()); // getContentPane returns a Container object
        frame.pack(); //else the frame doesn't show up
        frame.setVisible(true); // show frame to the user
    }

    private void createComponents(Container container) {
        JLabel text = new JLabel("Hi!");
        container.add(text); // container is some kind of list
    }

    public JFrame getFrame() {
        return frame;
    }
}
