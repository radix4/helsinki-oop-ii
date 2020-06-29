package farmsimulator;

public class BulkTank {
    private double capacity;
    private double volume = 0;

    public BulkTank() {
        this(2000);
    }

    public BulkTank(double capacity) {
        this.capacity = capacity;
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
        double newVolume = volume + amount;
        if (newVolume > capacity) {
            newVolume = capacity;
        }
        volume = newVolume;
    }

    public double getFromTank(double amount) {
        double takenAmount = amount;
        if (takenAmount > volume) {
            takenAmount = volume;
        }
        volume -= takenAmount;
        return takenAmount;
    }

    @Override
    public String toString() {
        return Math.ceil(volume) + "/" + Math.ceil(capacity);
    }
}