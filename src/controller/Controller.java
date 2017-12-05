package controller;

import javafx.stage.Stage;
import modele.*;

public class Controller {

	private Labyrinth lab;
	private static Controller instance = new Controller();

	public Controller() {
		lab = new Labyrinth();
	}

	public Labyrinth getLabyrinth() {
		return this.lab;
	}

	public static Controller getInstance() {
		return instance;
	}

	// TEST player
	public void testplayer() {
		Player player = new Player();
		System.out.println("\nposY before:" + player.getposY());
		player.move(Directions.NORTH);
		System.out.println("posY after:" + player.getposY());

		System.out.println("\nposY before:" + player.getposY());
		player.move(Directions.SOUTH);
		System.out.println("posY after:" + player.getposY());

		System.out.println("\nposX before:" + player.getposX());
		player.move(Directions.WEST);
		System.out.println("posX after:" + player.getposX());

		System.out.println("\nposX before:" + player.getposX());
		player.move(Directions.EAST);
		System.out.println("posX after:" + player.getposX());

	}

	public static void makeInstance() {
		// TODO Auto-generated method stub
		
	}

	public static void start(Stage stage) {
		// TODO Auto-generated method stub
		
	}
}