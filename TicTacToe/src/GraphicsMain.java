import java.awt.Color;
import java.util.Scanner;

import processing.core.PApplet;

/**
 * 
 * @author Weston
 *
 */

public class GraphicsMain extends PApplet{

	public static void main(String[] args) {
		PApplet.main("GraphicsMain");
	}
	//Variable for tracking game
	TicTacToe game = new TicTacToe();
	int[][] board = game.getBoard();
	Scanner s = new Scanner(System.in);
	boolean gameOver = false, POT = true;
	//set screen size
	public void settings() {
		size(600,600);
	}
	/* updates global variable board
	 * draws the lines the seperate the numbers
	 * draws an X or O if board array contains a 1 or a zero
	 */
	public void draw() 
	{
		background(15, 30, 200);
			drawBoard();
			board = game.getBoard();
			drawSymbols();
	}
	/*
	 * checks mouse position and places tile
	 * then runs turn() method regardless of position
	 */
	public void mousePressed() 
	{
		if(in00()) 
		{
			if(POT)
				game.placeX(0, 0);
			else
				game.placeO(0, 0);
			turn();
		}
		if(in01()) 
		{
			if(POT)
				game.placeX(0, 1);
			else
				game.placeO(0, 1);
			turn();
		}
		if(in02()) 
		{
			if(POT)
				game.placeX(0, 2);
			else
				game.placeO(0, 2);
			turn();
		}
		if(in10()) 
		{
			if(POT)
				game.placeX(1, 0);
			else
				game.placeO(1, 0);
			turn();
		}
		if(in11()) 
		{
			if(POT)
				game.placeX(1, 1);
			else
				game.placeO(1, 1);
			turn();
		}
		if(in12()) 
		{
			if(POT)
				game.placeX(1, 2);
			else
				game.placeO(1, 2);
			turn();
		}
		if(in20()) 
		{
			if(POT)
				game.placeX(2, 0);
			else
				game.placeO(2, 0);
			turn();
		}
		if(in21()) 
		{
			if(POT)
				game.placeX(2, 1);
			else
				game.placeO(2, 1);
			turn();
		}
		if(in22()) 
		{
			if(POT)
				game.placeX(2, 2);
			else
				game.placeO(2, 2);
			turn();
		}
	}
	//draws 4 lines at postions for a TicTacToe board
	public void drawBoard() 
	{
		strokeWeight(20);
		stroke(255);
		line(2*width/6, 50, 2*width/6, height-50);
		line(4*width/6, 50, 4*width/6, height-50);
		line(50, 2*height/6, width-50, 2*height/6);
		line(50, 4*height/6, width-50, 4*height/6);
	}
	//iterates through 2d array and if it contains a 1 it displays and X if it catches 2 it displays a O
	public void drawSymbols() 
	{
		textSize(155);
		for(int i = 0; i < board.length; i++) 
			for(int j = 0; j < board[i].length; j++) 
			{
				if(board[j][i] > 0)
				{
					String XO;
					if(board[j][i] == 1)
						XO = "X";
					else
						XO = "O";
					text(XO, (3*j*width/10)+70, (3*i*height/10)+175);
				}
			}
	}
	/*
	 * switches player one turn boolean
	 * checks winner and displays Winning message based on result of checkWinner()
	 * checks tie if checkWinner returns 0
	 */
	public void turn() 
	{
		POT = !POT;
		if(game.checkWinner() > 0)
		{
			if(game.checkWinner() == 1) 
			{
				System.out.println("Player One Wins!");
				exit();
				return;
			}
			else 
			{
				System.out.println("Player Two Wins!");
				exit();
				return;
			}
		}
		if(game.checkTie()) 
		{
			System.out.println("Tie Game Play Again");
			exit();
		}
	}
	//methods in00() - in22() contain boolean statment to check bounds of mouse based on the lines of TicTacToe board
	public boolean in00() 
	{
		return mouseX > 50 && mouseX < 2*width/6 && mouseY > 50 && mouseY < 2*height/6 && board[0][0] == 0;
	}
	
	public boolean in01() 
	{
		return mouseX > 50 && mouseX < 2*width/6 && mouseY > 2*height/6 && mouseY < 4*height/6 && board[0][1] == 0;
	}
	
	public boolean in02() 
	{
		return mouseX > 50 && mouseX < 2*width/6 && mouseY > 4*height/6 && mouseY < height-50 && board[0][2] == 0;
	}
	
	public boolean in10() 
	{
		return mouseX > 2*width/6 && mouseX < 4*width/6 && mouseY > 50 && mouseY < 2*height/6 && board[1][0] == 0;
	}
	
	public boolean in11() 
	{
		return mouseX > 2*width/6 && mouseX < 4*width/6 && mouseY > 2*height/6 && mouseY < 4*height/6 && board[1][1] == 0;
	}
	
	public boolean in12() 
	{
		return mouseX > 2*width/6 && mouseX < 4*width/6 && mouseY > 4*height/6 && mouseY < height-50 && board[1][2] == 0;
	}
	
	public boolean in20() 
	{
		return mouseX > 4*width/6 && mouseX < width-50 && mouseY > 50 && mouseY < 2*height/6 && board[2][0] == 0;
	}
	
	public boolean in21() 
	{
		return mouseX > 4*width/6 && mouseX < width-50 && mouseY > 2*height/6 && mouseY < 4*height/6 && board[2][1] == 0;
	}
	
	public boolean in22() 
	{
		return mouseX > 4*width/6 && mouseX < width-50 && mouseY > 4*height/6 && mouseY < height-50 && board[2][2] == 0;
	}
}
