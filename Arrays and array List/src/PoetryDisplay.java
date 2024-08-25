import java.util.ArrayList;

import processing.core.PApplet;

public class PoetryDisplay extends PApplet {

	public static void main(String[] args) {
		PApplet.main("PoetryDisplay");
	}

	public void settings() 
	{
		size(800, 600);
	}
	
	private BlackoutPoetry bp;
	public void setup()
	{
		bp = new BlackoutPoetry("frankenstein.txt");
		generatePoem();
	}
	
	public void generatePoem() 
	{
		background(200);
		fill(0);
		ArrayList<String> words = bp.getWords();
		float x = 20, y = 20;
		int textHeight = 14;
		textSize(textHeight);
		textFont(createFont("Consolas", textHeight));
		float letterWidth = textHeight * 0.6f;
		
		ArrayList<Integer> indices = bp.generatePoem("TNCJNVJNCN", 100);
		for(int i = 0; i < words.size(); i++) 
		{
			String word = bp.parseWord(words.get(i));
			if(indices.contains(i))
				text(word, x, y);
			else
			{
				fill(0);
				rect(x-2, y+2, word.length()*letterWidth + 1, -textHeight);
			}
			x+= word.length()*letterWidth + 4; // 4 pixels for space key
			if(x >= width-(letterWidth*10)) 
			{
				x = 10;
				y += textHeight * 1.3;
			}
		}
	}
}
