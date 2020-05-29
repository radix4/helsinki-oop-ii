import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubtractClicker implements ActionListener {
    private JTextField output;
    private JTextField input;
    private JButton reset;

    public SubtractClicker(JButton reset, JTextField output, JTextField input) {
        this.output = output;
        this.input = input;
        this.reset = reset;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        result();
    }

    public void result(){ //converts to numbers
        if (!stringToNum()) {
            this.input.setText("");
            return;
        }
        int output = Integer.parseInt(this.output.getText());
        int input = Integer.parseInt(this.input.getText());
        int total = output - input;
        this.output.setText("" + total);
        this.input.setText("");

        if(this.output.getText().equals("0")){
            reset.setEnabled(false);
        } else {
            reset.setEnabled(true);
        }

    }

    public boolean stringToNum(){


        try{
            int output = Integer.parseInt(this.output.getText());
            int input = Integer.parseInt(this.input.getText());
        } catch (Exception e){
            return false;
        }

        return true;
    }


}
