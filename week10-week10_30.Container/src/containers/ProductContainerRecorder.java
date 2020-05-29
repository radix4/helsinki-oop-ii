package containers;

public class ProductContainerRecorder extends ProductContainer{

    private ContainerHistory containerHistory = new ContainerHistory();

    public ProductContainerRecorder(String productName, double capacity, double initialVolume) {
        super(productName, capacity);
        addToTheContainer(initialVolume);
    }

    @Override
    public void addToTheContainer(double amount) {
        super.addToTheContainer(amount);
        containerHistory.add(getVolume());
    }

    @Override
    public double takeFromTheContainer(double amount) {
        containerHistory.add(getVolume() - amount);
        return super.takeFromTheContainer(amount);
    }

    public String history(){
        return containerHistory.toString();
    }

    public void printAnalysis(){
        System.out.println("Product: " + getName());
        System.out.println("History: " + history());
        System.out.println("Greatest product amount: " + containerHistory.maxValue());
        System.out.println("Smallest product amount: " + containerHistory.minValue());
        System.out.println("Average: " + containerHistory.average());
        System.out.println("Greatest change: " + containerHistory.greatestFluctuation());
        System.out.println("Variance: " + containerHistory.variance());

    }


}
