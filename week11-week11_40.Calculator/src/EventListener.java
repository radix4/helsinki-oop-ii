import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

public class EventListener implements ActionListener {
    private JButton plus;
    private JButton minus;
    private JButton reset;
    private JTextField resultField;
    private JTextField inputField;
    private ApplicationLogic app;

    public EventListener(JButton plus, JButton minus, JButton reset, JTextField resultField, JTextField inputField) {
        this.plus = plus;
        this.minus = minus;
        this.reset = reset;
        this.resultField = resultField;
        this.inputField = inputField;
        this.app = new ApplicationLogic();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int value = 0;

        try {
            value = Integer.parseInt(inputField.getText());
        } catch (Exception e) {
        }

        if (ae.getSource() == plus) {
            app.plus(value);
        } else if (ae.getSource() == minus) {
            app.minus(value);
        } else {
            app.reset();
        }
        int result = app.result();

        inputField.setText("");
        resultField.setText("" + result);
        if (result == 0) {
            reset.setEnabled(false);
        } else {
            reset.setEnabled(true);
        }
    }

}