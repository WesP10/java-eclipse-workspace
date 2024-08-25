import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordleSolver {

	private ArrayList<String> allWords;
	
	public WordleSolver() 
	{
		try {allWords = genList();} catch (FileNotFoundException e) {e.printStackTrace();}
	}
	
	private  ArrayList<String> genList() throws FileNotFoundException
	{
		ArrayList<String> s = new ArrayList<String>();
		Scanner sc = new Scanner(new File("dict/dictionary.txt"));
		while(sc.hasNext()) 
		{
			String word = sc.next();
			if(word.length() == 5)
				s.add(word);
		}
		return s;
	}
	
	public ArrayList<String> Solve(Wordle wordle) 
	{
		ArrayList<String> possible = new ArrayList<String>();
		//List of letters known to be in the word
		ArrayList<String> letIn = wordle.getGreen();
		for(int i = 0; i < wordle.getYellow().size(); i++) 
			letIn.add(wordle.getYellow().get(i));
		//Add all possible words
		for(int i = 0; i < allWords.size(); i++) 
			for(int j = 0; j < allWords.get(i).length(); j++) 
				for(int k = 0; k < letIn.size(); k++) 
				{
					String currentLet = ""+allWords.get(i).charAt(j);
					String currentWord = allWords.get(i);
					if(currentLet.equals(letIn.get(k)) && !possible.contains(currentWord))
						possible.add(currentWord);
				}
		//Remove all impossible words
		ArrayList<String> notIn = wordle.getGuessedNotIn();
		for(int i = 0; i < notIn.size(); i++) 
			for(int j = 0; j < possible.size(); j++) 
				for(int k = 0; k < possible.get(j).length(); k++) 
				{
					String cLet = ""+possible.get(j).charAt(k);
					if(cLet.equals(notIn.get(i)))
						possible.remove(possible.get(j));
				}
		return possible;
	}
}
