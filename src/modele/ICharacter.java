package modele;

/**
 * Interface qui représente un personnage du labyrinthe.
 * @author Ludovic, Julien, Andy, Matthias
 *
 */
public interface ICharacter {

	/**
	 * Permet de changer (ou initialiser) la position du personnage.
	 * @param lab Le labyrinthe.
	 * @param x Position en x.
	 * @param y Position en y.
	 */
	public void setPosition(Labyrinth lab, int x, int y);

	/**
	 * Déplacer le personnage.
	 * @param lab Le labyrinth.
	 * @param dir La direction.
	 */
	public void move(Labyrinth lab, Directions dir);

	/**
	 * 
	 * @return La position en x.
	 */
	public int getposX();

	/**
	 * 
	 * @return La position en y.
	 */
	public int getposY();

	/**
	 * 
	 * @return Le sommet sur lequel se trouve le personnage (dans le {@link Labyrinth}).
	 */
	public Vertex getVertexPos();
}
