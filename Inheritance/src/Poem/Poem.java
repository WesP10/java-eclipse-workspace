package Poem;

public abstract class Poem {

	public abstract int getNumLines();
	
	public abstract int getNumSyllables(int k);
	
	public void printRhythm() 
	{
		if(this.getClass().equals(new Haiku().getClass())) 
		{
			System.out.println("la-la-la-la-la");
			System.out.println("la-la-la-la-la-la-la");
			System.out.println("la-la-la-la-la");
		}
		else 
		{
			System.out.println("la-la-la-la-la-la-la-la-la");
			System.out.println("la-la-la-la-la-la-la-la-la");
			System.out.println("la-la-la-la-la-la");
			System.out.println("la-la-la-la-la-la");
			System.out.println("la-la-la-la-la-la-la-la-la");
		}
	}
}
