import java.util.ArrayList;

public class SeeItSayIt {

	public static void main(String[] args) {
		String s = "012";
		int n = 10;
		for(int i = 0; i < n; i++) 
		{
			System.out.println(s);
			ArrayList<String> p = see(s);
			s = "";
			for(int j = 0; j < p.size(); j++) 
			{
				s += say(p.get(j));
			}
		}
	}

	/**
	 * 
	 * @param num - "1" or "555"
	 * @return - String we would say "1" -> "11" or "555" -> "35"
	 */
	private static String say(String num) 
	{
		return "" + num.length() + num.charAt(0);
	}
	
	/**
	 * 
	 * @param num - "3110" -> [3, 11, 0]
	 * @return
	 */
	private static ArrayList<String> see(String num)
	{
		if(num.length() < 1)
			return null;
		ArrayList<String> nums = new ArrayList<String>();
		String lastNum = num.substring(0, 1);
		for(int i = 1; i < num.length(); i++) 
		{
			if(lastNum.equals(num.substring(i, i+1)))
			{
				if(i != num.length()-1)
					lastNum += num.substring(i, i+1);
				else 
				{
					lastNum += num.substring(i, i+1);
					nums.add(lastNum);
				}
					
			}
			else 
			{
				nums.add(lastNum);
				if(i != num.length()-1)
					lastNum = "" + num.substring(i, i+1);
				else
					lastNum = "";
			}
		}
		return nums;
	}
}
