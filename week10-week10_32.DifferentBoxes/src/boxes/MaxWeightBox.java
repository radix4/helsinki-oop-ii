package boxes;

import java.util.ArrayList;
import java.util.List;


public class MaxWeightBox extends Box{
    private int maxWeight;
    private List<Thing> things;

    public MaxWeightBox(int maxWeight) {
        this.maxWeight = maxWeight;
        this.things = new ArrayList<Thing>();
    }

    @Override
    public void add(Thing thing) { // bad coding here
        int totalWeight = 0;

        for (Thing t : things) { //use a separate method for this
            totalWeight += t.getWeight();
        }

        if(thing.getWeight() == 0){
            things.add(thing);
        }

        if (totalWeight >= maxWeight) {
            return;
        }

        things.add(thing);
    }

    @Override
    public boolean isInTheBox(Thing thing) { // bad coding
        return things.contains(thing);
    }
}
