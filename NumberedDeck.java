import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class NumberedDeck {
    private List<Integer> theDeck = new ArrayList<>();

    public NumberedDeck() {
        resetDeck();
    }

    public void shuffleDeck() {
        Collections.shuffle(theDeck);
    }

    public void showDeck() {
        System.out.println(theDeck);
    }

    public int deal() {
        if (theDeck.isEmpty()) {
            System.out.println("Deck empty! Resetting...");
            resetDeck();
        }
        return theDeck.remove(0);
    }

    public void resetDeck() {
        theDeck.clear();
        for (int i = 1; i <= 11; i++) {
            theDeck.add(i);
        }
        shuffleDeck();
    }

    public boolean isEmpty() {
        return theDeck.isEmpty();
    }
}