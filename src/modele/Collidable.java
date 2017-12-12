package modele;

public interface Collidable {
	/**
	 * Test si deux objets sont en collision.
	 * @param c : l'objet à tester.
	 * @return : vrai si this est en collision avec c, faux sinon.
	 */
	public boolean collision(Collidable c);
}
