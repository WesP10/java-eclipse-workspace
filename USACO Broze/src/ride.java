/*
ID: Wes10
LANG: JAVA
TASK: ride
PROG: ride
*/
import java.io.*;
import java.util.*;

class ride {
	public static void main (String [] args) throws IOException {
	    BufferedReader f = new BufferedReader(new FileReader("ride.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
	    String comet = f.readLine().trim().toUpperCase();
	    String group = f.readLine().trim().toUpperCase();
	    int c = prod(comet);
	    int g = prod(group);
	    if(c%47 == g%47)
	    	out.println("GO");
	    else
	    	out.println("STAY");
	    out.close();
	  }
	private static int prod(String s) {
		int prod = (byte)s.charAt(0)-64;
		for (int i = 1; i < s.length(); i++) {
			prod *= (byte) s.charAt(i) - 64;
		}
		return prod;
	}
}
