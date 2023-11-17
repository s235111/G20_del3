package game.chancecards;

import game.GameController;
import game.Player;
import game.Bank;

public class Birthday implements ChanceCard {
	@Override
	public String getDescription() {
		return "It's your birthday! Everyone gives you M1.\nHAPPY BIRTHDAY!";
	}

	@Override
	public void perform(Player player) {
		var players = GameController.getPlayers();
		for (var otherPlayer : players) {
			if (otherPlayer != player) {
				Bank.payPlayer(otherPlayer, player, 1);
			}
		}
	}
}
