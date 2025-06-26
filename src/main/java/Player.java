import java.util.ArrayList;

public class Player {
	public ArrayList<Deck.Card> hand;

	public Player(ArrayList<Deck.Card> hand) {
		this.hand = hand;
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
}
