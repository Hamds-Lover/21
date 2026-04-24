import java.util.Scanner;

public class Game {
    private NumberedDeck myDeck = new NumberedDeck();
    private Player p1 = new Player();
    private Player cpu = new Player();
    private final int CPU_STAND_THRESHOLD = 17;

    public void playGame() {
        myDeck.resetDeck();  // ensures fresh deck
        p1.clearHand();
        cpu.clearHand();

        myDeck.shuffleDeck();
        p1.hit(myDeck);
        cpu.hit(myDeck);
        p1.hit(myDeck);
        cpu.hit(myDeck);

        Scanner myChoice = new Scanner(System.in);
        boolean playerTurn = true;

        // Player's turn
        while (playerTurn) {
            System.out.print("CPU hand: ");
            cpu.showHiddenHand();
            p1.viewHand();
            System.out.println("Your hand value: " + p1.calcHandVal());
            System.out.println("1 - Hit");
            System.out.println("2 - Stand");
            System.out.print("Enter choice: ");
            int choice = myChoice.nextInt();

            if (choice == 1) {
                System.out.println("You drew a card.");
                p1.hit(myDeck);
                int pVal = p1.calcHandVal();
                if (pVal > 21) {
                    System.out.println("Your hand: " + pVal + " → BUST!");
                    System.out.println("You lose!");
                    myChoice.close();
                    return;
                }
            } else {
                playerTurn = false;
            }
        }

        // CPU's turn
        while (cpu.calcHandVal() < CPU_STAND_THRESHOLD) {
            cpu.hit(myDeck);
            if (cpu.calcHandVal() > 21) {
                System.out.println("CPU busts!");
                break;
            }
        }

        // Final evaluation
        int pVal = p1.calcHandVal();
        int cpuVal = cpu.calcHandVal();

        System.out.println("\n--- Final Hands ---");
        System.out.print("Your hand: "); p1.viewHand();
        System.out.println("Your total: " + pVal);
        System.out.print("CPU hand: "); cpu.viewHand();
        System.out.println("CPU total: " + cpuVal);

        // Clean win/loss logic
        if (pVal > 21) {
            System.out.println("You lose! (Bust)");
        } else if (cpuVal > 21) {
            System.out.println("You win! CPU busted.");
        } else if (pVal == 21 && cpuVal != 21) {
            System.out.println("You win! Blackjack!");
        } else if (cpuVal == 21 && pVal != 21) {
            System.out.println("You lose! CPU has 21.");
        } else if (pVal == cpuVal) {
            System.out.println("Push! It's a tie.");
        } else if (pVal > cpuVal) {
            System.out.println("You win!");
        } else {
            System.out.println("You lose!");
        }

        myChoice.close();
    }
}