
public class BoxersAndSuch {

	public static void main(String[] args) {
		//Boxing
		float d1 = 3.0f;
		System.out.println(d1);
		//Auto Boxing
		Double d2 = 2.0;
		System.out.println(d2);
		//primative
		double d3 = 2.5;
		System.out.println(d3);
		//Wrappers can be null - nullable
//		boolean b =null; //Doesn't work
		Boolean bool = null;
		System.out.println(bool);
		
		for(int i = 0; i < 15; i++)
			System.out.println(Integer.toBinaryString(i));
		
		//overflow error - if you run out of bits to store a value
		int x = Integer.MAX_VALUE;
		System.out.println(Integer.toBinaryString(x) + " Length is: " + Integer.toBinaryString(x).length());
		x++;
		System.out.println(Integer.toBinaryString(x));
		
		long x2 = (long)(1500000000);
		x2*=2;
		System.out.println(x2);
		
		Integer i = 3;
		Integer k = i;
		i = 4;
		System.out.println(k);

		Integer a = 5;
		int b = 10;
		if(a.intValue() == b)
			System.out.println("a = b");
		if(a > b)
			System.out.println("A is greater than B");
		else
			System.out.println("B is greater than A");
		
		Double d4 = 3.0;
		Double d5 = 4.0;
		double max = Double.max(3.0, 4.0);
		if(d4.compareTo(d5) < 0)
			System.out.println("d4 is less than d5");
		else if(d4.compareTo(d5) == 0)
			System.out.println("d4 = d5");
		else if(d4.compareTo(d5) > 0)
			System.out.println("d4 > d5");
		
		//^Chapter 5 in Barrons
	}

}
