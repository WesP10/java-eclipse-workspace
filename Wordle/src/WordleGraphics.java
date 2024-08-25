import java.io.FileNotFoundException;
import processing.core.PApplet;

public class WordleGraphics extends PApplet{

	public int boxW = 80, boxH = 80, offSetX = 60, offSetY = 8, r = 25, g = 125, b = 225;
	public Wordle wordle;
	public String[][] guesses;
	
	public static void main(String[] args) {
		PApplet.main("WordleGraphics");
	}

	public void settings() 
	{
		size(2000, 550);
	}
	
	public void setup() 
	{
		try {wordle = new Wordle();} catch (FileNotFoundException e) {e.printStackTrace();}
		guesses = new String[5][6];
		frameRate(20);
	}
	
	public void draw() 
	{
		background(r, g, b);
		drawGrid();
		drawLetters();
		drawGuess();
		askGuess();
	}
	
	
	private void drawGuess() 
	{
		//Itterates through 2d array of guess
		for(int i = 0; i < guesses.length; i++)
			for(int j = 0; j < guesses[i].length; j++) 
			{
				//Determines x and y position of letter being drawn
				int xH = i*boxW+122+(i*offSetX), yH = j*boxH+73+(j*offSetY);
				//g is the string currently being checked
				String g = guesses[i][j];
				//cc is the current character or wha is actually going to be displayed
				String cc = "";
				//Check to see if g is empty
				if(g != null) {
					//checks if green
				if(Character.toString(g.charAt(1)).equals("g")) {
					fill(0, 255, 0);
					cc += guesses[i][j].charAt(0);
				}
					//checks if yellow
				else if(Character.toString(g.charAt(1)).equals("y")) {
					fill(255, 255, 0);
					cc += guesses[i][j].charAt(0);
				}
					//otherwise character has no color
				else{
					fill(0);
					cc += guesses[i][j].charAt(0);
				}
				textSize(55);
				}
				//display character
				if(guesses[i][j] != null)
					text(cc, xH, yH);
			}
	}
	
	private void askGuess() 
	{
		String currentGuess = "";
		boolean validGuess = false;
		
		while(!validGuess) 
		{
			String guess = wordle.askGuess();
			if(guess != null) 
			{
				currentGuess = guess;
				break;
			}
			else
				System.out.println("Your guess must be a five letter word, try again: ");
		}
		if(currentGuess.equals(wordle.getWord())) 
		{
			textSize(225);
			fill(0, 255, 0);
			background(255);
			text("YOU WIN", 125, height/2+30);
			noLoop();
		}
		wordle.checkGuess(currentGuess);
		printGuess(currentGuess, wordle);
		if(wordle.getNumGuesses() <= 0) {
			textSize(225);
			fill(255, 0, 0);
			background(255);
			text("YOU LOSE", 125, height/2+30);
			noLoop();
		}
	}
	
	private void printGuess(String guess, Wordle wordle) 
	{
		int size = 0;
		if(wordle.getGreen().size() > wordle.getYellow().size())
			size = wordle.getGreen().size();
		else
			size = wordle.getYellow().size();
		
		for(int i = 0; i < guess.length(); i++) {
			boolean d = false;
			String currChar = ""+guess.charAt(i);
			for(int j = 0; j < size; j++) 
			{
				//green check
				if(j < wordle.getGreen().size()) 
				{
					if(currChar.equals(wordle.getGreen().get(j)) && !d) {
						//2nd character in string is "g"
						String cc = currChar+"g";
						guesses[i][5-wordle.getNumGuesses()] = cc;
						d = true;
					}
				}
			}
			for(int j = 0; j < size; j++) 
			{
				//yellow check
				if(j < wordle.getYellow().size()) 
				{
					if(currChar.equals(wordle.getYellow().get(j)) && !d) {
						//2nd charcter in string is "y"
						String cc = currChar+"y";
						guesses[i][5-wordle.getNumGuesses()] = cc;
						d = true;
					}
				}
			}
			if(!d) 
			{
				String cc = currChar+"n";
				guesses[i][5-wordle.getNumGuesses()] = cc;
				d = true;
			}
		}
		System.out.println();
	}
	
	private void drawLetters() 
	{
		String let = ""+wordle.getNotGuessed();
		textSize(45);
		fill(255);
		text(let, 975, 25, 250, height);
	}
	
	private void drawGrid() 
	{
		fill(255);
		for(int i = 0; i < 6; i++) 
		{
			for(int j = 0; j < 5; j++) 
			{
				int boxX = j*boxW+100+(j*offSetX), boxY = i*boxH+15+(i*offSetY);
				rect(boxX, boxY, boxW, boxH);
			}
		}
	}
}
