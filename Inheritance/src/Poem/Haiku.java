package Poem;

public class Haiku extends Poem{

	@Override
	public int getNumLines() {
		return 3;
	}

	@Override
	public int getNumSyllables(int k) {
		if(k == 2) return 7;
		return 5;
	}
	
	
}
