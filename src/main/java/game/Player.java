package game;

class Player {

	public boolean inJail;
	private Account account;
	private int position;
	// Should this be a seperate method or part of constructor??
	private String piece;

	// Constructor
	public Player() {
		this.account = new Account();
		this.position = 0;
		this.inJail = false;
	}

	// Constructor with name overload
	public Player(String piece) {
		this.inJail = false;
		this.account = new Account();
		this.position = 0;
		this.piece = piece;
	}

	public int move(int amount) {
		this.position += amount;
		return this.position;
	}

	public int getPosition() {
		return this.position;
	}

	public void setPosition(int pos) {
		this.position = pos;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setPiece(String piece) {
		this.piece = piece;
	}

	public String getPiece() {
		return this.piece;
	}
}
