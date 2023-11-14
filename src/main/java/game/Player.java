package game;

class Player {

	private String name;
	private Account account;
	private Square[] owned = new Square[24];

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

	public void addProperty(Square property) {
		for (int i = 0; i < owned.length; i++) {
			if (owned[i] == null) {
				owned[i] = property;
				break;
			}

		}
	}

}
