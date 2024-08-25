import java.util.Scanner;

public class ProblemFour {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] nk = sc.next().split(" ");
		int n = Integer.parseInt(nk[0]);
		int k = Integer.parseInt(nk[1]);
		int sum = 0;
		int[] nums = new int[n];
		for(int i = 1; i <= n; i++)
			nums[n] = Integer.parseInt(sc.next());
		
		for(int i = 0; i < k; k++) {
			String[] ot = sc.next().split(" ");
			int start = Integer.parseInt(ot[0]);
			int end = Integer.parseInt(ot[1]);
			for(int j = start; j < end; j++)
				sum+= nums[j];
		}
		System.out.println(sum);
	}

}
