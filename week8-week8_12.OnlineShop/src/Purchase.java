public class Purchase {
    private int amount;
    private int unitPrice;
    private String product;

    public Purchase(String product, int amount, int unitPrice){
        this.amount = amount;
        this.unitPrice = unitPrice;
        this.product = product;
    }

    public int price(){
        return this.amount * this.unitPrice;
    }

    public void increaseAmount(){
        this.amount++;
    }

    public String toString(){
        return product + ": " + this.amount;
    }
}
