
public class BinarySearchMain {

	public static void main(String[] args) {
		BinarySearchTree bst = createTree();
		bst.printTree();
		System.out.print("pre-order: ");
		bst.preOrderTraversal();
		System.out.println();
		bst.deleteNode(20);
		System.out.print("post-order: ");
		bst.postOrderTraversal();
		System.out.println();
		System.out.println("Max is "+bst.min());
		System.out.println("Min is "+bst.max());
	}

	public static BinarySearchTree createTree() 
	{
		BinarySearchTree bst = new BinarySearchTree(new Node(10, null, null, null));
		bst.insert(4);
		bst.insert(2);
		bst.insert(6);
		bst.insert(12);
		bst.insert(11);
		bst.insert(20);
		System.out.print("bst in-order: ");
		bst.inOrderTraversal();
		System.out.println();
		return bst;
	}
}
