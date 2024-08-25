
import java.util.ArrayList;

import processing.core.PApplet;

/**
 * The driver for the circle game.
 * @author sharicke
 *
 */
public class CircleGameDriver extends PApplet{
	private Character c;
	private ArrayList<Circle> enemies;
	private static int NUM_ENEMIES = 100;
	private boolean gameOver = false;
	private float playerSize = 45;
	private int timer;
	public double dif;
	Mode mode = new Mode("hard");
	public static void main(String[] args) {
		PApplet.main("CircleGameDriver");
	}
	public void settings()
	{
		fullScreen();
		//size(600, 600);
	}
	/**
	 * Sets up the initial game state. Spawns in the character in the middle
	 * of the screen and spawns a list of enemies based on NUM_ENEMIES constant.
	 */
	public void setup()
	{
		timer = 0;
		dif = 0;
		background(255);
		noCursor();
		frameRate(30);
		c = new Character(width/2, height/2, playerSize, new Color(200, 125, 80));
		enemies = new ArrayList<Circle>();
		for(int i = 0; i < NUM_ENEMIES; i++)
		{
			Circle e = new Circle(width, height);
			enemies.add(e);
			mode.incDif(e);

		}
		drawCharacter();
		drawEnemies();
	}
	/**
	 * The main loop for the game. Redraws the background and updates and redraws
	 * the player character and enemies.
	 */
	public void draw()
	{
		if (!gameOver)
		{
			background(255);
			updateCharacter();
			updateEnemies();
			drawCharacter();
			drawEnemies();
			if(frameCount % 30 == 0)
			incTimer();
			drawTimer();
			if(timer % 5 == 1)
				incDif();
		}
	}
	
	/**
	 * Click the mouse to start over.
	 */
	public void mousePressed()
	{
		setup();
		gameOver = false;
	}
	
	/**
	 * Updates the character by moving it to the mouse location then
	 * checking to see if it is colliding with each of the enemies. If
	 * it is colliding with a smaller enemy, it consumes the enemy, grows,
	 * and causes the enemy to respawn. If it is colliding with a larger enemy,
	 * the game ends.
	 */
	public void updateCharacter()
	{
		c.moveCharacter(mouseX, mouseY);
		for(int i = enemies.size()-1; i >= 0; i--)
		{
			Circle e = enemies.get(i);
			if(c.collidingWith(e))
			{
				if(c.getSize() > e.getSize())
				{
					c.grow();
					e.respawn(c.getSize()); //respawn enemy
					//enemies.remove(i); //remove from board
				}
				else
				{
					gameOver = true;
				}
			}
		}
	}
	
	/**
	 * Draws the character with an ellipse.
	 */
	public void drawCharacter()
	{
		Color color = c.getColor();
		fill(color.getRed(), color.getBlue(), color.getGreen());
		ellipse(c.getX(), c.getY(), c.getSize(), c.getSize());
	}
	
	/**
	 * Updates the position of all enemies
	 */
	public void updateEnemies()
	{
		for(Circle e : enemies)
		{
			e.update();
		}
	}
	
	/**
	 * Draws an ellipse for each enemy
	 */
	public void drawEnemies()
	{
		for(Circle e : enemies)
		{
			Color color = e.getColor();
			fill(color.getRed(), color.getGreen(), color.getBlue());
			ellipse(e.getX(), e.getY(), e.getSize(), e.getSize());
		}
	}

	public void drawTimer() 
	{
		String s = timer + " seconds";
		textSize(150);
		text(s, (width/2)-300, height/2);
	}

	public void incTimer() 
	{
		timer++;
	}
	
	public void incDif() 
	{
		mode.incDif();
	}
}
