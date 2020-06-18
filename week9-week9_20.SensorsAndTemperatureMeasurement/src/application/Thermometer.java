package application;

import java.util.Random;

public class Thermometer implements Sensor{
    private boolean isOn;
    private int measure;

    public Thermometer() {
        this.isOn = false;
    }

    @Override
    public boolean isOn() {
        return isOn;
    }

    @Override
    public void on() {
        isOn = true;
    }

    @Override
    public void off() {
        isOn = false;
    }

    @Override
    public int measure() {
        if (isOn) {
            measure = new Random().nextInt(61) - 30;
        } else {
            throw new IllegalStateException();
        }

        return measure;
    }
}
