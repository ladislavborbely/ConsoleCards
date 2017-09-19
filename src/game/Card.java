package game;

import game.values.CardColor;
import game.values.CardType;

public class Card {
	private final CardType type;
	private CardColor color;

	public Card(CardType name, CardColor color) {
		this.type = name;
		this.color = color;
	}

	/**
	 * String: 7,8,9,10,J,Q,K,A
	 * @return
	 */
	public String getSymbolOfType() {
		return type.getSymbol();
	}

	/**
	 * char: ♥ ♠ ♣ ♦
	 * @return
	 */
	public char getSymbolOfColor() {
		return color.getColorSymbol();
	}

	/**
	 * byte: value
	 * @return
	 */
	public byte getValue() {
		return type.getValue();
	}

	@Override
	public String toString() {
		return "Card symbol:" + getSymbolOfType() + " color:" + getSymbolOfColor() + " value:" + getValue();
	}

}
