package farmsimulator;

public class BulkTank {

    private double capacity;
    private double volume;

    public BulkTank() {
        this(2000);
    }

    public BulkTank(double capacity) {
        this.capacity = capacity;
        this.volume = 0;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getVolume() {
        return volume;
    }

    public double howMuchFreeSpace() {
        return capacity - volume;
    }

    public void addToTank(double amount) {
        if (volume + amount < capacity) {
            volume += amount;
        } else {
            volume = capacity;
        }
    }

    public double getFromTank(double amount) {
        if (volume - amount < 0) {
            double amountTaken = volume;
            volume = 0;

            return amountTaken;
        }

        volume -= amount;

        return amount;
    }

    @Override
    public String toString() {
        return Math.ceil(volume) + "/" + Math.ceil(capacity);
    }
}