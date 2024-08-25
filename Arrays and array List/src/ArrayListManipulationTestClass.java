import java.util.ArrayList;

public class ArrayListManipulationTestClass {
//main method
	public static void main(String[] args) {
		//ArrayList with one word stored to test combinisg lists
		ArrayList<String> moreWords = new ArrayList<String>();
		moreWords.add("more");
		//constructor for ArrayListManipulation
		ArrayListManipulation test = new ArrayListManipulation("ArrayList_test.txt");

		//prints out array and result for all 
		System.out.println("Words: " + test.getWords());
		System.out.print("Frankenstein: ");
		test.printTenWordsPerLine();
		System.out.println("Number of words: " + test.numWords());
		System.out.println("The Longest Word is: "+test.longestWord());
		System.out.println("The word keeping is at index: "+test.indexOfWord("keeping."));
		System.out.println("The word the appears "+test.countWord("the")+" times");
		System.out.println("The first word in alphabetical order is: "+test.max());
		System.out.println("The last word in alphabetical order is: "+test.min());
		System.out.println("All the words that start with c: "+test.startsWithLetter('c'));
		System.out.println("Words in alphabetical order"+test.alphabetize());
		System.out.println("Words 1 and 2 swapped, 2 and 3 swapped... "+test.swapWords());
		System.out.println("Frankenstein with moreWords at the end: "+test.combineLists(moreWords));
		System.out.println("ArrayList in opposite order: "+test.reverse());
	}

}
