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
public class PlayerController implements CharacterController {

	private Player player;
	private View view;

	/**
	 * 
	 * @param view
	 */
	protected PlayerController(View view) {
		player = new Player();
		this.view = view;
		view.updatePlayerPosition(player.getVertexPos());
	}

	@Override
	public void updatePostion() {

	}

	@Override
	public void spawn() {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * @return Le joueur
	 */
	public Player getPlayer() {
		return player;
	}
	
	/**
	 * Déplace le joueur en fonction des touches directionnelles du clavier
	 * @param event Evenement d'un appui sur une touches du clavier
	 */
	public void movePlayer(KeyEvent event) {

		switch (event.getCode()) {

		case UP:
			System.out.println("\n" + event.getCode());
			player.move(Controller.getLabyrinth(), Directions.NORTH);
			view.updatePlayerPosition(player.getVertexPos());
			System.out.println("position : " + player.getposX() + " ; " + player.getposY());
			break;

		case DOWN:
			System.out.println("\n" + event.getCode());
			player.move(Controller.getLabyrinth(), Directions.SOUTH);
			view.updatePlayerPosition(player.getVertexPos());
			System.out.println("position : " + player.getposX() + " ; " + player.getposY());
			break;

		case LEFT:
			System.out.println("\n" + event.getCode());
			player.move(Controller.getLabyrinth(), Directions.WEST);
			view.updatePlayerPosition(player.getVertexPos());
			System.out.println("position : " + player.getposX() + " ; " + player.getposY());
			break;

		case RIGHT:
			System.out.println("\n" + event.getCode());
			player.move(Controller.getLabyrinth(), Directions.EAST);
			view.updatePlayerPosition(player.getVertexPos());
			System.out.println("position : " + player.getposX() + " ; " + player.getposY());
			break;
		
		default:
			break;

		}
		player.collisionEnnemy(Controller.getInstance().getEnnemyController().getEnnemy());
	}

}
