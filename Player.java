import java.util.List;
import java.util.ArrayList;

public class Player {
    private List<Integer> hand = new ArrayList<>();

    public void hit(NumberedDeck deck) {
        hand.add(deck.deal());
    }

    public int calcHandVal() {
        int handVal = 0;
        for (int card : hand) {
            handVal += card;
        }
        return handVal;
    }

    public void viewHand() {
        System.out.println(hand);
    }

    public void showHiddenHand() {  // renamed from showNotFrst
        List<Integer> temp = new ArrayList<>();
        for (int i = 1; i < hand.size(); i++) {
            temp.add(hand.get(i));
        }
        System.out.println(temp);
    }

    public void clearHand() {
        hand.clear();
    }
}