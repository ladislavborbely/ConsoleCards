package game.utils;

import java.util.ArrayList;

import game.Card;

public class PrintAllCards {

	public static void printAll(ArrayList<Card> player1, ArrayList<Card> player2) {
		StringBuilder[] allCards = DeckBuilder.getAllCards(player1, player2);

		for (StringBuilder row : allCards) {
			System.out.println(row);
		}
	}
}
