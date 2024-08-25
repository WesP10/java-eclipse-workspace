import processing.core.PApplet;

public class MondrianImage extends PApplet{

	int[] colors = {color(50, 7, 205),color(99, 20, 203),color(255), color(255, 0, 0), color(0, 255, 0), color(0, 0, 255), color(0), color(45, 89, 63)};
	
	public static void main(String[] args) {
		PApplet.main("MondrianImage");
	}

	public void settings() 
	{
		size(800, 800);
	}
	
	public void setup() 
	{
		monRekt(0, 0, width, height, 3);
	}
	
	public void draw() 
	{
		
	}
	
	public void monRekt(float x, float y, float w, float h, int d) 
	{
		if(d <= 0)
			return;
		int c = (int)(Math.random()*colors.length);
		fill(colors[c]);
		d--;
		//picks random point at (px, py)
		float px = (float)(Math.random()*w+x);
		float py = (float)(Math.random()*h+y);
		//draws top left
		rect(x, y, px-x, py-y);
		monRekt(x, y, px-x, py-y, d);
		//draw top right
		rect(x+px, y, width-px, py-y);
		monRekt(x+px, y, width-px, py-y, d);
		//draw bottom left
		rect(x, y+py, px-x, height-py);
		monRekt(x, y+py, px-x, height-py, d);
		//draw bottom right
		rect(x+px, y+py, width-px, height-py);
		monRekt(x+px, y+py, width-px, height-py, d);
	}
}
