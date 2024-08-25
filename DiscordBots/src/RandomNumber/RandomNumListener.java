package RandomNumber;
import TicTacToe.Logger;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class RandomNumListener extends ListenerAdapter{

	private Logger p;
	
	public RandomNumListener() 
	{
		p = new Logger();
	}
	
	public void onSlashCommand(SlashCommandEvent event) 
	{
		if(event.getName().equals("RandomNumber")) getNum(event);
		else if(event.getName().contains("Guess")) guess(event, event.getOption("guess").getAsString());
	}
	
	public void getNum(SlashCommandEvent e) 
	{
		e.deferReply().queue();
		int num = (int)(Math.random()*10+1);
		p.print("Your number is "+num, e);
	}
	
	public void guess(SlashCommandEvent e, String guess) 
	{
		e.deferReply().queue();
		int num = (int)(Math.random()*10+1);
		int g = Integer.parseInt(guess);
		if(num == g)
			p.print("The Number was "+num+" and you guessed "+g+", good job!", e);
		else
			p.print("The Number was "+num+" and you guessed "+g+", better luck next time", e);
	}
}
