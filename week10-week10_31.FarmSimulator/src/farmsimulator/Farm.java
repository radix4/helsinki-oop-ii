package farmsimulator;

import java.util.HashSet;
import java.util.Set;

public class Farm implements Alive {
    private String owner;
    private Barn barn;
    private Set<Cow> cows = new HashSet<Cow>();

    public Farm(String owner, Barn barn) {
        this.owner = owner;
        this.barn = barn;
    }

    public String getOwner() {
        return owner;
    }

    public void addCow(Cow cow) {
        cows.add(cow);
    }

    @Override
    public void liveHour() {
        for (Cow cow : cows) {
            cow.liveHour();
        }
    }

    public void manageCows() {
        barn.takeCareOf(cows);
    }

    public void installMilkingRobot(MilkingRobot robot) {
        barn.installMilkingRobot(robot);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Farm owner: ");
        sb.append(owner);
        sb.append("\n");

        sb.append("Barn bulk tank: ");
        sb.append(barn.getBulkTank());
        sb.append("\n");

        if (cows.isEmpty()) {
            sb.append("No cows.");
        } else {
            sb.append("Animals:\n");

            for (Cow cow : cows) {
                sb.append("        ");
                sb.append(cow);
                sb.append("\n");
            }
        }

        return sb.toString();
    }
}