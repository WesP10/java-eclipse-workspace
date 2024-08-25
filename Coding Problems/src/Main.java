import java.io.*;

public class Main {
	public static String reversedMessage(String message, int k) {
		String w = "";
		for(int i = message.length()-1, j = 0; j < k; i--, j++) 
		{
			w+=message.charAt(i);
		}
		return message.substring(0, message.length()-k)+w;
	}

	// Do not modify below this line
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.valueOf(reader.readLine());
		
		for (int i = 0; i < t; i++) {
			String input = reader.readLine();
			String str = input.split(" ")[0];
			int k = Integer.valueOf(input.split(" ")[1]);
			String output = reversedMessage(str, k);
			System.out.println(output);
		}
	}
}
