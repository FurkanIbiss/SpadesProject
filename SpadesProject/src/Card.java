/**
 * 
 * Represents a playing card with a suit and value.
 */
public class Card {
	public Suit suitType;
	public int value;

	/**
	 * 
	 * Creates a new card with the specified suit and value.
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
	 * Creates a new empty card.
	 */
	public Card() {
	}

	/**
	 * 
	 * Returns the name of the card in the format "[suit] [value]". If the value is
	 * a face card or a joker, the name will reflect that.
	 * 
	 * @return the name of the card
	 */
	public String getName() {
		if (this.value >= 2 && this.value <= 10) {
			return this.suitType + " " + this.value;
		} else if (this.value == 11) {
			return this.suitType + " " + "Joker";
		} else if (this.value == 12) {
			return this.suitType + " " + "Queen";
		} else if (this.value == 13) {
			return this.suitType + " " + "King";
		} else {
			return this.suitType + " " + "Ace";
		}
	}

	/**
	 * 
	 * Returns the value of the card.
	 * 
	 * @return the value of the card
	 */
	public int getValue() {
		return value;
	}

	/**
	 * 
	 * Sets the value of the card to the specified integer.
	 * 
	 * @param a the integer to set as the value
	 */
	public void setValue(int a) {
		this.value = a;
	}

	/**
	 * 
	 * Sets the value of the card based on a string input. If the string input is a
	 * face card or a joker, it sets the value accordingly.
	 * 
	 * @param a the string input to set as the value
	 */
	public void setValue(String a) {
		if (a.equals("ACE")) {
			this.value = 14;
		} else if (a.equals("KING")) {
			this.value = 13;
		} else if (a.equals("QUEEN")) {
			this.value = 12;
		} else if (a.equals("JOKER")) {
			this.value = 11;
		} else {
			int tmp = Integer.parseInt(a);
			this.value = tmp;
		}
	}

	/**
	 * 
	 * Returns the suit of the card.
	 * 
	 * @return the suit of the card
	 */
	public Suit getSuit() {
		return suitType;
	}

	/**
	 * 
	 * Sets the suit of the card based on a string input.
	 * 
	 * @param s the string input to set as the suit
	 */
	public void setSuit(String s) {
		if ((Suit.CLUB.toString()).equals(s)) {
			this.suitType = Suit.CLUB;
		}
		if ((Suit.DIAMOND.toString()).equals(s)) {
			this.suitType = Suit.DIAMOND;
		}
		if ((Suit.HEART.toString()).equals(s)) {
			this.suitType = Suit.HEART;
		}
		if ((Suit.SPADE.toString()).equals(s)) {
			this.suitType = Suit.SPADE;
		}
	}
}