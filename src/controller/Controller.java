package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.TouchEvent;
import javafx.stage.Stage;
import view.*;
import modele.*;

/**
 * 
 * @author 
 *
 */
public class Controller {

	private static Labyrinth lab;
	private static Controller instance = new Controller();
	private static View view;
	private static PlayerController playerController;
	private static EnnemyController ennemyController;
	
	/**
	 * 
	 */
	private Controller() {
		lab = new Labyrinth();
		view = new View(Graph.WIDTH, Graph.HEIGHT);
		playerController = new PlayerController(view);
		ennemyController = new EnnemyController(view);

	}

	/**
	 * 
	 * @return
	 */
	public static Labyrinth getLabyrinth() {
		return lab;
	}

	/**
	 * 
	 * @return
	 */
	public static Controller getInstance() {
		return instance;
	}

	/**
	 * 
	 * @param primaryStage
	 */
	public void start(Stage primaryStage) {
		view.start(primaryStage, lab);
		view.keyPressed(playerController);
	}

	/**
	 * 
	 * @return
	 */
	public PlayerController getPlayerController() {
		return playerController;
	}

	/**
	 * 
	 * @return
	 */
	public EnnemyController getEnnemyController() {
		return ennemyController;
	}
}