/**
 * 
 * A class representing a Spades game.
 */
public class Game {

	public Deck deck;
	public Player bot1;
	public Player bot2;
	public Player bot3;
	public Player human;
	public LinkedList order;

	/**
	 * 
	 * Constructor for the Game class. Initializes the deck and player objects.
	 */
	public Game() {
		this.deck = new Deck();
		this.bot1 = new Bot("Bot1");
		this.bot2 = new Bot("Bot2");
		this.bot3 = new Bot("Bot3");
		this.human = new Human("User");
	}

	/**
	 * 
	 * Method to run the Spades game.
	 */
	public void run() {
 
	}

	/**
	 * 
	 * Method to determine the winning card from a set of four cards.
	 * 
	 * @param a the first card
	 * @param b the second card
	 * @param c the third card
	 * @param d the fourth card
	 * @return the winning card
	 */
	public Card winnerCard(Card a, Card b, Card c, Card d) {
 
		return a;
	}

	/**
	 * 
	 * Method to set the trick count for the winner of a hand.
	 * 
	 * @param winnerCard the card played by the winning player
	 */
	public void setWinnersTrick(Card winnerCard) {
 
	}

	/**
	 * 
	 * Method to determine the order of play for the next hand, given the winner of
	 * the previous hand.
	 * 
	 * @param winner the player who won the previous hand
	 * @return a linked list indicating the order of play for the next hand
	 */
	public LinkedList orderOfHand(Player winner) {
 
		return null;
	}

	/**
	 * 
	 * Method to run a hand of the Spades game.
	 */
	public void runHand() {
 
	}

	/**
	 * 
	 * Method to calculate the scores for each player at the end of the game.
	 */
	public void calculateScore() {
 
	}
}