import java.util.*;
import java.io.*;

public class HelloWorld
{
	static int[] nums = {0, 0, 5, 18};
	static int countOne = 0, countTwo = 0;
	
	public static void main(String[] args) throws IOException
	{
		byte b = 97;
		System.out.println((char)b);
	}

	private static ArrayList<String> letters1(String code)
	{
		ArrayList<String> letters = new ArrayList<String>();
		for(int i = 0; i < code.length(); i++)
			for(int j = 0; j < 3; j++) {
				byte b = Byte.parseByte(""+code.charAt(i));
				byte indx = (byte)(3*b+91+j);
				if(indx > 112)
					indx++;
				 letters.add(""+(char)indx);
			}
		return letters;
	}
	
	private static char[][] letters(String code)
	{
		char[][] letters = new char[code.length()][3];
		for(int i = 0; i < letters.length; i++)
			for(int j = 0; j < 3; j++) {
				byte b = Byte.parseByte(""+code.charAt(i));
				byte indx = (byte)(3*b+91+j);
				if(indx > 112)
					indx++;
				letters[i][j] = (char)indx;
			}
		return letters;
	}
	
	public static ArrayList<String> printCombinations1(char[][] mx, int position, String result, ArrayList<String> words,int i) {
		if (position < mx.length) {
			String newResult = result + "" + mx[position][i];
			if(i < 2)
				words = printCombinations1(mx, position + 1, newResult, words, i+1);
			else
				words = printCombinations1(mx, position + 1, newResult, words, 0);
        }
		else {
            words.add(result.toUpperCase());
        }
        return words;
    }
	
	public static ArrayList<String> printCombinations2(char[][] mx, int position, String result, ArrayList<String> words) {
		if (position == mx.length) {
            return words;
        }
        for (int i = 0; i < mx[position].length; i++) {
            String newResult = result + "" + mx[position][i];
            if(newResult.length() == mx.length)
            	words.add(newResult.toUpperCase());
            words = printCombinations2(mx, position + 1, newResult, words);
        }
        return words;
    }
	
	private static boolean equals(char[] a, char[] b) 
	{
		if(a.length != b.length)
			return false;
		for(int i = 0; i < a.length; i++)
			if(a[i] != b[i])
				return false;
		return true;
	}
	
	private static boolean same(String[] lets) 
	{
		String let = lets[0];
		int count = 1;
		for(int i = 1; i < lets.length; i++)
			if(let.equals(lets[i]) || let.equalsIgnoreCase("w"))
				count++;
		return count == lets.length;
	}
	
	private static int calcLeft(String[] lets, int breakPoint, int right) {
		String let = lets[breakPoint];
		if(breakPoint == 0)
			let = lets[lets.length-1];
		else
			let = lets[breakPoint-1];
		int count = 0;
		int nextLet = breakPoint-1;
		boolean sameLet = true;
		while(sameLet) {
			if(nextLet < 0)
				nextLet = lets.length-1;
			if(nextLet == breakPoint || nextLet == right)
				break;
			if(lets[nextLet].equals(let) || lets[nextLet].equalsIgnoreCase("w")) {
				count++;
				nextLet--;
			}
			else
				sameLet = false;
			if(nextLet < 0)
				nextLet = lets.length-1;
			if(nextLet == breakPoint || nextLet == right)
				sameLet = false;
		}
		return count;
	}

	private static int calcRight(String[] lets, int breakPoint) {
		String let = lets[breakPoint];
		int count = 1;
		int nextLet = breakPoint+1;
		boolean sameLet = true;
		while(sameLet) {
			if(nextLet >= lets.length)
				nextLet = 0;
			if(lets[nextLet].equals(let) || lets[nextLet].equalsIgnoreCase("w")) {
				count++;
				nextLet++;
			}
			else
				sameLet = false;
			if(nextLet >= lets.length)
				nextLet = 0;
			if(nextLet == breakPoint)
				sameLet = false;
		}
		return count;
	}
	
	private static int prod(String s) {
		int prod = (byte)s.charAt(0)-64;
		for (int i = 1; i < s.length(); i++) {
			prod *= (byte) s.charAt(i) - 64;
		}
		return prod;
	}
	
	public static double d() 
	{
		return 10.0;
	}
	
	public static void sort(String[] arr)

	{

	  for (int pass = arr.length - 1; pass >= 1; pass--)

	  {

	    String large = arr[0];

	    int index = 0;

	    for (int k = 0; k <= pass; k++)

	    {

	      if ((arr[k].compareTo(large)) > 0)

	      {

	        large = arr[k];

	        index = k;

	      }

	    }

	    arr[index] = arr[pass];

	    arr[pass] = large;
	    for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	    System.out.println();
	  }

	}
	
	public static void selectionSort(int[] elements)

	{

	for (int j = 0; j < elements.length - 1; j++)

	{

	int minIndex = j;

	 

	for (int k = j + 1; k < elements.length; k++)

	{

	if (elements[k] < elements[minIndex])

	{

	minIndex = k;

	}

	}

	 

	if (j != minIndex)

	{

	int temp = elements[j];

	elements[j] = elements[minIndex];
	countOne++;
	elements[minIndex] = temp;    // Line 19

	}

	}

	}
	
	public static void insertionSort(ArrayList<Integer> data)

	{

	for (int j = 1; j < data.size(); j++)

	{

	int v = data.get(j);

	int k = j;

	while (k > 0 && v < data.get(k - 1))

	{
	countOne++;
	data.set(k, data.get(k - 1)); /* Statement 1 */

	k--;

	}
	countTwo++;
	data.set(k, v); /* Statement 2 */

	 

	/* End of outer loop */

	}

	}
	
	public static void bubbleSort(int[] nums) {
		for (int j = 0; j < nums.length; j++)
		{	
			for(int i = 0; i < nums.length - 1 - j; i++) {
				if (nums[i] < nums[i+1]) {
					if(j == 1)
					swap(nums, i, i+1); //line 6 - swap
				}
			}
                        //line 9 - after a  pass through the list
		}
	}
	
	public static void print(int[] e) 
	{
		for(int i = 0; i < e.length; i++)
			System.out.print(e[i] + " ");
		System.out.println();
	}
	
	public static void swap(int[] arr, int i, int j) 
	{
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	
public static void calculator(double x, double y)
{

	double z = x - y;
	double w = x + y;

	System.out.println("x = " + x);
	System.out.println("y = " + y);
	System.out.println("x times y = " + x * y);
	System.out.println("x divided by y = " + x / y);
	System.out.println("x plus y = " + w);
	System.out.println("x minus y = " + z);
}
}