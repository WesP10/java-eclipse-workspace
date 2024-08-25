package Objects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import Main.GamePanel;

public class SuperObject {

	public BufferedImage img;
	public String name;
	public boolean collision = false;
	public int worldX, worldY;
	
	public void draw(Graphics2D g2, GamePanel gp) 
	{
		int screenX = worldX - gp.p.worldX + gp.p.screenX;
		int screenY = worldY - gp.p.worldY + gp.p.screenY;
		if(worldX + gp.tileSize > gp.p.worldX - gp.p.screenX &&
		   worldX - gp.tileSize < gp.p.worldX + gp.p.screenX &&
		   worldY + gp.tileSize > gp.p.worldY - gp.p.screenY &&
		   worldY - gp.tileSize < gp.p.worldY + gp.p.screenY) 
			g2.drawImage(img, screenX, screenY, gp.tileSize, gp.tileSize, null);
	}
}
