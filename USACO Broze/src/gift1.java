/*
ID: Wes10
LANG: JAVA
TASK: gift1
PROG: gift1
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
public class gift1 {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
	    HashMap<String, Integer> dic = new LinkedHashMap<String, Integer>();
	    int iLim = (int) Double.parseDouble(f.readLine());
	    boolean zero = false;
	    int rem = 0;
	    int gift = 0;
	    for(int i = 0; i < iLim; i++)
	    	dic.put(f.readLine(), 0);
	    for(int i = 0; i < iLim; i++) {
	    	zero = false;
	    	String name = f.readLine();
	    	String[] num = f.readLine().split(" ");
	    	int money = Integer.parseInt(num[0]);
	    	int shared = Integer.parseInt(num[1]);
	    	if(money == 0 || shared == 0) zero = true;
	    	if(!zero) {
	    		gift = money/shared;
	    		rem = money%shared;
	    	}
	    	else 
	    	{
	    		gift = 0;
	    		rem = 0;
	    	}
	    	int remSub = rem;
	    	dic.computeIfPresent(name, (k, v)-> v-money+remSub);
	    	for(int j = 0; j < shared; j++) {
	    		String recip = f.readLine();
	    		int giftSub = gift;
	    		dic.computeIfPresent(recip, (k,v)-> v+giftSub);
	    	}
	    }
	    for (String key : dic.keySet()) {
	        String fin = key + " " + dic.get(key);
	        //System.out.println(fin);
	        out.println(fin);
	    }
	    out.close();
	}
}
