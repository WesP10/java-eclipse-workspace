
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.util.ArrayList;
	import java.util.Scanner;
	public class IBeforeEMain {
	 public static void main(String[] args) throws FileNotFoundException {
	  ArrayList<String> words = new ArrayList<String>();
	  Scanner sc = new Scanner(new File("test2.txt"));
	  double followsRule = 0, noFollowsRule = 0;
	  while(sc.hasNext())
	   words.add(sc.next());
	  for(int i = 0; i < words.size(); i++) 
	  {
		  if(xei(words.get(i))) noFollowsRule++;
		  if(cei(words.get(i))) followsRule++;
		  if(xie(words.get(i))) followsRule++;
		  if(cie(words.get(i))) noFollowsRule++;
	  }
	  int percentFollows = (int)(followsRule/(followsRule+noFollowsRule)*100);
	  System.out.println("" + percentFollows + "% of words in the english dictionary follow the i before e rule");
	 }
	 
	 public static boolean xei(String word) 
	 {
		return word.contains("ei") && !word.contains("cei");
	 }
	 
	 public static boolean cei(String word) 
	 {
		 return word.contains("cei");
	 }
	 
	 public static boolean xie(String word) 
	 {
		 return word.contains("ie") && !word.contains("cie");
	 }
	 
	 public static boolean cie(String word) 
	 {
		 return word.contains("cie");
	 }
	 
	}
