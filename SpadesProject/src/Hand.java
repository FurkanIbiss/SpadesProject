/**
 * 
 * A class representing a hand of cards in a Spades game.
 */
public class Hand {

	public LinkedList hand;
	public boolean isSpadeBroken;

	/**
	 * 
	 * Constructor for the Hand class. Initializes an empty hand of cards.
	 */
	public Hand() {
		this.hand = new LinkedList();
		this.isSpadeBroken = false;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		Node current = this.hand.getHead();
		result.append("{");
		while (current != null) {
			result.append(current.card.getName() + "/");
			current = current.next;
		}
		result.append("}");

		return result.toString();
	}

	/**
	 * 
	 * Method to add a card to the hand.
	 * 
	 * @param card the card to add to the hand
	 */
	public void add(Card card) {
		this.hand.insertLast(new Node(card));
	}

	/**
	 * 
	 * Method to remove a card from the hand.
	 * 
	 * @param card the card to remove from the hand
	 */
	public void remove(Card card) {

		Node nodeToDelete = this.hand.getNodeWith(card.value, card.suitType);
		this.hand.delete(nodeToDelete);
	}

	/**
	 * 
	 * Method to check if the hand contains a specified card.
	 * 
	 * @param card the card to check for in the hand
	 * @return true if the hand contains the card, false otherwise
	 */
	public boolean contains(Card card) {
		Node n = new Node(card);

		return this.hand.isContains(n);
	}

	/**
	 * 
	 * Method to check if the hand is empty.
	 * 
	 * @return true if the hand is empty, false otherwise
	 */
	public boolean isNull() {

		return this.hand.isEmpty();
	}

	/**
	 * 
	 * Determines if the hand contains a card with the specified suit.
	 * 
	 * @param suit the suit to search for
	 * 
	 * @return true if the hand contains a card with the specified suit, false
	 *         otherwise
	 */
	public boolean isContainsSuitType(Suit suit) {
		Node tmp = this.hand.head;

		while (tmp != null) {
			if (tmp.card.suitType == suit) {
				return true;
			}
			tmp = tmp.getNext();
		}
		return false;
	}

	/**
	 * 
	 * Counts the number of cards in the hand with the specified suit.
	 * 
	 * @param suit the suit to count
	 * 
	 * @return the number of cards in the hand with the specified suit
	 */
	public int countSuitType(Suit suit) {
		Node tmp = this.hand.head;
		int count = 0;

		while (tmp != null) {
			if (tmp.card.suitType == suit) {
				count++;
			}
			tmp = tmp.getNext();
		}
		return count;
	}
}