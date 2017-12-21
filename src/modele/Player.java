package modele;

/**
 * 
 * @author Ludovic, Julien, Matthias, Andy
 *
 */
public class Player extends Character implements ICharacter {

	/**
	 * Contructeur du joueur, initialise sa position de fa��on al��atoire
	 */
	public Player(Labyrinth laby) {
		setPosition(laby, (int) (Math.random() * Graph.WIDTH),
				(int) (Math.random() * Graph.WIDTH));
	}

}
