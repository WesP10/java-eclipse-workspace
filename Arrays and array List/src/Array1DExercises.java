
public class Array1DExercises {

	public static void main(String[] args) 
	{
		Grade G = new Grade("src/scores.txt");
		printArray(G.getGrades());
		System.out.println("The mean of the grades is " + G.mean());
		System.out.println("The meadian of the grades is " + G.median());
		System.out.print("the mode is "); printArray(G.mode());
		System.out.println("The variance of the grades is " + G.variance());
		System.out.println("The standard deviation of the grades is " +G.standardDeviation());
		System.out.print("the histogram array is "); 
		printArray(G.histogram(10, 1, 100));
	}

	//generating a raandom array of integers
	/*integers will be between [0, maxValue]
	 * @param length - number of elements in array
	 * @param maxValue - max random int generated
	 * @return an array of random int
	 */
	public static int[] generateArray(int length, int maxValue) 
	{
		if(maxValue < 0 || length <= 0)
			throw new IllegalArgumentException("Length must be greater than 0 and the max value can not be negative");
		int[] randomArray = new int[length];
		for(int i = 0; i <= randomArray.length-1; i++) 
			randomArray[i] = (int)(Math.random()*(maxValue-1)+1);
		return randomArray;
	}
	
	public static void printArray(int[] e) 
	{
		System.out.print("[");
		for(int i = 0; i <= e.length-1; i++) {
			if(i == e.length-1)
				System.out.print(e[i]);
			else
				System.out.print(e[i] + ", ");
		}
		System.out.println("]");
	}

	public static void printArray(double[] e) 
	{
		System.out.print("[");
		for(int i = 0; i <= e.length-1; i++) {
			if(i == e.length-1)
				System.out.print(e[i]);
			else
				System.out.print(e[i] + ", ");
		}
		System.out.println("]");
	}
	
	public static Integer max(int[] e) 
	{
		if(e.length == 0)
//			throw new IllegalArgumentException("Array must have a length");
			return null;
		int max = e[0];
		for(int i = 1; i <= e.length-1; i++) 
		{
			if(e[i] > max)
				max = e[i];
		}
		return max;
	}
	
	public static Integer min(int[] e) 
	{
		if(e.length == 0)
//			throw new IllegalArgumentException("Array must have a length");
			return null;
		int min = Integer.MAX_VALUE;
		for(int num : e) 
			if(num < min)
				min = num;
		return min;
		
	}
	//Wraper class - Object based class for every primitive
	//Examples: Integer, Double, Boolean, Long
	//Allows us to use any of the primitive values + null
	
	public static int sum(int[] e) 
	{
		int sum = 0;
		for(int i = 0; i <= e.length-1; i++) 
		{
			sum += e[i];
		}
		return sum;
	}
	
	public static double avg(int[] e) 
	{
		return sum(e)/e.length;
	}
	
	public static void reverse(int[] e) 
	{
		int t;
        for (int i = 0; i < e.length / 2; i++) 
        {
            t = e[i];
            e[i] = e[e.length - i - 1];
            e[e.length - i - 1] = t;
        }
	}
	
	public static void swap(int[] e, int i, int j) 
	{
		int ph = e[i-1];
		e[i-1] = e[j-1];
		e[j-1] = ph;
	}
	
	public static void rotateRight(int[] e) 
	{
		int ph = e[e.length-1];
		for(int i = e.length-1; i >= 1; i--) 
		{
			e[i] = e[i-1];
		}
		e[0] = ph;
	}
	
	public static void rotateLeft(int[] e)
	{
		int ph = e[0];
		for(int i = 0; i <= e.length-2; i++) 
		{
			e[i] = e[i+1];
		}
		e[e.length-1] = ph;
	}
	
	public static void rotate(int[] e, int spaces) 
	{
		if(spaces > e.length)
			spaces = spaces % e.length;
		int[] indx = new int[2*e.length];
		for(int i = 0; i <= e.length-1; i++)
			indx[i] = e[i];
		for(int j = indx.length-e.length; j <= indx.length-1; j++)
			indx[j] = e[j-e.length];
		for(int g = 0; g <= e.length-1; g++)
			e[g] = indx[(g-spaces)+e.length];
	}
	
}
