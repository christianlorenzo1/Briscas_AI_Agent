import java.util.ArrayList;

public class Node<T> {
	private ArrayList<Node<T>> children = new ArrayList<Node<T>>();
	private Node<T> parent = null;
	private T data = null;
	private int score = 0;
	int depth = 0;
	public Node(T data) {
		this.data = data;
	}


	public Node(T data, Node<T> parent) {
		this.data = data;
		this.parent = parent;
	}

	public ArrayList<Node<T>> getChildren() {
		return children;
	}

	public void setParent(Node<T> parent) {
		this.parent = parent;
	}

	public Node<T> getParent(){

		return this.parent;
	}

	public void addChild(T data) {
		Node<T> child = new Node<T>(data);
		child.setParent(this);
		this.children.add(child);
	}

	public void addChild(Node<T> child) {
		child.setParent(this);
		this.children.add(child);
	}

	public T getData() {
		return this.data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public boolean isRoot() {
		return (this.parent == null);
	}

	public boolean isLeaf() {
		if(this.children.size() == 0) 
			return true;
		else 
			return false;
	}

	public void removeParent() {
		this.parent = null;
	}


	public void setLeft(Node<T> nNode) {
		if(children.size() != 0)
			children.set(0, nNode);
		else
			children.add(nNode);

		nNode.setParent(this);
	}
	public void setMiddle(Node<T> nNode) {
		if(children.size() != 1)
			children.set(1, nNode);
		else
			children.add(nNode);

		nNode.setParent(this);

	}

	public void setRight(Node<T> nNode) {
		if(children.size() != 2)
			children.set(2, nNode);
		else
			children.add(nNode);

		nNode.setParent(this);

	}

	public Node<T> getLeft() {
		if(children.size() >= 1)
			return children.get(0);
		return null;

	}
	public Node<T> getMiddle() {
		if(children.size() >= 2)
			return children.get(1);
		return null;

	}

	public Node<T> getRight() {
		if(children.size() >=3)
			return children.get(2);
		return null;
	}
	
	public int getNodeScore(){
		return score;
	}
	public void setNodeScore(int sc){
		 score= sc;
	}
	public int getDepth(){
		return depth;
	}
	public void setDepth(int sc){
		 depth = sc;
	}
	
}