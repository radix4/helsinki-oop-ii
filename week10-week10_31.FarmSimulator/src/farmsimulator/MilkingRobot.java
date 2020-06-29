package farmsimulator;

public class MilkingRobot {
    private BulkTank tank = null;

    public BulkTank getBulkTank() {
        return tank;
    }

    public void setBulkTank(BulkTank tank) {
        this.tank = tank;
    }

    public void milk(Milkable milkable) {
        if (tank == null) {
            throw new IllegalStateException("The bulk tank hasn't been installed");
        }

        tank.addToTank(milkable.milk());
    }
}