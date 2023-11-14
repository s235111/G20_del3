package game;

public class Account {

	private int balance;

	public Account() {
		this.balance = 0;
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
