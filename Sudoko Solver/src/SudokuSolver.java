import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SudokuSolver {
	
	private int[][] numbers;
	private ArrayList<int[][]> numLog;
	
	public int[][] getNumbers()
	{
		return numbers;
	}
	
	public ArrayList<int[][]> getNumLog()
	{
		return numLog;
	}
	
	public SudokuSolver(String filePath) {
		numbers = new int[9][9];
		try 
		{
			Scanner sc = new Scanner(new File(filePath));
			
			int col = 0;
			int row = 0;
			while(col < numbers.length && row < numbers[col].length) 
			{
				String l = sc.nextLine();
				
				while(col < numbers.length) 
				{
					String nums[] = l.split(" ");
					int num = Integer.parseInt(nums[col]);
					numbers[col][row] = num;
					col++;
				}
				if(col == numbers.length) 
				{
					col = 0;
					row++;
				}
			}
			sc.close();
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
		numLog = new ArrayList<int[][]>();
		numLog.add(numbers);
	}
	
	public int[][] copyNum()
	{
		int[][] copy = new int[9][9];
		for(int i = 0; i < copy.length; i++) 
			for(int j = 0; j < copy[i].length; j++) 
				copy[i][j] = numbers[i][j];
		return copy;
	}
	
	public boolean solve(int row, int col) {
		//Base case
		if (row == numbers.length){
			row = 0;
			//prefix iteration
			if (++col == numbers[row].length)
				//Successfully completed board
				return true;
		}
		if (numbers[row][col] != 0)
			return solve(row+1,col);
		
		for (int k = 1; k <= numbers.length; k++)
			if (isPossibleDigit(k,row,col)) {
				numbers[row][col] = k;
				numLog.add(copyNum());
				if (solve(row+1,col) == true) {
					return true;
				}
		}
		numbers[row][col] = 0;
		numLog.add(copyNum());
		//Impossible board
		return false;
	}
	
	public boolean isPossibleDigit(int val, int row, int col) {
		return !isInRow(val, row) && !isInColumn(val, col) && !isInSquare(val, row, col);
	}
	
	public boolean isInRow(int val, int row) {
		for(int i = 0; i < numbers[row].length; i++) 
			if(val == numbers[row][i])
				return true;
		return false;
	}
	
	public boolean isInColumn(int val, int col) {
		for(int i = 0; i < numbers.length; i++) 
			if(val == numbers[i][col])
				return true;
		return false;
	}
	
	public boolean isInSquare(int val, int row, int col) {
		int[][] square = getSquare(row, col);
		
		for(int i = 0; i < square.length; i++) 
			for(int j = 0; j < square[i].length; j++) 
				if(val == square[i][j])
					return true;
		return false;
	}
	
	public int[][] getSquare(int row, int col) {
		int[][] square = new int[3][3];
		int startR = row/3 *3;
		int startC = col/3 *3;
			
		for(int i = 0; i < 3; i++) 
			for(int j = 0; j < 3; j++) 
				square[i][j] = numbers[startR+i][startC+j];
		return square;
	}
	
	public void showPuzzle() {
		int colCount = 0;
		int rowCount = 0;
		for(int i = 0; i < numbers.length; i++) 
		{
			for(int j = 0; j < numbers[i].length; j++) {
				if(colCount == 3 || colCount == 6)
					System.out.print(" ");
				System.out.print(numbers[i][j] + " ");
				colCount++;
			}
			colCount = 0;
			System.out.println();
			if(rowCount == 2 || rowCount == 5)
				System.out.println();
			rowCount++;
		}
	}

}



