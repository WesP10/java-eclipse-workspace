package Objects;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Obj1Stamp extends SuperObject{

	public Obj1Stamp() 
	{
		name = "Stamp";
		try 
		{
			img = ImageIO.read(getClass().getResourceAsStream("/Res/objects/obj_0.png"));
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}
}
