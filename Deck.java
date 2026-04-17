import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class Deck {
    // deck var and init
    private static List<Card> theDeck = new ArrayList<>();


    // methods
    public void shuffleDeck() {
        Collections.shuffle(theDeck);
    }

    public void showDeck() {
        System.out.println(theDeck);
    }
}