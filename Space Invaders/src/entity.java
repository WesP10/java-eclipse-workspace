import java.util.ArrayList;

import processing.core.PImage;

public abstract class entity {

	private projectile p;
	private double coolDown, speed;
	private int x, y;
	private PImage pic;
	private boolean shot;
	
	public entity(projectile p, double coolDown, int x, int y, PImage pic, double speed) 
	{
		this.p=p;
		this.coolDown=coolDown;
		this.x=x;
		this.y=y;
		this.pic=pic;
		this.speed=speed;
		this.pic = pic;
		shot = false;
	}
	
	public void setShot(boolean b) 
	{
		shot = b;
	}
	
	public boolean getShot() 
	{
		return shot;
	}
	
	public double getSpeed() 
	{
		return speed;
	}
	
	public projectile getP() {
		return p;
	}



	public void setP(projectile p) {
		this.p = p;
	}



	public double getCoolDown() {
		return coolDown;
	}



	public void setCoolDown(double coolDown) {
		this.coolDown = coolDown;
	}



	public int getX() {
		return x;
	}



	public void setX(int x) {
		this.x = x;
	}



	public int getY() {
		return y;
	}



	public void setY(int y) {
		this.y = y;
	}



	public PImage getPic() {
		return pic;
	}

	public abstract void shoot(ArrayList<projectile> arr, int r);
}
