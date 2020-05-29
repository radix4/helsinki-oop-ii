import java.util.ArrayList;

public class Calculator {
    private Reader reader;
    private int numOfCalculations;

    public Calculator() {
        this.reader = new Reader();
        this.numOfCalculations = 0;
    }


    public void start(){
        while (true) {
            System.out.print("Command: ");
            String command = reader.readString();

            if (command.equals("end")) {
                break;
            }

            if (command.equals("sum")) {
                sum();
            } else if (command.equals("difference")) {
                difference();
            } else if (command.equals("product")) {
                product();
            }

        }
        statistics();
    }

    private boolean rightCommand(String command){

        if (!command.equals("sum") &&
                !command.equals("difference") &&
                !command.equals("product")){
            return false;
        }
        return true;
    }

    private void sum(){
        int[] values = getValues();
        System.out.println("Sum: "+ (values[0] + values[1]) );
        this.numOfCalculations++;
    }

    private void difference(){
        System.out.print("Value 1: ");
        int value1 = reader.readInteger();
        System.out.print("Value 2: ");
        int value2 = reader.readInteger();
        System.out.println("Difference: " + (value1-value2));
        this.numOfCalculations++;
    }

    private void product(){
        System.out.print("Value 1: ");
        int value1 = reader.readInteger();
        System.out.print("Value 2: ");
        int value2 = reader.readInteger();
        System.out.println("Product: " + (value1*value2));
        this.numOfCalculations++;
    }

    private void statistics(){
        System.out.println("Calculations done " + numOfCalculations);

    }

    private int[] getValues(){
        int[] values = {0,0};
        System.out.print("Value 1: ");
        values[0] = reader.readInteger();
        System.out.print("Value 2: ");
        values[1] = reader.readInteger();
        return values;
    }
}
