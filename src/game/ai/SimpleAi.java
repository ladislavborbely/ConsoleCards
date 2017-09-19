package game.ai;

public class SimpleAi implements Ai {

	@Override
	public boolean nextCard(int handValue){
		if (handValue < 14)
			return true;
		else return false;
	}

}
