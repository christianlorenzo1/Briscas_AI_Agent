
public class Card {
	private int score, number;
	private String club;

	public Card(String club, int score, int number){
		this.club = club;
		this.score = score;
		this.number = number;
	}
 
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}


}
