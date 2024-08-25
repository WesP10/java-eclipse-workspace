
public class Dog extends Animal{

	private boolean canSwim;
	
	public Dog(String name, int age, boolean canSwim) {
		super(age, name);
		this.canSwim = canSwim;
	}
	
	public Dog(String name, int age) 
	{
		this(name, age, false);
	}
	
	public void noise() 
	{
		System.out.println("Bark!!");
	}
	
	public int getAge() 
	{
		return super.getAge()*7;
	}
}
	
