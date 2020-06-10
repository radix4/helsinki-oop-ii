import java.util.HashMap;
import java.util.Map;

public class ShoppingBasket {

    private Map<String, Purchase> basket;

    public ShoppingBasket() {
        this.basket = new HashMap<String, Purchase>();
    }

    public void add(String product, int price) {
        if (basket.containsKey(product)){
            basket.get(product).increaseAmount();
            return;
        }

        Purchase purchase = new Purchase(product,1,price);
        basket.put(product,purchase);
    }

    public int price() {
        int totalPrice = 0;

        for (String p : basket.keySet()){
            totalPrice += basket.get(p).price();
        }

        return totalPrice;
    }

    public void print() {
        for (String p : basket.keySet()){
            System.out.println(basket.get(p));
        }
    }
}
