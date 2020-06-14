import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Jump {

    private int length;
    private List<Integer> stylePoints;

    public Jump(int length, List<Integer> stylePoints) {
        this.length = length;
        this.stylePoints = stylePoints;
    }

    public int getLength() {
        return length;
    }

    public List<Integer> getStylePoints() {
        return stylePoints;
    }

    public int totalPoints() {
        int sumOfStylePoints = 0;
        for (int points : restrictedStylePoints()) {
            sumOfStylePoints += points;
        }

        return sumOfStylePoints + length;
    }

    private List<Integer> restrictedStylePoints() {
        List<Integer> restricted = new ArrayList(this.stylePoints);
        restricted.remove(Collections.max(this.stylePoints));
        restricted.remove(Collections.min(this.stylePoints));

        return restricted;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("    length: ").append(this.length).append("\n");
        sb.append("    judge votes: ").append(this.stylePoints);

        return sb.toString();
    }
}