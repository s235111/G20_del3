package game;

public class Square {

	String name;
	int value;
	String colour;
	int index;
	Player owner;
	String type;

	public Square() {

	}

	public Square(String name, int price, String type, String colour) {
		this.name = name;
		this.value = price;
		this.type = type;
		this.colour = colour;
	}

	public String toString() {
		return this.name + ", " + this.value + ", af typen " + this.type + ", af farven: " + this.colour;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String newName) {
		this.name = newName;
	}

	public int getValue() {
		return this.value;
	}

	public void setValue(int newValue) {
		this.value = newValue;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public Player getOwner() {
		return this.owner;
	}

	public int getIndex() {
		return this.index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getColour() {
		return this.colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}
}
