import java.util.ArrayList;

public class Scanner {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("dog");
		list.add("cat");
		list.add("hat");
		String[] test = returnValsInReverseOrder(list);
		System.out.println(test[0]);
		System.out.println(test[1]);
		System.out.println(test[2]);
}
	
	public static String[] returnValsInReverseOrder(ArrayList<String> list) {
		String[] temp = new String[list.size()];
		for(int i = 0; i < temp.length; i++)
			temp[i] = "";
		String[] rev = new String[list.size()];
		int indx = 0;
		for(int i = list.size()-1; i >= 0; i--) 
		{
			for(int j = list.get(i).length()-1; j >= 0; j--) 
				temp[i] += list.get(i).charAt(j);
			rev[indx] = temp[i];
			indx++;
		}
		return rev;
	}
	
}