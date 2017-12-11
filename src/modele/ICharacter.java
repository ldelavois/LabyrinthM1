package modele;

public interface ICharacter {

	/**
	 * 
	 * @param lab
	 * @param x
	 * @param y
	 */
	public void setPosition(Labyrinth lab, int x, int y);

	/**
	 * 
	 * @param lab
	 * @param dir
	 */
	public void move(Labyrinth lab, Directions dir);

	/**
	 * 
	 * @return
	 */
	public int getposX();

	/**
	 * 
	 * @return
	 */
	public int getposY();

	/**
	 * 
	 * @return
	 */
	public Vertex getVertexPos();
}
