import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Storehouse {

    private Map<String, Integer> products;
    private Map<String, Integer> stocks;

    public Storehouse() {
        this.products = new HashMap<String, Integer>();
        this.stocks = new HashMap<String, Integer>();
    }

    /** Add parameters into a HashMap,
     * if key doesn't exist yet. */
    public void addProduct(String product, int price, int stock){
        if (!products.containsKey(product)) {
            products.put(product, price);
            stocks.put(product, stock);
        }
    }

    /** Return price of parameter product. */
    public int price(String product) {
        if (!products.containsKey(product)){
            return -99;
        }

        return products.get(product);
    }

    /** Returns the number of stocks of parameter product. */
    public int stock(String product) {
        if (!stocks.containsKey(product)){
            return 0;
        }

        return stocks.get(product);
    }

    /** Returns true if stocks of parameter product is >= 1.
     * */
    public boolean take(String product) {
        if (!stocks.containsKey(product) || stocks.get(product) == 0){
            return false;
        }

        stocks.put(product,stocks.get(product) - 1);
        return true;
    }

    public Set<String> products(){
        return products.keySet();
    }

}
