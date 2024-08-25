import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class TicTacToeBotCenter {

	public static void main(String[] args) throws LoginException {
		JDABuilder bot = JDABuilder.createDefault("OTcwNzAyMzUyNDg5MjU5MDI5.Ym_zAw.Hk-no8OAYs-fAeaqV5-uVodSGik");
		bot.setActivity(Activity.playing("With Mike's Mom's Tits"));
		bot.setStatus(OnlineStatus.ONLINE);
		TicTacToeBot t = new TicTacToeBot();
		t.setGameOn(false);
		bot.addEventListeners(t);
		bot.build();
	}

}
