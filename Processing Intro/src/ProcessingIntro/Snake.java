package ProcessingIntro;

import processing.core.PApplet;

public class Snake extends PApplet{
	public static void main(String[] args) {
		PApplet.main("ProcessingIntro.Snake");

	}
	private final int FRAMERATE = 60;
	private int timer, a, radius, vx, vy, foodX, foodY;
	private String s;
	
	public void settings() {
		//define window size
		size(600,600);
	}
	
	public void setup() {
		 foodX = (int) (Math.random()*540+10);
		 foodY = (int) (Math.random()*540+10);
		 vx = 300;
		 vy = 300;
		 radius = 10;
		 a = 0;
		 timer = 60;
		 s = "Timer ";
		 frameRate(FRAMERATE);
	}
	
	public void draw() {
		checkFood();
		drawScene();
		move(a);
		checkState();
		//Every Second Timer Goes Down
		if(frameCount % (FRAMERATE) == 0) 
			timer--;	
	}
	
	public void keyPressed() 
	{
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
			else if(keyCode == ESC) 
			{
				exit();
			}
		}
	}
	
	private void checkState() {
		if(radius >= 1280) 
		{
			background(0, 255, 50);
			fill(0);
			text("YOU WIN!", 150, 300);
			noLoop();
		}
		if(timer <= 0) 
		{
			background(255, 0, 50);
			fill(0);
			text("YOU LOSE!", 150, 300);
			noLoop();
		}
	}
	private void drawScene() {
		background(0, 0, 255);
		clear();
		fill(0, 0, 255);
		ellipse(vx, vy, radius, radius);
		fill(0, 255, 0);
		ellipse(foodX, foodY, 15, 15);
		textSize(60);
		fill(0, 0, 255);
		text(s + timer, 150, 300);
	}
	private void checkFood() {
		if(Math.sqrt((vx-foodX)*(vx-foodX)+(vy-foodY)*(vy-foodY)) < radius-5) 
		{
			 foodX = (int) (Math.random()*540+10);
			 foodY = (int) (Math.random()*540+10);
			 radius += 10;
		}
	}
	private void move(int a) {
		//Checks keyPressed 
		if(a == 0) 
			vx += 2;
		else if(a == 1)
			vx -= 2;
		else if(a == 2)
			vy -= 2;
		else if(a == 3)
			vy += 2;
		//Checks Boundaries 
		if(vx == 600)
			vx = 0;
		else if(vy == 600)
			vy = 0;
		else if(vx == 0)
			vx = 600;
		else if(vy == 0)
			vy = 600;
	}
}
