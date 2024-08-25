
public class Node {

	private int key;
	private Node leftChild, rightChild, parent;
	
	public Node(int key, Node leftChild, Node rightChild, Node parent)
	{
		this.key = key;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.parent = parent;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}
	
	public Node getParent() 
	{
		return parent;
	}
	
	public void setParent(Node p) 
	{
		parent = p;
	}
	
	public boolean isLeaf()
	{
		return leftChild == null && rightChild == null;
	}
}
