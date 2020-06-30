package boxes;

import java.util.ArrayList;

public class MaxWeightBox extends Box {

    private int maxWeight;
    private ArrayList<Thing> things;
    private int totalWeight;

    public MaxWeightBox(int maxWeight) {
        if (maxWeight < 0) {
            throw new IllegalArgumentException("Weight can't be negative.");
        }

        this.maxWeight = maxWeight;
        this.things = new ArrayList<>();
        this.totalWeight = 0;
    }

    @Override
    public void add(Thing thing) {
        if (totalWeight + thing.getWeight() <= maxWeight) {
            things.add(thing);
        }

        totalWeight += thing.getWeight();
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return things.contains(thing);
    }
}
