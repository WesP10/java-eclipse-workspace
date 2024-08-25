import java.io.FileNotFoundException;

import Hangman.Hangman;
import TicTacToe.TicTacToe;
import Wordle.Wordle;

public class Test {

	static Hangman game;
	
	public static void main(String[] args) throws FileNotFoundException {
		game = new Hangman();
		System.out.println(game.getMan().get(game.getLife()));
	}

}
