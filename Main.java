public class Main {
    public static void main(String[] args) {
        // Create an instance of the Deck class
        Deck myDeck = new Deck();

        // 1. Show the initial deck (populated by the static block)
        System.out.print("Initial Deck: ");
        myDeck.showDeck();

        // 2. Shuffle the deck
        System.out.println("Shuffling...");
        myDeck.shuffleDeck();

        // 3. Show the deck again to see the changes
        System.out.print("Shuffled Deck: ");
        myDeck.showDeck();
    }
}
