package game.chancecards;

import game.Player;
import game.Bank;

public class TooManySweets implements ChanceCard {
	@Override
	public String getDescription() {
		return "You've eaten too many sweets. PAY M2 to the bank.";
	}

	@Override
	public void perform(Player player) {
		Bank.withdraw(player, 2);
	}
}
