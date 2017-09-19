package game;

import java.util.ArrayList;

public class Player {
	private String name;
	private ArrayList<Card> hand = new ArrayList<>();
	private int handValue = 0;
	private boolean lastChoice = true;

	public Player(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addCard(Card card) {
		hand.add(card);
		handValue += card.getValue();
	}

	public void discardCards() {
		hand = new ArrayList<>();
		handValue = 0;
		lastChoice = true;
	}

	public boolean getLastChoice() {
		return lastChoice;
	}

	public void setLastChoice(boolean choice) {
		this.lastChoice = choice;
	}

	public String getName() {
		return name;
	}

	public int getHandValue() {
		return handValue;
	}

	public ArrayList<Card> getCards() {
		return hand;
	}

}
