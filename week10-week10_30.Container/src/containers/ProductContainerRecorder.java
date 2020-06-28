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

}