package Main;

import Objects.Obj1Stamp;
import Objects.Obj2Pencil;

public class AssetAssigner {

	GamePanel gp;
	
	public AssetAssigner(GamePanel gp) 
	{
		this.gp = gp;
	}
	
	public void setObj() 
	{
		gp.obj[0] = new Obj1Stamp(); 
		gp.obj[0].worldX = 2*gp.tileSize;
		gp.obj[0].worldY = 1*gp.tileSize;
		
		gp.obj[1] = new Obj2Pencil();
		gp.obj[1].worldX = 23*gp.tileSize;
		gp.obj[1].worldY = 20*gp.tileSize;
	}
}
