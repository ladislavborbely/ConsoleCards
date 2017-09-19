package game.utils;

import game.values.Constants;

/**
 * Class that generates VERTICAL card parts, 
 * methods returns StringBuilder[]
 */

public class CardPartBuilder {

	protected static StringBuilder[] generateEmptyArray() {
		StringBuilder[] array = new StringBuilder[Constants.CARD_HEIGHT];
		for (int i = 0; i < array.length; i++) {
			array[i] = new StringBuilder("");
		}
		return array;
	}

	/**
	 * Add vertical border parts of the card
	 * left, middle, right
	 * ╔		╦		╗
	 * ║		║		║
	 * ║		║		║
	 * ╚		╩		╝
	 * @param position
	 * 		  "left" side of card, "middle" part of card "right" side of card
	 * @return
	 */
	protected static StringBuilder[] addCardBorder(StringBuilder[] cardParts, String position) {
		char top = Constants.MTP;//middle top
		char middle = Constants.VUP;
		char bottom = Constants.MBP;//middle bottom

		if (!position.equals("middle")) {//middle is pre-defined as default(most used)
			switch (position) {
			case "left":
				top = Constants.LTC;
				bottom = Constants.LBC;
				break;
			case "right":
				top = Constants.RTC;
				bottom = Constants.RBC;
				break;
			}
		}
		cardParts[0].append(top);
		for (int i = 1; i < cardParts.length - 1; i++)
			cardParts[i].append(middle);
		cardParts[cardParts.length - 1].append(bottom);

		return cardParts;
	}

	/**
	 * adds left half (without border) of the card
	 */
	protected static StringBuilder[] addLeftCardPart(StringBuilder[] cardParts, char color, String type) {

		cardParts[0].append(generateStringHorizontalBorder());
		cardParts[1].append(generateTypeLeft(type));
		cardParts[2].append(generateColorLeft(color));
		for (int i = 3; i <= Constants.CARD_HEIGHT - 4; i++) {
			cardParts[i].append(generateStringSpaces());
		}
		cardParts[cardParts.length - 3].append(generateColorLeft(color));
		cardParts[cardParts.length - 2].append(generateTypeLeft(type));
		cardParts[cardParts.length - 1].append(generateStringHorizontalBorder());

		return cardParts;
	}

	/**
	 *adds right half (without border) of the card 
	 */
	protected static StringBuilder[] addRightCardPart(StringBuilder[] cardParts, char color, String type) {

		cardParts[0].append(generateStringHorizontalBorder());
		cardParts[1].append(generateTypeRight(type));
		cardParts[2].append(generateColorRight(color));
		for (int i = 3; i <= Constants.CARD_HEIGHT - 4; i++) {
			cardParts[i].append(generateStringSpaces());
		}
		cardParts[cardParts.length - 3].append(generateColorRight(color));
		cardParts[cardParts.length - 2].append(generateTypeRight(type));
		cardParts[cardParts.length - 1].append(generateStringHorizontalBorder());

		return cardParts;
	}

	/**
	 * ROW! For left side
	 * 7,8,9,10,J,Q,K,A
	 */
	private static String generateTypeLeft(String cardType) {
		StringBuilder fill = new StringBuilder("");
		if (cardType.length() == 1)
			fill.append(Constants.BSP);
		fill.append(cardType);
		for (int i = 2; i < Constants.CARD_WIDTH / 2 - 1; i++)
			fill.append(Constants.BSP);
		return fill.toString();
	}

	/**
	 * ROW! For right side
	 * 7,8,9,10,J,Q,K,A
	 */
	private static String generateTypeRight(String cardType) {
		StringBuilder fill = new StringBuilder("");
		for (int i = 2; i < Constants.CARD_WIDTH / 2 - 1; i++)
			fill.append(Constants.BSP);
		fill.append(cardType);
		if (cardType.length() == 1)
			fill.append(Constants.BSP);
		return fill.toString();
	}

	/**
	 * ROW! For left side
	 * ♥ ♠ ♣ ♦
	 */
	private static String generateColorLeft(char cardColor) {
		StringBuilder fill = new StringBuilder("");
		fill.append(Constants.BSP);
		fill.append(cardColor);
		for (int i = 2; i < Constants.CARD_WIDTH / 2 - 1; i++)
			fill.append(Constants.BSP);
		return fill.toString();
	}

	/**
	 * ROW! For right side
	 * ♥ ♠ ♣ ♦
	 */
	private static String generateColorRight(char cardColor) {
		StringBuilder fill = new StringBuilder("");
		for (int i = 2; i < Constants.CARD_WIDTH / 2 - 1; i++)
			fill.append(Constants.BSP);
		fill.append(cardColor);
		fill.append(Constants.BSP);
		return fill.toString();
	}

	/**
	 * Fill ROW with char
	 */
	private static String generateStringFill(char fillWithChar) {
		StringBuilder fill = new StringBuilder(fillWithChar);
		for (int i = 1; i < Constants.CARD_WIDTH / 2 - 0; i++)
			fill.append(fillWithChar);

		return fill.toString();
	}

	/**
	 * Fill ROW with blank spaces
	 */
	private static String generateStringSpaces() {
		return generateStringFill(Constants.BSP);
	}

	/**
	 * Fill ROW with horizontal (universal) border
	 */
	private static String generateStringHorizontalBorder() {
		return generateStringFill(Constants.HUP);
	}

}
