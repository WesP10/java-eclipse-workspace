package Hangman;

import java.io.FileNotFoundException;
import javax.security.auth.login.LoginException;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.commands.OptionType;

public class HangmanBot {

	public static void main(String[] args) throws LoginException, FileNotFoundException, InterruptedException {
		JDA bot = JDABuilder.createDefault("OTgxOTc3MTYyNzMzMTkxMjM5.GRcIlj.fwlW7rLwmF64ejK_YcQ2Zaw6Vo8EMX0FR_F1Gw")
				.setActivity(Activity.playing("Java Hangman"))
				.addEventListeners(new HangmanListener())
				.build().awaitReady();
		Guild g = bot.getGuildById("970340197931835442");
		if(g != null) 
		{
			g.upsertCommand("start", "Starts a new game of Hangman!").queue();
			g.upsertCommand("end", "Ends current game of Hangman!").queue();
			g.upsertCommand("guess", "Allows you to guess a letter!")
			.addOption(OptionType.STRING, "guess", "guess for hangman", true).queue();
		}

	}

	}

