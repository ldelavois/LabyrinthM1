package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import view.*;
import modele.*;

public class Controller implements EventHandler<ActionEvent> {

	private Labyrinth lab;
	private static Controller instance = new Controller();
	private static View view;

	public Controller() {
		lab = new Labyrinth();
		view = new View(16, 16);

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
			System.out.println("\n" + dir);
			System.out.println("Player");
			System.out.println("pos before: " + player.getposX() + " ; " + player.getposY());
			player.move(Directions.NORTH);
			System.out.println("pos after: " + player.getposX() + " ; " + player.getposY());

			lab.launchManhattan(enemies.getVertexPos(), player.getVertexPos());
			System.out.println("Enemies");
			System.out.println("pos before: " + enemies.getposX() + " ; " + enemies.getposY());
			enemies.move();
			System.out.println("pos after: " + enemies.getposX() + " ; " + enemies.getposY());

		}
	}

	public static void start(Stage primaryStage) {
		view.start(primaryStage);
		// view.setOnAction(this);

	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub

	}
}