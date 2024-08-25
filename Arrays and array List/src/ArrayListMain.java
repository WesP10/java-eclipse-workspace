import java.util.ArrayList;

public class ArrayListMain {

	public static void main(String[] args) 
	{
//		ArrayList utAL = new ArrayList();
//		utAL.add("One");
//		utAL.add(2);
//		System.out.println(utAL);
		//Generally avoid untyped array lists
		
		ArrayList<Integer> nums = new ArrayList<Integer>(50);
		//intial capacity of 50
		//nums.add("One"); = error
		System.out.println(nums.size()); //same as .length
		nums.add(5);
		System.out.println(nums.get(0));
		
		for(int i = 0; i < 10; i++) 
			nums.add((int) (Math.random()*100));
		
		nums.add(5, 25); //adds 25 at index 5
		System.out.println(nums);
		
		nums.remove(5); //removes at index of 5
		nums.remove((Integer)5); //removes value of 5
		System.out.println(nums);
		
		//set the last element to 100
		nums.set(nums.size()-1, 100);
		System.out.println(nums);
	
		ArrayList<String> names = new ArrayList<String>();
		names.add("Alice");
		names.add("Bob");
		names.add("Charlie");
		names.add("Alice");
		names.add("Bob");
		names.add("Charlie");
		names.add("Bob");
		names.add("Bob");
		removeBobs(names);
		System.out.println(names);
		
		ArrayList<Object> al = new ArrayList<Object>();
		ArrayList<Object> bl = new ArrayList<Object>();
		al.add(bl);
		System.out.println(al);
	}

	public static void removeBobs(ArrayList<String> e) 
	{
		//can't use foreach loop when adding or removing from ArrayLists
		//iterate through ArrayList backwards when removing to avoid shifting index problem
		for(int i = e.size()-1; i >= 0; i--) 
		{
			if(e.get(i).equals("Bob")) 
				e.remove(i);
		}
	}
	
}
