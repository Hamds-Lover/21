import java.util.List;
import java.util.ArrayList;

public class Player{
	private List<Integer> hand = new ArrayList<>();
	private int handVal = 0;


	//Methods
	public void hit(NumberedDeck deck){
		this.hand.add(deck.deal());
	}

	public int calcHandVal(){
		handVal = 0;
		for (int i = 0; i < hand.size(); i++) {
    		handVal += hand.get(i);
		}
		return handVal;
	}

	public void viewHand(){
		System.out.println(this.hand);
	}
}