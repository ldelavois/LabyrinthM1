package controller;

import javafx.scene.input.KeyEvent;
import modele.Directions;
import modele.Player;
import view.View;

/**
 * 
 * @author
 *
 */
public class PlayerController {

	private Player player;
	private View view;

	/**
	 * 
	 * @param view
	 */
	protected PlayerController(View view) {
		player = new Player(Controller.getLabyrinth());
		this.view = view;
		view.updatePlayerPosition(player.getVertexPos());
	}

	/**
	 * 
	 * @return Le joueur
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * D��place le joueur en fonction des touches directionnelles du clavier
	 * 
	 * @param event
	 *            Evenement d'un appui sur une touches du clavier
	 */
	public void movePlayer(KeyEvent event) {

		switch (event.getCode()) {

		case UP:
			System.out.println("\n" + event.getCode());
			player.move(Controller.getLabyrinth(), Directions.NORTH);
			System.out.println("position : " + player.getposX() + " ; " + player.getposY());
			break;

		case DOWN:
			System.out.println("\n" + event.getCode());
			player.move(Controller.getLabyrinth(), Directions.SOUTH);
			System.out.println("position : " + player.getposX() + " ; " + player.getposY());
			break;

		case LEFT:
			System.out.println("\n" + event.getCode());
			player.move(Controller.getLabyrinth(), Directions.WEST);
			System.out.println("position : " + player.getposX() + " ; " + player.getposY());
			break;

		case RIGHT:
			System.out.println("\n" + event.getCode());
			player.move(Controller.getLabyrinth(), Directions.EAST);
			System.out.println("position : " + player.getposX() + " ; " + player.getposY());
			break;

		default:
			break;

		}
		view.updatePlayerPosition(player.getVertexPos());
	}

}
