import java.util.HashMap;

public class PromissoryNote {

    private HashMap<String, Double> promissoryNotes;

    public PromissoryNote(){
        this.promissoryNotes = new HashMap<String, Double>();
    }

    public void setLoan(String toWhom, double value){
        promissoryNotes.put( toWhom, value );
    }

    public double howMuchIsTheDebt(String whose){
        if(promissoryNotes.containsKey(whose)){
            return promissoryNotes.get(whose);
        }

        return 0; // to avoid error because of null
    }
}
