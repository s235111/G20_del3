package game;

public class Bank {
	public static void deposit(Player player, int money) {
		player.setBalance(player.getBalance() + money);;
	}

	public static boolean withdraw(Player player, int money) {

		if (player.getBalance() - money >= 0){
			player.setBalance(player.getBalance() - money);
			return true;
		}else {
			return false;
		}
	}

	public static void payPlayer(Player player1, Player player2, int money){

		if (Bank.withdraw(player1, money)){
			Bank.deposit(player2, money);
		}

	}

	public static void payGo(Player player){
		Bank.deposit(player, 2);
	}

    public static void payRent(Player player, Square square){
        var owner = square.getOwner();
        var rent = square.getValue();

		if (owner != null){
			if (Bank.withdraw(player, rent)){
				Bank.deposit(owner, rent);
			}
		}
    }

    public static void transferSquare(Player player, Square square){
        square.setOwner(player);
    }



}
