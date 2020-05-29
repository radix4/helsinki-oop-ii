package farmsimulator;

import java.util.Collection;

public class Barn {

    private BulkTank tank;
    private MilkingRobot milkingRobot;

    public Barn(BulkTank tank) {
        this.tank = tank;
    }

    public BulkTank getBulkTank() {
        return tank;
    }

    public void installMilkingRobot(MilkingRobot milkingRobot) {
        this.milkingRobot = milkingRobot;

        milkingRobot.setBulkTank(tank);
    }

    public void takeCareOf(Cow cow) {
        if (milkingRobot == null) {
            throw new IllegalStateException("Milking robot not installed.");
        }

        milkingRobot.milk(cow);
    }

    public void takeCareOf(Collection<Cow> cows) {
        if (milkingRobot == null) {
            throw new IllegalStateException("Milking robot not installed.");
        }

        for (Cow c : cows) {
            milkingRobot.milk(c);
        }
    }

    @Override
    public String toString() {
        return tank.toString();
    }
}