
public class Mode {

	private int mode, dif;

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}
	
	public void incDif() 
	{
		dif++;
	}
	
	public Mode(String mode)
	{
		if(mode.equals("easy"))
			this.mode = 1;
		else if(mode.equals("medium"))
			this.mode = 2;
		else if(mode.equals("hard"))
			this.mode = 3;
		if(getMode() == 0)
			System.out.println("Declare mode easy, medium, or hard");
	}
	
	public void updateMode(Circle e) 
	{
		if(mode == 1) 
		{
			e.circleSizeM = 8;
			e.circleSpeed = 1.5;
			e.densityOfSpawning = 0.125;
		}
		
		else if(mode == 2) 
		{
			e.circleSizeM = 2;
			e.circleSpeed = 3;
			e.densityOfSpawning = 0.25;
		}
		
		else if(mode == 3) 
		{
			e.circleSizeM = (float) 0.2;
			e.circleSpeed = 12;
			e.densityOfSpawning = 0.99;
		}
		e.respawn();
	}
	
	public void crazyMode(Circle e) 
	{
		e.circleSizeM = (float)(Math.random()*9+0.2);
		e.circleSpeed = (Math.random()*13+1);
		e.densityOfSpawning = (float)(Math.random());
		e.respawn();
	}
	
	public void blackAndWhiteEnemies(Circle e) 
	{
		e.circleColorOffset = 255;
		e.respawn();
	}
	
	public void incDif(Circle e) 
	{
		e.circleSizeM = (float) 0.2;
		e.circleSpeed = 3 + (dif*5);
		e.respawn();
	}
}
