import java.util.ArrayList;

public class Suitcase {
    private int maxWeight;
    private int numberOfThings;
    private int weightInSuitcase;
    private ArrayList<Thing> things = new ArrayList<Thing>();

    public Suitcase(int maxWeight){
        this.maxWeight = maxWeight;
        this.weightInSuitcase = 0;
        this.numberOfThings = 0;
    }

    public void addThing(Thing thing){
        int totalWeight = weightInSuitcase + thing.getWeight();
        if (totalWeight > maxWeight){
            return;
        }

        numberOfThings++;
        weightInSuitcase += thing.getWeight();
        things.add(thing);
    }

    public void printThings(){
        for (Thing thing : things){
            System.out.println(thing);
        }
    }

    public int totalWeight(){
        return weightInSuitcase;
    }

    public String toString(){
        if (numberOfThings == 0){
            return "empty (0 kg)";
        }
        if (numberOfThings == 1){
            return numberOfThings + " thing (" + weightInSuitcase + " kg)";

        }
        return numberOfThings + " things (" + weightInSuitcase + " kg)";
    }
}
