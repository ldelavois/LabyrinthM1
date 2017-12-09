package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.TouchEvent;
import javafx.stage.Stage;
import view.*;
import modele.*;

public class Controller {

	private static Labyrinth lab;
	private static Controller instance = new Controller();
	private static View view;
	private static PlayerController playerController;
	// private Player player;

	private Controller() {
		lab = Labyrinth.getInstanceLab();
		view = new View(Graph.WIDTH, Graph.HEIGHT);
		playerController = new PlayerController(view);
		// player = new Player();
	}

	public Labyrinth getLabyrinth() {
		return lab;
	}

	public static Controller getInstance() {
		return instance;
	}
	
	// TEST player
	public void testennemy() {
		Ennemy ennemy = new Ennemy();

		lab.launchManhattan(ennemy.getVertexPos(), ennemy.getVertexPos());
		System.out.println("Enemies");
		System.out.println("pos before: " + ennemy.getposX() + " ; " + ennemy.getposY());
		ennemy.move();
		System.out.println("pos after: " + ennemy.getposX() + " ; " + ennemy.getposY());

	}

	public static void start(Stage primaryStage) {
		view.start(primaryStage, lab);
		view.keyPressed(playerController);
	}

}