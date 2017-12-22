package modele;

/**
 * Interface qui représente des objets pouvant entré en contact sur un plateau de jeu.
 * @author Ludovic, Julien, Andy, Matthias
 *
 */
public interface Collidable {
	/**
	 * Test si deux objets sont en collision.
	 * @param c l'objet à tester.
	 * @return Vrai si this est en collision avec c, faux sinon.
	 */
	public boolean collision(Collidable c);
}
