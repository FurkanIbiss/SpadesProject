/**
 * 
 * A class representing a player in a Spades game.
 */
public class Player {

	public int bidCount;
	public int score;
	public String name;
	public Hand hand;
	public int trickCount;
	public Card currentCard;
	public Suit currentSuit;

	/**
	 * 
	 * Constructor for the Player class. Initializes the player's name.
	 * 
	 * @param name the name of the player
	 */
	Player(String name) {
		this.name = name;
	}

	/**
	 * 
	 * Method to get the player's trick count.
	 * 
	 * @return the player's trick count
	 */
	public int getTrickCount() {
		return trickCount;
	}

	/**
	 * 
	 * Method to set the player's trick count.
	 * 
	 * @param trickCount the player's trick count
	 */
	public void setTrickCount(int trickCount) {
		this.trickCount = trickCount;
	}

	/**
	 * 
	 * Method to get the player's current card.
	 * 
	 * @return the player's current card
	 */
	public Card getCurrentCard() {
		return currentCard;
	}

	/**
	 * 
	 * Method to set the player's current card.
	 * 
	 * @param currentCard the card that the player knocked down that hand.
	 */
	public void setCurrentCard(Card currentCard) {
		this.currentCard = currentCard;
	}

	/**
	 * 
	 * Method to get the player's hand of cards.
	 * 
	 * @return the player's hand of cards
	 */
	public Hand getHand() {
		return hand;
	}

	/**
	 * 
	 * Method to set the player's hand of cards.
	 * 
	 * @param hand the player's hand of cards
	 */
	public void setHand(Hand hand) {
		this.hand = hand;
	}

	/**
	 * 
	 * Method to get the player's score.
	 * 
	 * @return the player's score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * 
	 * Method to set the player's score.
	 * 
	 * @param score the player's score
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * 
	 * Method to get the player's name.
	 * 
	 * @return the player's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * Method to get the player's bid for the current hand.
	 * 
	 * @return the player's bid for the current hand
	 */
	public int getBid() {
 
		return 0;
	}
}