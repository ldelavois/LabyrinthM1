package modele;

import controller.Controller;

public abstract class Character implements ICharacter {

	protected int posX;
	protected int posY;
	protected Vertex vertexPos;

	public int getposX() {
		return this.vertexPos.getX();
	}

	public int getposY() {
		return this.vertexPos.getY();
	}

	public Vertex getVertexPos() {
		return this.vertexPos;
	}

	public void setPosition(Labyrinth lab, int x, int y) {

		this.posX = x;
		this.posY = y;
		this.vertexPos = lab.getGraph().getVertex(x, y);
	}

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
