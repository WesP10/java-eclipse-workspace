import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 
 * @author Weston
 *
 */
public class ArrayListManipulation {

	//instance variable
	private ArrayList<String> words;
	
	/*
	 * constructor
	 * takes all the words from text file
	 */
	public ArrayListManipulation(String fileName) 
	{
		String text = "";
		try 
		{
			Scanner sc = new Scanner(new File(fileName));
			while(sc.hasNext()) 
				text+= sc.next() + " ";
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		String[] wordsArray = text.split(" ");
		words = new ArrayList<String>(Arrays.asList(wordsArray));
	}

	//returns the instance variable
	public ArrayList<String> getWords() {
		return words;
	}

	public void printTenWordsPerLine() 
	{
		//loops through words 10 words at a time and goes to a new line every 10
		for(int i = 0; i < words.size()/10; i++) 
		{
			for(int j = 0; j < 10; j++) 
			{
				System.out.print(words.get(j+(i*10)) + " ");
			}
			System.out.println();
		}
		/* ex: 53 words -> fist 50 printed above, last 3 words printed with this loop
		 * anything after a base of 10 is printed with this loop
		 */
		for(int i = (int)(words.size()/10)*10; i < words.size(); i++) 
		{
			System.out.print(words.get(i) + " ");
		}
		System.out.println();
	}
	
	//returns the length of the arrayList
	public int numWords() 
	{
		return words.size();
	}
	
	public String longestWord() 
	{
		//temporary variables to longest word durring iterations
		String currentLongestWord = null;
		int currentLongestWordLength = 0;
		//checks if arraylist is empty
		if(words.size() <= 0)
			return null;
		//loops through all words and compares to current longest
		for(int i = 0; i < words.size(); i++) 
		{
			int temp = (int)words.get(i).chars().count();
			if(temp > currentLongestWordLength) 
			{
				currentLongestWordLength = temp;
				currentLongestWord = words.get(i);
			}
		}
		
		return currentLongestWord;
	}
	
	public int indexOfWord(String word) 
	{
		//checks if the word at index i in the array is equal to user's word
		for(int i = 0; i < words.size(); i++) 
		{
			if(words.get(i).equalsIgnoreCase(word))
				return i;
		}
		//if no index of i contains the word the for loop will end and return -1
		return -1;
	}
	
	public int countWord(String word) 
	{
		int count = 0;
		//every time word is detected count is incremented
		for(int i = 0; i < words.size(); i++) 
		{
			if(words.get(i).equalsIgnoreCase(word))
				count++;
		}
		return count;
	}
	
	public String max() 
	{
		//checks if arraylist is empty
		if(words.size() <= 0)
			return null;
		//creates clone of words so instance variable is unchanged
		ArrayList<String> clone = new ArrayList<String>(words.size());
		for(int i = 0; i < words.size(); i++) 
			clone.add(words.get(i));
		//alphabetizes clone
		Collections.sort(clone, String.CASE_INSENSITIVE_ORDER);
		//retuens first word in alphabetized list
		return clone.get(0);
	}
	
	public String min() 
	{
		if(words.size() <= 0)
			return null;
		ArrayList<String> clone = new ArrayList<String>(words.size());
		for(int i = 0; i < words.size(); i++) 
			clone.add(words.get(i));
		Collections.sort(clone, String.CASE_INSENSITIVE_ORDER);
		//same as max except returns last element
		return clone.get(clone.size()-1);
	}
	
	public ArrayList<String> startsWithLetter(Character c)
	{
		ArrayList<String> startsWith = new ArrayList<String>();
		//iterates through words if the first letter matches the user's letter then the word is added to the arraylist
		for(int i = 0; i < words.size(); i++) 
		{
			char firstLetter = words.get(i).charAt(0);
			if(Character.toLowerCase(firstLetter) == Character.toLowerCase(c))
				startsWith.add(words.get(i));
		}
		return startsWith;
	}
	
	public ArrayList<String> alphabetize()
	{
		//clones array
		ArrayList<String> temp = new ArrayList<String>(words.size());
		for(int i = 0; i < words.size(); i++) 
			temp.add(words.get(i));
		//alphabetizes cloned arraylist ignoring case
		Collections.sort(temp, String.CASE_INSENSITIVE_ORDER);
		return temp;
	}
	
	public ArrayList<String> swapWords()
	{
		//temp variables to store words that are going to be swapped
		ArrayList<String> clone = new ArrayList<String>(words.size());
		int max;
		String temp;
		//determines how long the new arraylist is going to be
		if(words.size()%2 == 0)
			max = words.size();
		else
			max = words.size()-1;
		//clones array
		for(int i = 0; i < max; i++) 
		{
			clone.add(words.get(i));
		}
		//swaps words at "swapable indexs"
		for(int i = 0; i < max; i+=2) 
		{
			temp = clone.get(i);
			clone.set(i, clone.get(i+1));
			clone.set(i+1, temp);
		}
		return clone;
	}
	
	public ArrayList<String> combineLists(ArrayList<String> moreWords)
	{
		ArrayList<String> clone = new ArrayList<String>();
		for(int i = 0; i < words.size(); i++) 
		{
			clone.add(words.get(i));
		}
		for(int i = 0; i < moreWords.size(); i++) 
		{
			clone.add(moreWords.get(i));
		}
		return clone;
	}
	
	public ArrayList<String> reverse()
	{
		ArrayList<String> clone = new ArrayList<String>();
		for(int i = 0; i < words.size(); i++) 
		{
			clone.add(words.get(i));
		}
		String temp;
		for(int i = 0; i < clone.size()/2; i++) 
		{
			temp = clone.get(i);
			clone.set(i, clone.get(clone.size()-(1+i)));
			clone.set(clone.size()-(1+i), temp);
		}
		return clone;
	}
}
