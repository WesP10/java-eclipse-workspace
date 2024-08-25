package TicTacToe;

import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class Logger {

	public void print(String message, GuildMessageReceivedEvent e) {
		System.out.println(message);
		e.getChannel().sendMessage(message).queue();
	}
	
	public void print(String message, SlashCommandEvent e) 
	{
		System.out.println(message);
		e.getHook().sendMessage(message).queue();
	}
}
