package application;

import java.util.Random;

public class Thermometer implements Sensor{
    private Random random;
    private boolean power;

    public Thermometer() {
        this.random = new Random();
        this.power = false;
    }

    @Override
    public boolean isOn() {
        return power;
    }

    @Override
    public void on() {
        power = true;
    }

    @Override
    public void off() {
        power = false;
    }

    @Override
    public int measure() {
        if (this.power = true) {
            return this.random.nextInt(61) - 30;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
