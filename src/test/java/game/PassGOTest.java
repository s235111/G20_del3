package game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PassGOTest {
	@Test
	public void testPassingGO() {
		Player player = new Player("Boat");
		GameController.addPlayer(player);
		player.setBalance(10);
		assertEquals(10, player.getBalance());

		player.setPosition(GameController.getGameBoard().getArray().length - 2);
		player.move(1);
		assertEquals(12, player.getBalance(), "Landing on GO didn't pay out");

		player.setPosition(GameController.getGameBoard().getArray().length - 2);
		player.move(2);
		assertEquals(14, player.getBalance(), "Passing GO without landing didn't pay out");
	}
}
