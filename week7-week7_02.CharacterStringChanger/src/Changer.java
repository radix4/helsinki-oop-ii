import java.util.ArrayList;

public class Changer{
    private ArrayList<Change> objArray;

    public Changer() {
        this.objArray = new ArrayList<Change>();
    }

    public void addChange(Change change){
        objArray.add(change);
    }

    public String change(String word){
        String changedWord = word;
        for (Change dummy : objArray){
            changedWord = dummy.change(changedWord);
        }
        
        return changedWord;
    }


}