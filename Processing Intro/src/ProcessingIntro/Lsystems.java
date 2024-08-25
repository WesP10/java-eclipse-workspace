package ProcessingIntro;

import processing.core.PApplet;

public class Lsystems extends PApplet{
	public static void main(String[] args) {
		PApplet.main("ProcessingIntro.Lsystems");
	}
	
	public void settings() 
	{
		size(800, 800);
	}
	
	double x, y, angle; // class level variables
	public void move(double distance) 
	{
		double x2 = x + distance*Math.cos(Math.toRadians(angle));
		double y2 = y + distance*Math.sin(Math.toDegrees(angle));
		line((float)x, (float)y, (float)x2, (float)y2);
		x = x2;
		y = y2;
		
	}
	
	public void drawSerp(int depth, String str, double distance) 
	{
		if(depth == 0) 
		{
			for(int i = 0; i < str.length(); i++) 
			{
				String letter = str.substring(i, i+1);
				if(letter.equals("F") || letter.equals("G")) 
				move(distance);
				else if(letter.equals("+"))
					turn(-120);
				else
					turn(120);
			}
		}
		else 
		{
			String newStr = "";
			for(int i = 0; i < str.length(); i++) 
			{
				String letter = str.substring(i, i+1);
				if(letter.equals("F")) 
				newStr += "F-G+F+G-F";
				else if(letter.equals("G"))
				newStr += "GG";
				else
					newStr += letter;
			}
			drawSerp(depth-1, newStr, distance/1.1);
		}
	
	}
	
	/*
	 * Turns the turtle right for positive angles
	 * Turns the turtle left for negative angles
	 */
	
	public void turn(double angle) 
	{
		this.angle += angle;
	}
	
	public void setup() 
	{
		x = 20;
		y = 20;
		strokeWeight(0.5f); //thickness of line
		stroke(0, 0, 255); //color of line
//		frameRate(5);
		drawSerp(5, "F-G-G", 20);
	}
	
	public void draw() 
	{
		
		
	}
	
}
