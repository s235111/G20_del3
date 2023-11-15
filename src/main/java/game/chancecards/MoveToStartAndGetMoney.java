package game.chancecards;

import game.Player;
import game.Bank;

public class MoveToStartAndGetMoney implements ChanceCard {
	@Override
	public String getDescription() {
		return "Advance to START. Receive M2.";
	}

	@Override
	public void perform(Player player) {
		player.setPosition(0);
		Bank.deposit(player, 2);
	}
}
