package Entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {

	public int worldX, worldY, speed;
	public BufferedImage[] up, down, left, right;
	public String dir;
	public int spriteC = 0;
	public int spriteNum = 0;
	public Rectangle hitBox;
	public boolean cOn = false;
}
