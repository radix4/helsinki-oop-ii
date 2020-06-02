import java.util.ArrayList;
import java.util.List;

public class Suitcase {
    private List<Thing> things;
    private int maxWeight;

    public Suitcase(int maxWeight) {
        this.maxWeight = maxWeight;
        this.things = new ArrayList<Thing>();
    }

    public Thing heaviestThing(){
        if (things.isEmpty()){
            return null;
        }

        Thing heaviest = things.get(0);

        for (Thing thing : things){
            if (thing.getWeight() > heaviest.getWeight()){
                heaviest = thing;
            }
        }
        return heaviest;
    }

    public void addThing(Thing thing){
        if (thing == null){
            return;
        }

        if (totalWeight() + thing.getWeight() > maxWeight){
            return;
        }

        this.things.add(thing);
    }

    public int totalWeight(){
        int totalWeight = 0;

        for(Thing thing : things){
            totalWeight += thing.getWeight();
        }

        return totalWeight;
    }

    public void printThings(){
        for (Thing thing : things){
            System.out.println(thing);
        }
    }

    @Override
    public String toString() {
        if (things.size() == 0){
            return "empty (0 kg)";
        }

        if (things.size() == 1){
            return "1 thing (" + totalWeight() + " kg)";
        }

        return things.size() + " things (" + totalWeight() + " kg)";
    }
}