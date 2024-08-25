import processing.core.PImage;

public abstract class projectile {

	private int xPos, yPos;
	private double speed;
	private PImage pic;
	
	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public double getSpeed() {
		return speed;
	}

	public PImage getPic() {
		return pic;
	}

	public projectile(int x,int y,double speed,PImage pic) 
	{
		xPos=x;
		yPos=y;
		this.speed=speed;
		this.pic=pic;
	}
	
	public void move() 
	{
		yPos+=speed;
	}
	//return true if out of bounds
	public boolean checkBounds(int h) 
	{
		return yPos < 0 || yPos > h;
	}
	
}
