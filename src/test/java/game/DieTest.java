package game;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DieTest {
	@Test
	public void testDie() {
		Die die = new Die();
		int[] frequencies = new int[6];

		for (int i = 0; i < 10000; i++) {
			die.roll();
			frequencies[die.getValue() - 1]++;
		}

		int sum = 0;
		boolean ok;
		for (int i = 0; i < 6; i++) {
			ok = frequencies[i] >= 1400 && frequencies[i] <= 2000;
			System.out.println("[" + (ok ? " OK " : "FAIL") + "] # of " + (i + 1) + ": " + frequencies[i] + " times");
			assertTrue(ok, "Number of " + (i + 1) + "'s didn't fall within expected range");
			sum += (i + 1) * frequencies[i];
		}

		ok = sum >= 30000 && sum <= 40000;
		System.out.println("[" + (ok ? " OK " : "FAIL") + "] Sum: " + sum);
		assertTrue(ok, "Sum didn't fall within expected range");
	}
}
