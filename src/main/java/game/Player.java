package game;

class Player {

	private String name;
	private Account account;

	// Should this be a seperate method or part of constructor??
	private char icon;

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

	public void setIcon(char icon) {
		this.icon = icon;
	}

	public char getIcon() {
		return this.icon;
	}
	// public void addProperty(Square property) {
	// for (int i = 0; i < this.owned.length; i++) {
	// if (this.owned[i] == null) {
	// this.owned[i] = property;
	// break;
	// }
	//
	// }
	// }
	//
	// public Square[] getProperties() {
	// return this.owned;
	// }
}
