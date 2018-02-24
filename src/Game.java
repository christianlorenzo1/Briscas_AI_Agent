import java.util.ArrayList;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {

		Deck deck = new Deck();
		PlayerHand player1 = new PlayerHand(); //AI
		PlayerHand player2 = new PlayerHand();
		ArrayList<Card> cardPileP1 = new ArrayList<Card>();
		ArrayList<Card> cardPileP2 = new ArrayList<Card>();
		ArrayList<Card> cardsPlayed= new ArrayList<Card>();
		boolean firstmove = true;
		boolean roundWinner = true;
		int chosenCard = 0;
		Node<Card> cartaCero = new Node<Card>(new Card("Bastos",0,0));

		deck.shuffle();
		Card trump = deck.sendDeck().get(0);
		System.out.println("XXXXXXXXXXXXXXX---BRISCA---XXXXXXXXXXXXXXX");

		while(((player1.size() !=0 || player2.size() != 0)) || firstmove){

			if(firstmove){
				player1.addHand(deck.dealCard());
				player1.addHand(deck.dealCard());
				player1.addHand(deck.dealCard());
				
				Minimax min = new Minimax(deck, trump, player1);
				chosenCard = min.generateTree(cartaCero);	

				player2.addHand(deck.dealCard());
				player2.addHand(deck.dealCard());
				player2.addHand(deck.dealCard());	

				System.out.println("Write 1,2,3 to play the left most, center and right most card respectively.");
				System.out.print("AI:\t");
				System.out.print("[X,X]"+"[X,X]"+"[X,X]");
				System.out.println("\t\t\t\t AIScore:"+player1.getScore());
				System.out.println("\n");
				System.out.print("Trump:\t");
				System.out.print("["+trump.getClub()+","+trump.getNumber()+"]"); 
				System.out.print("\t Played Cards:"+"[_,_]"+"[_,_]");
				System.out.println("\n");
				System.out.print("Player:\t");
				System.out.print("["+player2.getCard(0).getClub()+","+player2.getCard(0).getNumber()+"]"+","+"["+player2.getCard(1).getClub()+","+player2.getCard(1).getNumber()+"]"+"["+player2.getCard(2).getClub()+","+player2.getCard(2).getNumber()+"]");
				System.out.println("\t\t Score:"+player2.getScore());
				//Scanner
				Scanner in = new Scanner(System.in);
				boolean isNumber =false;
				int op = 0;

				while(!isNumber){
					String choice = in.nextLine();

					try {
						op = Integer.parseInt(choice);
						if(op <= 3 && op >= 0){
							isNumber = true;
						}
						else
							System.out.println("Not a valid number.");
					} catch (NumberFormatException e) {
						System.out.println("It's not a number");

					}
				}

				Card played1 = null;
				Card playedAI = null;

				if(roundWinner){
					if(op == 1){
						played1= new Card(player2.getCard(0).getClub(),player2.getCard(0).getScore(),player2.getCard(0).getNumber());
						cardsPlayed.add(player2.playCard(0));

					}
					else if(op == 2){
						played1= new Card(player2.getCard(1).getClub(),player2.getCard(1).getScore(),player2.getCard(1).getNumber());

						cardsPlayed.add(player2.playCard(1));

					}

					else if(op == 3){
						played1= new Card(player2.getCard(2).getClub(),player2.getCard(2).getScore(),player2.getCard(2).getNumber());

						cardsPlayed.add(player2.playCard(2));

					}
					//Jugador ya tiro

					int n = chosenCard;

					playedAI = new Card(player1.getCard(n).getClub(), player1.getCard(n).getScore(), player1.getCard(n).getNumber());
					cardsPlayed.add(player1.playCard(n));
					//AI tiro de la izquierda

					if(played1.getClub().equals(playedAI.getClub()) ){
						if(played1.getScore() > playedAI.getScore()){
							//player one wins
							player2.setScore(played1.getScore() + playedAI.getScore());
						}
						else{
							//player AI wins
							player1.setScore(played1.getScore() + playedAI.getScore());
							roundWinner = false;

						}
					}
					if(played1.getClub().equals(trump.getClub()) && (!playedAI.getClub().equals(trump.getClub()))){
						//player 1 wins
						player2.setScore(played1.getScore() + playedAI.getScore());
					}
					if((!played1.getClub().equals(trump.getClub())) && (playedAI.getClub().equals(trump.getClub()))){
						//playerAI wins
						player1.setScore(played1.getScore() + playedAI.getScore());
						roundWinner = false;

					}
					if((!played1.getClub().equals(trump.getClub())) && (!playedAI.getClub().equals(trump.getClub())) && (!playedAI.getClub().equals(played1.getClub()))){
						//played1 wins
						player2.setScore(played1.getScore() + playedAI.getScore());

					}

				}


				firstmove = false;
			}
			else{
				System.out.println("Write 1,2,3 to play the left most, center and right most card respectively.");
				System.out.print("AI:\t");
				//System.out.print("[X,X]"+"[X,X]"+"[X,X]");
				for(int i = 0 ; i < player1.size(); i++){
					System.out.print("[X,X]");
				}
				System.out.println("\t\t\t AIScore:"+player1.getScore());
				System.out.println("\n");
				System.out.print("Trump:\t");
				System.out.print("["+trump.getClub()+","+trump.getNumber()+"]"); 
				System.out.print("\t Played Cards:"+"["+cardsPlayed.get(cardsPlayed.size()-1).getClub()+","+cardsPlayed.get(cardsPlayed.size()-1).getNumber()+"]"+"["+cardsPlayed.get(cardsPlayed.size()-2).getClub()+","+cardsPlayed.get(cardsPlayed.size()-2).getNumber()+"]");
				System.out.println("\n");
				System.out.println("\n");
				System.out.print("Player:\t");
				for(int i = 0 ; i < player2.size(); i++)
					System.out.print("["+player2.getCard(i).getClub()+","+player2.getCard(i).getNumber()+"]");//Print para carta del left de jugador.

				System.out.println("\t\t Score:"+player2.getScore()+"\n");
				
				Scanner stop = new Scanner(System.in);
				stop.nextLine();

				if(deck.size()!=0){
					player1.addHand(deck.dealCard());
				}
				if(deck.size()>=3){
					Minimax min = new Minimax(deck, trump, player1);
					chosenCard =min.generateTree(cartaCero);	
				}
				if(deck.size()!=0){
					player2.addHand(deck.dealCard());
				}

				System.out.println("Write 1,2,3 to play the left most, center and right most card respectively.");
				System.out.print("AI:\t");
				for(int i = 0 ; i < player1.size(); i++){
					System.out.print("[X,X]");
				}
				System.out.println("\t\t\t AIScore:"+player1.getScore());
				System.out.println("\n");
				System.out.print("Trump:\t");
				System.out.print("["+trump.getClub()+","+trump.getNumber()+"]"); 
				System.out.print("\t Played Cards:"+"[_,_]"+"[_,_]");
				System.out.println("\n");
				System.out.println("\n");
				System.out.print("Player:\t");
				for(int i = 0 ; i < player2.size(); i++)
					System.out.print("["+player2.getCard(i).getClub()+","+player2.getCard(i).getNumber()+"]");//Print para carta del left de jugador.

				System.out.println("\t\t Score:"+player2.getScore()+"\n");



				Card played1 = null;
				Card playedAI = null;

				if(roundWinner){
					Scanner in = new Scanner(System.in);
					boolean isNumber = false;
					int op = 0;

					while(!isNumber){
						String choice = in.nextLine();
						try {
							op = Integer.parseInt(choice);
							if(op <= 3 && op >= 0){
								if(player2.size() == 2 && op > 2){
									isNumber = false;
									System.out.println("Not a valid number.");
								}

								else if(player2.size() == 1 && op > 1){
									isNumber = false;
									System.out.println("Not a valid number.");

								}
								else
									isNumber = true;
							}
							else
								System.out.println("Not a valid number.");
						} catch (NumberFormatException e) {
							System.out.println("It's not a number");

						}
					}

					if(op == 1){
						played1= new Card(player2.getCard(0).getClub(),player2.getCard(0).getScore(),player2.getCard(0).getNumber());
						cardsPlayed.add(player2.playCard(0));
						if(deck.size()>=3){
							Node<Card> carta1 = new Node<Card>(played1);
							Minimax min = new Minimax(deck, trump, player1);
							chosenCard = min.generateTree(carta1);
						}

					}
					else if(op == 2){
						played1= new Card(player2.getCard(1).getClub(),player2.getCard(1).getScore(),player2.getCard(1).getNumber());

						cardsPlayed.add(player2.playCard(1));
						if(deck.size()>=3){
							Node<Card> carta2 = new Node<Card>(played1);
							Minimax min = new Minimax(deck, trump, player1);
							chosenCard = min.generateTree(carta2);
						}

					}

					else if(op == 3){
						played1= new Card(player2.getCard(2).getClub(),player2.getCard(2).getScore(),player2.getCard(2).getNumber());

						cardsPlayed.add(player2.playCard(2));
						if(deck.size()>=3){
							Node<Card> carta3 = new Node<Card>(played1);
							Minimax min = new Minimax(deck, trump, player1);
							chosenCard = min.generateTree(carta3);
						}

					}
					//Jugador ya tiro



					int n = chosenCard;

					//LASTMOVEMENT PROBLEMS
					while(n > player1.size()-1)
						n--;
					playedAI = new Card(player1.getCard(n).getClub(), player1.getCard(n).getScore(), player1.getCard(n).getNumber());
					cardsPlayed.add(player1.playCard(n));

					//AI tiro de la izquierda

					if(played1.getClub().equals(playedAI.getClub()) ){
						if(played1.getScore() > playedAI.getScore()){
							//player one wins
							player2.setScore(played1.getScore() + playedAI.getScore());
						}
						else{
							//player AI wins
							player1.setScore(played1.getScore() + playedAI.getScore());
							roundWinner = false;

						}
					}
					if(played1.getClub().equals(trump.getClub()) && (!playedAI.getClub().equals(trump.getClub()))){
						//player 1 wins
						player2.setScore(played1.getScore() + playedAI.getScore());
					}
					if((!played1.getClub().equals(trump.getClub())) && (playedAI.getClub().equals(trump.getClub()))){
						//playerAI wins
						player1.setScore(played1.getScore() + playedAI.getScore());
						roundWinner = false;

					}
					if((!played1.getClub().equals(trump.getClub())) && (!playedAI.getClub().equals(trump.getClub())) && (!playedAI.getClub().equals(played1.getClub()))){
						//played1 wins
						player2.setScore(played1.getScore() + playedAI.getScore());

					}

				}

				else{//Empieza AI a tirar



					int n = chosenCard;
					while(n>player1.size()-1)
						n--;

					playedAI = new Card(player1.getCard(n).getClub(), player1.getCard(n).getScore(), player1.getCard(n).getNumber());
					cardsPlayed.add(player1.playCard(n));

					System.out.println("Write 1,2,3 to play the left most, center and right most card respectively.");
					System.out.print("AI:\t");
					for(int i = 0 ; i < player1.size(); i++){
						System.out.print("[X,X]");
					}					System.out.println("\t\t\t AIScore:"+player1.getScore());
					System.out.println("\n");
					System.out.print("Trump:\t");
					System.out.print("["+trump.getClub()+","+trump.getNumber()+"]"); 
					System.out.print("\t Played Cards:"+"["+cardsPlayed.get(cardsPlayed.size()-1).getClub()+","+cardsPlayed.get(cardsPlayed.size()-1).getNumber()+"]"+"[_,_]");
					System.out.println("\n");
					System.out.println("\n");
					System.out.print("Player:\t");
					for(int i = 0 ; i < player2.size(); i++)
						System.out.print("["+player2.getCard(i).getClub()+","+player2.getCard(i).getNumber()+"]");//Print para carta del left de jugador.

					System.out.println("\t\t Score:"+player2.getScore()+"\n");

					Scanner in = new Scanner(System.in);
					boolean isNumber =false;
					int op = 0;

					while(!isNumber){
						String choice = in.nextLine();
						try {
							op = Integer.parseInt(choice);
							if(op <= 3 && op >= 0){

								if(player2.size() == 2 && op > 2){
									isNumber = false;
									System.out.println("Not a valid number.");
								}

								else if(player2.size() == 1 && op > 1){
									isNumber = false;
									System.out.println("Not a valid number.");

								}
								else
									isNumber = true;
							}
							else
								System.out.println("Not a valid number.");
						} catch (NumberFormatException e) {
							System.out.println("It's not a number");

						}
					}

					if(op == 1){
						played1= new Card(player2.getCard(0).getClub(),player2.getCard(0).getScore(),player2.getCard(0).getNumber());
						cardsPlayed.add(player2.playCard(0));

					}
					else if(op == 2){
						played1= new Card(player2.getCard(1).getClub(),player2.getCard(1).getScore(),player2.getCard(1).getNumber());

						cardsPlayed.add(player2.playCard(1));

					}

					else if(op == 3){
						played1= new Card(player2.getCard(2).getClub(),player2.getCard(2).getScore(),player2.getCard(2).getNumber());

						cardsPlayed.add(player2.playCard(2));

					}
					//Jugador ya tiro





					if(played1.getClub().equals(playedAI.getClub()) ){
						if(played1.getScore() > playedAI.getScore()){
							//player one wins
							player2.setScore(played1.getScore() + playedAI.getScore());
							roundWinner = true;
						}
						else{
							//player AI wins
							player1.setScore(played1.getScore() + playedAI.getScore());

						}
					}
					if(played1.getClub().equals(trump.getClub()) && (!playedAI.getClub().equals(trump.getClub()))){
						//player 1 wins
						player2.setScore(played1.getScore() + playedAI.getScore());
						roundWinner = true;
					}
					if((!played1.getClub().equals(trump.getClub())) && (playedAI.getClub().equals(trump.getClub()))){
						//playerAI wins
						player1.setScore(played1.getScore() + playedAI.getScore());

					}
					if((!played1.getClub().equals(trump.getClub())) && (!playedAI.getClub().equals(trump.getClub())) && (!playedAI.getClub().equals(played1.getClub()))){
						//playedAI wins
						player1.setScore(played1.getScore() + playedAI.getScore());


					}
				}

			}

		}
		//LAST SCREEN
		System.out.println("Write 1,2,3 to play the left most, center and right most card respectively.");
		System.out.print("AI:\t");
		for(int i = 0 ; i < player1.size(); i++){
			System.out.print("[X,X]");
		}					System.out.println("\t\t\t AIScore:"+player1.getScore());
		System.out.println("\n");
		System.out.print("Trump:\t");
		System.out.print("["+trump.getClub()+","+trump.getNumber()+"]"); 
		System.out.print("[_,_]"+"[_,_]");
		System.out.println("\n");
		System.out.println("\n");
		System.out.print("Player:\t");
		for(int i = 0 ; i < player2.size(); i++)
			System.out.print("["+player2.getCard(i).getClub()+","+player2.getCard(i).getNumber()+"]");//Print para carta del left de jugador.

		System.out.println("\t\t Score:"+player2.getScore()+"\n");




		if(player2.getScore() > player1.getScore())
			System.out.println("\nPlayer Won: "+ player2.getScore());
		else if(player2.getScore() == player1.getScore() )
			System.out.println("\nDraw");
		else
			System.out.println("\nAI Won: "+player1.getScore());

		System.out.println("\nXXXXXXXXXXX---GAME END---XXXXXXXXXXX");

	}

}
