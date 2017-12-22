package controller;

import modele.Ennemy;
import view.View;

/**
 * Controlleur pour l'ennemi (ou les ennemis) du plateau de jeu.
 * 
 * @author Ludovic, Julien, Andy, Matthias
 *
 */
public class EnnemyController extends Thread {

	private Ennemy ennemy;
	private View view;

	/**
	 * Constructeur de la classe.
	 * @param view View sur laquelle on veut afficher la porte.
	 */
	protected EnnemyController(View view) {
		ennemy = new Ennemy(Controller.getLabyrinth());
		this.view = view;
		view.updateEnnemyPosition(ennemy.getVertexPos());
	}

	protected Ennemy getEnnemy() {
		return ennemy;
	}

	protected void moveEnnemy() {
		Controller.getLabyrinth().launchManhattan(ennemy.getVertexPos(),
				Controller.getInstance().getPlayerController().getPlayer().getVertexPos());
		//System.out.println("\nEnemies");
		ennemy.move(Controller.getLabyrinth());
		//System.out.println("position : " + ennemy.getposX() + " ; " + ennemy.getposY());
		view.updateEnnemyPosition(ennemy.getVertexPos());
		Controller.getInstance().gameOver();
	}

	@Override
	public void run() {
		while (true) {
			moveEnnemy();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
