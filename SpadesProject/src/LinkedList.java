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
	public void shuffle() {
		Node current = head;
		int size = numberOfElements();

		for (int i = 0; i < size; i++) {

			int index = i + (int) (Math.random() * (size - i));

			Node nodeAtIndex = getNodeI(index);
			Card tempCard = current.card;
			Player tempPlayer = current.player;
			current.card = nodeAtIndex.card;
			current.player = nodeAtIndex.player;
			nodeAtIndex.card = tempCard;
			nodeAtIndex.player = tempPlayer;

			current = current.getNext();
		}
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
		if (tail == null) {
			tail = newNode;
		}
		newNode.setNext(head);
		head = newNode;
	}

	/**
	 * 
	 * Method to insert a node at the end of the linked list.
	 * 
	 * @param newNode the node to insert at the end of the linked list
	 */
	public void insertLast(Node newNode) {
		if (head == null) {
			head = newNode;
		} else {
			tail.setNext(newNode);
		}
		tail = newNode;
	}

	/**
	 * 
	 * Method to get the node at a specific index in the linked list.
	 * 
	 * @param i the index of the node to get
	 * @return the node at the specified index, or null if the index is out of range
	 */

	public Node getNodeI(int i) {
		Node tmp = head;
		int index = 0;
		while (tmp != null) {
			if (index == i) {
				return tmp;
			}
			index++;
			tmp = tmp.getNext();
		}
		return null;
	}

	/**
	 * 
	 * Method to get the number of nodes in the linked list.
	 * 
	 * @return the number of nodes in the linked list
	 */

	public int numberOfElements() {
		Node tmp = head;
		int count = 0;
		while (tmp != null) {
			count++;
			tmp = tmp.getNext();
		}
		return count;
	}

	/**
	 * 
	 * Method to delete the first node in the linked list.
	 */
	public void deleteFirst() {
		head = head.getNext();
		if (head == null) {
			tail = null;
		}
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
		Node tmp = head;
		Node previous = null;
		while (tmp != node) {
			previous = tmp;
			tmp = tmp.getNext();
		}
		return previous;
	}

	/**
	 * 
	 * Method to delete the last node in the linked list.
	 */
	public void deleteLast() {
		tail = getPrevious(tail);
		if (tail != null) {
			tail.setNext(null);
		} else {
			head = null;
		}
	}

	/**
	 * 
	 * Method to get the string representation of the linked list, which is a
	 * concatenation of the string representations of each node in the linked list.
	 * 
	 * @return the string representation of the linked list
	 */
	public String toString() {
		StringBuilder result = new StringBuilder();
		Node tmp = head;
		while (tmp != null) {
			result.append(tmp).append(" ");
			tmp = tmp.getNext();
		}
		return result.toString();
	}

	/**
	 * 
	 * Returns the node in the list that contains the specified value and suit.
	 * 
	 * @param i the value to search for
	 * 
	 * @param s the suit to search for
	 * 
	 * @return the node containing the specified value and suit, or null if not
	 *         found
	 */
	public Node getNodeWith(int i, Suit s) {
		Node tmp = head;

		while (tmp != null) {
			if (tmp.card.value == i && tmp.card.suitType.equals(s)) {
				return tmp;
			}

			tmp = tmp.getNext();
		}
		return null;
	}

	/**
	 * 
	 * Deletes the specified node from the middle of the list.
	 * 
	 * @param node the node to delete
	 */
	public void deleteMiddle(Node node) {
		Node previous;
		previous = getPrevious(node);
		previous.setNext(node.getNext());
	}

	/**
	 * 
	 * Deletes the specified node from the list.
	 * 
	 * @param nodeToDelete the node to delete
	 */
	public void delete(Node nodeToDelete) {
		if (nodeToDelete == null) {
			return;
		} else if (nodeToDelete == head) {
			head = head.next;
			return;
		} else if (nodeToDelete == tail) {
			tail = getPrevious(tail);
			if (tail != null) {
				tail.setNext(null);
			} else {
				head = null;
			}
		} else {
			getPrevious(nodeToDelete).setNext(nodeToDelete.next);
		}
	}

	/**
	 * 
	 * Determines if the list contains a node with the same value and suit as the
	 * specified node.
	 * 
	 * @param node the node to search for
	 * 
	 * @return true if the list contains a node with the same value and suit, false
	 *         otherwise
	 */
	public boolean isContains(Node node) {
		Node tmp = head;

		while (tmp != null) {
			if (tmp.card.suitType == node.card.suitType && tmp.card.value == node.card.getValue()) {
				return true;
			}
			tmp = tmp.getNext();
		}
		return false;
	}

}