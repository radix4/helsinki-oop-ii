import java.util.HashMap;
import java.util.Map;

public class PromissoryNote {
    private Map<String, Double> people;

    public PromissoryNote() {
        this.people = new HashMap<String, Double>();
    }

    public void setLoan(String toWhom, double value){
        people.put(toWhom,value);
    }

    public double howMuchIsTheDebt(String whose){
        if (people.get(whose) == null){
            return 0;
        }

        else return people.get(whose);
    }
}
