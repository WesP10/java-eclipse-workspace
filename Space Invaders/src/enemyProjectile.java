import processing.core.PApplet;

public class enemyProjectile extends projectile{

	public enemyProjectile(int x, int y, PApplet p) 
	{
		super(x, y, 8, p.loadImage("Pics/bullet.png"));
	}
}
