import java.util.Scanner;

/**
 * 
 * @author Weston
 *
 */

public class ConsoleMain {
	public static void main(String[] args) {
		//constructor for TICTACTOE
		TicTacToe game = new TicTacToe();
		//copy of board so I don't have to deal with private variables
		int[][] board = game.getBoard();
		//scanner for player inputs
		Scanner s = new Scanner(System.in);
		//current player inputted col and row
		int userCol, userRow;
		//booleans tracking if the game should countinue and if there isn't a 0 in the spot
		boolean gameOver = false, validMove = false;
		//game ends if gameOver == true
		while(gameOver == false)
		{
			while(validMove == false) 
			{	//displays current gameboard and asks player for values
				printBoard(game);
				System.out.println("Player One Please Select a Column: ");
				userCol = s.nextInt();
				System.out.println("Player One Please Select a Row: ");
				userRow = s.nextInt();
				//checks if the players move is open
				if( userCol >= 1 & userCol <= 3 & userRow >= 1 & userRow <= 3)
				{	/*if move is valid an X is placed
				 	* validMove is made true
				 	* Global variable is board is set to match private variabel board
				 	*/
					if (board[userCol-1][userRow-1] == 0) {
						game.placeX(userCol - 1, userRow - 1);
						validMove = true;
						board = game.getBoard();
					}
				}
				//if the move is invalid the player is informed with this message
				else
					System.out.println("NOT A VALID MOVE");
			}
			//reset validMove variable to false for player 2
			validMove = false;
			//checks gameOver and ends loop to prevent Player 2 from moving after the game
			gameOver = checkGameOver(game);
			if(gameOver == true)
				break;
			//repeat steps for player 1
			while(validMove == false) 
			{
				printBoard(game);
				System.out.println("Player Two Please Select a Column: ");
				userCol = s.nextInt();
				System.out.println("Player Two Please Select a Row: ");
				userRow = s.nextInt();
				if(board[userCol-1][userRow-1] == 0 || userCol > 3 || userRow > 3) 
				{
					game.placeO(userCol-1, userRow-1);
					validMove = true;
					board = game.getBoard();
				}
				else
					System.out.println("NOT A VALID MOVE");
			}
			validMove = false;
			gameOver = checkGameOver(game);
		}
	}

	//prints board in pretty fashion for the players to see
	public static void printBoard(TicTacToe game) 
	{
		int[][] board = game.getBoard();
		
		for(int i = 0; i < board.length; i++) 
		{
			for(int j = 0; j < board[i].length; j++) 
			{
				if(j == board.length-1)
					if(board[j][i] == 1)
						System.out.print("X");
					else if(board[j][i] == 2)
						System.out.print("O");
					else
						System.out.print("-");
				else
					if(board[j][i] == 1)
						System.out.print("X |");
					else if(board[j][i] == 2)
						System.out.print("O |");
					else
						System.out.print("- |");
			}
			System.out.println();
		}
		System.out.println();
	}
	//uses TicTacToe.java's checkWinner() method to print out appriate mesage
	public static boolean checkGameOver(TicTacToe game) 
	{
		int winner;
		
		winner = game.checkWinner();
		if(winner > 0) 
		{
			if(winner == 1)
				System.out.println("Player One Wins!");
			else
				System.out.println("Player Two Wins!");
			return true;
		}
		if(game.checkTie() != false)
		{
			System.out.println("The Game is a Tie :(");
			return true;
		}
		
		return false;
	}
}
