import processing.core.PApplet;
import processing.core.PImage;

/**
 * 
 * @author Weston
 * 
 */
public class GradeDisplay extends PApplet{

	public static void main(String[] args) {
		PApplet.main("GradeDisplay");
	}

	//constructor for grade class
	Grade g = new Grade("src/scores2.txt");
	//creates strings that I can display 
	String mean = "" + g.mean();
	String median = "" + g.median();
	String mode = "" + g.mode();
	String sDev = "" + g.standardDeviation();
	String var = "" + g.variance();
	PImage nerd, dumbEgg;
	/*
	 * Determines what is visual aid is being displayed
	 * Could be boolean, but if I ever add more graphs then an int is helpful
	 */
	int graphState = 0;
	//declares screen size
	public void settings() 
	{
		size(600, 400);
	}

	//setup runs once and sets frame rate to 30 frames a second
	public void setup() 
	{
		frameRate(30);
		textureMode(IMAGE);
		nerd = loadImage("nerd.jpg");
		dumbEgg = loadImage("dumb_egg.jpg");
	}
	
	public void draw() 
	{
		//clears what was previously displayed every second
		clear();
		//sets backround color to a nice grey
		background(100);
		//makes lines prefered thickness
		strokeWeight(4);
		//helps make text readable
		hint(ENABLE_STROKE_PURE);
		//draws rectangle that the information on grades is listed
		fill(172, 172, 178);
		rect(25, 25, 500, 120, 28);
		//Writes all of the grade information
		textSize(20);
		fill(0, 0, 255);
		text("Mean: " + mean, 50, 50);
		fill(0, 0, 255);
		text("Median: " + median, 50, 70);
		fill(0, 0, 255);
		text("Mode: " + printArray(g.mode()), 50, 90);
		fill(0, 0, 255);
		text("Variance: " + var, 50, 110);
		fill(0, 0, 255);
		text("Standard Deviation: " + sDev, 50, 130);
		hint(DISABLE_STROKE_PURE);
		
		//checks what graph and button should be displayed
		if(graphState == 0) 
		{
			drawHistogram(g.histogram(10, 1, 100));
			drawPieChartButton();
		}
		if(graphState == 1) 
		{
			drawPieChart(200, g.histogram(10, 1, 100));
			drawGradesButton();
		}
		if(graphState == 2) 
		{
			drawGrades(g);
			drawKidModelButton();
		}
		if(graphState == 3) 
		{
			drawKidModel(g);
			drawHistogramButton();
		}
	}
	
	public void mousePressed() 
	{
		//checks if cursor is over the button when the mouse is clicked and changes graph state
		if(overRect(50, 175, 165, 50) == true && graphState == 0)
			graphState = 1;
		else if(overRect(50, 175, 185, 50) == true && graphState == 1)
			graphState = 2;
		else if(overRect(50, 175, 185, 50) == true && graphState == 2)
			graphState = 3;
		else if(overRect(50, 175, 185, 50) == true && graphState == 3)
			graphState = 0;
	}
	
	//similiar code to 1dArrayExercises
	public String printArray(double[] e) 
	{
		//only used to convert mode array to String
		String mode = "[";
		for(int i = 0; i <= e.length-2; i++) 
			mode += e[i] + ", ";
		mode += e[e.length-1] + "]";
		return mode;
	}
	
	public void drawHistogram(int[] hg) 
	{
		int p, h;
		for(int i = 0; i <= hg.length-1; i++) 
		{
			/*
			 * maps mouse position to a color c
			 * @parameter iFac makes each bar darker than the last
			 * for loop draws each bar and the text 1-10, 11-20...
			 */
			double iFac = i*15;
		    double c = (map(mouseX, 0, width, 130, 255)-iFac);
		    double co = (map(mouseY, 0, height, 130, 255)-iFac);
		    fill(0, (int)c, (int)co);
			rect(50+(i*50), 350, 50, (float) (-((height/hg.length)/6)*hg[i]));
			textSize(10);
			p = 1+(10*i);
			h = 10+(10*i);
			text("" + p + " - " + h, (55+(i*50)), 375);
		}
	}
	
	//draws smooth rectangles and adds text over it
	public void drawHistogramButton() 
	{
		fill(172, 172, 178);
		rect(50, 175, 185, 50, 15);
		fill(0, 0, 255);
		textSize(35);
		text("Histogram", 55, 215);
	}
	
	public void drawPieChartButton() 
	{
		fill(172, 172, 178);
		rect(50, 175, 165, 50, 15);
		fill(0, 0, 255);
		textSize(35);
		text("Pie Chart", 55, 215);
	}
	
	public void drawGradesButton() 
	{
		fill(172, 172, 178);
		rect(50, 175, 145, 50, 15);
		fill(0, 0, 255);
		textSize(35);
		text("Grades", 55, 215);
	}
	
	public void drawKidModelButton() 
	{
		fill(172, 172, 178);
		rect(50, 175, 195, 50, 15);
		fill(0, 0, 255);
		textSize(35);
		text("Student Model", 55, 215);
	}
	
	public void drawPieChart(float diameter, int[] hg)
	{
		//first I convert all my histogram values to percents
		int[] pie = new int[hg.length];
		//find total
		double sum = 0;
		for(int i = 0; i <= hg.length-1; i++) 
			sum += hg[i];
		for(int i = 0; i <= pie.length-1; i++)
		{
			//and divide by number of values
			//then multiply by 360 bc you want that percent of a full circle
			double ph = ((hg[i]/sum)*360);
			//I add one degree here so when degrees are converted to radians there are no gaps
			pie[i] = (int)ph+1;
		}
		
		//draws pie chart - learned from proccesing's website
		  float lastAngle = 0;
		  for (int i = 0; i < pie.length; i++) 
		  {
			strokeWeight(6);
			double iFac = i*15;
		    double c = (map(mouseX, 0, width, 130, 255)-iFac);
		    double co = (map(mouseY, 0, height, 130, 255)-iFac);
		    fill(0, (int)c, (int)co);
		    arc(400, 275, diameter, diameter, lastAngle, lastAngle+radians(pie[i]), PIE);
		    lastAngle += radians(pie[i]);
		    strokeWeight(4);
		  }
	}
	
	public void drawGrades(Grade e) 
	{
		String grades = printArray(e.getGrades());
	    double c = map(mouseX, 0, width, 130, 255);
	    double co = map(mouseY, 0, height, 130, 255);
	    fill(0, (int)c-45, (int)co-45);
		textSize(15);
		text(grades, 50, 250, 550, 350);
	}
	
	public void drawKidModel(Grade e) 
	{
		beginShape();
		texture(nerd);
		vertex(50, 250);
		vertex(250, 250);
		vertex(250, 380);
		vertex(50, 380);
		endShape(CLOSE);
	}
	
	//Method that checks if my cursor is overlapping with dimensons of given rectangle
	boolean overRect(int x, int y, int width, int height)  
	{
		if (mouseX >= x && mouseX <= x+width && mouseY >= y && mouseY <= y+height) 
		    return true;
		else
		    return false;
	}
}

