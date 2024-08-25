import processing.core.PApplet;

public class FlowerPower extends PApplet{

	public static void main(String[] args) {
		PApplet.main("FlowerPower");
	}
	
	public void settings() 
	{
		size(600, 600);
	}
	
	public void setup() 
	{
		drawFlower(4);
	}
	
	public void drawFlower(int d) 
	{
		Branch root = new Branch(width/2, height-5, (float)(Math.random()*20 -10)-90, height/5);
		drawFlower(d, root);
	}
	
	float DIAM = 15, MIN_L = height/8, MAX_L = height/5;
	int MIN_B = 4, MAX_B = 7;
	
	private void drawFlower(int d, Branch b) 
	{
		if(d == 0) 
		{
			stroke(50, 200, 50);
			line(b.getBaseX(), b.getBaseY(), b.getEndX(), b.getEndY());
			noStroke();
			fill(200, 50, 50);
			ellipse(b.getEndX(), b.getEndY(), DIAM, DIAM);
			return;
		}
		else 
		{
				Branch branch = new Branch(b.getEndX(), b.getEndY(), (float)(Math.random()*90-45), (float)(Math.random()*(MAX_L-MIN_L)+MIN_L));
				drawFlower(--d, branch);
		}
	}
}
