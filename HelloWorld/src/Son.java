
public class Son extends Father{

	public Son() {
		super(0, 0);
	}

	
	public void act() 
	{
		System.out.println("sleep");
	}

	public void a() 
	{
		super.a();
		System.out.println("bark");
	}
}
