import processing.core.PApplet;

public class Combination extends PApplet {

	public static void main(String[] args) {
		PApplet.main("Combination");
	}

	public void settings() {
		size(1200, 1000);
	}
	
	static long[][] combs;
	static int numRows = 10;
	int rectWidth;
	int rectHeight;
	
	public void setup() {
		combs = new long[numRows][];
		//initialize a jagged array - row 0 is size 1, row i is size i+1
		for(int i = 0; i < numRows; i++)
			combs[i] = new long[i+1]; 
		
		//initialize the values in the table
		for(int c = 0; c < numRows; c++)
			combination(numRows-1, c);
		combination(0, 0);
		rectWidth = width/numRows;
		rectHeight = height/numRows;
		textSize(8);
	}
	
	/*
	 * 0C0
	 * 1C0 1C1
	 * 2C0 2C1 2C2
	 * ...
	 */
	
	public void draw() {
		background(255);
		int x_0 = width/2 - rectWidth/2;
		for(int r = 0; r < combs.length; r++)
		{
			for(int c = 0; c < combs[r].length; c++)
			{
				if(combs[r][c] % 2 == 0)
					fill(255, 0, 0);
				else
					fill(0, 255, 0);
				rect(x_0 + c*rectWidth, r*rectHeight, rectWidth, rectHeight);
				fill(0);
				//text("" + r + "C" + c, x_0 + (c+0.1f)*rectWidth, (r+0.75f)*rectHeight);
			}
			x_0 -= rectWidth/2;
		}
	}
	
	public void mousePressed() {
		noLoop();
		int r = (mouseY)/rectHeight;
		int c = (mouseX - width/2 + (r+1)*rectWidth/2)/rectWidth;
		if(r >= 0 && r < combs.length && c >= 0 && c < combs[r].length)
		{
			fill(0);
			textSize(20);
			text("" + r + " Choose " + c + ": " + combination(r,c), 50, 50);
			textSize(8);
		}
	}
	
	public void mouseReleased()
	{
		loop();
	}
	
	
	/**
	 * Return the value of r Choose c.
	 * @param r
	 * @param c
	 * @return
	 */
	public static long combination(int r, int c)
	{
		//memoization of the values
		if(r == c || c == 0) //ways of choosing all, or none
		{
			combs[r][c] = 1;
			return 1;
		}
		if(combs[r-1][c] == 0)
			combs[r-1][c] = combination(r-1, c);
		if(combs[r-1][c-1] == 0)
			combs[r-1][c-1] = combination(r-1, c-1);
		
		return combs[r-1][c] + combs[r-1][c-1];
	}
	
}