import java.util.ArrayList;
import java.util.Collections;

/**
 * A class used to represent the state of a solitaire board.
 * @Weston 
 *
 */
public class SolitaireBoard {

	private ArrayList<Card> allCards;
	private ArrayList<Card> deck;
	private ArrayList<Card> discard;	
	private ArrayList<ArrayList<Card>> topPiles;
	private ArrayList<ArrayList<Card>> bottomPiles;
	
	public final int NUM_BOTTOM_PILES = 7;
	public final int NUM_TOP_PILES = 4;
	
	/**
	 * The constructor initializes a new deck of cards, shuffles them, and deals the board. It
	 * also initializes all the ArrayLists used to represent the piles of cards.
	 */
	public SolitaireBoard()
	{
		allCards = new ArrayList<Card>();
		allCards = getNewDeck();
		deck = new ArrayList<Card>(allCards);
		discard = new ArrayList<Card>();
		
		topPiles = new ArrayList<ArrayList<Card>>();
		for(int i = 0; i < NUM_TOP_PILES; i++)
			topPiles.add(new ArrayList<Card>());
		bottomPiles = new ArrayList<ArrayList<Card>>();
		for(int i = 0; i < NUM_BOTTOM_PILES; i++)
			bottomPiles.add(new ArrayList<Card>());
		shuffle();
		dealBoard();
	}
	
	/**
	 * Get all the cards on the board, regardless of pile.
	 * @return
	 */
	public ArrayList<Card> getAllCards() {
		return allCards;
	}

	/**
	 * Return the deck pile.
	 * @return
	 */
	public ArrayList<Card> getDeck() {
		return deck;
	}

	/**
	 * Return the discard pile.
	 * @return
	 */
	public ArrayList<Card> getDiscard() {
		return discard;
	}

	/**
	 * Return the top four piles.
	 * @return
	 */
	public ArrayList<ArrayList<Card>> getTopPiles() {
		return topPiles;
	}

	/**
	 * Return the bottom seven piles.
	 * @return
	 */
	public ArrayList<ArrayList<Card>> getBottomPiles() {
		return bottomPiles;
	}

	/**
	 * Construct a new deck of cards. The cards in the deck should have a suit of "H", "S", "D"
	 * or "C", for hearts, spades, diamonds and clubs, respectively, and a rank of 1 - 13. A rank
	 * of 1 will correspond to an Ace, 11 to a Jack, 12 to a Queen, and 13 to a King.
	 * @return an ArrayList of Card with all 52 cards. No particular order is necessary.
	 */
	public ArrayList<Card> getNewDeck(){
		Card.NUM_CARDS = 0; //keep this line of code (used for resetting the game)
		ArrayList<Card> cards = new ArrayList<Card>(52);
		//nested for loops adds 13 cards for each of the 4 suits
		for(int i = 0; i < 4; i++) 
		{
			for(int j = 1; j <= 13; j++) 
			{
				if(i == 0) 
					cards.add(new Card("H", j));
				else if(i == 1) 
					cards.add(new Card("S", j));
				else if(i == 2) 
					cards.add(new Card("D", j));
				else if(i == 3) 
					cards.add(new Card("C", j));
			}
		}
		return cards;
	}
	
	/**
	 * This method should shuffle the deck of cards randomly. You can do this however you like,
	 * but a suggested algorithm is to pick a random card in the deck and move it to the end of
	 * the deck. Then repeat this a number of times until the deck is adequately shuffled.
	 */
	public void shuffle() {
		//selects random card and swaps it with card at 1st slot, then second slot, third...
		int r = (int)(Math.random()*51)+1;
		for (int i = deck.size() - 1; i >= 0; i--) {
            // swapping current index value
            // with random index value
            Collections.swap(deck, i, r);
            r = (int)(Math.random()*51)+1;
        }
	}
	
	/**
	 * Deal the initial board. A solitaire board has 7 piles from left to right. The leftmost 
	 * pile has 1 card, the next pile to the right has 2 cards, the next 3 cards, and so on.
	 * The 7th pile has 7 cards. The top card in each pile is dealt face up. For our ArrayList
	 * representing a pile, the bottom card in the pile will be the first card in the ArrayList
	 * and the top card will be the last card in the ArrayList. This method should use the
	 * dealTopCard() method to get the top card from the deck and add it to the appropriate pile.
	 */
	public void dealBoard() {
		//nested for loops intializes bottom piles and sets last card of each bottom pile to showing
		for(int i = 0; i < NUM_BOTTOM_PILES; i++) 
		{
			for(int j = 0; j <= i; j++) 
				bottomPiles.get(i).add(dealTopCard());
			bottomPiles.get(i).get(bottomPiles.get(i).size()-1).setFaceUp(true);
		}
	}
	
	/**
	 * Remove and return the top (last) card from the deck. If the deck is empty, return null.
	 * @return the top Card, or null if the deck is empty.
	 */
	public Card dealTopCard() {
		if(deck == null)
			return null;
		else
			//removes the last element of deck and returns it
			return deck.remove(deck.size()-1);
	}
	
	/**
	 * Flip 'numToFlip' cards from deck to discard. Use the dealTopCard() method. The cards 
	 * that flip should be added to the discard pile and turned face up. The cards should flip
	 * one at a time so that the order in the piles is reversed. For example, if the deck is
	 * [1C, 2C, 3C] and the discard is empty, then flip(2) will result in the deck being [1C] and
	 * the discard being [3C, 2C].
	 * @param numToFlip
	 */
	public void flip(int numToFlip) {
		//checks if null
		if(numToFlip <= 0)
			return;
		//checks if there are enough cards
		if(numToFlip > deck.size())
			numToFlip = deck.size();
		//removes and adds cards from deck to discard
		for(int i = 0; i < numToFlip; i++) 
		{
			deck.get(deck.size()-1).setFaceUp(true);
			discard.add(dealTopCard());
		}
	}
	
	/**
	 * Called when the deck runs out (deck is empty), move all the cards from the discard pile
	 * back into the deck. When this method finishes, the discard pile should be empty. The cards
	 * that were face up in the discard pile should now be face down in the deck. The top card
	 * of the discard pile should be the bottom card of the deck, and the bottom card of the
	 * discard should become the top card of the deck.
	 */
	public void moveDiscardBackToDeck()
	{
		//iteraates through discard pile and adds them to deck
		for(int i = 0; i < discard.size(); i++) 
		{
			discard.get(i).setFaceUp(false);
			deck.add(discard.remove(i));
		}
	}
	
	/**
	 * This method takes a Card and two ArrayList of Cards representing the source and destination
	 * piles. The method attempts to move the card from the source pile to the destination pile.
	 * If a move is valid, it is made and the method returns true. If a move is not valid, the
	 * method returns false. 
	 * 
	 * If any of the arguments are null, the method should return false.
	 * 
	 * There are a few valid moves in solitaire and I will list the valid moves here:
	 * 
	 * 1. Move the top card of the discard to a top pile. 
	 * If the top destination pile is empty, then the only valid move is moving an Ace. If the
	 * top destination pile is not empty, then you must place a card that is matching in 
	 * suit (hearts, spades, diamonds or clubs) and is one rank higher. For example, a 5 of 
	 * hearts could be placed onto a 4 of hearts, or an Ace of diamonds could be placed onto an
	 * empty pile.
	 * 
	 * 2. Move the top card of the discard to a bottom pile. 
	 * If the bottom destination pile is empty, then the only valid move is moving a King. If the
	 * bottom destination pile is not empty, then you muse place a card that is opposite in color
	 * (black on red or red on black) and is one rank lower. For example, a 5 of hearts could be
	 * placed onto a 6 of clubs or a 6 of spades. A King of Spades could be placed onto an empty
	 * pile.
	 * 
	 * 3. Move the top card of a bottom pile to a top pile.
	 * The same rules apply as case 1. The difference here is that if the new top card of the 
	 * bottom pile is face down, it should flip to face up.

	 * 4. Move some number of face up cards from one bottom pile to another bottom pile.
	 * The same rules apply as case 2. The difference here is that the card you are moving does
	 * not have to be the top card of a bottom pile. But if the card you are moving is not the
	 * top card, it still must be face up and all the cards on top of it should also move to the
	 * destination pile. If the new top card of the source pile is face down, it should flip to
	 * face up. 
	 * 
	 * 5. You do not need to consider the case of moving from the deck to the discard, as this 
	 * move is handled in the flip() method in this class. 
	 * 
	 * If you want to call helper methods to deal with the different cases, then you may do so.
	 * I suggest writing a method in the Card class that sees if one Card can move onto another
	 * Card and calling that method from this method, but you may do this however you want.
	 * 
	 * @param c - card to move
	 * @param sourcePile
	 * @param destinationPile
	 * @return true if the card successfully moved from the source pile to the destination pile
	 */
	public boolean movePiles(Card c, ArrayList<Card> sourcePile, ArrayList<Card> destinationPile)
	{
		//checks if piles are null
		if(c == null || sourcePile == null || destinationPile == null)
			return false;
		
		String source = "ZZ";
		String dest = "ZZ";
		
		if(sourcePile.equals(discard))
			source = "D";
		if(destinationPile.equals(discard))
			dest = "D";
		for(int i = 0; i < NUM_BOTTOM_PILES; i++) 
		{
			if(sourcePile.equals(bottomPiles.get(i)))
				source = "B";
			else if(destinationPile.equals(bottomPiles.get(i)))
				dest = "B";
		}
		for(int i = 0; i < NUM_TOP_PILES; i++) 
		{
			if(destinationPile.equals(topPiles.get(i)))
				dest = "T";
		}
		
		if(source.equals("D") && dest.equals("T") && destinationPile.size() > 0 && c.canMoveTcard(destinationPile.get(destinationPile.size()-1))
		|| source.equals("D") && dest.equals("T") && destinationPile.size() == 0 && c.canMoveTempty()
		|| source.equals("D") && dest.equals("B") && destinationPile.size() > 0 && c.canMoveBcard(destinationPile.get(destinationPile.size()-1))
		|| source.equals("D") && dest.equals("B") && destinationPile.size() == 0 && c.canMoveBempty()) 
		{
			destinationPile.add(c);
			boolean b = sourcePile.remove(c);
			if(sourcePile.size() > 0)
				sourcePile.get(sourcePile.size()-1).setFaceUp(true);
			System.out.println(source + dest);
			return b;
		}
		else if(source.equals("B") && dest.equals("T") && destinationPile.size() > 0 && c.canMoveTcard(destinationPile.get(destinationPile.size()-1))
			|| source.equals("B") && dest.equals("T") && destinationPile.size() == 0 && c.canMoveTempty()
			|| source.equals("B") && dest.equals("B") && destinationPile.size() > 0 && c.canMoveBcard(destinationPile.get(destinationPile.size()-1))
			|| source.equals("B") && dest.equals("B") && destinationPile.size() == 0) 
		{
			int indx = sourcePile.indexOf(c);
			ArrayList<Card> faceUp = new ArrayList<Card>();
			for(int i = indx; i < sourcePile.size(); i++) 
				faceUp.add(sourcePile.remove(indx));
			if(sourcePile.size() > 0)
				sourcePile.get(sourcePile.size()-1).setFaceUp(true);
			System.out.println(source + dest);
			return destinationPile.addAll(faceUp);
		}
		return false;
	}
	
	/**
	 * Check if the board is a winning position. A winning position is when all the cards
	 * are in the top 4 piles. 
	 * OPTIONAL: A game can be considered winning if all the cards are in the top or bottom piles
	 * (none in the discard or deck) and they are all revealed (face up).
	 * @return
	 */
	public boolean checkWinner()
	{
		ArrayList<ArrayList<Card>> win = genWin();
		int count = 0;
		
		for(int i = 0; i < NUM_TOP_PILES; i++)
		{
			for(int j = 0; j < topPiles.size(); j++) 
			{
				for(int k = 0; k < win.size(); k++) 
				{
					if(topPiles.get(i).equals(win.get(k)))
						count++;
				}
			}
		}
		return count == 4;
	}
	
	public ArrayList<ArrayList<Card>> genWin()
	{
		ArrayList<ArrayList<Card>> win = new ArrayList<ArrayList<Card>>(4);
		ArrayList<Card> hearts = new ArrayList<Card>(16);
		ArrayList<Card> spades = new ArrayList<Card>(16);
		ArrayList<Card> diamonds = new ArrayList<Card>(16);
		ArrayList<Card> clubs = new ArrayList<Card>(16);
		win.add(hearts);
		win.add(spades);
		win.add(diamonds);
		win.add(clubs);
		
		ArrayList<String> suitIndx = new ArrayList<String>(4);
		suitIndx.add("H");
		suitIndx.add("S");
		suitIndx.add("D");
		suitIndx.add("C");
		for(int i = 0; i < 4; i++) 
		{
			for(int j = 0; j < 16; j++) 
			{
				win.get(i).add(new Card(suitIndx.get(i), j));
			}
		}
		
		return win;
	}
}
