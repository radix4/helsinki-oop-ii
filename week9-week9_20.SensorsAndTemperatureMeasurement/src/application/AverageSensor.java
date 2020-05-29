package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor{
    private List<Sensor> AverageSensors;
    private List<Integer> readings;

    public AverageSensor() {
        this.AverageSensors = new ArrayList<Sensor>();
        readings = new ArrayList<Integer>();
    }

    public void addSensor(Sensor additional){
        this.AverageSensors.add(additional);
    }

    @Override
    public boolean isOn() {
        for (Sensor sensor : this.AverageSensors){
            if(!sensor.isOn()){
                return false;
            }
        }

        return true;
    }

    @Override
    public void on() {
        for (Sensor sensor : this.AverageSensors) {
            sensor.on();
        }
    }

    @Override
    public void off() {
        for (Sensor sensor : this.AverageSensors) {
            sensor.off();
        }
    }

    @Override
    public int measure() {
        if (this.isOn() == false || this.AverageSensors.size() == 0) {
            throw new IllegalStateException();
        }
        int reading = 0;
        for (Sensor sensor : this.AverageSensors) {
            reading += sensor.measure();
        }
        reading /= this.AverageSensors.size();
        this.readings.add(reading);
        return reading;

    }

    public List<Integer> readings(){
        return readings;
    }
}
