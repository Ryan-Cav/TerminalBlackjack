import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.stream.Stream;

public class GameStart {
	private static Scanner inputScanner = new Scanner(System.in);

	public static void main(String[] args) {
		clearScreen();
		System.out.println("Do you want to play TERMINAL BLACKJACK?");
		System.out.print("Y/N: ");
		String response = inputScanner.nextLine().toLowerCase();
		Deck deck = new Deck();
		while (response.equals("y")) {
			clearScreen();
			System.out.println("Game is Starting!");

			// Setup game
			// TODO: Move this out to a setup game method
			ArrayList<Player> players = setupGame(deck);
			Player house = players.get(0);
			Player user = players.get(1);

			house.printCardValue(0);
			System.out.println("------------------------");
			System.out.print("Your cards: ");
			user.printHand();

			// Check Blackjacks
			int houseValue = house.getHandValue();
			int userValue = user.getHandValue();
			if (houseValue == 21) {
				System.out.println("Blackjack!");
				house.printWinner(user);
			} else if (userValue == 21) {
				System.out.println("Blackjack!");
				house.printWinner(user);
			} else { // Continue Game
				while (!response.equals("s") && userValue < 21) {
					response = "";
					user.printHandValue();
					while (!(response.equals("h") || response.equals("s"))) {
						System.out.println("Do you want to Hit or Stand? (h/s)");
						response = inputScanner.nextLine().toLowerCase();
					}
					if (response.equals("h")) {
						userValue = user.addCard(deck.drawCard());
						user.printHand();
						house.printCardValue(0);
					}
				}
				if (userValue > 21) {
					System.out.println("Bust.");
					house.printWinner(user);
				} else {
					while (houseValue < 17) {
						houseValue = house.addCard(deck.drawCard());
						house.printHand();
					}
					house.printHandValue();
					if (house.getHandValue() > 21)
						System.out.println("House Busts. You win!");
					else if (house.getHandValue() > user.getHandValue()) {
						house.printWinner(user);
					} else if (user.getHandValue() > house.getHandValue()) {
						user.printWinner(house);
					} else {
						System.out.println("Push");
						house.printHandValue();
						user.printHandValue();
					}
				}
			}
			System.out.print("Do you want to keep playing (Y/N) ? ");
			response = inputScanner.nextLine().toLowerCase();
			clearScreen();
		}
	}

	private static ArrayList<Player> setupGame(Deck deck) {
		ArrayList<Deck.Card> houseCards = new ArrayList<Deck.Card>();
		ArrayList<Deck.Card> playerCards = new ArrayList<Deck.Card>();
		playerCards.add(deck.drawCard());
		houseCards.add(deck.drawCard());
		playerCards.add(deck.drawCard());
		houseCards.add(deck.drawCard());

		return new ArrayList<Player>(Stream.of(new Player(houseCards, "house"), new Player(playerCards, "user"))
				.collect(Collectors.toList()));
	}

	private static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
}
