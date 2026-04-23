import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Player player1 = new Player();
        Player player2 = new Player();
        // Create an instance of the Deck class
        NumberedDeck myDeck = new NumberedDeck();

        // 1. Show the initial deck (populated by the static block)
        System.out.print("Initial Deck: ");
        myDeck.showDeck();

        // 2. Shuffle the deck
        System.out.println("Shuffling...");
        myDeck.shuffleDeck();

        // 3. Show the deck again to see the changes
        System.out.print("Shuffled Deck: ");
        myDeck.showDeck();

        //Deal for player 1 and 2 alternatingly:
        player1.hit(myDeck);
        player2.hit(myDeck);
        player1.hit(myDeck);
        player2.hit(myDeck);

        //view all decks:
        System.out.println("Remaining in deck: ");
        myDeck.showDeck();
            //player1:
        System.out.println("Player1 hand:");
        player1.viewHand();
            //player2:
        System.out.println("Player2 hand:");
        player2.viewHand();
    }
}
