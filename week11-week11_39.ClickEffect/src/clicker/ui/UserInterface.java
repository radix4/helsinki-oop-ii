package clicker.ui;

import clicker.applicationlogic.Calculator;

import java.awt.*;
import javax.swing.*;

public class UserInterface implements Runnable {
    private JFrame frame;
    private Calculator calculator;

    public UserInterface(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void run() {
        frame = new JFrame("Click Effect");
        frame.setPreferredSize(new Dimension(200, 100));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(2,1);
        container.setLayout(layout);

        JLabel label = new JLabel("0");
        JButton click = new JButton("Click!");

        ClickListener clickMe = new ClickListener(calculator,label);

        click.addActionListener(clickMe);

        container.add(label);
        container.add(click);


    }

    public JFrame getFrame() {
        return frame;
    }
}
