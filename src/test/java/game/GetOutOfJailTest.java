package game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class GetOutOfJailTest {
	@Test
	public void testGettingOutOfJail() {
		Player player = new Player("Boat");
		GameController.addPlayer(player);
		player.setBalance(10);
		assertEquals(10, player.getBalance());

		player.setInJail(true);
		assertTrue(player.getInJail());
		player.setHasGetOutOfJailFreeCard(true);
		assertTrue(player.getHasGetOutOfJailFreeCard());

		GameController.handleJail(player);
		assertFalse(player.getInJail(), "'Get out of jail free' card didn't get player out of jail");
		assertFalse(player.getHasGetOutOfJailFreeCard(), "'Get out of jail free' card didn't get used");
		assertEquals(10, player.getBalance(), "Player paid bail even though they had a 'Get out of jail free' card");

		player.setInJail(true);
		assertTrue(player.getInJail());

		GameController.handleJail(player);
		assertFalse(player.getInJail(), "Player didn't get out of jail even though they could pay for bail");
		assertFalse(player.getHasGetOutOfJailFreeCard(), "'Player magically obtained a 'Get out of jail free' card by paying bail");
		assertEquals(8, player.getBalance(), "Player didn't pay bail to get out of jail");
	}
}
