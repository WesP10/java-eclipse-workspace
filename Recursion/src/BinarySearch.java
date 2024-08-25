import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
		int numTrials = 10;
		for(int n = 0; n < numTrials; n++) 
		{
			int[] list = new int[500000];
			for(int i = 0; i < list.length; i++)
				list[i] = (int)(Math.random()*list.length);
			Arrays.sort(list);
			int key = (int)(Math.random()*list.length);
			System.out.println(linearSearch(list, key));
			System.out.println("Lin Search Compares: " + count);
			RecBinarySearch(list, key);
			System.out.println("RecBinarySearch Compares: " + count);
		}
	}
	
	static int count = 0;
	
	public static int nonRecBinarySearch(int[] list, int key) 
	{
		int first = 0;
		int last = list.length-1;
		while (first <= last) 
		{
			int middle = first + (last - first) / 2;
			if(list[middle] == key)
				return middle;
			else if(list[middle] < key)
				first = middle + 1;
			else
				last = middle - 1;
		}
		return -1;
	}
	
	public static int RecBinarySearch(int[] list, int key) 
	{
		count = 0;
		return RecBinarySearch(list, key, 0, list.length-1);
	}
	
	private static int RecBinarySearch(int[] list, int key, int first, int last) 
	{
		if(first > last)
			return -1;
		int middle = first + (last - first) / 2;
		count++;
		if(list[middle] < key) 
			return RecBinarySearch(list, key, middle+1, last);
		else if(list[middle] > key) 
		{
			count++;
			return RecBinarySearch(list, key, first, middle-1);
		}
		else
			return middle;
	}
	
	public static int linearSearch(int[] list, int key) 
	{
		count = 0;
		for(int i = 0; i < list.length; i++)
		{
			count++;
			if(list[i] == key)
				return i;
		}
		return -1;
	}
}
