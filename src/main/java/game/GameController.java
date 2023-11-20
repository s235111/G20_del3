package game;

import java.util.Arrays;

public class GameController {

	private static Player[] players;

	private static GameBoard gameBoard = new GameBoard();


	public static void setupGame(){

		return;
	}

	public static void playTurn(Player player){
		return;
	}

	public static void endGameEvaluation(){

	}

	public static Player[] getPlayers(){
		return players;
	}

	public static void addPlayer(Player newPlayer){
			players = Arrays.copyOf(players, players.length + 1);
			players[players.length - 1] = newPlayer;
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

	public static void main(String[] args){

		System.out.println(players);
		GameController.addPlayer(new Player("Boat"));
		System.out.println(players);
	}
}
