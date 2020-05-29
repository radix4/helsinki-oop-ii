import java.util.HashMap;
import java.util.Map;

public class ShoppingBasket {
    private Map<String, Purchase> shoppingBasket;

    public ShoppingBasket(){
        this.shoppingBasket = new HashMap<String, Purchase>();
    }
    public void add(String product, int price){
        if (this.shoppingBasket.containsKey(product)){
            this.shoppingBasket.get(product).increaseAmount();
        } else {
            this.shoppingBasket.put(product, new Purchase(product, 1, price));
        }
    }
    public int price(){
        int price = 0;
        for (Purchase purchase : this.shoppingBasket.values()){
            price += purchase.price();
        }
        return price;
    }

    public void print(){
        for (Purchase purchase : this.shoppingBasket.values()){
            System.out.println(purchase);
        }
    }
}
