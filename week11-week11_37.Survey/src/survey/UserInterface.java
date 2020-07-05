package survey;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class UserInterface implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Survey");
        frame.setPreferredSize(new Dimension(200, 200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        JLabel question1 = new JLabel("Are you?");
        JCheckBox question1AnswerYes = new JCheckBox("Yes!");
        JCheckBox question1AnswerNo = new JCheckBox("No!");
        JLabel question2 = new JLabel("Why?");
        ButtonGroup question2Answers = new ButtonGroup();
        JRadioButton question2Answer1 = new JRadioButton("No reason.");
        JRadioButton question2Answer2 = new JRadioButton("Because it is fun!");

        question2Answers.add(question2Answer1);
        question2Answers.add(question2Answer2);

        JButton done = new JButton("Done!");

        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);

        container.add(question1);
        container.add(question1AnswerYes);
        container.add(question1AnswerNo);
        container.add(question2);
        container.add(question2Answer1);
        container.add(question2Answer2);
        container.add(done);
    }

    public JFrame getFrame() {
        return frame;
    }
}
