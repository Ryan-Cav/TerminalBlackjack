import java.util.ArrayList;

public class Player {
	private ArrayList<Deck.Card> hand;
	private String name;

	public Player(ArrayList<Deck.Card> hand, String name) {
		this.hand = hand;
		this.name = name;
	}

	public int addCard(Deck.Card card) {
		hand.add(card);
		return getHandValue();
	}

	public int getHandValue() {
		int val = 0;
		int numAces = 0;
		for (Deck.Card c : hand) {
			if (c.num.equals("A")) {
				numAces += 1;
			} else {
				val += c.value;
			}
		}
		while (numAces > 0) {
			if (val + 11 <= 21) {
				val += 11;
			} else {
				val += 1;
			}
			numAces--;
		}
		return val;
	}

	public ArrayList<Deck.Card> getHand() {
		return hand;
	}

	public void printHand() {
		for (Deck.Card c : this.hand) {
			System.out.print(c.num + c.suit + " ");
		}
		System.out.println();
	}

	public void printHandValue() {
		System.out.println(this.name + " hand value: " + getHandValue());
	}

	public void printCardValue(int num) {
		System.out.println(this.name + " card: " + hand.get(num).num + hand.get(num).suit);
	}

	public void printWinner(Player loser) {
		System.out.println(this.name + " wins");
		System.out.print(loser.name + " hand: ");
		loser.printHand();
		loser.printHandValue();
		System.out.print(this.name + " hand: ");
		printHand();
		printHandValue();
	}
}
