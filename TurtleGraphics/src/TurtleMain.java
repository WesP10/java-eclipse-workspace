import java.awt.Color;

public class TurtleMain {
	public static void main(String[] args) {
		//creating a new powerful turtle and setting the screen size
		Turtle t = new Turtle();
		t.fillBox(50, 50);

}
	public static int function1(int i)
	{
		if(i <= 1) 
		{
			return 0;
		}
		else 
		{
			return 1 + function1(i / 2);
		}

	}

	
}

	
	

