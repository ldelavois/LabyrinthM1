package controller;


import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import modele.Directions;
import modele.Player;
import view.View;

public class PlayerController implements CharacterController, EventHandler<KeyEvent> {

	private Player player;
	private View view;

	protected PlayerController(View v) {
		player = new Player();
		view = v;
		view.updatePlayerPosition(player.getVertexPos());
	}

	@Override
	public void updatePostion() {
		

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
			player.move(Controller.getLabyrinth(),Directions.NORTH);
			view.updatePlayerPosition(player.getVertexPos());
			System.out.println("position : " + player.getposX() + " ; " + player.getposY());
			break;
			
		case DOWN:
			System.out.println("\n"+event.getCode());
			player.move(Controller.getLabyrinth(),Directions.SOUTH);
			view.updatePlayerPosition(player.getVertexPos());
			System.out.println("position : " + player.getposX() + " ; " + player.getposY());
			break;
			
		case LEFT:
			System.out.println("\n"+event.getCode());
			player.move(Controller.getLabyrinth(),Directions.WEST);
			view.updatePlayerPosition(player.getVertexPos());
			System.out.println("position : " + player.getposX() + " ; " + player.getposY());
			break;
			
		case RIGHT:
			System.out.println("\n"+event.getCode());
			player.move(Controller.getLabyrinth(),Directions.EAST);
			view.updatePlayerPosition(player.getVertexPos());
			System.out.println("position : " + player.getposX() + " ; " + player.getposY());
			break;
			
		default:
			break;

		}
	
	}

}
