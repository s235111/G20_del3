package game;

import java.util.Random;

public class Die {

	private int value;
	private int sides;
	private Random random = new Random();

	public Die() {
		sides = 6;
	}

	public Die(int sides) {
		this.sides = sides;
	}

	public void roll() {
		value = random.nextInt(sides) + 1;
	}

	public int getValue() {
		return value;
	}

}
