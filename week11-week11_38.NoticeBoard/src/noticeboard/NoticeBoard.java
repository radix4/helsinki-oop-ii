package noticeboard;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class NoticeBoard implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Notice Board");
        frame.setPreferredSize(new Dimension(400,400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane()); //getConTentPane is an container object

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(3,1); // this one lays out the board
        container.setLayout(layout);

        JTextField text1 = new JTextField("To be copied and erased! ;(");
        JButton copy = new JButton("Copy!");
        JLabel text2 = new JLabel();

        ActionListener action = new ActionEventListener(text1,text2);
        copy.addActionListener(action); // calling using JButton object to listener


        container.add(text1);
        container.add(copy);
        container.add(text2);

    }
}