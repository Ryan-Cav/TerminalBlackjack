import java.util.Scanner;
import java.util.ArrayList;

public class GameStart {
	private static Scanner inputScanner = new Scanner(System.in);
	private boolean continuePlaying = false;

	public static void main(String[] args) {
		System.out.println("Do you want to play TERMINAL BLACKJACK?");
		System.out.print("Y/N: ");
		String response = inputScanner.nextLine().toLowerCase();
		Deck deck = new Deck();
		while (response.equals("y")) {
			System.out.println("Game is Starting!");

			// Draw house cards
			ArrayList<Deck.Card> houseCards = new ArrayList<Deck.Card>();
			houseCards.add(deck.drawCard());
			houseCards.add(deck.drawCard());
			System.out.println("House cards: " + houseCards.get(0).num + houseCards.get(0).suit);

			// Draw user cards
			Player house = new Player(houseCards);
			ArrayList<Deck.Card> playerCards = new ArrayList<Deck.Card>();
			playerCards.add(deck.drawCard());
			playerCards.add(deck.drawCard());
			System.out.println("Your cards: " + playerCards.get(0).num + playerCards.get(0).suit + " "
					+ playerCards.get(1).num + playerCards.get(1).suit);
			Player user = new Player(playerCards);

			int houseValue = house.getHandValue();
			int userValue = user.getHandValue();
			if (houseValue == 21)
				System.out.println("House wins: " + houseCards.get(0).num + houseCards.get(0).suit + " "
						+ houseCards.get(1).num + houseCards.get(1).suit);
			else if (userValue == 21)
				System.out.println("User wins: " + playerCards.get(0).num + playerCards.get(0).suit
						+ " " + playerCards.get(1).num + playerCards.get(1).suit);
			else {
				while (!response.equals("s") && userValue < 21) {
					response = "";
					System.out.println("User hand value: " + userValue);
					while (!(response.equals("h") || response.equals("s"))) {
						System.out.println("Do you want to Hit or Stand? (h/s)");
						response = inputScanner.nextLine().toLowerCase();
					}
					if (response.equals("h")) {
						userValue = user.addCard(deck.drawCard());
						printHand(user);
					}
				}
				if (userValue > 21)
					System.out.println("Bust. House wins.");
				else {
					while (houseValue < 17) {
						houseValue = house.addCard(deck.drawCard());
						printHand(house);
					}
					if (house.getHandValue() > 21)
						System.out.println("House Busts. You win!");
					else if (house.getHandValue() > user.getHandValue()) {
						System.out.println("House Wins!");
						printHand(house);
					} else if (user.getHandValue() > house.getHandValue()) {
						System.out.println("You Win!");
						printHand(user);
					} else
						System.out.println("Push");
				}
			}
			System.out.print("Do you want to keep playing (Y/N) ? ");
			response = inputScanner.nextLine().toLowerCase();
		}
	}

	private static void printHand(Player player) {
		for (Deck.Card c : player.getHand()) {
			System.out.print(c.num + c.suit + " ");
		}
		System.out.println(player.getHandValue());
	}
}
