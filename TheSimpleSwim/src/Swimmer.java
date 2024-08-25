import processing.core.PApplet;
import processing.core.PImage;

public class Swimmer {

	private float x, y, xOffset, yOffset;
	private final int size;
	private final PImage IMG;
	
	public Swimmer(int x, int y, int size, PApplet driver) {
		this.x=x;
		this.y=y;
		this.size = size;
		xOffset = 15;
		yOffset = 20;
		IMG = driver.loadImage("Swimmer.png");
		IMG.resize((int)(size+xOffset), (int)(size+yOffset));
	}
	public int getY() {
		return (int)y;
	}
	public void swimUp() {
			y-=15;
	}
	public void gravity() {
		if(y < 1400)
			y+=0.5;
	}
	public void draw(PApplet window) {
		window.rect(x, window.height/2, size, size);
		window.image(IMG, x, window.height/2);
	}
}
