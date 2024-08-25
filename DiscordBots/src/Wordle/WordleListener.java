package Wordle;

import java.io.FileNotFoundException;
import java.util.HashMap;

import TicTacToe.Logger;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class WordleListener extends ListenerAdapter{

	private Wordle wordle;
	private String word;
	private User player;
	private String[][] board;
	private boolean gameOn;
	private Logger p;
	
	public WordleListener() throws FileNotFoundException 
	{
		board = new String[6][5];
		wordle = new Wordle();
		word = wordle.getWord();
		p = new Logger();
		gameOn = false;
	}
	
	public void onSlashCommand(SlashCommandEvent e) 
	{
		if(e.getName().equals("start")) start(e);
		if(e.getName().equals("end")) end(e);
		if(e.getName().equals("guess")) guess(e, e.getOption("guess").getAsString());
	}

	public void start(SlashCommandEvent e) 
	{
		e.deferReply().queue();
		if(gameOn) {p.print("A game is already in progress!", e); return;}
		try {wordle = new Wordle();} catch (FileNotFoundException e1) {e1.printStackTrace();}
		word = wordle.getWord();
		System.out.println("WORD: "+word);
		gameOn = true;
		player = e.getUser();
		for(int i = 0;i < board.length; i++)
			for(int j = 0; j < board[i].length; j++)
				board[i][j] = "";
		p.print(player.getName()+" 's Wordle game has started, try using /guess to make a guess!", e);
	}
	
	public void end(SlashCommandEvent e) 
	{
		e.deferReply().queue();
		if(!gameOn) {p.print("No game in progress, try /start to start a game!", e); return;}
		if(!player.equals(e.getUser())) {p.print("Must be playing to end curent game!", e); return;}
		gameOn = false;
		p.print("Game has ended, use /start to play again!", e);
	}
	
	public void guess(SlashCommandEvent e, String g) 
	{
		e.deferReply().queue();
		if(!gameOn) {p.print("No game in progress, try /start to start a game!", e); return;}
		if(!player.equals(e.getUser())) {p.print("Must be playing to end curent game!", e); return;}
		g = wordle.askGuess(g);
		if(g == null) {p.print("Guess must be a five letter word!", e); return;}
		wordle.checkGuess(g);
		p.print("POSSSIBLE LETTERS: "+wordle.getNotGuessed(), e);
		p.print(printGuess(g), e);
		if(g.equals(word)) win(e);
		if(wordle.getNumGuesses() >= 6) lose(e);
	}
	
	public void lose(SlashCommandEvent e) 
	{
		p.print(player.getName()+" couldn't guess the Wordle! It was "+word, e);
		gameOn = false;
	}
	
	public void win(SlashCommandEvent e) 
	{
		p.print(player.getName()+" got the Wordle in "+wordle.getNumGuesses()+" guesses!", e);
		gameOn = false;
	}
	
	public String printGuess(String g) 
	{
		HashMap<String, Integer> green = wordle.getGreen();
		HashMap<String, Integer> yellow = wordle.getYellow();
		int row = wordle.getNumGuesses()-1;
		
		for(int i = 0; i < word.length(); i++) 
		{
			boolean pass = false;
			String gChar = ""+g.charAt(i);
				if(green.containsKey(gChar)) {
					if(green.get(gChar) == i) {
						board[row][i] = green(gChar);
						pass = true;
					}
				}
				if(yellow.containsKey(gChar)) {
					if(yellow.get(gChar) == i) {
						board[row][i] = gChar;
						pass = true;
					}
				}
				if(!pass)
					board[row][i] = gChar.toLowerCase();
		}
		
		String b = "```ml"+"\n";
		for (String[] x : board)
		{
		   for (String y : x)
			  if(y != null)
		       b+=(y + " ");
			  else
				  b+="X ";
		   b+="\n";
		}
		return b+="```";
	}

	public String green(String c) 
	{
		c = "'"+c+"'";
		return c.toLowerCase();
	}
}
