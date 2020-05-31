import java.util.ArrayList;
import java.util.List;

public class Changer {
    private List<Change> changes;

    public Changer() {
        this.changes = new ArrayList<Change>();
    }

    public void addChange(Change change){
        changes.add(change);
    }

    public String change(String characterString){

        for (Change c : changes){
             characterString = c.change(characterString);
        }

        return characterString;
    }
}
