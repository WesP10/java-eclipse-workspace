import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;

public class graphicalDriver extends PApplet{

	PImage background;
	ArrayList<ArrayList<enemy>> enemies;
	player player;
	ArrayList<projectile> shots;
	int count, dir, ldir;
	
	
	public static void main(String[] args) {
		PApplet.main("graphicalDriver");
	}

	public void settings() 
	{
		size(800, 600);
		
	}
	
	public void setup() 
	{
		frameRate(60);
		count = 0;
		dir = 0;
		ldir = 0;
		
		background = loadImage("Pics/background.jpg");
		background.resize(width, height);
		
		player = new player(width/3, height-100, this);
		
		shots = new ArrayList<projectile>();
		
		//creates 2d array of enemies
		enemies = new ArrayList<ArrayList<enemy>>(5);
		for(int i = 0; i < 5; i++)
			enemies.add(new ArrayList<enemy>());
		for(int i = 0; i < 5; i++)
			for(int j = 0; j < 8; j++)
				enemies.get(i).add(new enemy(j*(width/10), i*80, width, height, this));
	}
	
	public void draw() 
	{
		image(background, 0, 0);
		if(frameCount%60 == 0)
			enemiesMove();
		drawPlayer();
		drawEnemies();
		enShot();
		checkLose();
		moveShots();
		drawShots();
		checkShots();
		checkWin();
	}
	
	public void checkWin() 
	{
		for(int i = 0; i < enemies.size(); i++) 
			if(enemies.get(i).size() > 0)
				return;
		noLoop();
		background(255);
		fill(0, 255, 0);
		textSize(50);
		text("Winner", width/2-80, height/2);
	}
	
	public void checkShots() 
	{
		for(int i = 0; i < shots.size(); i++) 
		{
			projectile t = shots.get(i);
			if(t.getClass().equals(player.getP().getClass())) {
				for(int j = 0; j < enemies.size(); j++)
					for(int k = 0; k < enemies.get(j).size(); k++) 
						if(enemies.get(j).get(k).contact(t))
						{
							enemies.get(j).remove(k);
							shots.remove(i);
							player.setShot(false);
						}
			}
			else {
				if(player.contact(t))
					lose();
			}
		}
	}
	
	public void enShot() 
	{
		int r = (int)(Math.random()*150);
		int row = (int)(Math.random()*enemies.size());
		int col = (int)(Math.random()*enemies.get(row).size());
		if(enemies.get(row).get(col) != null)
			enemies.get(row).get(col).shoot(shots, r);
	}
	
	public void moveShots() 
	{
		for(int i = 0; i < shots.size(); i++) 
		{
			projectile t = shots.get(i);
			t.move();
			if(t.getyPos() > height || t.getyPos() < 0) {
				if(t.getClass().equals(player.getP().getClass()))
					player.setShot(false);
				shots.remove(t);
			}
		}
	}
	
	public void drawShots() 
	{
		for(int i = 0; i < shots.size(); i++) 
		{
			projectile t = shots.get(i);
			t.getPic().resize(10, 20);
			image(t.getPic(), t.getxPos(), t.getyPos());
		}
	}
	
	public void keyPressed() 
	{
		if (key == CODED) {
			if (keyCode == LEFT) 
			{
			    player.move(-1, width); 
			} 
			else if (keyCode == RIGHT)
			{
				player.move(1, width);
			} 
			else if(keyCode == UP) 
			{
				if(!player.getShot())
					player.shoot(shots, 0);
			}
		}
	}
	
	public void drawPlayer() 
	{
		image(player.getPic(), player.getX(), player.getY());
	}
	
	public void checkLose() 
	{
		for(int i = 0; i < enemies.size(); i++)
			for(int j = 0; j < enemies.get(i).size(); j++) 
				if(enemies.get(i).get(j).lose(height)) 
					lose();
	}
	
	public void lose() 
	{
		noLoop();
		background(0);
		fill(255, 0, 0);
		textSize(50);
		text("GAME OVER", width/2-130, height/2);
	}
	
	public void enemiesMove() 
	{
		for(int i = 0; i < enemies.size(); i++)
			for(int j = 0; j < enemies.get(i).size(); j++)
				enemies.get(i).get(j).move(count);
		if(count != 15)
			count++;
		else
			count = 0;
	}
	
	public void drawEnemies() 
	{
		for(int i = 0; i < enemies.size(); i++)
			for(int j = 0; j < enemies.get(i).size(); j++) 
			{
				enemy t = enemies.get(i).get(j);
				image(t.getPic(), t.getX(), t.getY());
			}
	}
}
