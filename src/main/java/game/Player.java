package game;

class Player {

	private String name;
	private Account account;

	// Constructor
	public Player() {
		this.name = "";
		this.account = new Account();
	}

	// Constructor with name overload
	public Player(String givenName) {
		this.name = givenName;
		this.account = new Account();
	}

	public String getName() {
		return this.name;
	}

	public void setName(String nameToSet) {
		this.name = nameToSet;
	}

	public Account getAccount() {
		return this.account;
	}

}
