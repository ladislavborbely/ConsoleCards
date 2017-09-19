package game.values;

public enum CardColor {
	//srdce ♥,pika ♠,kriz ♣,karo - bolo spomenute ze v enume sa ne-konstatnty daju akceptobvat
	SRDCE('♥'), PIKA('♠'), KRIZ('♣'), KARO('♦');

	private char symbol;

	private CardColor(char symbol) {
		this.symbol = symbol;
	}

	public char getColorSymbol() {
		return symbol;
	}

}