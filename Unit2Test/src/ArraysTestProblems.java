import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

public class ArraysTestProblems {
	/**
	 * Returns the maximum value in list.
	 * You may assume that list != null.
	 * You may also assume that the ArrayList referenced by list contains at least one value.
	 */
	public static double returnMaxValue(ArrayList<Double> list) {
		int maxIndx = 0;
		for(int i = 1; i < list.size(); i++) 
			if(list.get(i) > list.get(maxIndx))
				maxIndx = i;
		return list.get(maxIndx);
	}
	
	/**
	 * Returns the minimum value in arr.
	 * You may assume that arr != null.
	 * You may also assume that the array-of-int referenced by arr contains at least one value.
	 */
	public static int returnMinValue(int[] arr) {
		int minIndx = 0;
		for(int i = 0; i < arr.length; i ++)
			if(arr[i] < arr[minIndx])
				minIndx = i;
		return arr[minIndx];
	}
	
	/**
	 * Finds the maximum value in list, then returns an array-of-int containing
	 * the indexes in list at which that maximum value can be found.
	 * For example, if list = [-5,-2,-7,-2,-2,-10], then
	 * the array [1,3,4] will be returned, as the maximum value -2 is found in list
	 * in the cells with indexes 0, 3, and 4.
	 * Note: it is OK (recommended?) to loop through the ArrayList more than one time.
	 * You may assume that list != null.
	 * You may also assume that the ArrayList referenced by list contains at least one value.
	 */
	public static int[] findIndexesOfMax(ArrayList<Integer> list) {
		int maxIndx = 0;
		for(int i = 1; i < list.size(); i++) 
			if(list.get(i) > list.get(maxIndx))
				maxIndx = i;
		int maxNum = list.get(maxIndx);
		int count = 0;
		for(int i = 0; i < list.size(); i++) 
			if(list.get(i) == maxNum)
				count++;
		int[] maxVal = new int[count];
		int indx = 0;
		for(int i = 0; i < list.size(); i++)
			if(list.get(i) == maxNum) 
			{
				maxVal[indx] = i;
				indx++;
			}
		return maxVal;
	}
	
	/**
	 * Returns an array-of-String that contains the values from list in reverse order.
	 * For example, given list = ["Zuzu","Mildred","Taz","Dude"],
	 * the array ["eduD","zaT","derdliM","uzuZ"] will be returned.
	 * Note: the documentation for String can be found at
	 * https://docs.oracle.com/javase/8/docs/api/java/lang/String.html
	 * You may assume that list != null.
	 */
	public static String[] returnValsInReverseOrder(ArrayList<String> list) {
		String[] temp = new String[list.size()];
		for(int i = 0; i < temp.length; i++)
			temp[i] = "";
		String[] rev = new String[list.size()];
		int indx = 0;
		for(int i = list.size()-1; i >= 0; i--) 
		{
			for(int j = list.get(i).length()-1; j >= 0; j--) 
				temp[i] += list.get(i).charAt(j);
			rev[indx] = temp[i];
			indx++;
		}
		return rev;
	}
	
	/**
	 * Returns an ArrayList containing (in the same order) the positive values
	 * contained in arr.
	 * For example, if arr = [-1.1, 2.3, -5.8, 13.21, 34.55], then
	 * the ArrayList [2.3, 13.21, 34.55] will be returned.
	 * You may assume that arr != null.
	 */
	public static ArrayList<Double> returnListOfPositives(double[] arr) {
		ArrayList<Double> pos = new ArrayList<Double>();
		for(int i = 0; i < arr.length; i++)
			if(arr[i] >= 0)
				pos.add(arr[i]);
		return pos;
	}
	
	/**
	 * Returns an array-of-String that contains the values from list1 (in their current order)
	 * followed by the values from list2 (in their current order).
	 * You may assume that list1 != null and that list2 != null.
	 */
	public static String[] concatenate(ArrayList<String> list1, ArrayList<String> list2) {
		String[] comb = new String[list1.size()+list2.size()];
		int indx = 0;
		for(int i = 0; i < list1.size(); i++) 
		{
			comb[indx] = list1.get(i);
			indx++;
		}
		for(int i = 0; i < list2.size(); i++) 
		{
			comb[indx] = list2.get(i);
			indx++;
		}
		return comb;
	}
	
	/**
	 * Removes from list every Rectangle that has an area equal to 72.
	 * You may assume that list != null.
	 * Note: Rectangle's documentation can be found at
	 * https://docs.oracle.com/javase/8/docs/api/java/awt/Rectangle.html
	 */
	public static void removeRectanglesWithArea72(ArrayList<Rectangle> list) {
		for(int i = 0; i < list.size(); i++)
			if(list.get(i).height*list.get(i).width == 72)
				list.remove(i);
	}
	
	/**
	 * Changes each Point in arr so that it has been reflected in the y-axis.
	 * Example 1: the Point (3,7) will move to (-3,7).
	 * Example 2: the Point (-1,-3) will move to (1,-3).
	 * Example 3: the Point (0,5) will move to (0,5).
	 * You may assume that arr != null.
	 * Note: Point's documentation can be found at
	 * https://docs.oracle.com/javase/8/docs/api/java/awt/Point.html
	 */
	public static void reflectAllPointsInYAxis(Point[] arr) {
		for(int i = 0; i < arr.length; i++) 
			arr[i].setLocation(arr[i].getX()*-1, arr[i].getY());
	}
	
	/**
	 * Creates and returns an array-of-Point using (in their current order)
	 * the x-values from xVals and the y-values from yVals.
	 * For example, the Point in index 0 of the returned array will contain
	 * the value from cell 0 of xVals and the value from cell 0 of yVals.
	 * You may assume that xVals != null and that yVals != null.
	 * You may also assume that xVals.length == yVals.length.
	 */
	public static Point[] createAndReturnPoints(int[] xVals, int[] yVals) {
		Point[] points = new Point[xVals.length];
		for(int i = 0; i < points.length; i++)
			points[i] = new Point(xVals[i], yVals[i]);
		return points;
	}
	
	/**
	 * Creates and returns an array of boolean in which the value at a particular index will
	 * be true if the distance from the corresponding Point in list to the Point (0,0)
	 * is greater than radius (false otherwise).
	 * Example 1: if the Point at index 7 in list is (3,4) and radius is 2.0, then cell 7
	 * in the returned array will contain the value true: the distance from (3,4) to (0,0) 
	 * is 5.0, which is greater than 2.0.
	 * Example 2: if the Point at index 3 in list is (3,4) and radius is 6.0, then cell 3
	 * in the returned array will contain the value false: the distance from (3,4) to (0,0) 
	 * is 5.0, which is not greater than 6.0.
	 * You may assume that list != null.
	 */
	public static boolean[] outside(ArrayList<Point> list, double radius){
		boolean[] b = new boolean[list.size()];
		for(int i = 0; i < list.size(); i++) 
			if(Math.sqrt(list.get(i).getX()*list.get(i).getX() + list.get(i).getY()*list.get(i).getY()) > radius)
				b[i] = true;
		return b;
	}
	
	/**
	 * Rotates the values in arr one cell to the left. The value that is in the cell 
	 * with index 0 gets moved to the end of the array.
	 * Example: if arr = [1,2,3,4,5], then it will be changed to [2,3,4,5,1].
	 * You may assume that arr != null.
	 * You may also assume that the array referenced by arr contains at least two values.
	 */
	public static void rotateLeftOneCell(String[] arr) {
		String temp = arr[0];
		for(int i = 1; i < arr.length; i++) 
			arr[i-1] = arr[i];
		arr[arr.length-1] = temp;
	}

	/**
	 * Prints the contents in the 2d array 'arr' in tabular format, one row per line with one space between characters.
	 * Example: if arr = [['a', 'b', 'c'], ['d', 'e', 'f']] then it will output:
	 * 
	 * a b c
	 * d e f
	 * 
	 * in the console.
	 */
	public static void print2DArray(char[][] arr) {
        for(int i = 0; i < arr.length; i++) 
        {
        	for(int j = 0; j < arr[i].length; j++) 
        		System.out.print(arr[i][j] + " ");
        	System.out.println();
        }
	}

	/**
	 * Returns the maximum value in 2d array 'arr'.
	 * You may assume that 'arr' has at least one value at arr[0][0]. 
	 */
	public static double returnMaxValue(double[][] arr){
		double max = arr[0][0];
		for(int i = 0; i < arr.length; i++) 
			for(int j = 0; j < arr[i].length; j++) 
				if(arr[i][j] > max)
					max = arr[i][j];
		return max;
	}
}
