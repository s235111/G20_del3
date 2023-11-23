package game;

public class Player {

	private boolean inJail;
	private int position;
	// Should this be a seperate method or part of constructor??
	private String piece;
	private boolean HasGetOutOfJailFreeCard;
	private int balance;

	// Constructor
	public Player() {

		this.position = 0;
		this.inJail = false;
		this.HasGetOutOfJailFreeCard = false;
	}

	// Constructor with name overload
	public Player(String piece) {
		this.inJail = false;
		this.position = 0;
		this.piece = piece;
		this.HasGetOutOfJailFreeCard = false;
	}

	public int move(int amount) {
		int boardSize = GameController.getGameBoard().getArray().length;
		if (this.position + amount > boardSize){
			System.out.println("You passed go and get $2");
			Bank.payGo(this);
		}
		this.position = (this.position + amount) % boardSize;
		return this.position;
	}

	public int getPosition() {
		return this.position;
	}

	public void setPosition(int pos) {
		this.position = pos;
	}

	public void setPiece(String piece) {
		this.piece = piece;
	}

	public String getPiece() {
		return this.piece;
	}

	public boolean getInJail() {
		return this.inJail;
	}

	public void setInJail(boolean inJail) {
		this.inJail = inJail;
	}

	public boolean getHasGetOutOfJailFreeCard() {
		return this.HasGetOutOfJailFreeCard;
	}

	public void setHasGetOutOfJailFreeCard(boolean HasGetOutOfJailFreeCard) {
		this.HasGetOutOfJailFreeCard = HasGetOutOfJailFreeCard;
	}

	public int getBalance() {
		return this.balance;
	}

	public void setBalance(int amount) {
		this.balance = amount;
	}

	public String toString(){
		if (this.piece != null){
			return this.piece;
		} else {
			return "";
		}
	}
}
