package modele;

/**
 * 
 * @author Ludovic, Julien, Andy, Matthias
 *
 */
public abstract class Entity implements Collidable {
	protected int posX;
	protected int posY;
	protected Vertex vertexPos;
	
	/**
	 * @return La position en x de l'objet.
	 */
	public int getposX() {
		return this.vertexPos.getX();
	}

	/**
	 * @return La position en y de l'objet.
	 */
	public int getposY() {
		return this.vertexPos.getY();
	}

	/**
	 * @return Le sommet où est positionné l'objet.
	 */
	public Vertex getVertexPos() {
		return this.vertexPos;
	}

	/**
	 * Défini la position de l'objet.
	 * @param lab Le labyrinthe.
	 * @param x Position en x.
	 * @param y Position en y.
	 */
	public void setPosition(Labyrinth lab, int x, int y) {

		this.posX = x;
		this.posY = y;
		this.vertexPos = lab.getGraph().getVertex(x, y);
	}
	
	public boolean collision(Collidable c) {
		return ((Entity) c).getposX() == posX && ((Entity) c).getposY() == posY;
	}
}
