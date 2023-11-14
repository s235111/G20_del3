package game;

public class Square {

	String nameToken;
	int value;
	int index;
	String type;
	String colour;
	Player owner;

	public Square() {

	}

	public Square(String nameToken, int price, String type, String colour) {
		this.nameToken = nameToken;
		this.value = price;
		this.type = type;
		this.colour = colour;
	}

	public String toString() {
		return this.nameToken + ", " + this.value + ", af typen " + this.type + ", af farven: " + this.colour;
	}

	public String getNameToken() {
		return this.nameToken;
	}

	public void setNameToken(String newName) {
		this.nameToken = newName;
	}

	public int getMoneyValue() {
		return this.value;
	}

	public void setMoneyValue(int newValue) {
		this.value = newValue;
	}

	public String getType() {
		return this.type;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public Player getOwner() {
		return this.owner;
	}
}
