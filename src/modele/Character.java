package modele;

import controller.Controller;

/**
 * 
 * @author 
 *
 */
public abstract class Character implements ICharacter {

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

	/**
	 * Déplace le character dans la direction dir si il n'y a pas de mur 
	 * @param lab : Le labyrinthe
	 * @param dir : La direction
	 */
	public void move(Labyrinth lab, Directions dir) {
		if (!(lab.isWall(vertexPos, dir))) {
			switch (dir) {
			case NORTH:
				posY--;
				vertexPos = lab.getGraph().getVertex(posX, posY);
				break;

			case SOUTH:
				posY++;
				vertexPos = lab.getGraph().getVertex(posX, posY);
				break;

			case WEST:
				posX--;
				vertexPos = lab.getGraph().getVertex(posX, posY);
				break;

			case EAST:
				posX++;
				vertexPos = lab.getGraph().getVertex(posX, posY);
				break;
			}
		} else
			System.out.println("Wall");
	}

}
