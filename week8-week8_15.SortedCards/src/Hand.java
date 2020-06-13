import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand implements Comparable<Hand>{
    private List<Card> cards;
    private int totalValues;

    public Hand() {
        this.cards = new ArrayList<>();
        this.totalValues = 0;
    }

    public void add(Card card) {
        if (cards.contains(card)) {
            return;
        }
        totalValues += card.getValue();
        cards.add(card);
    }

    public int getTotalValues() {
        return totalValues;
    }

    public void sort() {
        Collections.sort(cards);
    }

    public void sortAgainstSuit() {
        Collections.sort(cards, new SortAgainstSuitAndValue());
    }

    public void print() {
        for (Card c : cards) {
            System.out.println(c);
        }
    }

    @Override
    public int compareTo(Hand o) {
        return totalValues - o.getTotalValues();
    }
}
