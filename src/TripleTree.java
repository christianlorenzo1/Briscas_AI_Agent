
public class TripleTree {
	private Node<Card> root;
	private int size=0;
	private int depth = 0;
	
	
	public TripleTree(){
		this.root = new Node<Card>(new Card("",0,0));
	}
		
	public Node<Card> insertLeft(Card v, Node<Card> parent){ 
		if (hasLeft(parent)) 
			System.out.println("Already has a left child.");
			// create new node with e as element and vbtn as parent
		Node<Card> nNode = new Node<Card>(v, parent); 
		parent.setLeft(nNode); 
		size++; 

		return nNode; 
	}
	
	public Node<Card> insertMiddle(Card v, Node<Card> parent){ 
		if (hasMiddle(parent)) 
			System.out.println("Already has a middle child.");
			// create new node with e as element and vbtn as parent
		Node<Card> nNode = new Node<Card>(v, parent); 
		parent.setMiddle(nNode); 
		size++; 
		return nNode; 
	}
	
	public Node<Card> insertRight(Card v, Node<Card> parent){ 
		if (hasRight(parent)) 
			System.out.println("Already has a right child.");
			// create new node with e as element and vbtn as parent
		Node<Card> nNode = new Node<Card>(v, parent); 
		parent.setRight(nNode); 
		size++; 
		return nNode; 
	}

	public Node<Card> getRoot(){
		return root;
	}
	
	private boolean hasLeft(Node<Card> c) {
		if(c.getLeft() == null){
			return false;
		}
		return true;
	}
	
	private boolean hasMiddle(Node<Card> c) {
		if(c.getMiddle() == null){
			return false;
		}
		return true;
	}
	
	
	private boolean hasRight(Node<Card> c) {
		if(c.getRight() == null){
			return false;
		}
		return true;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	

}
