import java.util.Scanner;

public class Game {
    private NumberedDeck myDeck = new NumberedDeck();
    private Player p1 = new Player();
    private Player cpu = new Player();
    private CpuDecisionMaker cpuAI = new CpuDecisionMaker();
    private GameEvaluator evaluator = new GameEvaluator();

    public void playGame() {
        myDeck.resetDeck();
        p1.clearHand();
        cpu.clearHand();

        myDeck.shuffleDeck();
        p1.hit(myDeck);
        cpu.hit(myDeck);
        p1.hit(myDeck);
        cpu.hit(myDeck);

        Scanner scanner = new Scanner(System.in);

        // Player turn
        while (true) {
            System.out.print("CPU hand: ");
            cpu.showHiddenHand();
            p1.viewHand();
            System.out.println("Your hand value: " + p1.calcHandVal());
            System.out.println("1 - Hit");
            System.out.println("2 - Stand");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("You drew a card.");
                p1.hit(myDeck);
                int pVal = p1.calcHandVal();
                if (pVal > 21) {
                    System.out.println("Your hand: " + pVal + " → BUST!");
                    System.out.println("You lose!");
                    scanner.close();
                    return;
                }
            } else {
                break;
            }
        }

        // CPU turn
        int playerVisibleTotal = p1.getVisibleHandTotal();
        while (cpuAI.shouldHit(cpu.calcHandVal(), playerVisibleTotal)) {
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

        GameResult result = evaluator.evaluate(pVal, cpuVal);
        switch (result) {
            case PLAYER_BUST:
                System.out.println("You lose! (Bust)");
                break;
            case CPU_BUST:
                System.out.println("You win! CPU busted.");
                break;
            case PLAYER_WIN:
                System.out.println("You win!");
                break;
            case CPU_WIN:
                System.out.println("You lose!");
                break;
            case TIE:
                System.out.println("Push! It's a tie.");
                break;
        }

        scanner.close();
    }
}