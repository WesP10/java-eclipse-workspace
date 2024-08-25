import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class TicTacToeBot extends ListenerAdapter{

	private TicTacToe t;
	private User p1, p2;
	private boolean p1Turn, gameOn;
	
	public void setGameOn(boolean b) 
	{
		gameOn = b;
	}
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent e) 
	{
		String[] args = e.getMessage().getContentRaw().split(" ");
		if(!args[0].equals("!") || e.getAuthor().isBot())
			return;
		String key = args[1];
		//start
		if(key.equalsIgnoreCase("start")) {
			if(gameOn) 
			{
				e.getChannel().sendMessage("Game in session, Please Use '! end' if you want to end your current game").queue();
				return;
			}
			t = new TicTacToe();
			p1Turn = true;
			gameOn = true;
			p1 = e.getAuthor();
			e.getMessage().reply("Use '! join' to play against "+ p1.getName()).queue();
			return;
		}
		//join
		if(key.equalsIgnoreCase("join")) {
			if(!gameOn) 
			{
				e.getChannel().sendMessage("No game currently started, use '! start' to start a game").queue();
				return;
			}
			if(p2 != null) 
			{
				e.getChannel().sendMessage("Game already had two players").queue();
				return;
			}
			p2 = e.getAuthor();
			e.getMessage().reply("Game Started: "+ p1.getName()+" vs "+ p2.getName()).queue();
			return;
		}
		//move
		if(key.equalsIgnoreCase("move")) {
			if(!gameOn) 
			{
				e.getChannel().sendMessage("Use '! start' to start a game").queue();
				return;
			}
			if(p2 == null) 
			{
				e.getChannel().sendMessage("Use '! join' to add a second player").queue();
				return;
			}
			
			if(!move(args[2], e)) 
			{
				e.getChannel().sendMessage("Move did not work :(").queue();
				e.getChannel().sendMessage("Make sure it is your turn and it you follow the correct format Example '! move a2'").queue();
				return;
			}
			if(!gameOn) return;
			if(p1Turn) 
				e.getChannel().sendMessage(printBoard(t) + "\n Player One's Turn").queue();
			else
				e.getChannel().sendMessage(printBoard(t) + "\n Player Two's Turn").queue();
			return;
		}
		//end
		if(key.equalsIgnoreCase("end")) 
		{
			if(!p1.equals(e.getAuthor()) && !p2.equals(e.getAuthor())) 
			{
				e.getChannel().sendMessage("You must be playing to end the game").queue();
				return;
			}
			gameOn = false;
			p1 = null;
			p2 = null;
			e.getChannel().sendMessage("'! start' to start a game!").queue();
			return;
		}
	}
	
	public boolean move(String move, GuildMessageReceivedEvent e) 
	{
		if(move.length() > 2 || move.length() < 2) return false;
		String th = ""+move.charAt(0);
		if(!(th.equalsIgnoreCase("a") || th.equalsIgnoreCase("b") || th.equalsIgnoreCase("c"))) return false;
		char c = move.charAt(0);
		int num = 0;
		try{int i = Integer.parseInt(""+move.charAt(1)); num = i-1;}
		catch (NumberFormatException nfe) { return false;}
		int let = 0;
		if(num < 0 || num > 2) return false;
		if("B".equalsIgnoreCase(""+c)) let = 1;
		if("c".equalsIgnoreCase(""+c)) let = 2;
		boolean worked = false;
		if(p1Turn && p1.getName().equals(e.getAuthor().getName())) 
		{
			if(t.getBoard(let, num) > 0) {e.getChannel().sendMessage("The space you selected is not open").queue(); return false;}
			t.placeO(let, num); 
			p1Turn = false; 
			worked = true;
		}
		else if(p2.getName().equals(e.getAuthor().getName())) 
		{
			if(t.getBoard(let, num) > 0) {e.getChannel().sendMessage("The space you selected is not open").queue(); return false;}
			t.placeX(let, num); 
			p1Turn = true; 
			worked = true;
		}
		if(t.checkTie()) tie(e);
		if(t.checkWinner()== 1) win1(e);
		if(t.checkWinner() == 2)win2(e);
		return worked;
	}
	
	public void tie(GuildMessageReceivedEvent e) 
	{
		gameOn = false;
		TextChannel text = e.getChannel();
		text.sendMessage(printBoard(t) + "\n"+p1.getName() +" and " + p2.getName() + " tied. '! start' to play again").queue();
	}
	
	public void win1(GuildMessageReceivedEvent e) 
	{
		gameOn = false;
		TextChannel text = e.getChannel();
		text.sendMessage(printBoard(t) + "\n"+p1.getName() +" beat " + p2.getName() + " in an intense match! '! start' to play again").queue();
	}
	
	public void win2(GuildMessageReceivedEvent e) 
	{
		gameOn = false;
		TextChannel text = e.getChannel();
		text.sendMessage(printBoard(t) + "\n"+p2.getName() +" destroyed " + p1.getName() + "! '! start' to play again").queue();
	}
	
	public String printBoard(TicTacToe game) 
	{
		int[][] board = game.getBoard();
		String b = "A   B   C \n";
		
		for(int i = 0; i < board.length; i++) 
		{
			for(int j = 0; j < board[i].length; j++) 
			{
				if(j == board.length-1)
					if(board[j][i] == 1)
						b+="X";
					else if(board[j][i] == 2)
						b+="O";
					else
						b+="-";
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
