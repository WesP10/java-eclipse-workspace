package Entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import Main.GamePanel;
import Main.KeyHandler;

public class Player extends Entity{

	GamePanel gp;
	KeyHandler key;
	
	public int screenX;
	public int screenY;
	
	
	public Player(GamePanel gp, KeyHandler key) 
	{
		this.gp = gp;
		this.key = key;
		screenX = gp.screenWidth/2 - (gp.tileSize/2);
		screenY = gp.screenHeight/2 - (gp.tileSize/2);
		hitBox = new Rectangle(3*gp.scale, 3*gp.scale, gp.scale*10, gp.scale*10);
		
		setDefault();
		getPlayerImage();
	}
	
	public void setDefault() 
	{
		worldX= gp.tileSize *16;
		worldY= gp.tileSize *12;
		speed = 4;
		dir = "right";
	}
	
	public void getPlayerImage() 
	{	
		up = new BufferedImage[4];
		down = new BufferedImage[4];
		left = new BufferedImage[4];
		right = new BufferedImage[4];
		
		try 
		{
			for(int i = 0; i < 4; i++)
			{
				up[i] = ImageIO.read(getClass().getResourceAsStream("/Res/drone_sprite/up_" + i + ".png"));
				down[i] = ImageIO.read(getClass().getResourceAsStream("/Res/drone_sprite/down_" + i + ".png"));
				left[i] = ImageIO.read(getClass().getResourceAsStream("/Res/drone_sprite/left_" + i + ".png"));
				right[i] = ImageIO.read(getClass().getResourceAsStream("/Res/drone_sprite/right_" + i + ".png"));
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void update() 
	{
		spriteCounter();
		if(key.down == true || key.up == true || key.left == true || key.right == true)
		{
			dirCheck();
			collisionCheck();
		}
	}
	
	public void draw(Graphics2D g2) 
	{
		BufferedImage img = null;
		
		switch(dir) 
		{
		case "up":
			if(spriteNum == 0)
				img = up[0];
			else if(spriteNum == 1)
				img = up[1];
			else if(spriteNum == 2)
				img = up[2];
			else if(spriteNum == 3)
				img = up[3];
			break;
		case "down":
			if(spriteNum == 0)
				img = down[0];
			else if(spriteNum == 1)
				img = down[1];
			else if(spriteNum == 2)
				img = down[2];
			else if(spriteNum == 3)
				img = down[3];
			break;
		case "left":
			if(spriteNum == 0)
				img = left[0];
			else if(spriteNum == 1)
				img = left[1];
			else if(spriteNum == 2)
				img = left[2];
			else if(spriteNum == 3)
				img = left[3];
			break;
		case "right":
			if(spriteNum == 0)
				img = right[0];
			else if(spriteNum == 1)
				img = right[1];
			else if(spriteNum == 2)
				img = right[2];
			else if(spriteNum == 3)
				img = right[3];
			break;
		}
		g2.drawImage(img, screenX, screenY, gp.tileSize, gp.tileSize, null);
	}
	
	public void dirCheck()
	{		
		if(key.up == true)
			dir = "up";
		if(key.down == true)
			dir = "down";
		if(key.left == true)
			dir = "left";
		if(key.right == true)
			dir = "right";
	}
	
	public void spriteCounter() 
	{
		spriteC++;
		if(spriteC > 5) 
		{
			if(spriteNum == 3)
				spriteNum = 0;
			else
				spriteNum++;
			spriteC = 0;
		}
	}
	
	public void collisionCheck() 
	{
		cOn = false;
		gp.cCheck.checkTile(this);
		
		if(cOn == false) 
		{
			switch(dir) 
			{
			case"up":
				worldY-=speed;
				break;
			case"down":
				worldY+=speed;
				break;
			case"left":
				worldX -=speed;
				break;
			case"right":
				worldX +=speed;
				break;
			}
		}
	}
}
