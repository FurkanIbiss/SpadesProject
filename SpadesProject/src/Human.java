import java.util.Scanner;

/**
 * 
 * A class representing a human player in a Spades game.
 */
public class Human extends Player {
	private Scanner scan;

	/**
	 * 
	 * Constructor for the Human class. Initializes the human player's name.
	 * 
	 * @param name the name of the human player
	 */
	public Human(String name) {
		super(name);
		this.scan = new Scanner(System.in);
	}

	/**
	 * 
	 * Method for the human player to set their bid for the current hand.
	 */
	public void setBid() {
		System.out.println("Give your bid between 0-13 inclusive:");
		int userBid = scan.nextInt();

		if (userBid >= 0 && userBid <= 13) {
			this.bidCount = userBid;
		} else {
			System.out.println("Your bid must be between 0 and 13. Give again:");
			setBid();
		}

	}

	/**
	 * 
	 * Method for the human player to play a card.
	 */
	public void play() {

		Card c = takeUserChoose();
		if (this.getHand().hand.isContains(new Node(c))) {
			if ((c.suitType == Suit.SPADE) && !this.hand.isSpadeBroken) {
				System.out.println("You cannot play spade before spade broken, choose another card.");
				play();
			} else if ((c.suitType == Suit.SPADE) && this.hand.isSpadeBroken) {

				this.currentCard = c;
				System.out.println("Player 1 [" + this.bidCount + "/" + this.trickCount + "]: " + c.getName());

			} else if (c.suitType == Suit.SPADE && !this.hand.isContainsSuitType(Suit.CLUB)
					&& !this.hand.isContainsSuitType(Suit.DIAMOND) && !this.hand.isContainsSuitType(Suit.HEART)) {
				 this.hand.isSpadeBroken = true;
				this.currentCard = c;
				System.out.println("Player 1 [" + this.bidCount + "/" + this.trickCount + "]: " + c.getName());
				this.countSpadeBroken++;
				if (this.countSpadeBroken == 1) {
					System.out.println("--------------------SPADE BROKEN" + "------------------------");
				}
			}

			else {
				this.currentCard = c;
				System.out.println("Player 1 [" + this.bidCount + "/" + this.trickCount + "]: " + c.getName());

			}

		} else {
			System.out.println("You don't have this card in your hand. Please choose another card:");
			play();
		}

	}

	/**
	 * 
	 * Method for the human player to play a card of a specified suit.
	 * 
	 * @param suit the suit of the current trick
	 */

	public void play(Suit suit) {

		Card c = takeUserChoose();
		if (this.getHand().hand.isContains(new Node(c))) {

			if (c.suitType == suit) {
				this.currentCard = c;
				System.out.println("Player 1 [" + this.bidCount + "/" + this.trickCount + "]: " + c.getName());
			} else if ((c.suitType != suit) && (!this.hand.isContainsSuitType(suit))) {

				this.currentCard = c;
				if (c.suitType == Suit.SPADE) {

					this.hand.isSpadeBroken = true;
					this.countSpadeBroken++;
					if (this.countSpadeBroken == 1) {
						System.out.println("--------------------SPADE BROKEN" + "------------------------");
					}
					System.out.println("Player 1 [" + this.bidCount + "/" + this.trickCount + "]: " + c.getName());
				} else {
					System.out.println("Player 1 [" + this.bidCount + "/" + this.trickCount + "]: " + c.getName());
				}

			}

			else {
				System.out.println("You have " + suit.toString()
						+ " in your hand. You have to play with one of them.Choose one of them!!");
				play(suit);
			}

		}

		else {
			System.out.println("You don't have this card in your hand. Please choose another card:");
			play(suit);
		}

	}

	/**
	 * Method which takes input via scanner from user and returns as card.
	 * 
	 * @return card
	 */
	private Card takeUserChoose() {
		Card x = new Card();
		System.out.println("Your current deck:");
		System.out.println(this.hand.toString());
		System.out.println("Which card will you play? Give as Suit and Face");
		System.out.println("SUIT: ");
		String s = scan.next();
		if (!s.equals("SPADE") && !s.equals("HEART") && !s.equals("DIAMOND") && !s.equals("CLUB")) {
			System.out.println("Invalid Suit, please choose from SPADE, HEART, DIAMOND, CLUB");
			return takeUserChoose();
		}
		x.setSuit(s);
		System.out.println("FACE: ");
		String f = scan.next();
		if (!f.equals("2") && !f.equals("3") && !f.equals("4") && !f.equals("5") && !f.equals("6") && !f.equals("7")
				&& !f.equals("8") && !f.equals("9") && !f.equals("10") && !f.equals("KING") && !f.equals("ACE")
				&& !f.equals("QUEEN") && !f.equals("JOKER")) {
			System.out.println("Invalid Face, please choose from 2, 3, 4, 5, 6, 7, 8, 9, 10, KING, ACE, QUEEN, JOKER");
			return takeUserChoose();
		}
		x.setValue(f);
		return x;
	}

}