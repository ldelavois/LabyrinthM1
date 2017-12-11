package modele;

import controller.Controller;

/**
 * 
 * @author 
 *
 */
public class Player extends Character implements ICharacter {

	/**
	 * 
	 */
	public Player() {
		setPosition(Controller.getLabyrinth(), (int) (Math.random() * Graph.WIDTH),
				(int) (Math.random() * Graph.WIDTH));
	}

}
