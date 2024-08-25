import java.util.ArrayList;
import java.util.Scanner;

public class ProblemTwo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] NT = sc.next().split(" ");
		ArrayList<Integer> nums = new ArrayList<Integer>();
		int n = Integer.parseInt(NT[0]);
		int t = Integer.parseInt(NT[1]);
		for(int i = 1; i <= n; i++)
			nums.add(Integer.parseInt(sc.next()));
		System.out.println(findNum(nums, t));
			
	}

	private static int findNum(ArrayList<Integer> nums, int t) {
		for(int i = 0; i < nums.size(); i++)
			if(nums.get(i) == t)
				return i;
		return -1;
	}
}
