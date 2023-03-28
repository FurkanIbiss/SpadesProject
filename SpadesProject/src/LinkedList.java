/**
 * 
 * A class representing a linked list used to track cards played and players in
 * a Spades game.
 */
public class LinkedList {

	protected Node head;
	protected Node tail;

	/**
	 * 
	 * Constructor for the LinkedList class. Initializes the head and tail nodes to
	 * null.
	 */
	public LinkedList() {
		head = null;
		tail = null;
	}

	/**
	 *
	 *
	 * A method to shuffle the elements in a linked list.
	 * 
	 * @param list the linked list to shuffle
	 */
	public void shuffle(LinkedList list) {

	}

	/**
	 * 
	 * Method to check if the linked list is empty.
	 * 
	 * @return true if the linked list is empty, false otherwise
	 */
	public boolean isEmpty() {
		return head == null;
	}

	/**
	 * 
	 * Method to get the head node of the linked list.
	 * 
	 * @return the head node of the linked list
	 */
	public Node getHead() {
		return head;
	}

	/**
	 * 
	 * Method to insert a node at the beginning of the linked list.
	 * 
	 * @param newNode the node to insert at the beginning of the linked list
	 */
	public void insertFirst(Node newNode) {

	}

	/**
	 * 
	 * Method to insert a node at the end of the linked list.
	 * 
	 * @param newNode the node to insert at the end of the linked list
	 */
	public void insertLast(Node newNode) {

	}

	/**
	 * 
	 * Method to insert a node at the end of the linked list.
	 * 
	 * @param newNode the node to insert at the end of the linked list
	 */
	public void insert(Node newNode) {

	}

	/**
	 * 
	 * Method to get the node at a specific index in the linked list.
	 * 
	 * @param i the index of the node to get
	 * @return the node at the specified index, or null if the index is out of range
	 */
	public Node getNodeI(int i) {
		return null;
	}

	/**
	 * 
	 * Method to get the number of nodes in the linked list.
	 * 
	 * @return the number of nodes in the linked list
	 */
	public int numberOfElements() {

		return 0;
	}

	/**
	 * 
	 * Method to delete the first node in the linked list.
	 */
	public void deleteFirst() {

	}

	/**
	 * 
	 * Method to get the node previous to a specified node in the linked list.
	 * 
	 * @param node the node to find the previous node of
	 * @return the node previous to the specified node, or null if the specified
	 *         node is the head node
	 */
	public Node getPrevious(Node node) {
		return null;
	}

	/**
	 * 
	 * Method to delete the last node in the linked list.
	 */
	public void deleteLast() {

	}

	/**
	 * 
	 * Method to get the string representation of the linked list, which is a
	 * concatenation of the string representations of each node in the linked list.
	 * 
	 * @return the string representation of the linked list
	 */
	public String toString() {
		return null;
	}
}