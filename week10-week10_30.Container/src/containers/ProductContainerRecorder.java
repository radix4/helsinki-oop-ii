package containers;

public class ProductContainerRecorder extends ProductContainer {

    private ContainerHistory history;

    public ProductContainerRecorder(String name, double capacity, double initialVolume) {
        super(name, capacity);
        history = new ContainerHistory();
        addToTheContainer(initialVolume);
    }

    public String history() {
        return history.toString();
    }

    @Override
    public void addToTheContainer(double amount) {
        super.addToTheContainer(amount);
        history.add(getVolume());
    }

    @Override
    public double takeFromTheContainer(double amount) {
        double value = super.takeFromTheContainer(amount);
        history.add(getVolume());
        return value;
    }
}