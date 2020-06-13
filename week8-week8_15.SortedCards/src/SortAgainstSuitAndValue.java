import java.util.Comparator;

public class SortAgainstSuitAndValue implements Comparator<Card> {
    @Override
    public int compare(Card k1, Card k2) {
        if (k1.getSuit() == k2.getSuit()) {
            return k1.getValue() - k2.getValue();
        }

        return k1.getSuit() - k2.getSuit();
    }
}
