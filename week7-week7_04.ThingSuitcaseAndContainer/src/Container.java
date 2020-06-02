import java.util.ArrayList;
import java.util.List;

public class Container {
    private int maxWeight;
    private List<Suitcase> suitcases;

    public Container(int maxWeight) {
        this.maxWeight = maxWeight;
        this.suitcases = new ArrayList<Suitcase>();
    }

    public void addSuitcase(Suitcase suitcase){
        if(suitcase == null){
            return;
        }

        if(totalWeight() + suitcase.totalWeight() > maxWeight){
            return;
        }

        suitcases.add(suitcase);
    }

    public int totalWeight(){
        int totalWeight = 0;

        for (Suitcase s : suitcases){
            totalWeight += s.totalWeight();
        }

        return totalWeight;
    }

    public void printThings(){
        for (Suitcase s : suitcases){
            s.printThings();
        }
    }

    @Override
    public String toString() {
        return suitcases.size() + " suitcases (" + totalWeight() + " kg)";
    }
}
