/**
 * This program puts things into boxes, then boxes into packers in an efficient way.
 * @author  Thang Cao
 * @since   06/16/2020
 * */

package moving;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Thing item = new Item("toothbrash", 2);
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("passport", 2));
        items.add(new Item("toothbrash", 1));
        items.add(new Item("circular saw", 100));

        Collections.sort(items);
        System.out.println(items);
    }
}
