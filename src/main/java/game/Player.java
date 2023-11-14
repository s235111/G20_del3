package game;

class Player {

	private String name;
	private Account account;
	private Square[] owned;

	// Constructor
	public Player() {
		this.name = "";
		this.account = new Account();
		this.owned = new Square[24];
	}

	// Constructor with name overload
	public Player(String givenName) {
		this.name = givenName;
		this.account = new Account();
		this.owned = new Square[24];
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

	public void addProperty(Square property) {
		for (int i = 0; i < this.owned.length; i++) {
			if (this.owned[i] == null) {
				this.owned[i] = property;
				break;
			}

		}
	}

	public Square[] getProperties() {
		return this.owned;
	}
}
