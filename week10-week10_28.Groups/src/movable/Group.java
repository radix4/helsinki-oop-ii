package movable;


import java.util.ArrayList;
import java.util.List;

public class Group implements Movable{
    private List<Movable> group;

    public Group() {
        this.group = new ArrayList<Movable>();
    }

    public void addToGroup(Movable movable){
        if(movable != null){
            this.group.add(movable);
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (Movable movable : this.group){
            sb.append(movable.toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public void move(int dx, int dy) {
        for (Movable move : this.group){
            move.move(dx,dy);
        }
    }
}
