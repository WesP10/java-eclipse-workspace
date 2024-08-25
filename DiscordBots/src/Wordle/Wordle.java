package Wordle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Wordle {

	private String word;
	private ArrayList<String> notGuessed, words;
	private HashMap<String, Integer> yellow, green;
	private int numGuesses;
	
	public Wordle() throws FileNotFoundException 
	{
		words = getWords();
		word = pickWord();
		yellow = new HashMap<String, Integer>();
		green = new HashMap<String, Integer>();
		notGuessed = genNotGuessed();
		numGuesses = 0;
	}
	
	public String getWord() 
	{
		return word;
	}
	
	public int getNumGuesses() 
	{
		return numGuesses;
	}
	
	public HashMap<String, Integer> getYellow()
	{
		return yellow;
	}
	
	public HashMap<String, Integer> getGreen()
	{
		return green;
	}
	
	public ArrayList<String> getNotGuessed()
	{
		return notGuessed;
	}
	
	public void checkGuess(String g) 
	{
		numGuesses++;
		for(int i = 0; i < g.length(); i++) 
			for(int j = 0; j < word.length(); j++) 
			{
				String guessChar = ""+g.charAt(i);
				notGuessed.remove(guessChar);
				String wordChar = ""+word.charAt(j);
				if(guessChar.equals(wordChar))
					if(i == j) {
						yellow.remove(guessChar);
						green.put(guessChar, i);
					}
					else 
					{
						if(containsDuplicateLetter(g, g.charAt(i))) 
						{
							if(g.substring(g.indexOf(guessChar)).indexOf(guessChar) == i) {
								yellow.remove(guessChar);
								green.put(guessChar, i);
							}
							else {
								green.remove(guessChar);
								yellow.put(guessChar, i);
							}
						}
						else {
							green.remove(guessChar);
							yellow.put(guessChar, i);	
						}
					}
			}
	}
	
	public boolean containsDuplicateLetter(String g, char guessChar) 
	{
		String newG = g.substring(g.indexOf(guessChar));
		return newG.contains(""+guessChar);
	}
	
	//Word gotten from Discord User
	//Removes guessed letters from notGuessed
	//return null if word isn't allowed
	//returns word in all caps otherWise
	public String askGuess(String guess) 
	{
		guess = guess.toUpperCase();
		if(guess.length() != 5 || !aWord(guess))
			return null;
		for(int i = 0; i < guess.length(); i++)
			notGuessed.remove(""+guess.charAt(i));
		return guess;
		
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
	
	private ArrayList<String> getWords() throws FileNotFoundException
	{
		ArrayList<String> t = new ArrayList<String>();
		Scanner sc = new Scanner(new File("dictionary.txt"));
		while(sc.hasNext()) 
		{
			String s = sc.next().toUpperCase();
			if(s.length() == 5)
				t.add(s);
		}
		return t;
	}
}

