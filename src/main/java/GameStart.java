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
		while(response.equals("y")) {
			System.out.println("Game is Starting!");
			ArrayList<Deck.Card> houseCards = new ArrayList<Deck.Card>();
			houseCards.add(deck.drawCard());
			houseCards.add(deck.drawCard());
			System.out.println(houseCards.get(0).num + houseCards.get(0).suit + " " + houseCards.get(1).num + houseCards.get(1).suit);
			Player house = new Player(houseCards); 
			ArrayList<Deck.Card> playerCards = new ArrayList<Deck.Card>();
			playerCards.add(deck.drawCard());
			playerCards.add(deck.drawCard());
			System.out.println(playerCards.get(0).num + playerCards.get(0).suit + " " + playerCards.get(1).num + playerCards.get(1).suit);
			Player user = new Player(playerCards);
			int houseResult = house.getHandValue();
			int userResult = user.getHandValue();
			System.out.println("House result: " + houseResult + " | User result: " + userResult);
			if (houseResult > userResult) System.out.println("House wins");
			else if (userResult > houseResult) System.out.println("User wins");
			else System.out.println("Push");
			System.out.print("Do you want to keep playing (Y/N) ? ");
			response = inputScanner.nextLine().toLowerCase();
		}	
	}
}

