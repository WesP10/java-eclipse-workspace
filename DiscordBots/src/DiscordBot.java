import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.*;
import net.dv8tion.jda.api.entities.Activity;

public class DiscordBot {

	public static void main(String[] args) throws LoginException{
		JDABuilder bot = JDABuilder.createDefault("OTcwMzUyODY3MzM0NTcwMDQ0.Ym6thw.7GOIYYJGUu14mMaVJq7LBlMSXE4");
		bot.setActivity(Activity.playing("With Mike's Mom's Tits"));
		bot.setStatus(OnlineStatus.ONLINE);
		bot.addEventListeners(new Listener());
		bot.build();
	}

}
