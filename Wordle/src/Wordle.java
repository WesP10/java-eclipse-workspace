
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Wordle {

	private String word;
	private ArrayList<String> guessed, notGuessed, yellow, green, words;
	private int numGuesses;
	
	public Wordle() throws FileNotFoundException 
	{
		words = getWords();
		word = pickWord();
		guessed = new ArrayList<String>();
		yellow = new ArrayList<String>();
		green = new ArrayList<String>();
		notGuessed = genNotGuessed();
		numGuesses = 6;
	}
	
	public String getWord() 
	{
		return word;
	}
	
	public int getNumGuesses() 
	{
		return numGuesses;
	}
	
	public ArrayList<String> getYellow()
	{
		return yellow;
	}
	
	public ArrayList<String> getGreen()
	{
		return green;
	}
	
	public ArrayList<String> getGuessed()
	{
		return guessed;
	}
	
	public ArrayList<String> getNotGuessed()
	{
		return notGuessed;
	}
	
	public ArrayList<String> getGuessedNotIn()
	{
		ArrayList<String> lets = new ArrayList<String>();
		
		for(int i = 0; i < guessed.size(); i++)
			lets.add(guessed.get(i));
		for(int i = 0; i < guessed.size(); i++) 
			for(int j = 0; j < word.length(); j++) 
			{
				String cLet = ""+word.charAt(j);
				if(guessed.get(i).equals(cLet))
					lets.remove(cLet);	
			}
		return lets;
	}
	
	public void checkGuess(String guess)
	{
		ArrayList<String> letters = new ArrayList<String>();
		for(int i = 0; i < guess.length(); i++) {
			String temp = ""+guess.charAt(i);
			letters.add(temp);
		}
		for(int i = 0; i < letters.size(); i++) 
		{
			if(word.contains(letters.get(i))) {
				if(word.indexOf(letters.get(i)) == i)
					green.add(letters.get(i));
				else
					yellow.add(letters.get(i));
			}
		}
	}
	
	public String askGuess() 
	{
		Scanner sc = new Scanner(System.in);
		String t = sc.next();
		t = t.toUpperCase();
		if(t.length() != 5 || !aWord(t))
			return null;
		ArrayList<String> letters = new ArrayList<String>();
		for(int i = 0; i < t.length(); i++) {
			String temp = ""+t.charAt(i);
			letters.add(temp);
		}
		for(int i = 0; i < letters.size(); i++) 
			for(int j = 0; j < notGuessed.size(); j++) 
				if(letters.get(i).equals(notGuessed.get(j))) 
					guessed.add(notGuessed.remove(j));
		numGuesses--;
		return t;
	}
	
	private boolean aWord(String guess) 
	{
		for(int i = 0; i < words.size(); i++)
			if(guess.equals(words.get(i)))
				return true;
		return false;
	}
	
	private ArrayList<String> genNotGuessed()
	{
		ArrayList<String> t = new ArrayList<String>();
		t.add("A");
		t.add("B");
		t.add("C");
		t.add("D");
		t.add("E");
		t.add("F");
		t.add("G");
		t.add("H");
		t.add("I");
		t.add("J");
		t.add("K");
		t.add("L");
		t.add("M");
		t.add("N");
		t.add("O");
		t.add("P");
		t.add("Q");
		t.add("R");
		t.add("S");
		t.add("T");
		t.add("U");
		t.add("V");
		t.add("W");
		t.add("X");
		t.add("Y");
		t.add("Z");
		return t;
	}
	
	private String pickWord() throws FileNotFoundException
	{
		return words.get((int)(Math.random()*(words.size()-1)));
	}

	private ArrayList<String> getWords() {
		ArrayList<String> t = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("dict/dictionary.txt"))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.length() == 5) {
					t.add(line);
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return t;
	}
}
