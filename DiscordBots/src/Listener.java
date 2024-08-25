import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Listener extends ListenerAdapter{
	
	public void onGuildMessageReceived(GuildMessageReceivedEvent e) 
	{
		String userName = e.getAuthor().getName();
		if(!userName.equals("CasperTG")) return;
		
		TicTacToe t = new TicTacToe();
		e.getMessage().reply(printBoard(t)).queue();;
	}
	
	public String printBoard(TicTacToe game) 
	{
		int[][] board = game.getBoard();
		String b = "";
		
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