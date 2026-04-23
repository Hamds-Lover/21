import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        List<Integer> player1 = new ArrayList<>();
        List<Integer> player2 = new ArrayList<>();
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
        player1.add(myDeck.deal());
        player2.add(myDeck.deal());
        player1.add(myDeck.deal());
        player2.add(myDeck.deal());

        //view all decks:
        System.out.println("Remaining in deck: ");
        myDeck.showDeck();
            //player1:
        System.out.println("Player1 hand:");
        System.out.println(player1);
            //player2:
        System.out.println("Player2 hand:");
        System.out.println(player2);
    }
}
