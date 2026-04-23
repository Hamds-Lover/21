import java.util.List;
import java.util.ArrayList;

public class Player{
	private List<Integer> hand = new ArrayList<>();


	//Methods
	public void hit(NumberedDeck deck){
		this.hand.add(deck.deal());
	}


	public void viewHand(){
		System.out.println(this.hand);
	}
}