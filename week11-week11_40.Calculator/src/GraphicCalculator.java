
import java.awt.*;
import javax.swing.*;

public class GraphicCalculator implements Runnable {
    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Calculator");
        frame.setPreferredSize(new Dimension(300, 150));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        frame.setLayout(new GridLayout(3, 1));
        JTextField resultField = new JTextField("0");
        container.add(resultField);
        resultField.setEnabled(false);
        JTextField inputField = new JTextField("");
        container.add(inputField);

        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        JButton reset = new JButton("Z");

        JPanel panel = new JPanel(new GridLayout(1, 3));
        panel.add(plus);
        panel.add(minus);
        panel.add(reset);
        container.add(panel);
    }

    public JFrame getFrame() {
        return frame;
    }
}
