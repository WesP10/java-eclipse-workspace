package RandomNumber;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.commands.OptionType;

public class RandomNumBot {

	public static void main(String[] args) throws LoginException, InterruptedException {
		JDA bot = JDABuilder.createDefault("")
				.setActivity(Activity.listening("Mr. Sharick's MixTape"))
				.addEventListeners(new RandomNumListener())
				.build().awaitReady();
		Guild g = bot.getGuildById("");
		if(g != null) {
		g.upsertCommand("RandomNumber", "Gives you a random number between 1 and 10").queue();;
		g.upsertCommand("Guess", "Let's you guess a number between and 1 and 10")
		.addOption(OptionType.STRING, "guess", "Your guess between 1 and 10", true).queue();;
		}
	}

}
