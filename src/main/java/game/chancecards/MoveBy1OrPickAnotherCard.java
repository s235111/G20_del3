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
		var scanner = new java.util.Scanner(System.in);
		String input;
		while (true) {
			System.out.print("[Y] Move forward, [N] Take another: ");
			input = scanner.nextLine().toLowerCase();
			if (input == "y" || input == "n")
				break;
			System.out.println("That wasn't a valid input, try again");
		}
		if (input == "y") {
			player.move(1);
		} else {
			GameController.drawChanceCard(player);
		}
	}
}
