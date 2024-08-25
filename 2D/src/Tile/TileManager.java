package Tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import Main.GamePanel;

public class TileManager {

	GamePanel gp;
	public Tile[] tile;
	public int mapNum[][];
	
	public TileManager(GamePanel gp) 
	{
		this.gp = gp;
		tile = new Tile[17];
		mapNum = new int[gp.worldCol][gp.worldRow];
		
		getImg();
		loadMap();
	}
	
	public void getImg() 
	{
		try 
		{
			for(int i = 0; i < tile.length; i++)
			{
				tile[i] = new Tile();
				tile[i].img = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/tile_" + i +".png"));
			}
			
			tile[2].collision = true;
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void loadMap() 
	{
		try 
		{
			InputStream is = getClass().getResourceAsStream("/Res/tiles/world_map.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			while(col < gp.worldCol && row < gp.worldRow) 
			{
				String l = br.readLine();
				
				while(col < gp.worldCol) 
				{
					String nums[] = l.split(" ");
					int num = Integer.parseInt(nums[col]);
					mapNum[col][row] = num;
					col++;
				}
				if(col == gp.worldCol) 
				{
					col = 0;
					row++;
				}
			}
			br.close();
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2) 
	{
		int worldCol = 0;
		int worldRow = 0;
		
		while(worldCol < gp.worldCol && worldRow < gp.worldRow) 
		{
			int tNum = mapNum[worldCol][worldRow];
			int screenX = (worldCol*gp.tileSize) - gp.p.worldX + gp.p.screenX;
			int screenY = (worldRow*gp.tileSize) - gp.p.worldY + gp.p.screenY;
			if((worldCol*gp.tileSize) + gp.tileSize > gp.p.worldX - gp.p.screenX &&
			   (worldCol*gp.tileSize) - gp.tileSize < gp.p.worldX + gp.p.screenX &&
			   (worldRow*gp.tileSize) + gp.tileSize > gp.p.worldY - gp.p.screenY &&
			   (worldRow*gp.tileSize) - gp.tileSize < gp.p.worldY + gp.p.screenY) 
				g2.drawImage(tile[tNum].img, screenX, screenY, gp.tileSize, gp.tileSize, null);
			worldCol++;
			if(worldCol == gp.worldCol) 
			{
				worldCol = 0;
				worldRow++;
			}
		}
	}
}
