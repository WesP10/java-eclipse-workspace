import processing.core.PApplet;

public class playerProjectile extends projectile{

	public playerProjectile(int x, int y, PApplet p) 
	{
		super(x, y, -8, p.loadImage("Pics/pBullet.png"));
	}

}
