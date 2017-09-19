package game;

import java.util.Scanner;

import game.ai.Ai;
import game.ai.SimpleAi;
import game.exceptions.NoCardException;
import game.utils.PrintAllCards;

public class Game {
	private Scanner sc = new Scanner(System.in);
	Player player1 = new Player(" ");
	Player player2 = new Player("Ai Adam");
	Ai ai = new SimpleAi();
	Deck deck;
	private int roundNr;
	private boolean end = false;

	public void play() {
		while (true) {
			init();
			roundZero();
			while (end != true) {
				round();
			}
			System.out.println(" - - - End of game.\n\n");
		}
	}

	private void init() {

		if (end == true) {
			System.out.println("Press 1 to Start new game, any other key to Exit...");
			String answer = sc.nextLine();
			if (answer.equals("1")) {
				end = false;
			} else {
				System.out.println("Exiting...");
				System.exit(0);
			}
		}

		if (player1.getName().equals(" ")) {
			System.out.print("Enter your name: ");
			player1.setName(sc.nextLine());
		}

		player1.discardCards();
		player2.discardCards();
		deck = new Deck();
	}

	private void roundZero() {
		System.out.println("----------------  NEW GAME ---------------- ");
		try {
			player1.addCard(deck.getNextCard());
			player2.addCard(deck.getNextCard());
			player1.addCard(deck.getNextCard());
			player2.addCard(deck.getNextCard());
		} catch (NoCardException e) {
			e.getMessage();
		}
		roundNr = 0;
		everyTurn();
	}

	/**
	 * echo Winner & looser
	 */
	private void endMessage(Player winner, Player looser) {
		System.out.println();
		System.out.println(" * * * Player " + winner.getName() + " winns! with " + winner.getHandValue() + " * * *");
		System.out.println("       Player " + looser.getName() + " loses! with " + looser.getHandValue() + "  :(");
	}

	private void everyTurn() { // each player 1 turn per round
		PrintAllCards.printAll(player1.getCards(), player2.getCards());
		System.out.println(player1.getName() + " has " + player1.getHandValue() + " and  " + player2.getName() + " has " + player2.getHandValue());
		checkEndConditions();
	}

	private void everyRound() {
		roundNr += 1;
		System.out.println("---------------- " + "Round: " + roundNr + "---------------- ");
	}

	public void round() {
		everyRound();
		if (end != true) {
			takeNextCard(humanPlayerTurn(), player1);
			everyTurn();
		}
		if (end != true) {
			takeNextCard(aiPlayerTurn(), player2);
			everyTurn();
		}
	}

	private void takeNextCard(boolean want, Player player) {
		player.setLastChoice(want);
		if (want == true) {
			System.out.println(player.getName() + ": card please!");
			try {
				player.addCard(deck.getNextCard());
			} catch (Exception e) {
				System.out.println("No more cards in deck!");
			}
		} else {
			System.out.println(player.getName() + ": enought!");
		}
	}

	private boolean humanPlayerTurn() {
		String input;
		System.out.print("Your turn -> Press 1 to add a card, 0 to keep current hand: ");
		input = sc.nextLine();
		switch (input) {
		case "1":
			return true;
		case "0":
			return false;
		default:
			System.out.println("Invalid input! press 1 or 0.");
			humanPlayerTurn();
			break;
		}
		return false;
	}

	private boolean aiPlayerTurn() {
		System.out.println("Ai turn -> ");
		return ai.nextCard(player2.getHandValue());
	}

	private void checkEndConditions() {
		// 21 winner!
		if (player1.getHandValue() == 21) {
			endMessage(player1, player2);
			this.end = true;
		} else if (player2.getHandValue() == 21) {
			endMessage(player2, player1);
			this.end = true;
		}
		// more than 21
		else if (player1.getHandValue() > 21) {
			endMessage(player2, player1);
			this.end = true;
		} else if (player2.getHandValue() > 21) {
			endMessage(player1, player2);
			this.end = true;
		}
		// no1 wants more cards, draw or higher hand wins
		else if (player1.getLastChoice() == false && player2.getLastChoice() == false) {
			if (player1.getHandValue() == player2.getHandValue()) {
				System.out.println("\n ! ! ! Draw ! ! !");
				this.end = true;
			} else if (player1.getHandValue() > player2.getHandValue()) {
				endMessage(player1, player2);
				this.end = true;
			} else {
				endMessage(player2, player1);
				this.end = true;
			}
		}
	}

}
