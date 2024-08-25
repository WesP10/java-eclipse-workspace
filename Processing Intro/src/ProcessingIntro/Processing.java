package ProcessingIntro;

import java.awt.Point;

import javax.swing.Box.Filler;

import processing.core.PApplet;

public class Processing extends PApplet{
	public static void main(String[] args) {
		PApplet.main("ProcessingIntro.Processing");
	}
	public void settings() {
		//define window size
		size(600,600);
	}
	
	BezierCurve bez;
//	Button button;
	
	public void setup() {
		background(255);
		frameRate(60);
		strokeWeight(10);
		bez = new BezierCurve(new Point(0, 300), new Point(400, 200), 
			new Point(100, 75), new Point(600, 300));
//		button = new Button(200, 100, 250, 125, "Click Me!");
//		button.setStroke(5);
//		button.setBackground(20, 145, 20);
//		button.setTextColor(200, 9, 54);
		Point[] points = bez.getPoints();
		for (int i = 0; i < points.length-15; i++) {
			point((float)points[i].getX(), (float)points[i].getY());
			fill(255, 0, 0);
			line((float)points[i].getX(), (float)points[i].getY(), (float)points[i+15].getX(), (float)points[i+15].getY());
		}
	}
	
//	public void draw() {
//		//Draw Button
//		if(frameCount%20==0)
//			button.setText(""+(int)frameRate);
//		button.draw(this);
//	}
//	public void mousePressed() {
//		if(button.clicked(mouseX, mouseY))
//			System.out.println("AHHHHH");
//	}
}
