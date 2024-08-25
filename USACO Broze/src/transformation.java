import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/*
 ID: Wes10
 LANG: JAVA
 TASK: transform
 */

class transform {

	public static void main(String[] args) throws Exception {
		BufferedReader f = new BufferedReader(new FileReader("transform.in"));
		PrintWriter out = new PrintWriter(new File("transform.out"));
		
		int n = Integer.parseInt(f.readLine());
		char[] board = board(n, f);
		char[] output = board(n, f);
		
		char[] turn90 = turn90(board, n);
		char[] turn180 = turn180(board, n);
		char[] turn270 = turn270(board, n);
		char[] horiz = horiz(board, n);
		
		int pattern = findPattern(board, turn90, turn180, turn270, horiz, output, n);
//		System.out.println(pattern);
		out.println(pattern);
		out.close();
	}

	private static int findPattern(char[] board, char[] turn90, char[] turn180,
			char[] turn270, char[] horiz,char[] output,int n) {
		if(equals(turn90, output))
			return 1;
		if(equals(turn180, output))
			return 2;
		if(equals(turn270, output))
			return 3;
		if(equals(horiz, output))
			return 4;
		ArrayList<char[]> afterHor = new ArrayList<char[]>();
		afterHor.add(turn90(horiz, n));
		afterHor.add(turn180(horiz, n));
		afterHor.add(turn270(horiz, n));
		for(int i = 0; i < afterHor.size(); i++)
			if(equals(afterHor.get(i), output))
				return 5;
		if(equals(board, output))
			return 6;
		return 7;
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
	
	private static void print(char[] board, int n)
	{
		for(int i = 0; i < board.length; i++) {
			if(i%n == 0)
				System.out.println();
			System.out.print(board[i]);
		}
		System.out.println();
	}
	
	private static char[] horiz(char[] board, int n) {
		char[] out = new char[n*n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int indx = j + i*n;
				int newIndx = n-(1+j) + i*n;
				out[indx] = board[newIndx];
			}
		}
		return out;
	}

	private static char[] turn180(char[] board, int n) {
		return turn90(turn90(board, n), n);
	}

	private static char[] turn90(char[] board, int n) {
		char[] out = new char[n*n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int indx = j + i*n;
				int newIndx = (n-(1+i))+j*n;
				out[newIndx] = board[indx];
			}
		}
		return out;
	}

	private static char[] turn270(char[] board, int n) {
		char[] out = new char[n*n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int indx = j + i*n;
				int newIndx = (n-(1+i))+j*n;
				out[indx] = board[newIndx];
			}
		}
		return out;
	}
	
	private static char[] board(int n, BufferedReader f) throws Exception 
	{
		char[] board = new char[n*n];
		int indx = 0;
		while(indx < board.length) {
			char[] line = f.readLine().toCharArray();
			for(int i = 0; i < line.length; i++) {
				board[indx] = line[i];
				indx++;
			}
		}
		return board;
	}
}
