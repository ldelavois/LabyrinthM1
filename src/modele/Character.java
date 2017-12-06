package modele;

import controller.Controller;

public abstract class Character implements ICharacter {

	protected int posX;
	protected int posY;
	protected Vertex vertexPos;
	protected static Labyrinth lab = Controller.getInstance().getLabyrinth();

	public int getposX() {
		return this.vertexPos.getX();
	}

	public int getposY() {
		return this.vertexPos.getY();
	}
	
	public Vertex getVertexPos() {
		return this.vertexPos;
	}
	
	public void move(Directions dir) {
		if (!(lab.isWall(vertexPos, dir))) {
			switch (dir) {
			case NORTH:
				vertexPos = lab.getGraph().getVertex(new Vertex(posX, ++posY, -1));
				break;

			case SOUTH:
				vertexPos = lab.getGraph().getVertex(new Vertex(posX, --posY, -1));
				break;

			case WEST:
				vertexPos = lab.getGraph().getVertex(new Vertex(--posX, posY, -1));
				break;

			case EAST:
				vertexPos = lab.getGraph().getVertex(new Vertex(++posX, posY, -1));
				break;
			}
		} else
			System.out.println("Wall");
	}
}
