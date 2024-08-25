package Hangman;

import java.io.FileNotFoundException;

import TicTacToe.Logger;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class HangmanListener extends ListenerAdapter{

	private Hangman game;
	private Logger p;
	private User player;
	
	public HangmanListener() 
	{
		game = null;
		p = new Logger();
		player = null;
	}
	
	public void onSlashCommand(SlashCommandEvent e) 
	{
		if(e.getName().equals("start")) start(e);
		if(e.getName().equals("end")) end(e);
		if(e.getName().equals("guess")) guess(e, e.getOption("guess").getAsString().toUpperCase());
	}
	
	public void start(SlashCommandEvent e) 
	{
		e.deferReply().queue();
		if(game != null) {p.print("A game is already in progress!", e); return;}
		try {game = new Hangman();} catch (FileNotFoundException e1) {e1.printStackTrace();}
		player = e.getUser();
		p.print(player.getName()+" started a game of hangman!", e);
	}
	
	public void end(SlashCommandEvent e) 
	{
		e.deferReply().queue();
		if(game == null) {p.print("No game is in progress!", e); return;}
		if(!player.equals(e.getUser())) {p.print("You must be playing to end the game!", e); return;}
		p.print("Game ended, the word was "+game.getWord()+". Use /start to play again!", e);
		game = null;
		player = null;
	}
	
	public void guess(SlashCommandEvent e, String g) 
	{
		e.deferReply().queue();
		if(g.length() != 1) {p.print("Your guess must be one letter", e); return;}
		if(game == null) {p.print("A game is not in progress!", e); return;}
		if(!player.equals(e.getUser())) {p.print("You must be playing to make a guess the game!", e); return;}
		if(game.guess(g))
			p.print(game.getCurrentWord(), e);
		else
			p.print("NO NEW LETTERS: "+game.getCurrentWord(), e);
		p.print(game.getMan().get(game.getLife()), e);
		p.print("Available: "+game.getNotGuessed(), e);
		if(!game.getGameOn()) 
		{
			if(game.checkWin()) win(e);
			else lose(e);
		}
	}
	
	private void win(SlashCommandEvent e) 
	{
		p.print(player.getName()+" beat the hangman!", e);
		game = null;
		player = null;
	}
	
	private void lose(SlashCommandEvent e) 
	{
		p.print(player.getName()+" lost hangman!", e);
		game = null;
		player = null;
	}
}
