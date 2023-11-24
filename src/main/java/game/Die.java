package game;

import java.util.Random;

public class Die {

	private int value;
	private Random random = new Random();

	public Die() {
	}

	public void roll() {
		this.value = random.nextInt(6) + 1;
	}

	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
