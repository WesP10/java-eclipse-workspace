
public class Test {

	public static void main(String[] args) {
		Card card = new Card("H", 6);
		SolitaireBoard board = new SolitaireBoard();
		System.out.println(board.getDeck());
		System.out.println(board.getDiscard());
		board.flip(3);
		System.out.println(board.getDiscard());
		for(int i = 0; i < board.getDiscard().size(); i++)
			System.out.println(board.getDiscard().get(i).isFaceUp());
//		System.out.println(board.getDiscard());
	}

	public void testHolder() 
	{
		Card card = new Card("H", 6);
		SolitaireBoard board = new SolitaireBoard();
		
		board.getDeck().get(board.getDeck().size()-1).setFaceUp(true);
		System.out.println(board.getDeck());
		System.out.println(board.getDiscard());
		board.flip(3);
	}
}
