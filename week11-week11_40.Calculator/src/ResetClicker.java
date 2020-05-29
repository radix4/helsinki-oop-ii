import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetClicker implements ActionListener {
    private JTextField output;
    private JTextField input;
    private JButton reset;


    public ResetClicker(JButton reset, JTextField output, JTextField input) {
        this.output = output;
        this.input = input;
        this.reset = reset;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        reset();
    }

    public void reset(){
        if(!stringToNum()){
            this.input.setText("");
            return;
        }

        this.output.setText("0");
        this.input.setText("");

        reset.setEnabled(false);
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
