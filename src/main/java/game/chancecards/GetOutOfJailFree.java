package game.chancecards;

import game.Player;

public class GetOutOfJailFree implements ChanceCard {
	@Override
	public String getDescription() {
		return "Get out of jail free. Keep this card until you need it.";
	}

	@Override
	public void perform(Player player) {
		player.setHasGetOutOfJailFreeCard(true);
	}
}
