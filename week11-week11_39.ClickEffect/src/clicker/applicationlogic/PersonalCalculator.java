package clicker.applicationlogic;

public class PersonalCalculator implements Calculator{
    private int value;

    public PersonalCalculator() {
        this.value = 0;
    }


    @Override
    public int giveValue() {
        return value;
    }

    @Override
    public void increase() {
        value++;
    }
}
