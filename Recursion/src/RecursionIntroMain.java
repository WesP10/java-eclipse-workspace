
public class RecursionIntroMain {

	public static void main(String[] args) {
		print(4);
	}
	
	public static void print(int n) 
	{
		if(n > 0) 
		{
			System.out.print("*");
			n--;
			print(n);
			System.out.print("!");
		}
	}
	
	static int[] fibs = new int[100];
	public static long countRecursions = 0;
	public static void testEOF() 
	{
		for(int n = 0; n < 50; n++) 
		{
			System.out.println("N is: " + n);
			fibs = new int[100];
			countRecursions = 0;
			badFibonacci(n);
			System.out.println("Num of Recursions for BadFib: " + countRecursions);
			countRecursions = 0;
			fibonacci(n);
			System.out.println("Num of Recursions for GoodFib: " + countRecursions);
			System.out.println();
		}
	}

	public static int badFibonacci(int n) 
	{
		if(n == 0 || n == 1)
			return n;
		countRecursions+=2;
		return badFibonacci(n-1) + badFibonacci(n-2);
	}
	
	public static int fibonacci(int n) 
	{
		if(fibs[n] != 0)
			return fibs[n];
		if(n == 0||n == 1)
			return n;
		countRecursions++;
		int fibN_1 = fibonacci(n-1);
		fibs[n-1] = fibN_1;
		return fibN_1 + fibs[n-2];
	}
	
	public static long factorial(long n) 
	{
		if(n < 0)
			throw new IllegalArgumentException("n must be positive");
		return n*factorialH(n-1);
	}
	
	public static long factorialH(long n) 
	{
		if(n == 0)
			return 1;
		return n*factorialH(n-1);
	}
	
	public static int puzzle(int base, int limit)
	{
		if (base > limit)
		return -1;
		else if (base == limit)
		return 1;
		else
		return base * puzzle(base + 1, limit);
	}
}
