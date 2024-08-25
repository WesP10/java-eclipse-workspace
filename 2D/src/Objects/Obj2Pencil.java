package Objects;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Obj2Pencil extends SuperObject{
	
	public Obj2Pencil() 
	{
		name = "Pencil";
		try 
		{
			img = ImageIO.read(getClass().getResourceAsStream("/Res/objects/obj_1.png"));
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}

}
