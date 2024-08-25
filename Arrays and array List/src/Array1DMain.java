import java.util.ArrayList;

public class Array1DMain {

	public static void main(String[] args) 
	{		
		boolean[] b = new boolean[10];
		
		//iterate through an array
		//length is a public constant field of the [] class
		//once we establish length of array it can't be changed
		//1 - forloop
		for(int i = 0; i < b.length; i++)
		{
			b[i] = (Math.random()*10+1) < 5;
			System.out.println(b[i]);
		}
		
		//2 - for each loop
		//can only access the array
		for(boolean bools : b) 
		{
			System.out.println("B " + bools);
			bools = false;
		}
		
		//3 - while loop
		int j = b.length - 1;
		while(j >= 0) 
		{
			System.out.println(b[j]);
			j--;
		}
		
		//initializing an array - 3 ways
		//1 - using new
		//int[] someNumbers = new int[10];
		//values go to default of variable type
		Person[] people = new Person[10];
		people[0] = new Person("Shithead");
		//doesn't work alone must intilize each object seperatley
		people[0].name = "Gibby";
		
		//use a for loop
		//intializing an array 2 - using implicent declaration
		String[] names = {"shithead", "fucker", "asshole", "Helen", "Vlad", "dad",
				"Amy", "Ron", "Lex", "Nate", "annoying"};
		//only works when you are declaring an array
		//3 - using implicit declaration with "new" keyword
		//names = new String[] {"Bill"};
		
		for(int i = 0; i < people.length; i++)
			people[i] = new Person(names[i]);
		
		for(Person P:people)
			System.out.println(P.introduce());
		
	}
	
	
}
