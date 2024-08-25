package ProcessingIntro;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PShape;

public class selfPortrait extends PApplet{
	public static void main(String[] args) 
	{
	PApplet.main("ProcessingIntro.selfPortrait");	
	}
	
	public void settings() 
	{
		//sets size of screen for project
		size(800, 700);
		
	}
	/*PIamge declares variable for my 3 photos
	 * M stands for moving
	 * PShape declares variable for the shapes I drew
	 * int declares all the numbers I use in this project
	 */
	PImage photo, photo1, photoM;
	PShape app, snap, plushFrog;
	int x, y, g, h, g1, h1, vx, vy, a;
	
	
	public void setup() 
	{
		//sets background color to a nice blue
		background(38, 97, 255);
		//intalizes variables for moving swim cap
		vx = 50;
		vy = 450;
		a = 4;
		//intalizes variables for snapchat logo
		x = 300;
		y = 300;
		//intalizes variables for switching swim club and favorite restraunt photos
		g = 400;
		h = 425;
		g1 = 600;
		h1 = 525;
		//intalizes photos and resizes them
		photo1 = loadImage("Images/pic5.png");
		photo1.resize(200, 100);
		photo = loadImage("Images/pic4.jpg");
		photo.resize(200, 100);
		photoM = loadImage("Images/pic6.jpg");
		photoM.resize(200, 200);
		/*
		 * Creates a yellow curved rectangle 
		 * Could've used normal rectangle command
		 * I didn't read documentation enough
		 * Change radii to 45 to curve edges
		 */
		app = createShape();
		beginShape();
		fill(255, 245, 75);
		vertex(x, y);
		vertex(x, y+50);
		bezierVertex(x, y+50, x, y+100, x+50, y+100);
		vertex(x+50, y+100);
		vertex(x+100, y+100);
		bezierVertex(x+100, y+100, x+150, y+100, x+150, y+50);
		vertex(x+150, y+50);
		vertex(x+150, y);
		bezierVertex(x+150, y, x+150, y-50, x+100, y-50);
		vertex(x+100, y-50);
		vertex(x+50, y-50);
		bezierVertex(x+50, y-50, x, y-50, x, y);
		endShape(CLOSE);
		//Creates shape of ghost in snap logo
		snap = createShape();
		beginShape();
		fill(255, 255, 255);
		vertex(x+25, y);
		bezierVertex(x+25, y, x+75, y-75, x+125, y);
		bezierVertex(x+125, y, x+140, y-25, x+140, y);
		bezierVertex(x+140, y, x+140, y, x+130, y+70);
		bezierVertex(x+130, y+70, x+60, y+75, x+10, y+70);
		endShape(CLOSE);
		//creates shape of childhood toy I had
		plushFrog = createShape();
		beginShape();
		//makes shape of frog bosy
		fill(0, 255, 0);
		ellipse(100, 175, 150, 50);
		ellipse(200, 175, 150, 50);
		ellipse(110, 225, 50, 100);
		ellipse(180, 225, 50, 100);
		ellipse(150, 175, 175, 125);
		ellipse(150, 100, 200, 100);
		ellipse(110, 50, 50, 50);
		ellipse(180, 50, 50, 50);
		//makes the shape of the eyes
		fill(255, 255, 255);
		ellipse(110, 50, 25, 25);
		ellipse(180, 50, 25, 25);
		fill(0, 0, 0);
		ellipse(110, 50, 15, 15);
		ellipse(180, 50, 15, 15);
		//creates the mouth of the frog
		fill(255, 0, 0);
		vertex(75, 110);
		bezierVertex(75, 110, 150, 150, 225, 110);
		vertex(225, 110);
		
		endShape(CLOSE);
		
		frameRate(60);
	}
	
	public void draw() 
	{
		//draws frog
		shape(plushFrog);
		/*
		 * draws snapchat logo
		 * for loop adds eyes to snap logo
		 */
		shape(app);
		shape(snap);
		for(int i = 1; i <=2; i++) {
		fill(0, 0, 0);
		ellipse(x+(i*50), y+15, 10, 10);
		}
		//creates white rectangle my first 2 photos go into
		stroke(255, 255, 255);
		fill(255, 255, 255);
		rect(400, 425, 400, 200);
		stroke(0, 0, 0);
		line(425, 600, 775, 475);
		//draws images
		image(photo1, g1, h1);
		image(photo, g, h);
		//checks frame to see if it should switch the 2 photos
		if(frameCount % 60 == 0)
		{
			g = 400;
			h = 425;
			g1 = 600;
			h1 = 525;
		}
		
		if(frameCount % 120 == 0) 
		{
			g = 600;
			h = 525;
			g1 = 400;
			h1 = 425;
		}
		//draws 3rd photo and sets its cordinates to variable values
		image(photoM, vx, vy);
		/*uses arrow keys to re-assign value of int a 
		 *tells swimcap photo which way (if at all) it shold be moving
		 */
		if(a == 0) 
		{
			background(0);
			vx++;
		}
		
		else if(a == 1) 
		{
			vx--;
		}
		
		else if(a == 2) 
		{
			vy--;
		}
		
		else if(a == 3) 
		{
			vy++;
		}
		else if(a == 4) 
		{
			vx = vx;
			vy = vy;
		}
		if(vx >= 800)
			vx = 0;
		if(vy >= 700)
			vy = 0;
	}
	
	public void keyPressed() {
		//sets arrow keys to changing value of a
		if(key == CODED) 
		{
			if(keyCode == RIGHT)
			{
				a = 0;
			}
			else if(keyCode == LEFT) 
			{
				a = 1;
			}
			else if(keyCode == UP) 
			{
				a = 2;
			}
			else if(keyCode == DOWN) 
			{
				a = 3;
			}
			//the escape key ends the program
			else if(keyCode == ESC) 
			{
				exit();
			}
		}
	}
	
	
	
	
	
	
	
	
	
}
