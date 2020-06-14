import java.util.ArrayList;
import java.util.List;

public class Jumper implements Comparable<Jumper> {

    private String name;
    private List<Jump> jumps;

    public Jumper(String name) {
        this.name = name;
        this.jumps = new ArrayList<Jump>();
    }

    public String getName() {
        return this.name;
    }

    public void addJump(Jump jump) {
        this.jumps.add(jump);
    }

    public int totalPoints() {
        int points = 0;
        for (Jump jump : this.jumps) {
            points += jump.totalPoints();
        }

        return points;
    }

    public List<Jump> getJumps() {
        return jumps;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (getClass() != object.getClass()) {
            return false;
        }

        Jumper comparable = (Jumper) object;

        if (this.name == null || !this.name.equals(comparable.getName())) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        if (this.name == null) {
            return 7;
        }

        return this.name.hashCode();
    }

    @Override
    public int compareTo(Jumper t) {
        return this.totalPoints() - t.totalPoints();
    }

    @Override
    public String toString() {
        int totalPoints = this.totalPoints();
        if (totalPoints == 1) {
            return this.name + " (" + totalPoints + " point)";
        }

        return this.name + " (" + totalPoints + " points)";
    }
}