import java.util.ArrayList;

public class PlayerHand {
	private ArrayList<Card> handP1;
	int score = 0;
	public PlayerHand(){
		this.handP1 = new ArrayList<Card>();
	}

	public void addHand(Card c){
		handP1.add(c);
	}

	public Card playCard(int i){
		return handP1.remove(i);

	}
	public Card getCard(int i){
		if(handP1.size() < i){
			return new Card("",0,0) ;
		}
		return handP1.get(i);
	}

	public int size(){
		return handP1.size();
	}

	public int getScore(){
		return score;
	}
	public void setScore(int sco){
		score += sco;
	}
}
