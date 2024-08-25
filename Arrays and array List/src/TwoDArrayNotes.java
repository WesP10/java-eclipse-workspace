
public class TwoDArrayNotes {

	public static void main(String[] args) {
		int numRows = 3;
		int numCols = 4;
		int[][] matrix = new int[numRows][numCols];
		matrix[0][0] = 5;
		matrix[2][3] = 8;
		matrix[0][matrix[0].length-1] = 4;
		randomizeValues(matrix, 0, 10);
		print2DArray(matrix);
		sumCol(matrix);
		//matrix.length -> num of rows
		//matrix[0].length -> num colums
		
		//jagged array
		int[][] jag = new int[10][];
		for(int i = 0; i < jag.length; i++) 
			jag[i] = new int[10-i];
		randomizeValues(jag, 0, 10);
		print2DArray(jag);
		sumCol(jag);
		
		boolean[][] pins = new boolean[4][];
		for(int i = 0; i < pins.length; i++)
			pins[i] = new boolean[i+1];
	}

	public static void print2DArray(int[][] e) 
	{
		//for eachloop with 2D arrays can only acces, not modify
		for(int[] row : e)
		{
			for(int x : row) 
				System.out.print(x + " ");
			System.out.println();
		}
	}
	
	public static void randomizeValues(int[][] e, int low, int high) 
	{
		for(int i = 0; i < e.length; i++) 
			for(int j = 0; j < e[i].length; j++) 
			{
				//value between [low, high]
				e[i][j] = (int) (Math.random()*(high-low+1)+low);
			}
	}
	
	public static void sumCol(int[][] e) 
	{
		//assumes rectangular matrix
		for(int i = 0; i < e[0].length; i++) 
		{
			int sum = 0;
			for(int j = 0; j < e.length; j++) 
			{
				sum+= e[j][i];
			}
			System.out.println("For column " + i + " the sum is " + sum);
		}
	}
}
