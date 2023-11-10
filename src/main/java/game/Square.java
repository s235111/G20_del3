package game;

public class Square {

	String nameToken;
	int price;
	boolean chancesquare;
	boolean start;
	boolean prison;
	boolean visiting;
	boolean parking;
	String color;

	public Square() {

	}

	public Square(String nameToken, int price, boolean chancesquare, boolean start, boolean prison,
			boolean visiting, boolean parking, String color) {
		this.nameToken = nameToken;
		this.price = price;
		this.chancesquare = chancesquare;
		this.start = start;
		this.prison = prison;
		this.visiting = visiting;
		this.parking = parking;
		this.color = color;
	}

	public String getNameToken() {
		return this.nameToken;
	}

	public void setNameToken(String newName) {
		this.nameToken = newName;
	}

	public int getMoneyValue() {
		return this.price;
	}

	public void setMoneyValue(int newValue) {
		this.price = newValue;
	}

	public boolean getExtraTurn() {
		return this.chancesquare;
	}
}
