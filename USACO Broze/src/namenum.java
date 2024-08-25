import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/*
 ID: Wes10
 LANG: JAVA
 TASK: namenum
 */

public class namenum {

	public static void main(String[] args) throws Exception {
		BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
		BufferedReader dict = new BufferedReader(new FileReader("dict.txt"));
		PrintWriter out = new PrintWriter(new File("namenum.out"));
		
		String code = f.readLine();
		ArrayList<String> letters = letters(code);
		ArrayList<String> names = genNames(letters, dict);
		if(names.size() == 0)
			out.println("NONE");
		for(String w : names)
			out.println(w);
		out.close();
	}
	
	private static ArrayList<String> genNames(ArrayList<String> temp, BufferedReader dict) throws Exception {
		ArrayList<String> names = new ArrayList<String>();
		String line;
        while ((line = dict.readLine()) != null) {
            boolean same = true;
            if (temp.size() == line.length()) {
                for (int i = 0; i < temp.size(); i++) {
                    if (temp.get(i).indexOf(line.charAt(i)) == -1) {
                        same = false;
                        break;
                    }
                }
                if (same)
                    names.add(line);
            }
        }
        return names;
	}

	private static ArrayList<String> letters(String code)
	{
		ArrayList<String> letters = new ArrayList<String>();
		for(int i = 0; i < code.length(); i++)
			for(int j = 0; j < 3; j++) {
				byte b = Byte.parseByte(""+code.charAt(i));
				byte indx = (byte)(3*b+91+j);
				if(indx > 112)
					indx++;
				 letters.add(""+(char)indx);
			}
		return letters;
	}
}
