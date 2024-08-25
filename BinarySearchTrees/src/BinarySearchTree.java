import java.util.ArrayList;

/**
 * 
 * @author Weston
 *
 */
public class BinarySearchTree {

	private Node root;
	private int numNodes, comp;
	char prefixChar;
	public BinarySearchTree() {
		root = null;
		numNodes = 0;
		prefixChar = ' ';
		comp = 0;
	}
	
	public BinarySearchTree(Node root) {
		this.root = root;
		numNodes = 1;
		prefixChar = ' ';
	}
	public Node getRoot() {
		return root;
	}
	public void setRoot(Node root) {
		this.root = root;
	}
	
	public int getComp() 
	{
		return comp;
	}
	
	/**
	 * Insert a new node with the given 'key' into the tree.
	 * @param key
	 */
	public void insert(int key) {
		numNodes++;
		recursiveInsert(key, root);
	}
	
	/**
	 * Insert a new node with the given 'key' into the subtree in the proper position.
	 * @param key
	 * @param n
	 */
	private void recursiveInsert(int key, Node n) {
		comp++;
		if(n.getKey() > key)
		{
			comp++;
			if(n.getLeftChild() != null)
				recursiveInsert(key, n.getLeftChild());
			else 
			{
				n.setLeftChild(new Node(key, null, null, n));
				
			}
		}
		else
		{	
			comp++;
			if(n.getRightChild() != null)
				recursiveInsert(key, n.getRightChild());
			else
			{
				n.setRightChild(new Node(key, null, null, n));
				
			}
		}
	}
	
	/**
	 * Searches the tree and returns the Node which the 'key' value.
	 * @param key
	 * @return the node with the value 'key', or null if no node is found
	 */
	public Node search(int key) {
		return recursiveSearch(key, root);
	}
	/**
	 * Searches the subtree starting at node n. Returns the Node which the 'key' value.
	 * @param key
	 * @param n
	 * @return the node with the value 'key', or null if no node is found
	 */
	private Node recursiveSearch(int key, Node n){
		if(key < n.getKey() && n.getLeftChild() == null)
			return null;
		else if(key < n.getKey())
			return recursiveSearch(key, n.getLeftChild());
		else if(key > n.getKey() && n.getRightChild() == null)
			return null;
		else if(key > n.getKey())
			return recursiveSearch(key, n.getRightChild());
		else if(key == n.getKey())
			return n;
		else
			return null;
	}
	/**
	 * Print the 'key' values in order. See the assignment description for more details.
	 */
	public int[] inOrderTraversal() {
		return recursiveInOrderTraversal(root, new ArrayList<>());
	}
	
	/**
	 * Prints the 'key' values from the subtree rooted at 'n' in order.
	 * @param n
	 */
	public int[] recursiveInOrderTraversal(Node n, ArrayList<Integer> arr) {
		comp++;
		if(n.getLeftChild() != null)
			recursiveInOrderTraversal(n.getLeftChild(), arr);
		arr.add(n.getKey());
		comp++;
		if(n.getRightChild() != null) 
			recursiveInOrderTraversal(n.getRightChild(), arr);
		if(arr.size() == numNodes) 
		{
			int[] arrr = new int[numNodes];
			for(int i = 0; i < arrr.length; i++)
				arrr[i] = arr.get(i);
			return arrr;
		}
		return null;
	}
	
	public void preOrderTraversal() 
	{
		preOrderTraversal(root); 
	}
	
	private void preOrderTraversal(Node n) 
	{
		System.out.print(n.getKey() + " ");
		if(n.getLeftChild() != null) 
			preOrderTraversal(n.getLeftChild()); 
		if(n.getRightChild() != null) 
			preOrderTraversal(n.getRightChild());
	} 
	
	public void postOrderTraversal() 
	{
		postOrderTraversal(root); 
	}
	
	private void postOrderTraversal(Node n) 
	{
		if(n.getLeftChild() != null) 
			postOrderTraversal(n.getLeftChild());
		if(n.getRightChild() != null) 
			postOrderTraversal(n.getRightChild());
		System.out.print(n.getKey() + " ");
	} 
	
	/**
	 * Returns the minimum value of the tree.
	 * @return
	 */
	public int min() {
		return recursiveMin(root);
	}
	/**
	 * Recursive method, returns the minimum value of the subtree rooted at n.
	 * @param n
	 * @return
	 */
	private int recursiveMin(Node n) {
		if(n.getLeftChild() != null)
			return recursiveMin(n.getLeftChild());
		return n.getKey();
	}
	
	/**
	 * Returns the maximum value of the tree
	 * @return
	 */
	public int max() {
		return recursiveMax(root);
	}
	/**
	 * Recursive method, returns the maximum value of the subtree rooted at n.
	 * @param n
	 * @return
	 */
	private int recursiveMax(Node n) {
		if(n.getRightChild() != null)
			return recursiveMax(n.getRightChild());
		return n.getKey();
	}

	public void deleteNode(int key) 
	{
		Node n = search(key);
		if(n != null)
			deleteNode(n);
		else
			throw new IllegalArgumentException("A node with value " + key + " does not exist in current BST");
	}
	
	private void deleteNode(Node n) 
	{
		if(n.isLeaf() && n.getKey() <= n.getParent().getKey()) 
		{
			n.getParent().setLeftChild(null);
			return;
		}
		else if(n.isLeaf() && n.getKey() > n.getParent().getKey()) 
		{
			n.getParent().setRightChild(null);
			return;
		}
		if(n.getRightChild() != null) 
		{
			Node rep = search(recursiveMin(n.getRightChild()));
			if(n.getKey() < n.getParent().getKey()) {
				n.getParent().setLeftChild(rep);
			}
			else {
				n.getParent().setRightChild(rep);
			}
			deleteNode(rep);
			return;
		}
		if(n.getLeftChild() != null) 
		{
			Node rep = search(recursiveMin(n.getLeftChild()));
			if(n.getKey() < n.getParent().getKey()) {
				n.getParent().setLeftChild(rep);
			}
			else {
				n.getParent().setRightChild(rep);
			}
			deleteNode(rep);
			return;
		}
	}
	
	public void printTree() 
	{
		int depth = findDepth(root);
		printTree(root, depth);
	}
	
	private void printTree(Node n, int depth) 
	{
		printSpaces(depth);
		System.out.println(n.getKey());
		if(n.getLeftChild() != null) 
		{
			printLeft(n, --depth);
		}
		if(n.getRightChild() != null) 
		{
			printRight(n, --depth);
		}
		if(n.getLeftChild() != null && n.getRightChild() != null) 
		{
			printTree(n.getLeftChild(), depth);
			printTree(n.getRightChild(), depth);
		}
		else if(n.getLeftChild() != null)
			printTree(n.getLeftChild(), depth);
		else if(n.getRightChild() != null)
			printTree(n.getRightChild(), depth);
	}
	
	private void printRight(Node n, int d) 
	{
		printSpaces(d);
		System.out.print(n.getRightChild().getKey() + " ");
	}
	
	private void printLeft(Node n, int d) 
	{
		printSpaces(d);
		System.out.print(n.getLeftChild().getKey() + " ");
	}
	
	private void printSpaces(int d) 
	{
		if(d <= 0)
			return;
		System.out.print(" ");
		printSpaces(--d);
	}
	
	private int findDepth(Node n) 
	{
		int left = findLeft(n, 1);
		int right = findRight(n, 1);
		if(left >= right)
			return left;
		else
			return right;
	}

	private int findLeft(Node n, int c) 
	{
		if(n.getLeftChild() != null)
			return findLeft(n.getLeftChild(), ++c);
		if(n.getRightChild() != null)
			return findLeft(n.getRightChild(), ++c);
		return c;
	}
	
	private int findRight(Node n, int c) 
	{
		if(n.getRightChild() != null)
			return findRight(n.getRightChild(), ++c);
		if(n.getLeftChild() != null)
			return findRight(n.getRightChild(), ++c);
		return c;
	}
}
