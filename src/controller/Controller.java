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
		Enemies enemies = new Enemies();
		for (Directions dir : Directions.values()) {
			System.out.println(dir);
			System.out.println("\nPlayer" + dir);
			System.out.println("pos before: " + player.getposX() + " ; " + player.getposY());
			player.move(Directions.NORTH);
			System.out.println("pos after: " + player.getposX() + " ; " + player.getposY());
			
			//lab.launchManhattan(enemies.getVertexPos(), player.getVertexPos());
			System.out.println("\nEnemies");
			System.out.println("pos before: " + enemies.getposX() + " ; " + enemies.getposY());
			player.move(Directions.NORTH);
			System.out.println("pos after: " + enemies.getposX() + " ; " + enemies.getposY());

		}
	}

	public static void makeInstance() {
		// TODO Auto-generated method stub

	}

	public static void start(Stage stage) {
		// TODO Auto-generated method stub

	}
}