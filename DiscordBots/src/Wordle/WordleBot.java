package Wordle;

import java.io.FileNotFoundException;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.commands.OptionType;

public class WordleBot {

	public static void main(String[] args) throws LoginException, InterruptedException, FileNotFoundException {
		JDA bot = JDABuilder.createDefault("OTc4NDU0MjU3NDU4MDg1OTM4.GcGH1A.jIj1R1bp-B9JAbzAKFhopEp5QTBzrCjRCu9Dwg")
				.setActivity(Activity.playing("Discount/Discord Wordle"))
				.addEventListeners(new WordleListener())
				.build().awaitReady();
		Guild g = bot.getGuildById("970340197931835442");
		if(g != null) 
		{
			g.upsertCommand("start", "Starts a new game of Wordle!").queue();
			g.upsertCommand("end", "Ends current game of wordle!").queue();
			g.upsertCommand("guess", "Allows you to guess a word!")
			.addOption(OptionType.STRING, "guess", "guess for wordle", true).queue();
		}

	}

}
