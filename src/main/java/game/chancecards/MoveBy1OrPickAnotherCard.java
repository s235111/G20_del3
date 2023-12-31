package game.chancecards;

import game.Player;
import game.GameController;

public class MoveBy1OrPickAnotherCard implements ChanceCard {
	@Override
	public String getDescription() {
		return "Move forward by 1 or take another chance card.";
	}

	@Override
	public void perform(Player player) {
		System.out.println("The square in front of you is: " + GameController.getGameBoard()
			.getSquare((player.getPosition() + 1) % GameController.getGameBoard().getArray().length).toString());
		var scanner = new java.util.Scanner(System.in);
		String input;
		while (true) {
			System.out.print("[Y] Move forward, [N] Take another: ");
			input = scanner.nextLine().toLowerCase();
			if (input.equals("y") || input.equals("n"))
				break;
			System.out.println("That wasn't a valid input, try again");
		}
		if (input.equals("y")) {
			player.move(1);
			GameController.handleSquare(player);
		} else {
			GameController.drawChanceCard(player);
		}
	}
}
