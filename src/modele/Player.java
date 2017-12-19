package modele;

import controller.Controller;

/**
 * 
 * @author Ludovic, Julien, Matthias, Andy
 *
 */
public class Player extends Character implements ICharacter {

	/**
	 * Contructeur du joueur, initialise sa position de façon aléatoire
	 */
	public Player() {
		setPosition(Controller.getLabyrinth(), (int) (Math.random() * Graph.WIDTH),
				(int) (Math.random() * Graph.WIDTH));
	}
	
	public void collisionEnnemy(Ennemy ennemy) {
		if(collision(ennemy)) {
			System.out.println("PERDU");
			//...
		}
	}

}
