package game;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import game.chancecards.*;

public class ChanceCardDeck {
	private ArrayDeque<ChanceCard> cards;
	private ArrayList<ChanceCard> discardPile;

	public ChanceCardDeck() {
		cards = new ArrayDeque<ChanceCard>();
		discardPile = new ArrayList<ChanceCard>(List.of(
			new Birthday(),
			new GetOutOfJailFree(),
			new Homework(),
			new MoveBy1OrPickAnotherCard(),
			new MoveToPromenade(),
			new MoveToStartAndGetMoney(),
			new MoveUpTo5Squares(),
			new SkateParkFreeSquare(),
			new TooManySweets(),
			new ColorFreeSquare("Red"),
			new ColorFreeSquare("Gold"),
			new ColorFreeSquare("Cyan"),
			new ColorFreeSquare("Gold", "Green"),
			new ColorFreeSquare("Pink", "Blue"),
			new ColorFreeSquare("Cyan", "Red"),
			new ColorFreeSquare("Brown", "Yellow")
		));
		reshuffleDiscardPile();
	}

	public void reshuffleDiscardPile() {
		Random random = new Random();
		int index;
		for (int i = discardPile.size() - 1; i >= 0; i--) {
			index = random.nextInt(i);
			cards.add(discardPile.remove(index));
		}
	}

	public ChanceCard pullCard() {
		if (cards.size() == 0) {
			reshuffleDiscardPile();
		}
		ChanceCard card = cards.remove();
		discardPile.add(card);
		return card;
	}
}
