/** This program stores people's names and nicknames into a HashMap
 * @author Thang Cao
 * @date 06/03/2020
 * */

import java.util.HashMap;
import java.util.Map;

public class Nicknames {

    public static void main(String[] args) {
        Map<String, String> people = new HashMap<String, String>();

        people.put("matti", "mage");
        people.put("mikael", "mixu");
        people.put("arto", "arppa");

        System.out.println(people.get("mikael"));
    }

}
