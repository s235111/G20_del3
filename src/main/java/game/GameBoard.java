package game;

public class GameBoard {
	public Square[] squares = new Square[] {
			new Square("Start", 0, false, true, false, false, false, null),
			new Square("Burgerjoint", 1, false, false, false, false, false, "Brown"),
			new Square("Pizzaria", 1, false, false, false, false, false, "Brown"),
			new Square("Chance", 0, true, false, false, false, false, null),
			new Square("Candystore", 1, false, false, false, false, false, "Cyan"),
			new Square("Icecreamstore", 1, false, false, false, false, false, "Cyan"),
			new Square("Visit", 0, false, false, false, true, false, null),
			new Square("Museum", 2, false, false, false, false, false, "Pink"),
			new Square("Library", 2, false, false, false, false, false, "Pink"),
			new Square("Chance", 0, true, false, false, false, false, null),
			new Square("Skaterpark", 2, false, false, false, false, false, "Gold"),
			new Square("Swimmingpool", 2, false, false, false, false, false, "Gold"),
			new Square("Parking", 0, false, false, false, false, true, null),
			new Square("Casino", 3, false, false, false, false, false, "Red"),
			new Square("Movietheater", 3, false, false, false, false, false, "Red"),
			new Square("Chance", 0, true, false, false, false, false, null),
			new Square("Toystore", 3, false, false, false, false, false, "Yellow"),
			new Square("Animalshop", 3, false, false, false, false, false, "Yellow"),
			new Square("Prison", 3, false, false, true, false, false, null),
			new Square("Bowlinghall", 4, false, false, false, false, false, "Green"),
			new Square("Zoo", 4, false, false, false, false, false, "Green"),
			new Square("Chance", 0, true, false, false, false, false, null),
			new Square("Waterpark", 5, false, false, false, false, false, "Blue"),
			new Square("The beach", 5, false, false, false, false, false, "Blue"),

	};

	public Square getSquare(int index) {
		return squares[index];
	}

	public Square[] getArray() {
		return squares;
	}

	public String toString() {
		String temp = "";
		for (var i : squares) {

			temp += i.nameToken + ", " + i.price + ", " + (i.chancesquare ? "Is a chance Square" : "")
					+ (i.start ? "Is a start square" : "") + (i.prison ? "Its the prison" : "")
					+ (i.visiting ? "Visit prison square" : "") + (i.parking ? "Its the parking square" : "");
		}
		return temp;
	}
}
