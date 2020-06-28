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

    @Override
    public String toString() {
        return history.toString();
    }
}