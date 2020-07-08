package clicker.ui;

import clicker.applicationlogic.Calculator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class ClickListener implements ActionListener {

    private Calculator calculator;
    private JLabel text;

    public ClickListener(Calculator calculator, JLabel text) {
        this.calculator = calculator;
        this.text = text;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        this.calculator.increase();
        this.text.setText("" + calculator.giveValue());
    }
}