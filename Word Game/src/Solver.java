import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solver {

	String[] allWords;
	String word;
	
	public Solver(char[] c) 
	{
		allWords = fillWithDic();
		word = null;
	}
	
	private String[] fillWithDic() 
	{
		String text = "";
		try 
		{
			Scanner sc = new Scanner(new File("words.txt"));
			while(sc.hasNext()) 
				text+= sc.next() + " ";
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		return text.split(" ");
	}
	
	private String[] checkLetters(String[] c) 
	{
		int check = 0;
		for(int i = 0; i < allWords.length; i++) 
		{
			check = 0;
			for(int j = 0; j < c.length; j++) 
			{
				if(allWords[i].contains(c[j]))
					check++;
			}
				
		}
		return null;
	}
}
