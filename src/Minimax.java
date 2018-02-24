import java.util.ArrayList;
import java.util.Collections;

public class Minimax {

	ArrayList<Card> playedCards = new ArrayList<Card>();
	ArrayList<Card> deck = new ArrayList<Card>();
	PlayerHand player = new PlayerHand(); 
	PlayerHand aiHand = new PlayerHand();
	ArrayList <Node<Card>> queue = new ArrayList<Node<Card>>();
	Card trump = null;
	TripleTree t;
	private int ADDER = 12;	

	Node<Card> cartaJugada = new Node<Card>(new Card("Bastos",0,0));

	public Minimax(Deck deckR, Card trump, PlayerHand ai){

		for(int i =0; i < deckR.size(); i++){
			deck.add(deckR.sendDeck().get(i));
		}
		this. trump = trump;
		this.aiHand = ai;
		t  = new TripleTree();
	}

	public int generateTree(Node<Card> jugada){
		
		cartaJugada = jugada;
		//Assume Opponents Cards
//		Collections.shuffle(deck);
		if(deck.size() !=0)
			player.addHand(deck.remove(0));

		if(deck.size() !=0)
			player.addHand(deck.remove(0));

		if(deck.size() !=0)
			player.addHand(deck.remove(0));


		t.insertLeft(aiHand.getCard(0), t.getRoot());
		t.insertMiddle(aiHand.getCard(1), t.getRoot());
		t.insertRight(aiHand.getCard(2), t.getRoot());

		t.getRoot().setNodeScore(0);

		t.getRoot().setDepth(0);
		t.getRoot().getLeft().setDepth(t.getRoot().getDepth()+1);
		t.getRoot().getMiddle().setDepth(t.getRoot().getDepth()+1);
		t.getRoot().getRight().setDepth(t.getRoot().getDepth()+1);


		if(t.getRoot().getLeft().getData().getClub().equals(trump.getClub())){
			t.getRoot().getLeft().setNodeScore(t.getRoot().getLeft().getData().getScore() + ADDER);
		}
		else{
			t.getRoot().getLeft().setNodeScore(t.getRoot().getLeft().getData().getScore());

		}
		if(t.getRoot().getMiddle().getData().getClub().equals(trump.getClub())){
			t.getRoot().getMiddle().setNodeScore(t.getRoot().getMiddle().getData().getScore() + ADDER);
		}
		else{
			t.getRoot().getMiddle().setNodeScore(t.getRoot().getMiddle().getData().getScore());
		}
		if(t.getRoot().getRight().getData().getClub().equals(trump.getClub())){
			t.getRoot().getRight().setNodeScore(t.getRoot().getRight().getData().getScore() + ADDER);
		}
		else{
			t.getRoot().getRight().setNodeScore(t.getRoot().getRight().getData().getScore());

		}

		queue.add(t.getRoot().getLeft());
		queue.add(t.getRoot().getMiddle());
		queue.add(t.getRoot().getRight());	

		Node<Card> parent = queue.remove(0);
		t.insertLeft(player.getCard(0),parent);
		t.insertMiddle(player.getCard(1), parent);
		t.insertRight(player.getCard(2), parent);

		parent.getLeft().setDepth(parent.getDepth()+1);
		parent.getMiddle().setDepth(parent.getDepth()+1);
		parent.getRight().setDepth(parent.getDepth()+1);


		if(parent.getLeft().getData().getClub().equals(trump.getClub())){
			parent.getLeft().setNodeScore(parent.getLeft().getData().getScore() + ADDER);
		}
		else{
			parent.getLeft().setNodeScore(parent.getLeft().getData().getScore());

		}
		if(parent.getMiddle().getData().getClub().equals(trump.getClub())){
			parent.getMiddle().setNodeScore(parent.getMiddle().getData().getScore() + ADDER);
		}
		else{
			parent.getMiddle().setNodeScore(parent.getMiddle().getData().getScore());
		}
		if(parent.getRight().getData().getClub().equals(trump.getClub())){
			parent.getRight().setNodeScore(parent.getRight().getData().getScore() + ADDER);
		}
		else{
			parent.getRight().setNodeScore(parent.getRight().getData().getScore());
		}

		queue.add(parent.getLeft());
		queue.add(parent.getMiddle());
		queue.add(parent.getRight());	

		parent = queue.remove(0);
		t.insertLeft(player.getCard(0),parent);
		t.insertMiddle(player.getCard(1), parent);
		t.insertRight(player.getCard(2), parent);

		parent.getLeft().setDepth(parent.getDepth()+1);
		parent.getMiddle().setDepth(parent.getDepth()+1);
		parent.getRight().setDepth(parent.getDepth()+1);

		if(parent.getLeft().getData().getClub().equals(trump.getClub())){
			parent.getLeft().setNodeScore(parent.getLeft().getData().getScore() + ADDER);
		}
		else{
			parent.getLeft().setNodeScore(parent.getLeft().getData().getScore());

		}
		if(parent.getMiddle().getData().getClub().equals(trump.getClub())){
			parent.getMiddle().setNodeScore(parent.getMiddle().getData().getScore() + ADDER);
		}
		else{
			parent.getMiddle().setNodeScore(parent.getMiddle().getData().getScore());
		}
		if(parent.getRight().getData().getClub().equals(trump.getClub())){
			parent.getRight().setNodeScore(parent.getRight().getData().getScore() + ADDER);
		}
		else{
			parent.getRight().setNodeScore(parent.getRight().getData().getScore());
		}

		queue.add(parent.getLeft());
		queue.add(parent.getMiddle());
		queue.add(parent.getRight());

		parent = queue.remove(0);
		t.insertLeft(player.getCard(0),parent);
		t.insertMiddle(player.getCard(1), parent);
		t.insertRight(player.getCard(2), parent);

		parent.getLeft().setDepth(parent.getDepth()+1);
		parent.getMiddle().setDepth(parent.getDepth()+1);
		parent.getRight().setDepth(parent.getDepth()+1);

		if(parent.getLeft().getData().getClub().equals(trump.getClub())){
			parent.getLeft().setNodeScore(parent.getLeft().getData().getScore() + ADDER);
		}
		else{
			parent.getLeft().setNodeScore(parent.getLeft().getData().getScore());

		}
		if(parent.getMiddle().getData().getClub().equals(trump.getClub())){
			parent.getMiddle().setNodeScore(parent.getMiddle().getData().getScore() + ADDER);
		}
		else{
			parent.getMiddle().setNodeScore(parent.getMiddle().getData().getScore());
		}
		if(parent.getRight().getData().getClub().equals(trump.getClub())){
			parent.getRight().setNodeScore(parent.getRight().getData().getScore() + ADDER);
		}
		else{
			parent.getRight().setNodeScore(parent.getRight().getData().getScore());
		}
		

		queue.add(parent.getLeft());
		queue.add(parent.getMiddle());
		queue.add(parent.getRight());
		//TERMINA EL PRIMER MOVE

		boolean isEmpty =false;
		while(t.getSize()<= 119){
			if(deck.size() == 0){
				isEmpty = true;
				break;
			}
			queue =	expand(queue);
		}
		if(isEmpty)
			return 0;
		else
			heuristic();	
		return minimax();
	}

	public ArrayList<Node<Card>> expand(ArrayList<Node<Card>> queue){
		if(queue.size()!= 0){
			Node<Card> current = queue.remove(0);
			ArrayList<Card> cartasJugadas = backTracking(current);

			for(int i =0; i<cartasJugadas.size(); i++){
				for(int j=0; j<cartasJugadas.size();j++){
					if(j!=i){
						if((cartasJugadas.get(i).getClub().equals(cartasJugadas.get(j).getClub()))  &&  (cartasJugadas.get(i).getNumber() == cartasJugadas.get(j).getNumber())  ){
							cartasJugadas.remove(j);
							j--;
						}
					}
				}
			}

			//deck.removeAll(cartasJugadas);
			if(deck.size() == 0){
				return queue;
			}
			else{
				Node<Card> dealtCard = new Node<Card>(deck.remove(0));
				cartasJugadas.add(dealtCard.getData());
				Node<Card> parent = current.getParent();
				Node<Card> grandParent = parent.getParent();

				ArrayList<Node<Card>> previousHand = new ArrayList<Node<Card>>();

				previousHand.add(new Node<Card>(grandParent.getLeft().getData()));
				previousHand.add(new Node<Card>(grandParent.getMiddle().getData()));
				previousHand.add(new Node<Card>(grandParent.getRight().getData()));

				for(int i = 0; i < previousHand.size(); i++){
					if((parent.getData().getClub().equals(previousHand.get(i).getData().getClub())) && (parent.getData().getNumber() == previousHand.get(i).getData().getNumber())){
						previousHand.remove(i);
					}
				}

				//ADDING NODES TO THE TREE
				t.insertLeft(dealtCard.getData(),current);
				t.insertMiddle(previousHand.remove(0).getData(), current);
				t.insertRight(previousHand.remove(0).getData(), current);

				current.getLeft().setDepth(current.getDepth()+1);
				current.getMiddle().setDepth(current.getDepth()+1);
				current.getRight().setDepth(current.getDepth()+1);

				t.setDepth(current.getDepth() +1);

				if(current.getLeft().getData().getClub().equals(trump.getClub())){
					current.getLeft().setNodeScore(current.getLeft().getData().getScore() + ADDER);
				}
				else{
					current.getLeft().setNodeScore(current.getLeft().getData().getScore());

				}
				if(current.getMiddle().getData().getClub().equals(trump.getClub())){
					current.getMiddle().setNodeScore(current.getMiddle().getData().getScore() + ADDER);
				}
				else{
					current.getMiddle().setNodeScore(current.getMiddle().getData().getScore());
				}
				if(current.getRight().getData().getClub().equals(trump.getClub())){
					current.getRight().setNodeScore(current.getRight().getData().getScore() + ADDER);
				}
				else{
					current.getRight().setNodeScore(current.getRight().getData().getScore());

				}


				queue.add(current.getLeft());
				queue.add(current.getMiddle());
				queue.add(current.getRight());

				for(int i = 0; i < cartasJugadas.size(); i++){
					deck.add(cartasJugadas.remove(0));
				}
				return queue;
			}
		}
		else
			return queue;
	}

	public ArrayList<Card> backTracking(Node<Card> currentNode){
		while(currentNode.getParent()!= null ) {
			currentNode = currentNode.getParent();

			playedCards.add(currentNode.getLeft().getData());
			playedCards.add(currentNode.getMiddle().getData());
			playedCards.add(currentNode.getRight().getData());
		}
		return playedCards;
	}

	public void heuristic(){
		ArrayList <Node<Card>> q = new ArrayList<Node<Card>>();
		Node<Card> current = t.getRoot();

		while (current.getMiddle() != null){
			q.add(current.getLeft());
			q.add(current.getMiddle());
			q.add(current.getRight());
			current = q.remove(0);

		}

		while(q.size() > 0){
			int score =  current.getNodeScore() - current.getParent().getNodeScore() + current.getParent().getParent().getNodeScore() 
					- current.getParent().getParent().getParent().getNodeScore();
			current.setNodeScore(score);
			while(deck.size() > 33){
				if(current.getData().getClub().equals(trump.getClub())){
					current.setNodeScore(current.getNodeScore() - 20);
					
				}
				break;
			}
			current = q.remove(0);
		}

	}



	public int minimax(){
		ArrayList <Node<Card>> q = new ArrayList<Node<Card>>();
		Node<Card> current = t.getRoot();
		if(cartaJugada.getData().getClub().equals(trump.getClub())){
			cartaJugada.setNodeScore(cartaJugada.getData().getScore() + ADDER);
		}
		else{
		cartaJugada.setNodeScore(cartaJugada.getData().getScore());
		}
		
		while (current.getDepth() != 3){
			q.add(current.getLeft());
			q.add(current.getMiddle());
			q.add(current.getRight());
			current = q.remove(0);
		}

		while(current.getDepth()==3 && q.size() !=0){
			int min = current.getLeft().getNodeScore();
			if(current.getMiddle().getNodeScore() < min)
				min = current.getMiddle().getNodeScore();
			if(current.getRight().getNodeScore() < min)
				min = current.getRight().getNodeScore();

			current.setNodeScore(min);
			current = q.remove(0);
		}

		current = t.getRoot();

		while (current.getDepth() != 2){
			q.add(current.getLeft());
			q.add(current.getMiddle());
			q.add(current.getRight());
			current = q.remove(0);
		}

		while(current.getDepth()==2 && q.size() !=0){
			int max = current.getLeft().getNodeScore();
			if(current.getMiddle().getNodeScore() > max)
				max = current.getMiddle().getNodeScore();
			if(current.getRight().getNodeScore() > max)
				max = current.getRight().getNodeScore();

			current.setNodeScore(max);
			current = q.remove(0);
		}

		current = t.getRoot();

		while (current.getDepth() != 1){
			q.add(current.getLeft());
			q.add(current.getMiddle());
			q.add(current.getRight());
			current = q.remove(0);
		}

		while(current.getDepth()==1 && q.size() !=0){
			int min = current.getLeft().getNodeScore();
			if(current.getMiddle().getNodeScore() < min)
				min = current.getMiddle().getNodeScore();
			if(current.getRight().getNodeScore() < min)
				min = current.getRight().getNodeScore();

			current.setNodeScore(min);
			current = q.remove(0);
		}

		current = t.getRoot();
		int value = 0;
		int min = 0;
		int max = 0;
		if(current.getLeft().getNodeScore() > max){
			value =0;
			max = current.getLeft().getNodeScore();
		}
		if(current.getMiddle().getNodeScore() > max){
			value =0;
			max = current.getMiddle().getNodeScore();
		}
			value = 1;
		if(current.getRight().getNodeScore() > max){
			value =2;
			max = current.getRight().getNodeScore();
		}
		
		if(cartaJugada.getNodeScore() > max){
			if(current.getLeft().getNodeScore() > min){
				value =0;
				min = current.getLeft().getNodeScore();
			}
			if(current.getMiddle().getNodeScore() > min){
				value =0;
				min = current.getMiddle().getNodeScore();
			}
				value = 1;
			if(current.getRight().getNodeScore() > min){
				value =2;
				min = current.getRight().getNodeScore();
			}
			
			
		}
			
		
		return value;

	}
	


}