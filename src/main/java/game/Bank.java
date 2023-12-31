package game;

import java.util.Scanner;

public class Bank {
	public static void deposit(Player player, int money) {
		player.setBalance(player.getBalance() + money);
	}

	public static boolean withdraw(Player player, int money) {
		if (player.getBalance() - money >= 0) {
			player.setBalance(player.getBalance() - money);
			return true;
		} else {
			return false;
		}
	}

	public static void payPlayer(Player player1, Player player2, int money) {
		if (Bank.withdraw(player1, money)) {
			Bank.deposit(player2, money);
		}
	}

	public static void payGo(Player player) {
		Bank.deposit(player, 2);
	}

	public static void payRent(Player player, Square square) {
		var owner = square.getOwner();
		var rent = square.getValue();

		if (owner != null) {
			if (bothPropertiesOwned(square)) {
				rent *= 2;
			}
			System.out.println("You have to pay $" + rent + " to " + owner);
			if (Bank.withdraw(player, rent)) {
				Bank.deposit(owner, rent);
			} else {
				int missingRent = rent - player.getBalance();
				if (playerHasPortfolioOf(player, missingRent)) {
					sellSquaresForRent(player, square, missingRent);
				} else {
					System.out.println("player cant pay \n");
					player.setBalance(0);
					GameController.endGameEvaluation();
				}
			}
		}
	}

	public static void transferSquare(Player player, Square square) {
		square.setOwner(player);
	}

	public static void payGameStart(Player[] players) {
		payAll(players, switch (players.length) {
			case 2 -> 20;
			case 3 -> 18;
			case 4 -> 16;
			default -> 10;
		});
	}

	private static void payAll(Player[] players, int money) {
		for (Player player : players) {
			Bank.deposit(player, money);
		}
	}

	private static boolean bothPropertiesOwned(Square square) {
		for (Square s : GameController.getGameBoard().getArray()) {
			if (square != s && square.getColour() == s.getColour()) {
				return square.getOwner() == s.getOwner();
			}
		}
		return false;
	}

	private static void sellSquaresForRent(Player player, Square square, int missingRent) {
		Scanner scanner = new Scanner(System.in);
		while (missingRent > 0 && playerHasPortfolioOf(player, missingRent)) {
			System.out.println("You need to sell a property for a value of: " + missingRent + " Here are your properties:");
			Square[] squares = GameController.getGameBoard().getOwnedBy(player);
			for (int i = 0; i < squares.length; i++) {
				System.out.println(i + squares[i].toString());
			}
			System.out.println("Please choose the one property at a time to sell by writing the number to the left of the property, and press Enter");
			int input = scanner.nextInt();
			if (input < squares.length) {
				Square chosenSquare = squares[input];
				missingRent -= chosenSquare.getValue();
				transferSquare(square.getOwner(), chosenSquare);
			}
		}
		if (missingRent < 0) {
			deposit(player, Math.abs(missingRent));
		}
	}

	private static boolean playerHasPortfolioOf(Player player, int missingRent) {
		int totalValue = 0;
		Square[] squares = GameController.getGameBoard().getOwnedBy(player);
		for (Square square : squares) {
			totalValue += square.getValue();
		}
		return totalValue >= missingRent;
	}

	public static int getPortfolio(Player player) {
		int totalValue = 0;
		Square[] squares = GameController.getGameBoard().getOwnedBy(player);
		for (Square square : squares) {
			totalValue += square.getValue();
		}
		return totalValue;
	}
}
