package controller;

import modele.Ennemy;
import view.View;

/**
 * 
 * @author 
 *
 */
public class EnnemyController implements CharacterController {

	private Ennemy ennemy;
	private View view;
	
	/**
	 * 
	 * @param view
	 */
	protected EnnemyController(View view) {
		ennemy = new Ennemy();
		this.view=view;
		view.updateEnnemyPosition(ennemy.getVertexPos());
	}

	@Override
	public void updatePostion() {
		// TODO Auto-generated method stub

	}

	@Override
	public void spawn() {
		// TODO Auto-generated method stub

	}
	
	public Ennemy getEnnemy() {
		return ennemy;
	}
	
	/**	
	 * 
	 */
	public void moveEnnemy() {
		Controller.getLabyrinth().launchManhattan(ennemy.getVertexPos(), Controller.getInstance().getPlayerController().getPlayer().getVertexPos());
		System.out.println("Enemies");
		ennemy.move(Controller.getLabyrinth());
		System.out.println("position : " + ennemy.getposX() + " ; " + ennemy.getposY());
		view.updateEnnemyPosition(ennemy.getVertexPos());
	}

}
