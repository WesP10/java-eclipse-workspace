import java.util.ArrayList;



public class NQueensBoard
{
	private int[][] board;
	public final int QUEEN = -2;
	public final int ELIMINATED = -1;

	
	/**
	 * constructor
	 * initializes board to be of size n-by-n and containing all zeroes
	 */
	public NQueensBoard(int n)
	{
		board = new int[n][n];
		for(int i = 0; i < board.length; i++)
			for(int j = 0; j < board.length; j++)
				board[i][j] = 0;

	}
	
	public int countQueens()
	{
		int count = 0;
		for(int i = 0; i < board.length; i++)
			for(int j = 0; j < board.length; j++)
				if(board[i][j] == QUEEN)
					count++;
		return count;
	}
	
	/**
	 * sets value of all cells in board to 0
	 */
	public void refreshBoard()
	{
		for(int i = 0; i < board.length; i++)
			for(int j = 0; j < board.length; j++)
				board[i][j] = 0;
	}
	
	/**
	 * prints the contents of each square in board in tabular format
	 * if square contains QUEEN, print 'Q'
	 * if square contains ELIMINATED, print '~'
	 * otherwise, print '-'
	 */
	public void printGrid()
	{
		for(int[] row : board)
		{
			for(int space : row)
			{
				if(space == QUEEN)
					System.out.print("Q ");
				else if(space == ELIMINATED)
					System.out.print("~ ");
				else
					System.out.print(space + " ");
			}
			System.out.println();
		}
	}
	
	public int[][] getBoard()
	{
		return board;
	}
	/**
	 * calls scoreSquare method for each square on board
	 * places result from each call to scoreSquare in that square in board
	 */
	public void scoreSpaces()
	{
		for(int i = 0; i < board.length; i++)
			for(int j = 0; j < board.length; j++)
				board[i][j] = scoreSquare(i, j);
	}
	/**
	 * returns true if there is an available square on board
	 * returns false if there are no available squares
	 */
	public boolean checkBoard()
	{
		for(int i = 0; i < board.length; i++)
			for(int j = 0; j < board.length; j++)
				if(board[i][j]>=0)
					return true;
		return false;
	}
	/**
	 * changes the value of board[row][col] to QUEEN
	 * changes the value of all squares that are eliminated by this queen to ELIMINATED 
	 */
	public void placeQueen(int row, int col)
	{
		int maxIndex = board.length;
		board[row][col] = QUEEN;
		for(int c = 0; c < board[row].length; c++)
			if(c != col)
				board[row][c] = ELIMINATED;
		for(int r = 0; r < board.length; r++)
			if(r != row)
				board[r][col] = ELIMINATED;
		for(int i = 1; i < board.length; i++)
		{
			if(row + i < maxIndex && col + i < maxIndex)
				board[row+i][col+i] = ELIMINATED;
			if(row + i < maxIndex && col - i >= 0)
				board[row+i][col-i] = ELIMINATED;
			if(row - i >= 0 && col + i < maxIndex)
				board[row-i][col+i] = ELIMINATED;
			if(row - i >= 0 && col - i >= 0)
				board[row-i][col-i] = ELIMINATED;
		}
	}
	/**
	 * returns ELIMINATED if square at row, col contains ELIMINATED 
	 * returns QUEEN if square at row, col contains QUEEN
	 * otherwise, counts the number of squares that would become unavailable 
	 * if the square at row, col were to receive a queen (including the 	  
       	 * square at row,col); this count is returned
	 */
	public int scoreSquare(int row, int col)
	{
		int count = 1;
		if( board[row][col]==QUEEN || board[row][col] == ELIMINATED)
			return board[row][col];
		else
		{
			for(int c = 0; c< board[row].length; c++)
				if(board[row][c]!= ELIMINATED && board[row][c] != QUEEN && c!=col) count++;
			for(int r = 0; r< board.length; r++)
				if(board[r][col]!= ELIMINATED && board[r][col] != QUEEN && r!=row) count++;
			for(int r = row+1, c = col+1; r < board.length && c<board[r].length; r++, c++)
				if(board[r][c]!= ELIMINATED && board[r][c] != QUEEN) count++;
			for(int r = row+1, c = col-1; r < board.length && c>=0; r++, c--)
				if(board[r][c]!= ELIMINATED && board[r][c] != QUEEN) count++;
			for(int r = row-1, c = col+1; r >=0 && c<board[r].length; r--, c++)
				if(board[r][c]!= ELIMINATED && board[r][c] != QUEEN) count++;
			for(int r = row-1, c = col-1; r >=0 && c>=0; r--, c--)
				if(board[r][c]!= ELIMINATED && board[r][c] != QUEEN) count++;	
		
			return count;
		}
		
	}
	/**
	 * calculates the smallest non-negative score on the board
	 * determines the number of squares that contain this score
	 * randomly selects one of these squares 
	 * calls placeQueen method to place a queen in this square
	 */
	public void findAndPlace()
	{
		for(int i = 0; i < board.length; i++)
			for(int j = 0; j < board.length; j++)
				board[i][j] = scoreSquare(i, j);
		int minPos = board.length * board.length;
		for(int i = 0; i < board.length; i++)
			for(int j = 0; j < board.length; j++)
				if(board[i][j] >= 0 && board[i][j] < minPos)
					minPos = board[i][j];
		
		ArrayList<Position> lows = new ArrayList<Position>();
		for(int i = 0; i < board.length; i++)
			for(int j = 0; j < board.length; j++)
				if (board[i][j] == minPos)
				{
					lows.add(new Position(i, j));
				}
		
		int random = (int) (Math.random()*lows.size());
		placeQueen(lows.get(random).getRow(),lows.get(random).getCol());
		
	}
	
	public class Position
	{
		int row;
		int col;
		
		public Position (int i, int j)
		{
			row = i;
			col = j;
		}

		
		/**
		 * @return the row
		 */
		public int getRow()
		{
			return row;
		}

		
		/**
		 * @return the col
		 */
		public int getCol()
		{
			return col;
		}
		
	}

}