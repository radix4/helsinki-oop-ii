package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {
    private List<Sensor> sensors;

    public AverageSensor() {
        sensors = new ArrayList<>();
    }

    @Override
    public boolean isOn() {
        for (Sensor s : sensors) {
            if (!s.isOn()) {
                return false;
            }
        }

        return true;
    }

    @Override
    public void on() {
        for (Sensor s : sensors) {
            s.on();
        }
    }

    @Override
    public void off() {
        for (Sensor s : sensors) {
            s.off();
        }
    }

    @Override
    public int measure() {
        if (sensors.isEmpty() || !isOn()) {
            throw new IllegalStateException();
        }

        int totalReading = 0;

        for (Sensor s : sensors) {
            totalReading += s.measure();
        }

        return totalReading / sensors.size();
    }



    public void addSensor(Sensor additional) {
        if (additional == null) {
            return;
        }

        sensors.add(additional);
    }
}
