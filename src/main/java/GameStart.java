import java.util.Scanner;

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
			Deck.Card c = deck.drawCard();
			System.out.print(c.num + " " + c.suit + " " + c.value);
			System.out.println();
			System.out.print("Do you want to keep playing (Y/N) ? ");
			response = inputScanner.nextLine().toLowerCase();
		}	
	}
}

