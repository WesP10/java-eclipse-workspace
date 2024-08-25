import java.util.ArrayList;

import processing.core.PApplet;

public class player extends entity implements contacts{

	public player(int x, int y, PApplet p) 
	{
		super(new playerProjectile(x, 0, p), 5, x, y, p.loadImage("Pics/player.png"),3);
		super.getPic().resize(100, 60);
	}
	
	public void move(int dir, int w) 
	{
		if(dir < 0)
				super.setX(super.getX()-(int)super.getSpeed());
		if(dir > 0)
				super.setX(super.getX()+(int)super.getSpeed());
		if(super.getX() < 0)
			super.setX(0);
		if(super.getX() > w)
			super.setX(w);
	}
	
	public void shoot(ArrayList<projectile> arr, int r) 
	{
		getP().setxPos(getX()+40);
		getP().setyPos(500);
		arr.add(getP());
		super.setShot(true);
	}
	
	@Override
	public boolean contact(Object e) {
		//player dimesions - 100x60
		projectile t = (projectile)e;
		return t.getxPos() > super.getX() && t.getxPos() < super.getX()+100
				&& t.getyPos() > 500;
	}

}
