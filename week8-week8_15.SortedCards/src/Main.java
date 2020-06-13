import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** This program sorts a deck of card against different criteria.
 * @author  Thang Cao
 * @since   06/13/2020
 * */

public class Main {

    public static void main(String[] args) {
        Hand hand = new Hand();

        hand.add( new Card(12, Card.HEARTS) );
        hand.add( new Card(4, Card.CLUBS) );
        hand.add( new Card(2, Card.DIAMONDS) );
        hand.add( new Card(14, Card.CLUBS) );
        hand.add( new Card(7, Card.HEARTS) );
        hand.add( new Card(2, Card.CLUBS) );

        hand.sortAgainstSuit();

        hand.print();
    }
}
