package game;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

public class GameController {

	private static Player[] players = new Player[]{};

	private static GameBoard gameBoard = new GameBoard();

	private static Die die = new Die();

	private static boolean hasEnded = false;

	private static String[] availablePlayers = new String[]{"Boat","Cat","Car","Dog"};

	private static String[] getAvailablePlayers(){
		return availablePlayers;
	}


	private static boolean pieceIsAvailable(String piece){
		for (String p: availablePlayers){
			if(p.equals(piece)){
				return true;
			}
		}
		return false;
	}

	private static String availablePlayersString(){
		String temp = "";
		for (String s: getAvailablePlayers()){
			temp = temp + " " + s;
		}
		return temp;
	}


	public static void setupGame(){

		System.out.println("Welcome to Monopoly Junior!!!");
		System.out.println("You can play with some or all of the follwoing 4 pieces: Boat, Cat, Car, Dog");

		boolean allPlayersAdded = false;
		Scanner sc = new Scanner(System.in);
		String input;

		while (allPlayersAdded == false){
			if(players.length == 0){
				System.out.println("Please choose the first player you have the option to use any aforementioned piece");
				input = sc.nextLine();
				if (pieceIsAvailable(input)){
					addPlayer(new Player(input));
				} else{
					continue;
				}
			}
			if(players.length == 1){
				System.out.println("Please choose the second player you have the option to use" + availablePlayersString());
				input = sc.nextLine();
				if (pieceIsAvailable(input)){
					addPlayer(new Player(input));
				} else{
					continue;
				}
			}

			System.out.println("Great, we now have the following players:");
			System.out.println(playersToString());
			System.out.println("If you wish to play type play, otherwise add another player piece");
			input = sc.nextLine();
			if (input.equals("play")){
				allPlayersAdded = true;
				break;
			}
			if (pieceIsAvailable(input)){
				addPlayer(new Player(input));
			} else{
				System.out.println("Please input a valid game piece, remeber it is case sensitive");
			}


			if(players.length == 4){
				allPlayersAdded = true;
				break;
			}
		}
		System.out.println("The game will now start with the following players:");
		System.out.println(playersToString());
		Bank.payGameStart(players);


	}

	public static void playTurn(Player player){

		if (player.getInJail() == true){
			if (player.getHasGetOutOfJailFreeCard() == true){
				System.out.println("You used a get out of jail free card to get out of jail");
				player.setHasGetOutOfJailFreeCard(false);
			} else {
				Bank.withdraw(player, 2);
				System.out.println("You paid $2 to get out of jail");
			}
		}



		System.out.println("Your turn " + player.toString() + "\n");
		System.out.println("you have a balance of: " + player.getBalance());
		System.out.println("You are at: " + player.getPosition());
		Scanner sc = new Scanner(System.in);
		die.roll();
		System.out.println("you rolled " + die.getValue());
		System.out.println("press enter to move");
		String input;
		input = sc.nextLine();

		player.move(die.getValue());
		handleSquare(player);

	}


	private static void handleSquare(Player player){
		Square playerSquare = gameBoard.getSquare(player.getPosition());
			switch (playerSquare.getType()){
			case "start":
				System.out.println("you landed on go");
				break;
			case "square":
				if (playerSquare.getOwner() == player){
					System.out.println("you landed on your own property " + playerSquare.getName());
				}

				if (playerSquare.getOwner() == null){

					if(player.getBalance() >= playerSquare.getValue()){
						System.out.println("You landed on " + playerSquare.getName() + " and buy it for $" + playerSquare.getValue());
						Bank.withdraw(player, playerSquare.getValue());
						playerSquare.setOwner(player);

					} else{
						System.out.println("You do not have enough money to buy this square, nothing happens");
					}
				}

				if (playerSquare.getOwner() != null && playerSquare.getOwner() != player){
					System.out.println("You landed in " + playerSquare.getName());
					Bank.payRent(player, playerSquare);
					if(GameController.getHasEnded()){
						System.out.println("You now have $" + player.getBalance());
					}
				}
				break;

			case "chance":
				System.out.println("You landed on a Chance square, and get to draw a chance card");
				drawChanceCard(player);
				break;

			case "parking":
				System.out.println("you arrived at free parking, nothing more happens");
				break;

			case "prison":
				System.out.println("You landed on go to prison, and are taken to jail");
				player.setPosition(17);
				player.setInJail(true);
				break;

			case "visit":
				System.out.println("You are visiting jail, welcome!");
				break;

			default:
				System.out.println("Something went wrong, how didi this happen!!!!");
			}
	}



	public static void endGameEvaluation(){
		GameController.setHasEnded(true);

		//Sort the players by balance, least to most
		Arrays.sort(players, new Comparator<Player>() {
            @Override
            public int compare(Player p1, Player p2) {
                return Integer.compare(p1.getBalance(), p2.getBalance());
            }
        });

		//Print the scores
		System.out.println("Final Score:");
		for (Player player : players) {
            System.out.println(player.getPiece() + " - Balance: " + player.getBalance());
        }

		//find the winner
		if (players.length == 2){
			System.out.println("The winner is: " + players[players.length-1]);
		}

		if (players.length == 3){
			if (players[players.length-1].getBalance() == players[players.length-2].getBalance()){
				System.out.println("We have a tie!!!");
			} else{
				System.out.println("The winner is: " + players[players.length-1]);
			}
		}
		if (players.length == 4){
			if (players[players.length-1].getBalance() == players[players.length-2].getBalance()){
				if (players[players.length-1].getBalance() == players[players.length-3].getBalance()){
					System.out.println("We have a three way tie!!!");
				} else {
					System.out.println("We have a tie!!!");
				}
			} else{
				System.out.println("The winner is: " + players[players.length-1]);
			}
		}





	}

	public static boolean getHasEnded(){
		return hasEnded;
	}

	public static void setHasEnded(boolean state){
		hasEnded = state;
	}

	public static Player[] getPlayers(){
		return players;
	}

	public static void addPlayer(Player newPlayer){
		players = Arrays.copyOf(players, players.length + 1);
		players[players.length - 1] = newPlayer;
		//Note I know this is bad oop design...
		availablePlayers = removeElement(availablePlayers, newPlayer.getPiece());
	}

	public static GameBoard getGameBoard(){
		return GameController.gameBoard;
	}

	public static void setGameBoard(GameBoard gameBoard){
		GameController.gameBoard = gameBoard;
	}

	public static void drawChanceCard(Player player){
		return;
	}



	public static String playersToString(){
		String temp = "";
		for(Player i: players){
			temp = temp + i.toString() + " ";
		}
		return temp;
	}


	private static String[] removeElement(String[] original, String elementToRemove) {
        int numberOfElements = original.length;
        int count = 0;

        for (String item : original) {
            if (item.equals(elementToRemove)) {
                count++;
            }
        }

        String[] newArray = new String[numberOfElements - count];
        int newIndex = 0;

        for (String item : original) {
            if (!item.equals(elementToRemove)) {
                newArray[newIndex++] = item;
            }
        }

        return newArray;
    }

	public static void main(String[] args){

		setupGame();
		while (hasEnded == false){
			for(Player player: players){
				if(GameController.getHasEnded()){
					return;
				}
				playTurn(player);
			}
		}
		System.out.println("Thanks for playing");
	}
}
