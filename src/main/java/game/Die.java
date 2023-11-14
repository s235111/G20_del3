package game;

import java.util.Random;

public class Die {

	private int value;
	private Random random = new Random();

	public Die() {
	}

	public void roll() {
		value = random.nextInt(6) + 1;
	}

	public int getValue() {
		return value;
	}

}
