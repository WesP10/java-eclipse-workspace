package TicTacToe;

public class TicTacToe {
	//instance variables
	private int[][] board;
	//constans used to populate board 2d array
	private final int XVALUE;
	private final int OVALUE;
	//constructor
	public TicTacToe() 
	{
		board = new int[3][3];
		XVALUE = 1;
		OVALUE = 2;
	}
	//returns board which is a private variable
	public int[][] getBoard()
	{
		return board;
	}
	//returns value in board @param col and @param row
	public int getBoard(int col, int row) 
	{
		return board[col][row];
	}
	//replaces a 0 with an 1 at col, row
	public void placeX(int col, int row) 
	{
		board[col][row] = XVALUE;
	}
	//replaces a 0 with a 2 at col, row
	public void placeO(int col, int row) 
	{
		board[col][row] = OVALUE;
	}
	//sweeps across all winning patterns and checks if 3 X's or 3's are consecutive
	public int checkWinner() 
	{
		int count = 0;
		//checks vertical rows
		for(int i = 0; i < board.length; i++) 
		{
			for(int j = 0; j < board[i].length; j++) 
			{
				if(board[i][j] == XVALUE)
					count++;
			}
			if(count == 3)
				return XVALUE;
			count = 0;
			for(int j = 0; j < board[i].length; j++) 
			{
				if(board[i][j] == OVALUE)
					count++;
			}
			if(count == 3)
				return OVALUE;
			count = 0;
		}
		//checks horizontal cols
		for(int i = 0; i < board.length; i++) 
		{
			for(int j = 0; j < board[i].length; j++) 
			{
				if(board[j][i] == XVALUE)
					count++;
			}
			if(count == 3)
				return XVALUE;
			count = 0;
			for(int j = 0; j < board[i].length; j++) 
			{
				if(board[j][i] == OVALUE)
					count++;
			}
			if(count == 3)
				return OVALUE;
			count = 0;
		}
		//checks bottom right diagnol
		for(int i  = 0; i < board.length; i++) 
		{
			if(board[i][i] == XVALUE)
				count++;
		}
		if(count == 3)
			return XVALUE;
		count = 0;
		for(int i  = 0; i < board.length; i++) 
		{
			if(board[i][i] == OVALUE)
				count++;
		}
		if(count == 3)
			return OVALUE;
		count = 0;
		//checks bottom left diagnol
		for(int i  = board.length-1, j = 0; i >= 0 && j < board.length; i--, j++) 
		{
			if(board[i][j] == XVALUE)
				count++;
		}
		if(count == 3)
			return 1;
		count = 0;
		for(int i  = board.length-1, j = 0; i >= 0 && j < board.length; i--, j++) 
		{
			if(board[i][j] == OVALUE)
				count++;
		}
		if(count == 3)
			return OVALUE;
		return 0;
	}
	//checks to see if all values are filled returns false as long as there is even a single 0
	public boolean checkTie() 
	{
		int count = 0;
		
		for(int i = 0; i < board.length; i++) 
			for(int j = 0; j < board[i].length; j++) 
				if(board[i][j] == 0)
					count++;
		return count <= 0;
	}
	
}
