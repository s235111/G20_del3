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

	public void showOwnedBy(Player player) {
		for (Square i : squares) {
			if (i.owner == (player)) {
				System.out.println(i.toString());
			}
		}
	}

	public void showPlayerPath(Player player, int index) {
		String list = "";
		for (int i = squares[player.getPosition()].index; i != index; i = (i + 1) % 24) {
			list = squares[i].toString();
			System.out.println(list);
		}
	}
}
