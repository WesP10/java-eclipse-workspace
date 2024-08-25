package Main;

import Entity.Entity;

public class CollisionCheck {

	GamePanel gp;
	
	public CollisionCheck(GamePanel gp) 
	{
		this.gp = gp;
	}
	
	public void checkTile(Entity e) 
	{
		int eLeftWorld = e.worldX + e.hitBox.x;
		int eRightWorld = e.worldX + e.hitBox.x + e.hitBox.width;
		int eTopWorld = e.worldY + e.hitBox.y;
		int eBotWorld = e.worldY + e.hitBox.height + e.hitBox.y;
		
		int eLeftCol = eLeftWorld/gp.tileSize;
		int eRightCol = eRightWorld/gp.tileSize;
		int eTopRow = eTopWorld/gp.tileSize;
		int eBotRow = eBotWorld/gp.tileSize;
		
		int tNum1, tNum2;
		
		switch(e.dir) 
		{
		case"up":
			eTopRow = (eTopWorld - e.speed)/gp.tileSize;
			tNum1 = gp.tileM.mapNum[eLeftCol][eTopRow];
			tNum2 = gp.tileM.mapNum[eRightCol][eTopRow];
			if(gp.tileM.tile[tNum1].collision == true || gp.tileM.tile[tNum2].collision == true) 
				e.cOn = true;
			break;
		case"down":
			eBotRow = (eBotWorld + e.speed)/gp.tileSize;
			tNum1 = gp.tileM.mapNum[eLeftCol][eBotRow];
			tNum2 = gp.tileM.mapNum[eRightCol][eBotRow];
			if(gp.tileM.tile[tNum1].collision == true || gp.tileM.tile[tNum2].collision == true) 
				e.cOn = true;
			break;
		case"left":
			eLeftCol = (eLeftWorld - e.speed)/gp.tileSize;
			tNum1 = gp.tileM.mapNum[eLeftCol][eTopRow];
			tNum2 = gp.tileM.mapNum[eLeftCol][eBotRow];
			if(gp.tileM.tile[tNum1].collision == true || gp.tileM.tile[tNum2].collision == true) 
				e.cOn = true;
			break;
		case"right":
			eRightCol = (eRightWorld + e.speed)/gp.tileSize;
			tNum1 = gp.tileM.mapNum[eRightCol][eTopRow];
			tNum2 = gp.tileM.mapNum[eRightCol][eBotRow];
			if(gp.tileM.tile[tNum1].collision == true || gp.tileM.tile[tNum2].collision == true) 
				e.cOn = true;
			break;
		}
	}
}
