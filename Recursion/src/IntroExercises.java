/**
 * 
 * @author Weston
 *
 */

public class IntroExercises {

	public static void main(String[] args) 
	{
		sumDigits(254);
	}
	
	public static void naturalNumbers() 
	{
		int n = 1;
		naturalNumbers(n);
	}
	
	public static void naturalNumbers(int n) 
	{
		System.out.println(n);
		if(n >= 50)
			return;
		naturalNumbers(++n);
	}
	
	public static int sum(int n) 
	{
		if(n == 1)
			return 1;
		return n + sum(n-1);
	}
	
	public static void printArr(int[] arr) 
	{
		int n = 0;
		System.out.println(arr[n]);
		printArrH(arr, ++n);
	}
	
	public static void printArrH(int[] arr, int n) 
	{
		if(n == arr.length)
			return;
		System.out.println(arr[n]);
		printArrH(arr, ++n);
	}
	
	public static int sumDigits(int n) 
	{
		if(n == 0)
			return n;
		return n%10 + sumDigits(n/10);
	}
	
	public static Character firstCapLetter(String n) 
	{
		int indx = 0;
		if(indx >= n.length())
			return null;
		if(Character.isUpperCase(n.charAt(indx)))
			return n.charAt(indx);
		return firstCapLetter(n.replace(""+n.charAt(indx), ""));
	}

	public static void hailStone(int n) 
	{
		System.out.println(n);
		if(n == 1) 
			return;
		if(n%2 == 0) 
			hailStone(n/2);
		else
			hailStone(n*3+1);
	}
	
	public static boolean isPrime(int n)
    {
        if (n <= 1)
            return false;
        
        int i = 2;
        if (n % i == 0)
        	return false;
        return isPrime(n, ++i);
    }
	
	public static boolean isPrime(int n, int i) 
	{
		if(i >= n)
			return true;
		if (n % i == 0)
        	return false;
		return isPrime(n, ++i);
	}
}
