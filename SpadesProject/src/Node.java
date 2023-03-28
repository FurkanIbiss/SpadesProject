/**
 * 
 * A class representing a node in a linked list used to track cards played and
 * players in a Spades game.
 */
public class Node {
	protected Player player;
	protected Card card;
	protected Node next;

	/**
	 * 
	 * Constructor for the Node class representing a card node. Initializes the card
	 * and sets the next node to null.
	 * 
	 * @param card the card represented by the node
	 */
	public Node(Card card) {
		this.card = card;
		this.next = null;
	}

	/**
	 * 
	 * Constructor for the Node class representing a player node. Initializes the
	 * player and sets the next node to null.
	 * 
	 * @param player the player represented by the node
	 */
	public Node(Player player) {
		this.player = player;
		this.next = null;
	}

	/**
	 * 
	 * Method to set the next node in the linked list.
	 * 
	 * @param next the next node to set
	 */
	public void setNext(Node next) {
		this.next = next;
	}

	/**
	 * 
	 * Method to get the next node in the linked list.
	 * 
	 * @return the next node in the linked list
	 */
	public Node getNext() {
		return next;
	}

	/**
	 * 
	 * Method to get the string representation of the node, which is the suit and
	 * value of the card followed by a "|" character.
	 * 
	 * @return the string representation of the node
	 */
	public String toString() {
		return "" + card.suitType + " " + card.value + "|";
	}
}