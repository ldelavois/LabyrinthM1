package controller;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import view.*;
import modele.*;

/**
 * Cette classe s'occupe d'orchestrer tous les controlleursbde l'application ainsi que de 
 * réaliser quelques opérations comme la terminaison de l'application.
 * 
 * @author Ludovic, Julien, Andy, Matthias
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
	 * Constructeur de la classe. Récupère toutes les instances des controlleurs nécessaires 
	 * et lance l'application
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
	 * @return Le layrinthe du jeu.
	 */
	public static Labyrinth getLabyrinth() {
		return lab;
	}

	/**
	 * 
	 * @return L'instance unique de la classe.
	 */
	public static Controller getInstance() {
		return instance;
	}

	/**
	 * Démarre l'application.
	 * @param primaryStage Stage (JavaFX) principale de l'application.
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
	
	protected ItemController getItemController() {
		return itemController;
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
		if(playerController.getPlayer().collision(Controller.getInstance().getDoorController().getDoor())) {
			System.out.println("Vous avez gagné !");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.exit(0);
		}
	}

	protected void itemDrop() {
		if (itemController.getItem() != null) {
				if (playerController.getPlayer().collision(itemController.getItem())) {
					System.out.println("Vous avez récupéré un bonbon!");
					view.deleteCandy();
					itemController.deleteItem();
				}
		}
	}

	@Override
	public void handle(KeyEvent event) {
		getPlayerController().movePlayer(event);
		itemDrop();
		gameOver();
		victory();
	}
}