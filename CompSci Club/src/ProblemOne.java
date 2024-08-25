import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class ProblemOne {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int sides = Integer.parseInt(sc.next());
		String shape = "";
		if(sides == 3)
			shape = "triangle";
		if(sides == 4)
			shape = "square";
		if(sides == 5)
			shape = "pentagon";
		if(sides == 6)
			shape = "hexagon";
		if(sides == 7)
			shape = "heptagon";
		if(sides == 8)
			shape = "octagon";
		if(sides == 9)
			shape = "nonagon";
		if(sides == 10)
			shape = "decagon";
		System.out.println(shape);
	}

}
