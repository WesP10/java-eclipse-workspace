package Hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Hangman {

	private ArrayList<String> notGuessed, currentWord, man, inWord;
	private String word;
	private int life;
	private boolean gameOn;
	
	public Hangman() throws FileNotFoundException 
	{
		notGuessed = genNG();
		word = genWord();
		currentWord = startWord();
		man = genMan();
		inWord = inWord();
		life = 7;
		gameOn = true;
	}
	
	public boolean getGameOn() {
		return gameOn;
	}
	
	public ArrayList<String> getNotGuessed() {
		return notGuessed;
	}

	public String getCurrentWord() {
		return currentWord.toString();
	}

	public ArrayList<String> getMan() {
		return man;
	}

	public String getWord() {
		return word;
	}

	public int getLife() {
		return life;
	}
	
	//return true if win
	public boolean checkWin()
	{
		boolean count = true;
		for(int i = 0; i < currentWord.size(); i++)
			if(currentWord.get(i).equals("_ "))
				count = false;
		if(count)
			gameOn = false;
		return count;
	}
	
	//pre-condition let is one letter
	public boolean guess(String let) 
	{
		boolean in = false;
		for(int i = 0; i < inWord.size(); i++) 
			if(inWord.get(i).equals(let)) 
			{
				int[] letIndx = getLetIndx(let);
				for(int j = 0; j < letIndx.length; j++)
					currentWord.set(letIndx[j], let);
				in = true;
				notGuessed.remove(let);
			}
		if(!in) 
		{
			life--;
			notGuessed.remove(let);
		}
		else
			checkWin();
		checkTie();
		return in;
	}

	private void checkTie() 
	{
		gameOn = !(life < 0);
	}
	
	private int[] getLetIndx(String let) 
	{
		ArrayList<Integer> indx = new ArrayList<Integer>();
		String clone = ""+word;
		String cloneClone = ""+word;
		while(clone.contains(let)) 
		{
			indx.add(clone.indexOf(let));
			clone = "";
			for(int i = 0; i <= cloneClone.indexOf(let); i++)
				clone += "#";
			System.out.println("Clone: "+ clone + " Word: "+word);
			if(cloneClone.indexOf(let) < cloneClone.length())
				clone += cloneClone.substring(cloneClone.indexOf(let)+1);
			else
				break;
			cloneClone = ""+clone;
		}
		int[] r = new int[indx.size()];
		for(int i = 0; i < indx.size(); i++)
			r[i] = indx.get(i);
		return r;
	}
	
	private ArrayList<String> inWord()
	{
		ArrayList<String> t = new ArrayList<String>();
		for(int i = 0; i < word.length(); i++)
			t.add((""+word.charAt(i)).toUpperCase());
		return t;
	}
	
	private ArrayList<String> genMan()
	{
		man = new ArrayList<String>();
		String zero = "#------#--"+"\n"
				+ "|      |  "+"\n"
				+ "|      O  "+"\n"
				+ "|     /|\\ "+"\n"
				+ "|      |  "+"\n"
				+ "|     / \\ "+"\n"
				+ "#_________"+"\n";
	String one = "#------#--"+"\n"
			+ "|      |  "+"\n"
			+ "|      O  "+"\n"
			+ "|     /|\\ "+"\n"
			+ "|      |  "+"\n"
			+ "|     /   "+"\n"
			+ "#_________"+"\n";
	String two = "#------#--"+"\n"
			+ "|      |  "+"\n"
			+ "|      O  "+"\n"
			+ "|     /|\\ "+"\n"
			+ "|      |  "+"\n"
			+ "|         "+"\n"
			+ "#_________"+"\n";
	String three = "#------#--"+"\n"
			+ "|      |  "+"\n"
			+ "|      O  "+"\n"
			+ "|     /|\\ "+"\n"
			+ "|         "+"\n"
			+ "|         "+"\n"
			+ "#_________"+"\n";
	String four = "#------#--"+"\n"
			+ "|      |  "+"\n"
			+ "|      O  "+"\n"
			+ "|     /|  "+"\n"
			+ "|         "+"\n"
			+ "|         "+"\n"
			+ "#_________"+"\n";
	String five = "#------#--"+"\n"
			+ "|      |  "+"\n"
			+ "|      O  "+"\n"
			+ "|     /   "+"\n"
			+ "|         "+"\n"
			+ "|         "+"\n"
			+ "#_________"+"\n";
	String six = "#------#--"+"\n"
			+ "|      |  "+"\n"
			+ "|      O  "+"\n"
			+ "|         "+"\n"
			+ "|         "+"\n"
			+ "|         "+"\n"
			+ "#_________"+"\n";
	String seven = "#------#--"+"\n"
			+ "|      |  "+"\n"
			+ "|         "+"\n"
			+ "|         "+"\n"
			+ "|         "+"\n"
			+ "|         "+"\n"
			+ "#_________"+"\n";
	man.add(zero);
	man.add(one);
	man.add(two);
	man.add(three);
	man.add(four);
	man.add(five);
	man.add(six);
	man.add(seven);
	return man;
	}
	
	private ArrayList<String> startWord()
	{
		 currentWord = new ArrayList<String>();
		 for(int i = 0; i < word.length(); i++)
			 currentWord.add("_ ");
		 return currentWord;
	}
	
	private String genWord() throws FileNotFoundException 
	{
		ArrayList<String> t = new ArrayList<String>();
		Scanner sc = new Scanner(new File("hangman.txt"));
		while(sc.hasNext()) 
		{
			String s = sc.next().toUpperCase();
				t.add(s);
		}
		return t.get((int)(Math.random()*(t.size()-1)));
	}
	
	private ArrayList<String> genNG()
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

}
