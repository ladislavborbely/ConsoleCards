package game;

import java.util.ArrayList;
import java.util.Random;

import game.exceptions.NoCardException;
import game.values.CardColor;
import game.values.CardType;

public class Deck {
	private ArrayList<Card> deck = new ArrayList<>();
	private Random rand = new Random();

	public Deck() {
		generate();
		shuffle();
	}

	private void generate() {
		deck.clear();
		for (CardColor color : CardColor.values()) { //of each color
			for (CardType nameValue : CardType.values()) { //of each type
				deck.add(new Card(nameValue, color));
			}
		}
	}

	private void shuffle() { //this simulates real life shuffle, random cards are moved to new pile
		ArrayList<Card> shuffledDeck = new ArrayList<>();
		int randNumber;
		while (deck.size() > 0) {
			randNumber = rand.nextInt(deck.size());
			shuffledDeck.add(deck.get(randNumber));
			deck.remove(randNumber);
		}
		deck = shuffledDeck;
	}

	public void showDeck() {
		System.out.println('\n');
		for (Card card : deck)
			System.out.println(card.toString());
		System.out.println('\n');
	}

	public Card getNextCard() throws NoCardException {
		if (deck.size() == 0) {
			throw new NoCardException("No cards left in the deck!");
		}
		Card nextCard;
		nextCard = deck.get(0);
		deck.remove(0);
		return nextCard;
	}
}
