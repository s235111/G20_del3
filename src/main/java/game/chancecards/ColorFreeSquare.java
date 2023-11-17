package game.chancecards;

import game.Player;
import game.GameBoard;

public class ColorFreeSquare implements ChanceCard {
	private String color1;
	private String color2;

	public ColorFreeSquare(String fieldColor) {
		this.color1 = fieldColor;
	}

	public ColorFreeSquare(String color1, String color2) {
		this.color1 = color1;
		this.color2 = color2;
	}

	@Override
	public String getDescription() {
		return "Advance to a " + color1 + (color2 != null ? " or " + color2 : "") + " square."
				+ "\nIf it's vacant, get it for FREE! Otherwise, PAY rent to the owner.";
	}

	@Override
	public void perform(Player player) {
		// feosjf
	}
}
