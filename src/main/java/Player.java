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
		for (Deck.Card c : hand) {
			val+=c.value;
		}
		return val;
	}

	public ArrayList<Deck.Card> getHand() {
		return hand;
	}
}
