
public class Cat extends Animal{

	private int numLives;
	
	public Cat(int age, String name) {
		this(age, name, 9);
		numLives = 9;
	}

	public Cat(int age, String name, int numLives) 
	{
		super(age, name);
		this.numLives=numLives;
	}

	public void noise() 
	{
		System.out.println("Meoww");
	}
}
