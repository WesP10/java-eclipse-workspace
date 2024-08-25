import processing.core.PApplet;
import processing.core.PImage;

public class Player {

	private int x, y;
	public int coinCount;
	private final int size;
	private final PImage IMG;
	
	public Player(int x, int y, int size, PApplet driver) {
		this.x=x;
		this.y=y;
		this.size=size;
		IMG = driver.loadImage("swimmer.png");
		IMG.resize(size, size);
	}

	public void update() {
		
	}
	public void draw(PApplet window) {
		window.rect(x, y, size, size);
		window.image(IMG, x, y);
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
