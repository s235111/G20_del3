package game.chancecards;

import game.GameController;
import game.Player;

public class MoveUpTo5Squares implements ChanceCard {
	@Override
	public String getDescription() {
		return "Move forward by up to 5 squares.";
	}

	@Override
	public void perform(Player player) {
		int numSquares = GameController.getGameBoard().getArray().length;
		System.out.println("The squares in front of you are:");
		for (int i = 1; i <= 5; i++) {
			System.out.println(" - " + GameController.getGameBoard()
				.getSquare((player.getPosition() + i) % numSquares).toString());
		}
		var scanner = new java.util.Scanner(System.in);
		int input;
		while (true) {
			System.out.print("How many do you want to move by? [1-5]: ");
			try {
				input = Integer.parseInt(scanner.nextLine());
			} catch (Exception e) {
				System.out.println("That wasn't a valid number, try again");
				continue;
			}
			if (input >= 1 && input <= 5)
				break;
			System.out.println("The number has to be in the range 1-5, try again");
		}
		player.move(input);
		GameController.handleSquare(player);
	}
}
