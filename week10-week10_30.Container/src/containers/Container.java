package containers;

public class Container {

    private double capacity;
    private double volume;

    public Container(double capacity) { //capacity = tilavuus in finnish
        if (capacity > 0.0) {         //capacity cant be negative
            this.capacity = capacity;
        } else {
            this.capacity = 0.0;
        }

        this.volume = 0.0;
    }


    public double getVolume() { // returns volume of the product in the container
        return volume;
    }

    public double getOriginalCapacity() { //returns the original capacity of the container
        return capacity;                    // what the constructor was originally given
    }

    public double getCurrentCapacity() { // returns the remaining capacity of the container
        return capacity - volume;
    }

    public void addToTheContainer(double amount) { //add things to container
        if (amount < 0) { //if a part of that amount is fit but not whole, left over is thrown away
            return;
        }
        if (amount <= getCurrentCapacity()) {
            volume = volume + amount; // if whole fits
        } else {
            volume = capacity; // else leftover is thrown away
        }
    }

    public double takeFromTheContainer(double amount) {
        if (amount < 0) { // if you take 0 from container
            return 0.0;
        }
        if (amount > volume) { // if you take everything
            double everything = volume;
            volume = 0.0;
            return everything;
        }

        volume = volume - amount; //if you take some
        return amount;
    }

    @Override
    public String toString() {
        return "volume = " + volume + ", free space " + getCurrentCapacity();
    }
}
