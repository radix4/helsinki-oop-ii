package noticeboard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ActionEventListener implements ActionListener {

    private JTextField text1;
    private JLabel text2;

    public ActionEventListener(JTextField text1, JLabel text2) {
        this.text1 = text1;
        this.text2 = text2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        text2.setText(text1.getText());
        text1.setText("");
    }
}