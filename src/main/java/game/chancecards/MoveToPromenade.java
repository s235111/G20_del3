package game.chancecards;

import game.GameController;
import game.Player;

public class MoveToPromenade implements ChanceCard {
	@Override
	public String getDescription() {
		return "Advance to the Promenade.";
	}

	@Override
	public void perform(Player player) {
		player.setPosition(23);
		GameController.handleSquare(player);
	}
}
