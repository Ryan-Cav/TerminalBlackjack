import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private ArrayList<Card> deck;

	public Deck() {
		deck = new ArrayList<Card>(52);

		deck.add(new Card("2", "H", 2));
		deck.add(new Card("3", "H", 3));
		deck.add(new Card("4", "H", 4));
		deck.add(new Card("5", "H", 5));
		deck.add(new Card("6", "H", 6));
		deck.add(new Card("7", "H", 7));
		deck.add(new Card("8", "H", 8));
		deck.add(new Card("9", "H", 9));
		deck.add(new Card("10", "H", 10));
		deck.add(new Card("J", "H", 10));
		deck.add(new Card("Q", "H", 10));
		deck.add(new Card("K", "H", 10));
		deck.add(new Card("A", "H", 1));
		deck.add(new Card("2", "D", 2));
		deck.add(new Card("3", "D", 3));
		deck.add(new Card("4", "D", 4));
		deck.add(new Card("5", "D", 5));
		deck.add(new Card("6", "D", 6));
		deck.add(new Card("7", "D", 7));
		deck.add(new Card("8", "D", 8));
		deck.add(new Card("9", "D", 9));
		deck.add(new Card("10", "D", 10));
		deck.add(new Card("J", "D", 10));
		deck.add(new Card("Q", "D", 10));
		deck.add(new Card("K", "D", 10));
		deck.add(new Card("A", "D", 1));
		deck.add(new Card("2", "S", 2));
		deck.add(new Card("3", "S", 3));
		deck.add(new Card("4", "S", 4));
		deck.add(new Card("5", "S", 5));
		deck.add(new Card("6", "S", 6));
		deck.add(new Card("7", "S", 7));
		deck.add(new Card("8", "S", 8));
		deck.add(new Card("9", "S", 9));
		deck.add(new Card("10", "S", 10));
		deck.add(new Card("J", "S", 10));
		deck.add(new Card("Q", "S", 10));
		deck.add(new Card("K", "S", 10));
		deck.add(new Card("A", "S", 1));
		deck.add(new Card("2", "C", 2));
		deck.add(new Card("3", "C", 3));
		deck.add(new Card("4", "C", 4));
		deck.add(new Card("5", "C", 5));
		deck.add(new Card("6", "C", 6));
		deck.add(new Card("7", "C", 7));
		deck.add(new Card("8", "C", 8));
		deck.add(new Card("9", "C", 9));
		deck.add(new Card("10", "C", 10));
		deck.add(new Card("J", "C", 10));
		deck.add(new Card("Q", "C", 10));
		deck.add(new Card("K", "C", 10));
		deck.add(new Card("A", "C", 1));
	}

	public Card drawCard() {
		Random random = new Random();
		int randomNum = random.nextInt(deck.size());
		Card rand = deck.get(randomNum);
		deck.remove(rand);
		return rand;
	}

	public class Card {
		public String num, suit;
		public int value;
		public Card(String num, String suit, int value) {
			this.num = num;
			this.suit = suit;
			this.value = value;
		}
	}
}
