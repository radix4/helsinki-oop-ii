import java.util.ArrayList;
import java.util.List;

public class Box implements ToBeStored{
    private double maxWeight;
    private List<ToBeStored> things;
    private int numOfThings;

    public Box(double maxWeight) {
        things = new ArrayList<ToBeStored>();
        this.maxWeight = maxWeight;
        numOfThings = 0;
    }

    public void add(ToBeStored thing){
        if (thing.weight() + totalWeight() > maxWeight){
            return;
        }

        things.add(thing);
        numOfThings++;
    }

    public double totalWeight(){
        double totalWeight = 0;
        for (ToBeStored thing : things){
            totalWeight += thing.weight();
        }

        return totalWeight;
    }

    @Override
    public String toString() {
        return "Box: " + numOfThings + " things, total weight " + totalWeight() + " kg";
    }

    @Override
    public double weight() {
        return totalWeight();
    }
}
