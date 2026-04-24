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
        boolean playerStood = false;
        boolean cpuStood = false;

        // Main game loop – alternate turns until both stand or bust
        while (!playerStood || !cpuStood) {
            // Player's turn (if hasn't stood)
            if (!playerStood) {
                System.out.print("CPU hand: ");
                cpu.showHiddenHand();
                System.out.print("Your hand: ");
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
                    playerStood = true;
                    System.out.println("You stand.");
                }
            }

            // CPU's turn (if hasn't stood and game still active)
            if (!cpuStood && !playerStood) { // if player just stood, CPU still plays
                // Recalculate player's visible total (may have changed after player hit)
                int playerVisibleTotal = p1.getVisibleHandTotal();
                if (!cpuAI.shouldHit(cpu.calcHandVal(), playerVisibleTotal)) {
                    cpuStood = true;
                    System.out.println("CPU stands.");
                } else {
                    System.out.println("CPU draws a card.");
                    cpu.hit(myDeck);
                    int cpuVal = cpu.calcHandVal();
                    if (cpuVal > 21) {
                        System.out.println("CPU hand: " + cpuVal + " → CPU BUSTS!");
                        System.out.println("You win!");
                        scanner.close();
                        return;
                    }
                }
            } else if (!cpuStood && playerStood) {
                // Player already stood, CPU continues until it stands or busts
                int playerVisibleTotal = p1.getVisibleHandTotal();
                while (cpuAI.shouldHit(cpu.calcHandVal(), playerVisibleTotal)) {
                    System.out.println("CPU draws a card.");
                    cpu.hit(myDeck);
                    int cpuVal = cpu.calcHandVal();
                    if (cpuVal > 21) {
                        System.out.println("CPU hand: " + cpuVal + " → CPU BUSTS!");
                        System.out.println("You win!");
                        scanner.close();
                        return;
                    }
                }
                cpuStood = true;
                System.out.println("CPU stands.");
            }
        }

        // Both stood – evaluate final hands
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