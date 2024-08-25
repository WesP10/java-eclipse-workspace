import java.util.ArrayList;

/**
 * A Card class to represent a playing card.
 * @Weston
 *
 */
public class Card {

	private String suit;
	private int rank;
	private boolean faceUp;
	private int color;
	
	public final int BLACK = 0;
	public final int RED = 1;
	
	public static int NUM_CARDS = 0;
	private int id;
	
	/**
	 * Create a new card. Set the suit and the rank based on the parameters. Set the color
	 * to RED or BLACK based on the suit. "H" or "D" (hearts or diamonds) are red, "S" or "C" 
	 * (spades or clubs) are black. All cards should be face down by default (faceUp = false).
	 * @param suit
	 * @param rank
	 */
	public Card(String suit, int rank) {
		id = NUM_CARDS; //keep this line of code (id is required for the processing class)
		NUM_CARDS += 1; //keep this line as well
		this.suit = suit;
		this.rank = rank;
		if(suit.equals("H") || suit.equals("D"))
			color = 1;
		else
			color = 0;
	}

	/**
	 * Getter for the card id. Used to search for the card in the deck more easily.
	 * @return
	 */
	public int getID() {
		return id;
	}

	/**
	 * Return true if the card is face up, false otherwise.
	 * @return
	 */
	public boolean isFaceUp() {
		return faceUp;
	}
	

	/**
	 * //TODO: Add any other helper methods for implementing the 
	 * rules of solitaire. This can include getters and setters for
	 * the fields, helper methods to compare if cards can be stacked, etc.
	 */
	
	//auto generated setter for if the card is showing
	public void setFaceUp(boolean faceUp) {
		this.faceUp = faceUp;
	}

	/**
	 * Two cards are equal if they have the same suit and same rank.
	 */
	public boolean equals(Object o)
	{
		//checks if object o is a card and then compares 
		if (o == null) return false;
		if (o.getClass() != this.getClass()) return false;

		Card x = (Card) o;
		return (this.suit.equals(x.suit) && this.rank == x.rank);
	}
	
	/**
	 * Return the two-character string representing the card. The string is the rank followed
	 * by the suit. If the rank is 1, use "A" for ace, 11, use "J" for jack, 12, use "Q" for
	 * queen, 13, use "K" for king. For 2, 3, ... 10, use "2", "3", ... "10". For example, the 
	 * 10 of spades card would return the string 10S. The Ace of Hearts would return the string
	 * AH.
	 * @return 
	 */
	public String toString()
	{
		ArrayList indx = generateIndx();
		//adds letter/number indicating rank
		String s = "" + indx.get(rank-1);
		//adds letter indicating suit
		s += suit;
		return s;
	}
	
	//generates index for rank
	public ArrayList generateIndx() 
	{
		ArrayList indx = new ArrayList<>();
		indx.add("A");
		for(int i = 2; i <= 10; i++)
			indx.add(i);
		indx.add("J");
		indx.add("Q");
		indx.add("K");
		return indx;
	}
	
	//methods to check if the the card can be moved to specified space
	public boolean canMoveBempty() 
	{
		return(this.rank == 13);
	}
	
	public boolean canMoveBcard(Card e) 
	{
		return(this.color != e.color && this.rank+1 == e.rank);
	}
	
	public boolean canMoveTempty() 
	{
		return(this.rank == 1);
	}
	
	public boolean canMoveTcard(Card e) 
	{
		return(this.suit.equals(e.suit) && this.rank-1 == e.rank);
	}
}
