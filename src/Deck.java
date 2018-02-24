import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private ArrayList<Card> deck = new ArrayList<Card>();

	public Deck(){
		this.intializeDeck();
	}

	public void intializeDeck(){
		//Loop Bastos
		for(int i = 1; i < 13; i++){
			if(i==1)
				deck.add(new Card("Bastos",11,1));
			else if(i==3)
				deck.add(new Card("Bastos",10,3));
			else if(i==12)
				deck.add(new Card("Bastos",4,12));
			else if(i==11)
				deck.add(new Card("Bastos",3,11));
			else if(i==10)
				deck.add(new Card("Bastos",2,10));
			else if (i==8 || i==9)
				System.out.println("");
			else
				deck.add(new Card("Bastos",0,i));

		}

		//Loop Espadas
		for(int i = 1; i < 13; i++){
			if(i==1)
				deck.add(new Card("Espada",11,1));
			else if(i==3)
				deck.add(new Card("Espada",10,3));
			else if(i==12)
				deck.add(new Card("Espada",4,12));
			else if(i==11)
				deck.add(new Card("Espada",3,11));
			else if(i==10)
				deck.add(new Card("Espada",2,10));
			else if (i==8 || i==9)
				System.out.println("");
			else
				deck.add(new Card("Espada",0,i));

		}

		//Loop Oro
		for(int i = 1; i < 13; i++){
			if(i==1)
				deck.add(new Card("Oro",11,1));
			else if(i==3)
				deck.add(new Card("Oro",10,3));
			else if(i==12)
				deck.add(new Card("Oro",4,12));
			else if(i==11)
				deck.add(new Card("Oro",3,11));
			else if(i==10)
				deck.add(new Card("Oro",2,10));
			else if (i==8 || i==9)
				System.out.println("");
			else
				deck.add(new Card("Oro",0,i));

		}

		//Loop Copa
		for(int i = 1; i < 13; i++){
			if(i==1)
				deck.add(new Card("Copa",11,1));
			else if(i==3)
				deck.add(new Card("Copa",10,3));
			else if(i==12)
				deck.add(new Card("Copa",4,12));
			else if(i==11)
				deck.add(new Card("Copa",3,11));
			else if(i==10)
				deck.add(new Card("Copa",2,10));
			else if (i==8 || i==9)
				System.out.println("");
			else
				deck.add(new Card("Copa",0,i));

		}

	}

	public void removeAll(ArrayList<Card> cartasJugadas){

		for(int i =0 ; i < cartasJugadas.size(); i++){
			for(int j=0; j<deck.size(); j++){
				if((cartasJugadas.get(i).getClub().equals(deck.get(j).getClub())) && (cartasJugadas.get(i).getNumber()== deck.get(j).getNumber())){
					deck.remove(j);
				}
				System.out.println("");
			}
		}
	}

	public void shuffle(){
		Collections.shuffle(deck);
	}

	public Card dealCard(){
		return deck.remove(deck.size()-1); // CHECK 
	}

	public int size(){
		return deck.size();
		
	}
	public ArrayList<Card> sendDeck(){
		return deck;
	}
}
