package game.chancecards;

import game.Player;

public class MoveUpTo5Squares implements ChanceCard {
	@Override
	public String getDescription() {
		return "Move forward by up to 5 squares.";
	}

	@Override
	public void perform(Player player) {
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
		scanner.close();
		player.move(input);
	}
}
