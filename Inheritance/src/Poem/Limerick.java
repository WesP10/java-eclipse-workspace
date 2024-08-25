package Poem;

public class Limerick extends Poem{

	@Override
	public int getNumLines() {
		return 5;
	}

	@Override
	public int getNumSyllables(int k) {
		if(k == 3 || k == 4) return 6;
		return 9;
	}

}
