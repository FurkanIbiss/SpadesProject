/**
 * 
 * A class representing a deck of cards used in a game of Spades.
 */
public class Deck {

	/**
	 * 
	 * The linked list that represents the deck of cards.
	 */
	public LinkedList deck;

	/**
	 * 
	 * Constructor for the Deck class. Initializes the deck of cards as an empty
	 * linked list and fill it with cards.
	 */
	public Deck() {
		deck = new LinkedList();
		for (int i = 2; i <= 14; i++) {
			deck.insertLast(new Node(new Card(Suit.CLUB, i)));
		}
		for (int i = 2; i <= 14; i++) {
			deck.insertLast(new Node(new Card(Suit.SPADE, i)));
		}
		for (int i = 2; i <= 14; i++) {
			deck.insertLast(new Node(new Card(Suit.DIAMOND, i)));
		}
		for (int i = 2; i <= 14; i++) {
			deck.insertLast(new Node(new Card(Suit.HEART, i)));
		}
	}

	/**
	 * 
	 * Method to deal a hand of cards to four players.
	 * 
	 * @param a player to be dealt cards
	 * @param b player to be dealt cards
	 * @param c player to be dealt cards
	 * @param d player to be dealt cards
	 */
	public void deal(Player a, Player b, Player c, Player d) {
		Node tmp = this.deck.getHead();

		int count = 0;
		while (tmp != null) {

			if (count >= 0 && count < 13) {
				a.hand.hand.insertFirst(new Node(tmp.card));

				count++;
			} else if (count >= 13 && count < 26) {
				b.hand.hand.insertFirst(new Node(tmp.card));

				count++;
			} else if (count >= 26 && count < 39) {
				c.hand.hand.insertFirst(new Node(tmp.card));

				count++;
			} else if (count >= 39 && count < 52) {
				d.hand.hand.insertFirst(new Node(tmp.card));

				count++;
			}
			tmp = tmp.getNext();

		}

	}

	/**
	 * 
	 * Method to get the string representation of the deck of cards.
	 * 
	 * @return the string representation of the deck of cards
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		Node current = deck.getHead();
		for (int i = 1; i <= 52; i++) {
			result.append(current.card.getName() + " ");
			current = current.next;
		}
		return result.toString();
	}
}