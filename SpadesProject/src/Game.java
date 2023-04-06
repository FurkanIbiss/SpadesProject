
/**
 * 
 * A class representing a Spades game.
 */
public class Game {

	public Deck deck;
	public Bot bot1;
	public Bot bot2;
	public Bot bot3;
	public Human human;
	public LinkedList order;
	public Suit currentHandSuit;
	public boolean isSpadeBroken;

	/**
	 * 
	 * Constructor for the Game class. Initializes the deck and player objects.
	 */
	public Game() {
		this.deck = new Deck();
		this.bot1 = new Bot("Bot1");
		this.bot2 = new Bot("Bot2");
		this.bot3 = new Bot("Bot3");
		this.human = new Human("User");

	}

	/**
	 * 
	 * Method to run the Spades game.
	 * 
	 * @throws InterruptedException
	 */
	public void run() throws InterruptedException {
		System.out.println("Welcome to the SpadesGame!");
		System.out.println(
				"WARNING: Write the cards you want to play as a player in capital letters without using Turkish characters!!!");
		System.out.println("Game is starting!");
		runRound();

	}

	/**
	 * Plays 13 rounds of games until any player reaches 500 points or more.
	 * 
	 * @throws InterruptedException
	 */
	private void runRound() throws InterruptedException {
		while (this.bot1.score != 500 && this.bot2.score != 500 && this.bot3.score != 500 && this.human.score != 500) {
			initializeGame();
			Card winnerCard = bot1.getHand().hand.head.card;
			this.order = orderOfHand(winnerCard);
			int count = 0;
			System.out.println("-----------------------ROUND" + (count + 1) + "-------------------");
			while (count < 13) {
				runHand();
				System.out.println("-------------------NEW HAND----------------------------");
				count++;
			}
			CalculateHandScores();
		}
		determineWinnerOfGame();
	}

	/**
	 * Method determines winner and print it to console
	 */
	private void determineWinnerOfGame() {
		if (this.bot1.score >= 500) {
			System.out.println("--------------------BOT1 WINS!!!---------------------");
		} else if (this.bot2.score >= 500) {
			System.out.println("--------------------BOT2 WINS!!!---------------------");
		} else if (this.bot3.score >= 500) {
			System.out.println("--------------------BOT3 WINS!!!---------------------");
		} else {
			System.out.println("--------------------YOU WINS!!!---------------------");
		}

	}

	/**
	 * Calculates scores of player at the end of each hand and prints them.
	 */
	public void CalculateHandScores() {

		calculateScore(bot1);
		calculateScore(bot2);
		calculateScore(bot3);
		calculateScore(human);
		System.out.println("SCORS:  BOT1: " + bot1.score + "  BOT2:" + bot2.score + "  BOT3:" + bot3.score + "  PLAYER:"
				+ human.score);

	}

	/**
	 * 
	 * Method to determine the winning card from a set of four cards.
	 * 
	 * @param a the first card
	 * @param b the second card
	 * @param c the third card
	 * @param d the fourth card
	 * @return the winning card
	 */
	public Card winnerCard(Card a, Card b, Card c, Card d) {
		Card card = new Card();
		if ((a.suitType.equals(b.suitType)) && (b.suitType.equals(c.suitType)) && (c.suitType.equals(d.suitType))) {
			int max = Math.max(Math.max(Math.max(a.getValue(), b.getValue()), c.getValue()), d.getValue());
			card = new Card(a.getSuit(), max);

		} else if (a.suitType.equals(Suit.SPADE) || b.suitType.equals(Suit.SPADE) || c.suitType.equals(Suit.SPADE)
				|| d.suitType.equals(Suit.SPADE)) {
			int tempA = a.value;
			int tempB = b.value;
			int tempC = c.value;
			int tempD = d.value;
			if (!(a.suitType.equals(Suit.SPADE))) {
				a.setValue(0);
			}
			if (!(b.suitType.equals(Suit.SPADE))) {
				b.setValue(0);
			}
			if (!(c.suitType.equals(Suit.SPADE))) {
				c.setValue(0);
			}
			if (!(d.suitType.equals(Suit.SPADE))) {
				d.setValue(0);
			}
			int max = Math.max(Math.max(Math.max(a.getValue(), b.getValue()), c.getValue()), d.getValue());
			card = new Card(Suit.SPADE, max);
			a.setValue(tempA);
			b.setValue(tempB);
			c.setValue(tempC);
			d.setValue(tempD);

		} else {
			int max = Math.max(Math.max(Math.max(a.getValue(), b.getValue()), c.getValue()), d.getValue());
			if (max == a.getValue()) {
				card = new Card(a.getSuit(), max);

			}
			if (max == b.getValue()) {
				card = new Card(b.getSuit(), max);

			}
			if (max == c.getValue()) {
				card = new Card(c.getSuit(), max);

			}
			if (max == d.getValue()) {
				card = new Card(d.getSuit(), max);

			}

		}
		return card;

	}

	/**
	 * 
	 * Method to set the trick count for the winner of a hand.
	 * 
	 * @param winnerCard the card played by the winning player
	 */
	public void setWinnersTrick(Card winnerCard) {
		if (this.bot1.hand.contains(winnerCard)) {
			this.bot1.trickCount++;
		}
		if (this.bot2.hand.contains(winnerCard)) {
			this.bot2.trickCount++;
		}
		if (this.bot3.hand.contains(winnerCard)) {
			this.bot3.trickCount++;
		}
		if (this.human.hand.contains(winnerCard)) {
			this.human.trickCount++;
		}

	}

	/**
	 * 
	 * Method to determine the order of play for the next hand, given the winner of
	 * the previous hand.
	 * 
	 * @param winner the player who won the previous hand
	 * @return a linked list indicating the order of play for the next hand
	 *         respecting to the winner
	 */
	public LinkedList orderOfHand(Card card) {
		LinkedList newOrder = new LinkedList();
		if (bot1.getHand().contains(card)) {
			newOrder.insertLast(new Node(bot1));
			newOrder.insertLast(new Node(bot2));
			newOrder.insertLast(new Node(bot3));
			newOrder.insertLast(new Node(human));

		}
		if (bot2.getHand().contains(card)) {
			newOrder.insertLast(new Node(bot2));
			newOrder.insertLast(new Node(bot3));
			newOrder.insertLast(new Node(human));
			newOrder.insertLast(new Node(bot1));
		}
		if (bot3.getHand().contains(card)) {
			newOrder.insertLast(new Node(bot3));
			newOrder.insertLast(new Node(human));
			newOrder.insertLast(new Node(bot1));
			newOrder.insertLast(new Node(bot2));
		}
		if (human.getHand().contains(card)) {
			newOrder.insertLast(new Node(human));
			newOrder.insertLast(new Node(bot1));
			newOrder.insertLast(new Node(bot2));
			newOrder.insertLast(new Node(bot3));
		}

		return newOrder;
	}

	/**
	 * 
	 * Method to run a hand of the Spades game.
	 * 
	 * @throws InterruptedException
	 */
	public void runHand() throws InterruptedException {
		Node tmp = this.order.getHead();
		int i = 0;
		while (tmp != null && i != 4) {
			if (tmp.player instanceof Human) {
				if (i == 0) {
					human.play();
					human.currentSuit = human.currentCard.getSuit();
					this.currentHandSuit = human.currentSuit;
				} else {
					human.play(this.currentHandSuit);
					this.isSpadeBroken = human.getHand().isSpadeBroken;
				}
			} else if (tmp.player instanceof Bot) {
				Bot bot = (Bot) tmp.player;
				if (i == 0) {
					bot.play();
					bot.currentSuit = bot.currentCard.getSuit();
					this.currentHandSuit = bot.currentSuit;
				} else {
					bot.play(this.currentHandSuit);
					this.isSpadeBroken = bot.getHand().isSpadeBroken;
				}
			}
			tmp = tmp.next;
			i++;
			Thread.sleep(1000);
			bot1.hand.isSpadeBroken = this.isSpadeBroken;
			bot2.hand.isSpadeBroken = this.isSpadeBroken;
			bot3.hand.isSpadeBroken = this.isSpadeBroken;
			human.hand.isSpadeBroken = this.isSpadeBroken;
		}
		finalizeHand();
	}

	/**
	 * Method finds the winning card and player, updates the players' trick numbers,
	 * and removes their cards from their hands and do other updates for new hand.
	 */
	private void finalizeHand() {
		Card wCard = null;
		wCard = winnerCard(bot1.currentCard, bot2.currentCard, bot3.currentCard, human.currentCard);
		this.order = orderOfHand(wCard);
		System.out.println("Winner Card: " + wCard.getName());
		setWinnersTrick(wCard);
		bot1.hand.remove(bot1.currentCard);
		bot2.hand.remove(bot2.currentCard);
		bot3.hand.remove(bot3.currentCard);
		human.hand.remove(human.currentCard);
		bot1.countSpadeBroken = 0;
		bot2.countSpadeBroken = 0;
		bot3.countSpadeBroken = 0;
		human.countSpadeBroken = 0;
	}

	/**
	 * 
	 * Method to calculate the scores for each player at the end of the game.
	 */
	public void calculateScore(Player a) {
		if (a.bidCount == 0) {
			if (a.trickCount == 0) {
				a.score = a.score + 100;
			} else {
				a.score = a.score - 100;
			}
		}
		if (a.trickCount < a.bidCount) {
			a.score = a.score - (10 * a.bidCount);
		}
		if (a.trickCount >= a.bidCount) {
			a.score = a.score + (10 * a.bidCount) + (1 * (a.trickCount - a.bidCount));
		}

	}

	/**
	 *
	 * Initializes the game by creating new hands for all players, resetting their
	 * stats, shuffling the deck, dealing the cards, and setting the bids for all
	 * players.
	 *
	 * @throws InterruptedException if the thread is interrupted while sleeping
	 */
	public void initializeGame() throws InterruptedException {
		this.bot1.hand = new Hand();
		this.bot2.hand = new Hand();
		this.bot3.hand = new Hand();
		this.human.hand = new Hand();
		this.bot1.countSpadeBroken = 0;
		this.bot2.countSpadeBroken = 0;
		this.bot3.countSpadeBroken = 0;
		this.human.countSpadeBroken = 0;
		this.bot1.bidCount = 0;
		this.bot2.bidCount = 0;
		this.bot3.bidCount = 0;
		this.human.bidCount = 0;
		this.bot1.trickCount = 0;
		this.bot2.trickCount = 0;
		this.bot3.trickCount = 0;
		this.human.trickCount = 0;
		this.deck.deck.shuffle();
		deck.deal(bot1, bot2, bot3, human);
		bot1.setBid();
		System.out.println("Bot1's bid is : " + bot1.getBid());
		Thread.sleep(1000);
		bot2.setBid();
		System.out.println("Bot2's bid is : " + bot2.getBid());
		Thread.sleep(1000);
		bot3.setBid();
		System.out.println("Bot3's bid is : " + bot3.getBid());
		Thread.sleep(1000);
		System.out.println("Here is your hand:");
		System.out.println(human.hand.toString());
		human.setBid();
	}
}