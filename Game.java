import java.util.Scanner;
public class Game{
	//Playing deck;
    NumberedDeck myDeck = new NumberedDeck();
    //Player
	Player p1 = new Player();
	Player cpu = new Player();
	int cpuVal;
	int pVal;

	public void playGame(){
		int play = 1;
		myDeck.shuffleDeck();
		p1.hit(myDeck);
		cpu.hit(myDeck);
		p1.hit(myDeck);
		cpu.hit(myDeck);
		Scanner myChoice = new Scanner(System.in);
		while(play != 0){
			System.out.print("Cpu hand: ");
			cpu.showNotFrst();
			p1.viewHand();
			System.out.println("Your hand is worth: " + p1.calcHandVal());
	        System.out.println("1-Hit.");
	        System.out.println("2-Stand.");
	        System.out.println("Enter choice: ");
	        int choice = myChoice.nextInt();
	        switch(choice){
	        	case 1:
					System.out.println("You Hit.");
					p1.hit(myDeck);
					break;
				case 2:
					System.out.println("You Stood.");
					play = 0;
					break;
	        }
	        if(cpu.calcHandVal()<15){
	        	cpu.hit(myDeck);
	        }
		}
		pVal = p1.calcHandVal();
		cpuVal = cpu.calcHandVal();
	    if (pVal > 21) {
	    	System.out.println("You lost!");
        }
        if (cpuVal == 21 && pVal != 21) {
        	System.out.println("You lost!");
        }
        if (pVal < 21) {
        	if (cpuVal > pVal && cpuVal < 21) {
        		System.out.println("You lost!");
        	}else{
        		System.out.println("Win!!");
        	}
        }
        cpu.viewHand();
        p1.viewHand();
	}
}