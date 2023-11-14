package game;

public class GameBoard {
	public Square[] squares = new Square[] {
			new Square("Start", 0, "start", null),
			new Square("Burgerjoint", 1, "square", "Brown"),
			new Square("Pizzaria", 1, "square", "Brown"),
			new Square("Chance", 0, "chance", null),
			new Square("Candystore", 1, "square", "Cyan"),
			new Square("Icecreamstore", 1, "square", "Cyan"),
			new Square("Visit", 0, "visit", null),
			new Square("Museum", 2, "square", "Pink"),
			new Square("Library", 2, "square", "Pink"),
			new Square("Chance", 0, "chance", null),
			new Square("Skaterpark", 2, "square", "Gold"),
			new Square("Swimmingpool", 2, "square", "Gold"),
			new Square("Parking", 0, "parking", null),
			new Square("Casino", 3, "square", "Red"),
			new Square("Movietheater", 3, "square", "Red"),
			new Square("Chance", 0, "chance", null),
			new Square("Toystore", 3, "square", "Yellow"),
			new Square("Animalshop", 3, "square", "Yellow"),
			new Square("Prison", 3, "prison", null),
			new Square("Bowlinghall", 4, "square", "Green"),
			new Square("Zoo", 4, "square", "Green"),
			new Square("Chance", 0, "chance", null),
			new Square("Waterpark", 5, "square", "Blue"),
			new Square("The beach", 5, "square", "Blue"),

	};

	public Square getSquare(int index) {
		return squares[index];
	}

	public Square[] getArray() {
		return squares;
	}

	public String toString() {
		String list = "";
		for (Square i : squares) {
			list += i.toString();
			list += System.lineSeparator();
		}
		return list;
	}

	public Square[] getSquaresOwnedBy(Player player) {
		Square[] owned = new Square[24];
		int j = 0;
		for (Square i : squares) {
			if (i.owner.equals(player)) {
				owned[j] = i;
			}
			j++;
		}
		return owned;
	}
}
