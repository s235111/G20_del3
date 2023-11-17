package game.chancecards;

import game.Player;
import game.Bank;

public class Homework implements ChanceCard {
	@Override
	public String getDescription() {
		return "You did all your homework! Receive M2 from the bank.";
	}

	@Override
	public void perform(Player player) {
		Bank.deposit(player, 2);
	}
}
