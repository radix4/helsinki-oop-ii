package clicker.applicationlogic;


public class PersonalCalculator implements Calculator {
    private int x;

    public PersonalCalculator() {
        x = 0;
    }

    @Override
    public int giveValue() {
        return x;
    }

    @Override
    public void increase() {
        x++;
    }
}
