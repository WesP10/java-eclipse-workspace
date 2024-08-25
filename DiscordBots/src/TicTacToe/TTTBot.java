package TicTacToe;

import javax.security.auth.login.LoginException;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.commands.OptionType;

public class TTTBot {

	public static void main(String[] args) throws LoginException, InterruptedException {
		JDA bot = JDABuilder.createDefault("OTcwNzAyMzUyNDg5MjU5MDI5.Gd9o0f.HGqE3VEnR7iHc6SfSA7zzCrR1x8jXXqphIcnGs")
				.setActivity(Activity.listening("Mr. Sharick's MixTape"))
				.addEventListeners(new TTTListener())
				.build().awaitReady();
		Guild guild = bot.getGuildById("970340197931835442");
		if(guild != null) {
		guild.upsertCommand("start", "Starts a new game of Tictactoe!").queue();
		guild.upsertCommand("move", "Places a 'x' or 'o' on the given space! Example format -> '/move a1'")
		.addOption(OptionType.STRING, "move", "Your move on the tictactoe board", true).queue();
		guild.upsertCommand("join", "Adds a second player to an already started Tictactoe game!").queue();
		guild.upsertCommand("end", "Allows a player to end their game!").queue();
		}
	}

}
