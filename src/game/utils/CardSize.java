package game.utils;

import game.exceptions.DimensionsException;
import game.values.Constants;

public class CardSize {

	@SuppressWarnings("unused")
	static void validateCardSize() throws DimensionsException {

		if (Constants.CARD_HEIGHT < 6 || Constants.CARD_WIDTH < 6) {
			throw new DimensionsException("Invalid card size! Card too small.");
		}

	}

}
