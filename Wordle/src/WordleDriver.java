import java.io.FileNotFoundException;

public class WordleDriver {
	public static final String RED = "\u001B[31m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	public static final String RESET = "\u001B[0m";
	
	public static void main(String[] args) throws FileNotFoundException {
		boolean gameOver = false, validGuess = false;
		Wordle wordle = new Wordle();
		String currentGuess = "";
		while(!gameOver) 
		{
			System.out.println("Avaliable letters: "+wordle.getNotGuessed());
			System.out.println("Please input your first guess: ");
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
				System.out.println(GREEN+"YOU WIN"+RESET);
				break;
			}
			wordle.checkGuess(currentGuess);
			printGuess(currentGuess, wordle);
			if(wordle.getNumGuesses() <= 0) {
				gameOver = true;
				System.out.println(RED+"YOU LOSE"+RESET);
			}
		}
		
	}
	
	private static void printGuess(String guess, Wordle wordle) 
	{
		int size = 0;
		if(wordle.getGreen().size() > wordle.getYellow().size())
			size = wordle.getGreen().size();
		else
			size = wordle.getYellow().size();
		
		for(int i = 0; i < guess.length(); i++) {
			boolean d = false;
			for(int j = 0; j < size; j++) 
			{
				String currChar = ""+guess.charAt(i);
				if(j < wordle.getGreen().size()) 
				{
					if(currChar.equals(wordle.getGreen().get(j)) && !d) {
						String cc = GREEN + currChar + RESET;
						System.out.print(cc);
						d = true;
					}
				}
				if(j < wordle.getYellow().size()) 
				{
					if(currChar.equals(wordle.getYellow().get(j)) && !d) {
						String cc = YELLOW + currChar + RESET;
						System.out.print(cc);
						d = true;
					}
				}
			}
			if(!d) System.out.print(guess.charAt(i));
		}
		System.out.println();
	}

}
