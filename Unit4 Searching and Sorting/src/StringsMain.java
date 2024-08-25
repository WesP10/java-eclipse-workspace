
public class StringsMain {

	public static void main(String[] args) {
		// Strings are immutable - can't be modified once they are created
		String s1 = "Hello";
		s1 += ""; //this is creating a new string and then cancatinating it
		System.out.println(s1);
		
		String s2 = new String("Hello");
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		
		String s3 = "hello";
		String s4 = "hello";
		System.out.println(s3 == s4);
		
		String s5 = new String(new char[] {'h', 'e', 'l', 'l', 'o'});
		char[] c1 = s5.toCharArray();
		
		//greater than 0 'a' comes after 'B' lexographically
		//less than 0 'a' comes before 'b'
		System.out.println("a".compareTo("B"));
	}

	public static boolean isPalindrome(String s) 
	{
		for(int i = 0; i < s.length()/2; i++) 
		{
			String letter = s.substring(i, i+1);
			String last = s.substring(s.length()-1-i, s.length()-i);
			if(!letter.equals(last))
				return false;
		}
		return true;
	}
	
	public static boolean isPalidrome2(String s) 
	{
		String firstHalf = s.substring(0, s.length()/2-1);
		char[] fh = firstHalf.toCharArray();
		String rfh = "";
		for(int i = 0; i < fh.length; i++)
			rfh += fh[fh.length-1-i];
//		return s.contains(rfh); //Doesn't work on all cases
		int p = s.lastIndexOf(rfh);
		if(p != -1 && (p == s.length()/2 || p == s.length()/2+1)) //needs testing
			return true;
		return false;
	}
	
}
