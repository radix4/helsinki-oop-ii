package containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContainerHistory {

    private List<Double> history;

    public ContainerHistory() {
        history = new ArrayList<Double>();
    }

    public void add(double situation) {
        history.add(situation);
    }

    public void reset() {
        history.clear();
    }
    public double minValue() {
        return Collections.min(history);
    }

    public double maxValue() {
        return Collections.max(history);
    }

    public double average() {
        if (history.isEmpty()) {
            return 0;
        }

        double sum = 0;
        for (double situation : history) {
            sum += situation;
        }

        return sum / history.size();
    }

    public double greatestFluctuation() {
        if (history.isEmpty()) {
            return 0;
        }

        double biggest = 0;

        for (int i = 0; i < history.size() - 1; i++) {
            double previousChange = Math.abs(history.get(i) - history.get(i + 1));
            if (previousChange > biggest) {
                biggest = previousChange;
            }
        }

        return biggest;
    }

    public double variance() {
        double average = average();

        double subSquareSum = 0;
        for (double number : history) {
            double subtraction = number - average;
            double subtractionSquare = subtraction * subtraction;
            subSquareSum += subtractionSquare;
        }

        return subSquareSum / (history.size() - 1);
    }

    @Override
    public String toString() {
        return history.toString();
    }
}