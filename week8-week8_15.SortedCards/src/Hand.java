import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Hand implements Comparable<Hand> {
    private ArrayList<Card> cards;

    public Hand(){
        this.cards = new ArrayList<Card>();
    }

    public void add(Card card){
        this.cards.add(card);
    }

    public void sort(){
        Collections.sort(this.cards);
    }

    public void print(){
        for(Card card : this.cards){
            System.out.println(card);
        }
    }

    public int totalCardValues(){
        int totalValues = 0;
        for(Card card : this.cards){
            totalValues += card.getValue();
        }
        return totalValues;
    }

    public void sortAgainstSuit(){
        Collections.sort(cards, new SortAgainstSuitAndValue());
    }

    @Override
    public int compareTo(Hand hand2) {
        return totalCardValues() - hand2.totalCardValues();
    }
}
