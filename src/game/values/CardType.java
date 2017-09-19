package game.values;


public enum CardType {
	SEDEM("7", (byte) 7), OSEM("8", (byte) 8), DEVAT("9", (byte) 9), DESAT("10", (byte) 10), JACK("J", (byte) 1), QUEEN("Q", (byte) 1), KING("K", (byte) 1), ACE("A", (byte) 11);

	private String symbol;
	private byte value;

	CardType(String symbol, byte value) {
		this.symbol = symbol;
		this.value = value;
	}

	public String getSymbol() {
		return symbol;
	}

	public byte getValue() {
		return value;
	}

}