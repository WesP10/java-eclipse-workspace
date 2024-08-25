import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class HashingExamples {

	public static void main(String[] args) {
		Integer x = 69;
		System.out.println(x.hashCode());

		Character c = 'o'; //ASCII value
		System.out.println(c.hashCode());
		
		String s = "C";
		System.out.println(s.hashCode());
		
		String A = "D";
		System.out.println(A.hashCode());
		
		String one = "DDB";
		String two = "DCa";
		System.out.println(one.hashCode());
		System.out.println(two.hashCode());
		
		//Hashset - a collection of iteams, unordered, no duplicates
		
		HashSet<String> hs = new HashSet<String>();
		hs.add("Cat");
		if(hs.contains("Cat"))
			System.out.println("Boom");
		System.out.println(hs.remove("Cat"));
		System.out.println(hs.remove("Cat"));
		
		String letters = "a b c d e f g h i j k l m n o p q r s t u v w x y z";
		for(String letter:letters.split(" "))
			hs.add(letter);
		System.out.println("Unique letters: " + hs.size());
		
		//Iterator
		Iterator<String> iter = hs.iterator();
		while(iter.hasNext())
			System.out.println(iter.next());
		
		//Hashmap
		String sen = "Ella is stupid and should put her work back in shared doc";
		String[] words = sen.split(" ");
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		for(String word : words) 
		{
			word = word.trim().toLowerCase();
			for(int i = 0; i < word.length(); i++) 
			{
				String letter = word.substring(i, i+1);
				if(!hm.containsKey(letter))
					hm.put(letter, 1);
				else 
				{
					Integer freq = hm.get(letter);
					hm.put(letter, freq+1);
				}
			}
		}
		
		Iterator<String> keyI = hm.keySet().iterator();
		Iterator<Integer> valI = hm.values().iterator();
		while(keyI.hasNext())
			System.out.println(keyI.next() + ": " + valI.next());
	}
	
}
