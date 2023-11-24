package game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class GoToJailTest {
	@Test
	public void testGoingToJail() {
		Player player = new Player("Boat");
		GameController.addPlayer(player);
		assertEquals("prison",
			GameController.getGameBoard().getSquare(18).getType(),
			"Expected square of index 18 to be a 'Go to jail' square");
		assertFalse(player.getInJail(), "Didn't expect player to be in jail by default");
		player.move(18);
		GameController.handleSquare(player);
		assertTrue(player.getInJail(), "Landing on 'Go to jail' didn't put player in jail");
	}
}
