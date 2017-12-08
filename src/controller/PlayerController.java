package controller;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import modele.Directions;
import modele.Player;

public class PlayerController implements CharacterController, EventHandler<KeyEvent> {

	private Player player;

	protected PlayerController() {
		player = new Player();
	}

	@Override
	public void updatePostion() {
		// TODO Auto-generated method stub

	}

	@Override
	public void spawn() {
		// TODO Auto-generated method stub

	}

	@Override
	public void handle(KeyEvent event) {

		switch (event.getCode()) {
		
		case UP:
			System.out.println("\n"+event.getCode());
			player.move(Directions.NORTH);
			System.out.println("position : " + player.getposX() + " ; " + player.getposY());
			break;
			
		case DOWN:
			System.out.println("\n"+event.getCode());
			player.move(Directions.SOUTH);
			System.out.println("position : " + player.getposX() + " ; " + player.getposY());
			break;
			
		case LEFT:
			System.out.println("\n"+event.getCode());
			player.move(Directions.WEST);
			System.out.println("position : " + player.getposX() + " ; " + player.getposY());
			break;
			
		case RIGHT:
			System.out.println("\n"+event.getCode());
			player.move(Directions.EAST);
			System.out.println("position : " + player.getposX() + " ; " + player.getposY());
			break;
			
		default:
			break;

		}
	
	}

}
