package game.chancecards;

import game.GameBoard;
import game.Player;
import game.Bank;

public class SkateParkFreeSquare implements ChanceCard {
	@Override
	public String getDescription() {
		return "Advance to the Skate Park to perfect your flip! If no one owns it, get it for FREE! Otherwise, PAY rent to the owner.";
	}

	@Override
	public void perform(Player player) {
		player.setPosition(10);
		var skatePark = GameBoard.getSquare(10);
		if (skatePark.getOwner() == null) {
			skatePark.setOwner(player);
		} else {
			Bank.payRent(player, skatePark);
		}
	}
}
