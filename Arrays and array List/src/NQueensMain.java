
public class NQueensMain {

	public static void main(String[] args) {
		NQueensBoard b = new NQueensBoard(5);
		b.printGrid();
		System.out.println(b.scoreSquare(0, 1));
	}

}
