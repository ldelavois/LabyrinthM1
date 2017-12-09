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
	private static EnnemyController ennemyController;

	private Controller() {
		lab = new Labyrinth();
		view = new View(Graph.WIDTH, Graph.HEIGHT);
		playerController = new PlayerController(view);
		ennemyController = new EnnemyController(view);

	}

	public static Labyrinth getLabyrinth() {
		return lab;
	}

	public static Controller getInstance() {
		return instance;
	}

	public static void start(Stage primaryStage) {
		view.start(primaryStage, lab);
		view.keyPressed(playerController);
	}

	public PlayerController getPlayerController() {
		return playerController;
	}

	public EnnemyController getEnnemyController() {
		return ennemyController;
	}
}