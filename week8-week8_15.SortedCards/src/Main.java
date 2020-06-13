import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** This program
 * @author  Thang Cao
 * @since   06/13/2020
 * */

public class Main {

    public static void main(String[] args) {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(7,1));
        cards.add(new Card(6,2));
        cards.add(new Card(5,3));

        Collections.sort(cards);

        System.out.println(cards);
    }
}
