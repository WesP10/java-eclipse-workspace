
/*
ID: Wes10
LANG: JAVA
TASK: test
*/
import java.io.*;
import java.util.*;

class test {
  public static void main (String [] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("test.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
    StringTokenizer st = new StringTokenizer(f.readLine());
    int i1 = Integer.parseInt(st.nextToken());    // first integer
    int i2 = Integer.parseInt(st.nextToken());    // second integer
    out.println(i1+i2);                           // output result
    out.close();                                  // close the output file
  }
}