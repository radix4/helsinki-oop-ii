
import java.awt.*;
import javax.swing.*;

public class GraphicCalculator implements Runnable {
    private JFrame frame;
    private JTextField output;
    private JTextField input;
    private JButton addButt;
    private JButton subtractButt;
    private JButton resetButt;


    @Override
    public void run() {
        frame = new JFrame("Calculator");
        frame.setPreferredSize(new Dimension(400,400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);


    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(3,1);
        container.setLayout(layout);

        output = new JTextField("0");
        input = new JTextField();
        output.setEnabled(false);

        container.add(output);
        container.add(input);
        container.add(panel());
    }

    private JPanel panel(){
        JPanel panel = new JPanel(new GridLayout(1,3));

        addButt = new JButton("+");
        subtractButt = new JButton("-");
        resetButt = new JButton("Z");

        AddClicker add = new AddClicker(resetButt,output,input);
        SubtractClicker subtract = new SubtractClicker(resetButt,output,input);
        ResetClicker reset = new ResetClicker(resetButt,output,input);

        addButt.addActionListener(add);
        subtractButt.addActionListener(subtract);
        resetButt.addActionListener(reset);

        resetButt.setEnabled(false);


        panel.add(addButt);
        panel.add(subtractButt);
        panel.add(resetButt);

        return panel;
    }

    private boolean isOutputZero(){
        return output.getText().equals("0");
    }

    public JFrame getFrame() {
        return frame;
    }
}
