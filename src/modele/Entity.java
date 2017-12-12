package modele;

public abstract class Entity implements Collidable {
	protected int posX;
	protected int posY;
	protected Vertex vertexPos;
	
	/**
	 * Retourne la position X du character
	 */
	public int getposX() {
		return this.vertexPos.getX();
	}

	/**
	 * Retourne la position Y du character
	 */
	public int getposY() {
		return this.vertexPos.getY();
	}

	/**
	 * Retourne le vertex où est positionné le character
	 */
	public Vertex getVertexPos() {
		return this.vertexPos;
	}

	/**
	 * Défini la position du caracter
	 * @param lab : Le labyrinthe
	 * @param x : Position x
	 * @param y : Position y
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
