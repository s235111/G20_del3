package game.chancecards;

import game.Player;

public interface ChanceCard {
	public String getDescription();

	public void perform(Player player);
}
