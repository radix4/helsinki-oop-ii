package containers;

import java.util.ArrayList;
import java.util.List;

public class ContainerHistory {
    private List<Double> history;


    public ContainerHistory() {
        this.history = new ArrayList<Double>();
    }

    public double greatestFluctuation(){
        if (history.isEmpty()){
            return 0;
        }

        if (history.size() == 1){
            return 0;
        }


        double greatest = 0;
        double temp = 0;

        for (int i = 1; i < history.size(); i++){ // size is 3
            temp = Math.abs(history.get(i-1) - history.get(i));
            if (greatest <= temp){
                greatest = temp;
            }
        }

        return greatest;
    }

    public double variance(){
        double variance = 0.0;

        if (history.isEmpty()){
            return variance;
        }

        if (history.size() == 1){
            return variance;
        }

        for (double d : history){
            variance += Math.pow((average() - d), 2);
        }

        return variance / (history.size() - 1);
    }


    public double maxValue(){
        double max = history.get(0);

        for (double d : history){
            if (d >= max){
                max = d;
            }
        }
        return max;
    }

    public double minValue(){
        double min = history.get(0);

        for (double d : history){
            if (d <= min){
                min = d;
            }
        }
        return min;
    }

    public double average(){
        double average = 0;
        int counter = 0;

        for (double d : history){
            average += d;
            counter++;
        }


        return average/counter;
    }

    public void add(double situation) {
        history.add(situation);
    }

    public void reset() {
        history.clear();
    }

    @Override
    public String toString() {
        return history.toString();
    }
}
