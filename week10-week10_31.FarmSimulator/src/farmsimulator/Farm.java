package farmsimulator;

import java.util.ArrayList;
import java.util.List;

public class Farm implements Alive {

    private String owner;
    private Barn barn;
    private List<Cow> cows;

    public Farm(String owner, Barn barn) {
        this.owner = owner;
        this.barn = barn;
        this.cows = new ArrayList<Cow>();
    }

    public String getOwner() {
        return owner;
    }

    public void installMilkingRobot(MilkingRobot milkingRobot) {
        barn.installMilkingRobot(milkingRobot);
    }

    public void addCow(Cow cow) {
        cows.add(cow);
    }

    public void manageCows() {
        barn.takeCareOf(cows);
    }

    @Override
    public void liveHour() {
        for (Cow cow : cows) {
            cow.liveHour();
        }
    }

    @Override
    public String toString() {
        String output = "Farm owner: " + owner + "\nBarn bulk tank: "
                + barn.toString() + "Animals:";

        for (Cow cow : cows) {
            output += "\n        " + cow.toString();
        }

        return output;
    }
}