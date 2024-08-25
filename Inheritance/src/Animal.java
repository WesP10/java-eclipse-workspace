
public class Animal extends Object{

	private int age;
	private String name;
	
	public Animal(int age, String name) 
	{
		this.age=age;
		this.name=name;
	}
	
	public void noise() 
	{
		System.out.println("vysdfboh");
	}
	
	public int getAge() 
	{
		return age;
	}
	
	public void setAge(int age) 
	{
		this.age=age;
	}
}
