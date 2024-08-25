package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import Entity.Player;
import Objects.SuperObject;
import Tile.TileManager;

/**
 * 
 * @author Weston
 *
 */

public class GamePanel extends JPanel implements Runnable{

	public int ogTileSize = 16;
	public int scale = 4;
	public int tileSize = ogTileSize * scale; //48x48 tiles
	
	public int screenCol = 16;
	public int screenRow = 12;
	public int screenWidth = screenCol * tileSize; //768 pixels
	public int screenHeight = screenRow * tileSize; //576 pixels
	
	public int worldCol = 47;
	public int worldRow = 22;
	public int worldWidth = tileSize * worldCol;
	public int worldHeight = tileSize * worldRow;
	
	TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	public CollisionCheck cCheck = new CollisionCheck(this);
	public Player p = new Player(this, keyH);
	public SuperObject obj[] = new SuperObject[5];
	public AssetAssigner aa = new AssetAssigner(this);
	
	int FPS = 60;
	
	public GamePanel() 
	{
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.blue);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	public void setupGame() 
	{
		aa.setObj();
	}

	public void startThread() 
	{
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	@Override
	public void run() 
	{	
		double drawInterval = 1000000000/FPS; //0.016 seconds
		double nextStep = System.nanoTime() + drawInterval;
		
		while(gameThread != null) 
		{
			p.update();
			repaint();
			
			try 
			{
				double remainingTime = (nextStep - System.nanoTime())/1000000;
				if(remainingTime < 0)
					remainingTime = 0;
				Thread.sleep((long) remainingTime);
				nextStep += drawInterval;
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		
	}
	
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		tileM.draw(g2);
		for(int i = 0; i < obj.length; i++) 
			if(obj[i] != null)
				obj[i].draw(g2, this);
		p.draw(g2);
		
		g2.dispose();
	}

}
