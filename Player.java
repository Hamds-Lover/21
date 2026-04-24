import java.util.List;
import java.util.ArrayList;

public class Player {
    private List<Integer> hand = new ArrayList<>();

    public void hit(NumberedDeck deck) {
        hand.add(deck.deal());
    }
//for ai debug purposes
    public void hitWin(NumberedDeck deck){
        hand.add(deck.winSU());
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

        // Visible hand for player
    public int getVisibleHandTotal() {
        int total = 0;
        for (int i = 1; i < hand.size(); i++) { // skip first card (face down)
            total += hand.get(i);
        }
        return total;
    }
}