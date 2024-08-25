import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;

public class BlackoutPoetry {

	public static void main(String[] args) {	
		BlackoutPoetry W = new BlackoutPoetry("frankenstein.txt");
		for(int i : W.generatePoem("TNCJNVJNCN", 100))
			System.out.print(W.parseWord(W.taggedWords.get(i)) + " ");
	}

	private MaxentTagger tagger = new MaxentTagger("models/english-left3words-distsim.tagger");
	private ArrayList<String> taggedWords;
	
	public ArrayList<String> getWords()
	{
		return taggedWords;
	}
	
	public BlackoutPoetry(String filename) 
	{
		String text = "";
		try 
		{
			Scanner sc = new Scanner(new File(filename));
			while(sc.hasNext()) 
				text+= sc.next() + " ";
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		String taggedText = tagger.tagString(text);
		
		String[] taggedArray = taggedText.split(" "); //"Some String" -> ["Some", "String"]
		taggedWords = new ArrayList<String>(Arrays.asList(taggedArray));
	}
	
	public String parseTag(String taggedWord) 
	{
		String[] parts = taggedWord.split("_");
		if(parts.length != 2)
			throw new IllegalArgumentException("Word was not tagged");
		return parts[1];
	}
	
	public String parseWord(String taggedWord) 
	{
		String[] parts = taggedWord.split("_");
		if(parts.length != 2)
			throw new IllegalArgumentException("Word was not tagged");
		return parts[0];
	}
	
	public ArrayList<Integer> generatePoem(String senS, int groupSize)
	{
		ArrayList<String> nounTag = new ArrayList<String>(Arrays.asList("WP", "NN", "NNP", "NNPS", "NNS"));
		ArrayList<String> verbTag = new ArrayList<String>(Arrays.asList("VB", "VBG", "VBN"));
		ArrayList<String> adjTag = new ArrayList<String>(Arrays.asList("JJS", "JJ", "JJR"));
		ArrayList<String> adverbTag = new ArrayList<String>(Arrays.asList("RB", "RBR", "RBS"));
		ArrayList<String> conjTag = new ArrayList<String>(Arrays.asList("CC"));
		ArrayList<String> determinerTag = new ArrayList<String>(Arrays.asList("DT", "PDT", "WDT"));
		
		int i = 0; //start of group
		ArrayList<Integer>  keepIndx = new ArrayList<Integer>();
		int numTries = 0;
		while(i < taggedWords.size() && !senS.isEmpty()) 
		{
			numTries++;
			String category = senS.substring(0, 1); //first letter
			int randomIndex = (int)(Math.random()*groupSize + i);
			String randomWord = taggedWords.get(randomIndex);
			
			if(category.equals("N") && nounTag.contains(parseTag(randomWord))
			|| category.equals("V") && verbTag.contains(parseTag(randomWord))
			|| category.equals("J") && adjTag.contains(parseTag(randomWord))
			|| category.equals("D") && adverbTag.contains(parseTag(randomWord))
			|| category.equals("C") && conjTag.contains(parseTag(randomWord))
			|| category.equals("T") && determinerTag.contains(parseTag(randomWord))
			|| numTries > 100) 
			{
				keepIndx.add(randomIndex);
				senS = senS.substring(1); //everything but index 0
				i = randomIndex + 1;
				numTries = 0;
			}
		}
		return keepIndx;
	}
	
}
