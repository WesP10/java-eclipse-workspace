import java.util.ArrayList;
import processing.core.PApplet;

public class enemy extends entity implements contacts{

	private ArrayList<Integer> moves;
	private final static int stepSize = 30;
	
	public enemy(int x, int y, int w, int h, PApplet p) 
	{
		super(new enemyProjectile(x, 0, p), 3, x, y, p.loadImage("Pics/enemy.jpg"), stepSize);
		moves = calcMoves(w, h);
		super.getPic().resize(30, 40);
	}

	public ArrayList<Integer> calcMoves(int w, int h) 
	{
		int num = (w - 590)/stepSize;
		int depth = (h - 520)/stepSize;
		int wh = 0;
		
		ArrayList<Integer> n = new ArrayList<Integer>();
		
		while(wh < depth) 
		{
			wh++;
			if(wh%2 == 0)
				for(int i = 0; i < num; i++) 
					n.add(0);
			else
				for(int i = 0; i < num; i++) 
					n.add(1);
			if(w != depth-1)
				n.add(-1);
		}
		return n;
	}
	
	public void move(int c) 
	{
		if(moves.get(c) > 0)
			super.setX(super.getX()+(int)super.getSpeed());
		if(moves.get(c) == 0)
			super.setX(super.getX()-(int)super.getSpeed());
		if(moves.get(c) < 0)
			super.setY(super.getY()+(int)super.getSpeed());
	}
	
	public boolean lose(int h) 
	{
		if(super.getY() > h-150)
			return true;
		return false;
	}
	
	@Override
	public boolean contact(Object e) {
		//enemy dimesion - 30x40
		projectile t = (projectile)e;
		return t.getxPos() > super.getX() && t.getxPos() < super.getX()+30
				&& t.getyPos() > super.getY() && t.getyPos() < super.getY()+40;
	}

	public void shoot(ArrayList<projectile> arr, int r) {
		if(r < 3)
		{
			getP().setxPos(getX());
			getP().setyPos(getY());
			arr.add(getP());
			super.setShot(true);
		}
	}

}
