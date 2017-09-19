package game.utils;

import java.util.ArrayList;

import game.Card;
import game.values.Constants;

@SuppressWarnings("unused")

public class DeckBuilder extends CardPartBuilder {

	private static StringBuilder[] AllCArds;

	private static void init() {
		AllCArds = generateEmptyArray();
	}

	/**
	 * add cards for left player
	 */
	private static void addLeftPlayerCards(ArrayList<Card> cards) {
		AllCArds = addCardBorder(AllCArds, "left");
		for (int i = 0; i < (cards.size() - 1); i++) {
			AllCArds = addLeftCardPart(AllCArds, cards.get(i).getSymbolOfColor(), cards.get(i).getSymbolOfType());
			AllCArds = addCardBorder(AllCArds, "middle");
		}
		AllCArds = addLeftCardPart(AllCArds, cards.get(cards.size() - 1).getSymbolOfColor(), cards.get(cards.size() - 1).getSymbolOfType());
		AllCArds = addRightCardPart(AllCArds, cards.get(cards.size() - 1).getSymbolOfColor(), cards.get(cards.size() - 1).getSymbolOfType());
		AllCArds = addCardBorder(AllCArds, "right");
	}

	/**
	 * add cards for right player
	 */
	private static void addRightPlayerCards(ArrayList<Card> cards) {
		AllCArds = addCardBorder(AllCArds, "left");
		AllCArds = addLeftCardPart(AllCArds, cards.get(cards.size() - 1).getSymbolOfColor(), cards.get(cards.size() - 1).getSymbolOfType());
		AllCArds = addRightCardPart(AllCArds, cards.get(cards.size() - 1).getSymbolOfColor(), cards.get(cards.size() - 1).getSymbolOfType());
		for (int i = 0; i < (cards.size() - 1); i++) {
			AllCArds = addRightCardPart(AllCArds, cards.get(i).getSymbolOfColor(), cards.get(i).getSymbolOfType());
			AllCArds = addCardBorder(AllCArds, "middle");
		}
		AllCArds = addCardBorder(AllCArds, "right");
	}

	/**
	 * add space between cards
	 */
	private static void addSpaces() {
		for (int i = 0; i < AllCArds.length; i++) {
			for (int e = 1; e <= Constants.DECK_PLAYER_SPACE; e++) {
				AllCArds[i].append(" ");
			}
		}
	}

	private static void build(ArrayList<Card> player1, ArrayList<Card> player2) { //Start/Main!
		try {
			CardSize.validateCardSize();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.err.println("Closing Program!");
			System.exit(0);
		}

		init(); //set the array size
		addLeftPlayerCards(player1);
		addSpaces();
		addLeftPlayerCards(player2);
	}

	public static StringBuilder[] getAllCards(ArrayList<Card> player1, ArrayList<Card> player2) {
		build(player1, player2);
		return AllCArds;
	}

}
