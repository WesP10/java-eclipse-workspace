/**
 * A simple position class to hold rows and columns. It also holds a reference to a previous position
 * for determining the path at the end.
 * @author SharickE
 *
 */
public class Position {

	private int row, col;
	private Position previous;
	

	public Position(int row, int col)
	{
		this.row = row;
		this.col = col;
		previous = null;
	}
	
	public Position(int row, int col, Position previous) {
		this(row, col);
		this.previous = previous;
	}

	/**
	 * The position that came before this position in a path
	 * @return
	 */
	public Position getPrevious() {
		return previous;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public boolean equals(Object other) {
		if(other == null || other.getClass() != getClass()) return false;
		else {
			Position p = (Position) other;
			return row == p.row && col == p.col;
		}
	}
	
	@Override
	public String toString() {
		return "Position [row=" + row + ", col=" + col + "]";
	}
	
	

}
