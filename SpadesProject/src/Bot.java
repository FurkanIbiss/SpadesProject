/**
 * 
 * A class representing a bot player in a Spades game.
 */
public class Bot extends Player {

	/**
	 * 
	 * Constructor for the Bot class. Initializes the bot's name.
	 * 
	 * @param name the name of the bot
	 */
	public Bot(String name) {
		super(name);
	}

	/**
	 * 
	 * Method for the bot to play a card while it is first player.
	 */
	public void play() {
		Card c = new Card();
		Node tmp = this.hand.hand.getHead();
		if (this.hand.isSpadeBroken) {
			c = tmp.card;
			this.currentCard = c;
			System.out.println(this.getName() + " [" + this.bidCount + "/" + this.trickCount + "]: " + c.getName());
		} else if (this.hand.isContainsSuitType(Suit.SPADE) && !this.hand.isContainsSuitType(Suit.CLUB)
				&& !this.hand.isContainsSuitType(Suit.DIAMOND) && !this.hand.isContainsSuitType(Suit.HEART)) {
            this.hand.isSpadeBroken = true;
			c = tmp.card;
			this.currentCard = c;
			System.out.println(this.getName() + " [" + this.bidCount + "/" + this.trickCount + "]: " + c.getName());
			this.countSpadeBroken++;
			if (this.countSpadeBroken == 1) {
				System.out.println("--------------------SPADE BROKEN" + "------------------------");
			}

		}

		else if ((!this.hand.isSpadeBroken)
				& (this.hand.hand.numberOfElements() != this.hand.countSuitType(Suit.SPADE))) {
			while (tmp != null) {
				if (tmp.card.suitType != Suit.SPADE) {
					c = tmp.card;
					this.currentCard = c;
					System.out.println(
							this.getName() + " [" + this.bidCount + "/" + this.trickCount + "]: " + c.getName());
					break;
				}
				tmp = tmp.next;
			}
		} else {
			c = tmp.card;
			this.currentCard = c;
			System.out.println(this.getName() + " [" + this.bidCount + "/" + this.trickCount + "]: " + c.getName());
		}

	}

	/**
	 * 
	 * Method for the bot to play a card of a specified suit.
	 * 
	 * @param suit the suit of the card to play
	 */
	public void play(Suit suit) {
		boolean tmpBool = this.hand.isSpadeBroken;
		Card c = new Card();
		if (this.hand.isContainsSuitType(suit)) {

			Node tmp = this.hand.hand.getHead();
			while (tmp != null) {

				if (tmp.card.suitType == suit) {

					c = tmp.card;

				}
				tmp = tmp.getNext();

			}

		} else if (!this.hand.isContainsSuitType(suit) && this.hand.isContainsSuitType(Suit.SPADE)) {
			this.countSpadeBroken++;

			Node tmp = this.hand.hand.getHead();
			while (tmp != null) {

				if (tmp.card.suitType == Suit.SPADE) {

					c = tmp.card;
					this.getHand().isSpadeBroken = true;

				}
				tmp = tmp.getNext();

			}

		} else {

			Node tmp = this.hand.hand.getHead();

			c = tmp.card;

		}

		this.currentCard = c;
		System.out.println(this.getName() + " [" + this.bidCount + "/" + this.trickCount + "]: " + c.getName());
		if (this.countSpadeBroken == 1 && (!tmpBool)) {
			System.out.println("--------------------SPADE BROKEN" + "------------------------");
		}

	}

	/**
	 * 
	 * Method for the bot to set its bid for the current hand.
	 */
	public void setBid() {
		int countSpade = 0;
		Node tmp = this.hand.hand.getHead();
		while (tmp != null) {

			if (tmp.card.suitType == Suit.SPADE) {
				countSpade++;
			}
			tmp = tmp.next;
		}

		this.bidCount = countSpade;

	}

	/**
	 * Method which returns bid of bot
	 */
	public int getBid() {
		return this.bidCount;
	}
}