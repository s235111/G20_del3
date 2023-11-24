package game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

public class PayTest {
	@Test
	public void testPaying() {
		Player player1 = new Player("Boat");
		Player player2 = new Player("Dog");
		GameController.addPlayer(player1);
		GameController.addPlayer(player2);
		player1.setBalance(10);
		player2.setBalance(10);
		player1.setPosition(6);
		player2.setPosition(6);
		assertEquals(10, player1.getBalance());
		assertEquals(10, player2.getBalance());
		assertEquals(6, player1.getPosition());
		assertEquals(6, player2.getPosition());

		GameBoard board = GameController.getGameBoard();
		Square square = board.getSquare(7);
		assertEquals("square", square.getType(), "Expected square 7 to be a property");

		assertNull(square.getOwner());
		player1.move(1);
		GameController.handleSquare(player1);
		assertSame(player1, square.getOwner(), "First player didn't become owner of square");
		assertEquals(10 - square.getValue(), player1.getBalance(), "First player didn't pay for property");

		player2.move(1);
		GameController.handleSquare(player2);
		assertSame(player1, square.getOwner(), "Second player got property from first player");
		assertEquals(10 - square.getValue(), player2.getBalance(), "Second player didn't pay rent");
		assertEquals(10, player1.getBalance(), "First player didn't receive rent payment");
	}
}
