package containers;

public class ProductContainer extends Container{
    private String name;

    public ProductContainer(String productName, double capacity) {
        super(capacity);
        this.name = productName;
    }



    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    @Override
    public String toString() {
        return this.name + ": " + super.toString();
    }
}
