package controller;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import view.*;
import modele.*;

/**
 * 
 * @author
 *
 */
public class Controller implements EventHandler<KeyEvent> {

	private static Labyrinth lab;
	private static Controller instance = new Controller();
	private static View view;
	private static PlayerController playerController;
	private static EnnemyController ennemyController;
	private static DoorController doorController;
	private static ItemController itemController;

	/**
	 * 
	 */
	private Controller() {
		lab = new Labyrinth();
		view = new View(Graph.WIDTH, Graph.HEIGHT);
		playerController = new PlayerController(view);
		ennemyController = new EnnemyController(view);
		doorController = new DoorController(view);
		itemController = new ItemController(view);
		ennemyController.start();
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
		view.keyPressed(this);
	}

	/**
	 * 
	 * @return Le controller de l'objet player
	 */
	protected PlayerController getPlayerController() {
		return playerController;
	}

	/**
	 * 
	 * @return Le controller de l'objet ennemy
	 */
	protected EnnemyController getEnnemyController() {
		return ennemyController;
	}
	
	protected DoorController getDoorController() {
		return doorController;
	}

	protected void gameOver() {
		if (playerController.getPlayer().collision(Controller.getInstance().getEnnemyController().getEnnemy())) {
			System.out.println("Vous avez perdu!");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.exit(0);
					}
	}

	protected void victory() {
		if(playerController.getPlayer().collision(/*changer avec la porte*/Controller.getInstance().getEnnemyController().getEnnemy())) {
			System.out.println("Vous avez gagné!");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.exit(0);
		}
	}
	@Override
	public void handle(KeyEvent event) {
		getPlayerController().movePlayer(event);
		gameOver();
		victory();
	}
}