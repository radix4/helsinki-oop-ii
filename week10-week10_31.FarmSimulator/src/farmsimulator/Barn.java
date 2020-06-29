package farmsimulator;

import java.util.Collection;

public class Barn {
    private BulkTank tank;
    private MilkingRobot robot;

    public Barn(BulkTank tank) {
        this.tank = tank;
    }

    public BulkTank getBulkTank() {
        return tank;
    }

    public void installMilkingRobot(MilkingRobot robot) {
        robot.setBulkTank(tank);
        this.robot = robot;
    }

    public void takeCareOf(Cow cow) {
        if (robot == null) {
            throw new IllegalStateException("The milking robot hasn't been installed");
        }

        robot.milk(cow);
    }

    public void takeCareOf(Collection<Cow> cows) {
        for (Cow cow : cows) {
            takeCareOf(cow);
        }
    }

    @Override
    public String toString() {
        return tank.toString();
    }
}