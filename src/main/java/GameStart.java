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
			Deck.Card hc = deck.drawCard();
			Deck.Card hc2 = deck.drawCard();
			System.out.println(hc.num + hc.suit + " " + hc2.num + hc2.suit);
			Deck.Card pc = deck.drawCard();
			Deck.Card pc2 = deck.drawCard();
			System.out.println(pc.num + pc.suit + " " + pc2.num + pc2.suit);
			System.out.print("Do you want to keep playing (Y/N) ? ");
			response = inputScanner.nextLine().toLowerCase();
		}	
	}
}

