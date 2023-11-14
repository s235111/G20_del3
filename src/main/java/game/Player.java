package game;

class Player {

	private String name;
	private Account account;
	private int position;
	// Should this be a seperate method or part of constructor??
	private String piece;

	// Constructor
	public Player() {
		this.name = "";
		this.account = new Account();
		this.position = 0;
	}

	// Constructor with name overload
	public Player(String givenName) {
		this.name = givenName;
		this.account = new Account();
		this.position = 0;
	}

	public void move(int amount) {
		this.position += amount;
	}

	public int getPosition() {
		return this.position;
	}

	public void setPosition(int pos) {

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

	public void setIcon(String piece) {
		this.piece = piece;
	}

	public String getIcon() {
		return this.piece;
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
