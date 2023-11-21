package game.chancecards;

import game.Player;
import game.GameController;
import game.Square;
import game.Bank;

public class ColorFreeSquare implements ChanceCard{
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
	public void perform(Player player) throws IllegalArgumentException{
		int i = player.getPosition();
		Square square;
		while (true) {
			i = (i + 1) % 24;
			square = GameController.getGameBoard().getSquare(i);
			if (square.getColour().equals(color1) || square.getColour().equals(color2)) {
				break;
			}
			// Make sure we don't have an infinite loop if the colour(s) aren't on the board
			if (i == player.getPosition()) {
				throw new IllegalArgumentException("Couldn't find given colour(s) on the board");
			}
		}
		player.setPosition(i);
		if (square.getOwner() == null) {
			square.setOwner(player);
		} else {
			Bank.payRent(player, square);
		}
	}

	public String getColor1() {
		return color1;
	}

	public void setColor1(String color1) {
		this.color1 = color1;
	}

	public String getColor2() {
		return color2;
	}

	public void setColor2(String color2) {
		this.color2 = color2;
	}
}
