package TicTacToe;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class TTTListener extends ListenerAdapter{

	private TicTacToe t;
	private User p1, p2;
	private Logger log;
	private boolean p1Turn, gameOn;
	
	public TTTListener() 
	{
		t = new TicTacToe();
		gameOn = false;
		p1Turn = false;
		log = new Logger();
	}
	@Override
	public void onSlashCommand(SlashCommandEvent e) 
	{
		if(e.getName().equals("start")) start(e);
		if(e.getName().equals("move")) move(e, e.getOption("move").getAsString());
		if(e.getName().equals("join")) join(e);
		if(e.getName().equals("end")) end(e);
	}
	
	public void start(SlashCommandEvent e) 
	{
		e.deferReply().queue();
		if(gameOn) {log.print("There is already a game in progress!", e); return;}
		p1 = e.getUser();
		p1Turn = true;
		gameOn = true;
		log.print(p1.getName()+" has started a game, use /join to add a second player!", e);
	}
	
	public void move(SlashCommandEvent e, String move) 
	{
		e.deferReply().queue();
		if(!gameOn) {log.print("Use /start to start a game!", e); return;}
		if(e.getUser() != p1 || e.getUser() != p2) {log.print("You must be a player to make a move!", e); return;}
		if(p1Turn && e.getUser() != p1) {log.print("It is not your turn!", e); return;}
		else if(!p1Turn && e.getUser() != p2) {log.print("It is not your turn!", e); return;}
		if(move.length() != 2) {log.print("Your move must follow the 'a1' format!", e); return;}
		char col = move.toLowerCase().charAt(0);
		if(Character.compare(col, 'a') != 0 && Character.compare(col, 'b') != 0 && Character.compare(col, 'c') != 0) {log.print("Letter must be between a and c!", e); return;}
		int row = Integer.parseInt(""+move.charAt(1))-1;
		if(row > 2 || row < 0) {log.print("Your move must be between 1 and 3!", e); return;}
		if(!move(col, row)) {log.print("error!", e); return;}
		p1Turn = !p1Turn;
		log.print(printBoard(t), e);
		check(e);
	}
	
	public void join(SlashCommandEvent e) 
	{
		e.deferReply().queue();
		if(!gameOn) {log.print("Use /start to start a game!", e); return;}
		if(p2 != null) {log.print("There are already two players!", e); return;}
		p2 = e.getUser();
		log.print(p2.getName()+" has joined the game!", e);
	}
	
	public void end(SlashCommandEvent e) 
	{
		e.deferReply().queue();
		if(e.getUser() != p1 || e.getUser() != p2) {log.print("You must be playing to end the game!", e); return;}
		t = new TicTacToe();
		gameOn = false;
		p1Turn = false;
		p1 = null;
		p2 = null;
		log.print("Game has ended, use /start to play again!", e);
	}
	
	public boolean move(char c, int row) 
	{
		int col = 0;
		if(Character.compare(c, 'a') == 0) col = 0;
		else if(Character.compare(c, 'b') == 0) col = 1;
		else if(Character.compare(c, 'c') == 0) col = 2;
		else return false;
		if(p1Turn) t.placeX(col, row);
		else t.placeO(col, row);
		return true;
	}
	
	public void check(SlashCommandEvent e) 
	{
		if(t.checkWinner() == 1) {log.print(p1.getName()+" wins, /start to play again!", e); gameOn = false; p1 = null; p2 = null; return;}
		if(t.checkWinner() == 2) {log.print(p2.getName()+" wins, /start to play again!", e); gameOn = false; p1 = null; p2 = null; return;}
		if(t.checkTie()) {log.print("Tie game, /start to play again!", e); gameOn = false; p1 = null; p2 = null;}
	}
	
	public String printBoard(TicTacToe game) 
	{
		int[][] board = game.getBoard();
		String b = "A   B   C \n";
		
		for(int i = 0; i < board.length; i++) 
		{
			for(int j = 0; j <= board[i].length; j++) 
			{
				if(j == board.length) {
					int t = i+1;
					b+=""+t;
				}
				else if(j == board.length-1)
					if(board[j][i] == 1)
						b+="X ";
					else if(board[j][i] == 2)
						b+="O ";
					else
						b+="- ";
				else
					if(board[j][i] == 1)
						b+="X |";
					else if(board[j][i] == 2)
						b+="O |";
					else
						b+="- |";
			}
			b+="\n";
		}
		return b;
	}
}
