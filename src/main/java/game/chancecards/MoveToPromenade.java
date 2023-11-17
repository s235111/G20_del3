package game.chancecards;

import game.Player;

public class MoveToPromenade implements ChanceCard {
	@Override
	public String getDescription() {
		return "Advance to the Promenade.";
	}

	@Override
	public void perform(Player player) {
		player.setPosition(23);
	}
}
