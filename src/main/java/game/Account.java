package game;

public class Account {

	private int balance;

	public Account() {
		this.balance = 0;
	}

	// Sets start balance acording to number of players
	public Account(int players) {
		switch (players) {
			case 2:
				this.balance = 20;
				break;
			case 3:
				this.balance = 18;
				break;

			case 4:
				this.balance = 16;
				break;
			default:
				break;
		}
	}

	public int getBalance() {
		return this.balance;
	}

	public void deposit(int amount) {
		this.balance += amount;
	}

	public boolean withdraw(int amount) {
		this.balance -= amount;
		if (balance < 0) {
			balance = 0;
			return false;
		}
		return true;
	}

	public void setBalance(int amount) {
		this.balance = amount;
	}
}
