import processing.core.PApplet;

import java.util.ArrayList;

public class SudokoProcessing extends PApplet{

	SudokuSolver s;
	
	boolean running = false;
	
	ArrayList<int[][]> moveLog;
	
	int indx = 0;
	
	
	public static void main(String[] args) {
		PApplet.main("SudokoProcessing");
	}

	public void settings() 
	{
		size(450, 450);
	}
	
	public void setup() 
	{
		background(255);
		s = new SudokuSolver("Puzzles/puzzle1.txt");
		fill(0);
		textSize(40);
		frameRate(30);
		
		drawPuzzle(s.getNumbers());
	}
	
	public void mousePressed() 
	{
		s.solve(0, 0);
		moveLog = s.getNumLog();
		running = true;
	}
	
	public void draw() 
	{
		if(running && indx < moveLog.size()) 
		{
			drawPuzzle(moveLog.get(indx));
			indx++;
		}
	}
	
	public void drawPuzzle(int[][] numbers) 
	{
		background(255);
		drawGridLines();
		drawNumbers(numbers);
	}
	
	public void drawGridLines() 
	{
		for(int i = 0; i < 10; i++) 
		{
			int strokeWeight = i%3==0? 3:1;
			
			strokeWeight(strokeWeight);
			line(i*(width/9), 0, i*(width/9), height);
			line(0, i*(height/9), width, i*(height/9));
		}
	}
	
	public void drawNumbers(int[][] numbers) 
	{
		for(int i = 0; i < numbers.length; i++)
			for(int j = 0; j < numbers[i].length; j++) 
				if(numbers[i][j] != 0)
					text("" + numbers[i][j], (j+0.08f)*width/numbers.length + 10, (i+0.85f)*height/numbers.length);
	}
}
