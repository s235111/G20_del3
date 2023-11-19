package game;

public class Bank {
	public static void deposit(Player player, int money) {
		player.getAccount().deposit(money);
	}

	public boolean withdraw(Player player, int money) {
		if (player.getAccount().withdraw(money)) {
			player.getBalance().withdraw(money);
			return true;
		} else
			return false;

	}

	public static void payPlayer(Player player1, Player player2, int money){
		player1.getAccount().withdraw(money);
		player2.getAccount().deposit(money);
	}

	public static void payGo(Player player){
		player.getAccount().deposit(2);
	}

    public static void payRent(Player player, Square square){
        var owner = square.getOwner();
        var rent = square.getRent();

        owner.getAccount().deposit(rent);
        player.getBalance().withdraw(rent);
    }

    public static void transferSquare(Player player, Square square){
        square.setOwner(player);
    }

    
	
}
