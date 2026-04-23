import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class NumberedDeck {
    // deck var and init
    private List<Integer> theDeck = new ArrayList<>();

    public NumberedDeck(){
        for (int i = 1; i<=11; i++) {
            theDeck.add(i);
        }
    }

    // methods
    public void shuffleDeck() {
        Collections.shuffle(theDeck);
    }

    public void showDeck() {
        System.out.println(theDeck);
    }

    public int deal(){
        return theDeck.remove(0);
    }

    public void resetDeck(){
        
    }
}