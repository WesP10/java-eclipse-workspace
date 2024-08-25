import java.util.Scanner;

public class ProblemThree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.next();

		int count = 0;
		boolean single = true;
		for(int i = 0; i < 26; i++) {
			char current = word.charAt(i);
			for(int j = 0; j < word.length(); j++) {
				char c = word.charAt(j);
				if(c == current) {
					single = false;
				}
			}
			if(single)
				count++;
		}
		System.out.println(count);
	}

}
