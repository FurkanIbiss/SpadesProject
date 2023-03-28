/**
 * 
 * A class representing a card in a deck of cards.
 */
public class Card {
	public Suit suitType;
	public int value;

	/**
	 * 
	 * Constructor for the Card class. Initializes the card's suit and value.
	 * 
	 * @param suitType the suit of the card
	 * @param value    the value of the card
	 */
	public Card(Suit suitType, int value) {
		this.suitType = suitType;
		this.value = value;
	}

	/**
	 * 
	 * Method to get the name of the card.
	 * 
	 * @return the name of the card
	 */
	public String getName() {
		return null;
	}

	/**
	 * 
	 * Method to get the value of the card.
	 * 
	 * @return the value of the card
	 */
	public int getValue() {
		return value;
	}

	/**
	 * 
	 * Method to get the suit of the card.
	 * 
	 * @return the suit of the card
	 */
	public String getSuit() {
		return suitType.toString();
	}
}