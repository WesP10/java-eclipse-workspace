
public class test {

	public static void main(String[] args) 
	{
		int[][] matA = new int[3][3];
		matA[0][0] = 2;
		matA[1][1] = 5;
		matA[2][2] = 4;
		int[][] matB = new int[3][3];
		matB[0][0] = -1;
		matB[1][1] = 3;
		matB[2][2] = 2;
		int[][] matC = new int[2][3];
		matC[0][0] = -1;
		matC[0][1] = 2;
		matC[0][2] = 3;
		matC[1][0] = 5;
		matC[1][1] = 4;
		matC[1][2] = 6;
		int[][] matE = expandMatrix(matC);
		print2DArray(matE);
		System.out.println(diagonalOp(matA, matB));
	}
	
	public static int[][] expandMatrix(int[][] matA)
	{
		int[][] matE = new int[matA.length*2][matA[0].length*2];
		for(int i = 0; i < matE.length; i+=2) 
		{
			for(int j = 0; j < matE[i].length; j++) 
			{
				System.out.println("i: " + i + "j: " + j);
				matE[i][j] = matA[i/2][j/matA.length];
				matE[i+1][j] = matA[i/2][j/matA.length];
			}
		}
		return matE;
	}
	
	public static int diagonalOp(int[][] matA, int[][]matB)
	{
		int sum = 0;
		for(int i = 0; i < matA.length; i++) 
			sum += matA[i][i]*matB[i][i];
		return sum;
	}
	
	public static void print2DArray(int[][] e) 
	{
		for(int[] row : e)
		{
			for(int x : row) 
				System.out.print(x + " ");
			System.out.println();
		}
	}
}
