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

	public void setPosition() {
		this.vertexPos = Labyrinth.getInstanceLab().getGraph()
				.getVertex(new Vertex((int) (Math.random() * Graph.WIDTH), (int) (Math.random() * Graph.HEIGHT), 0));
		this.posX = vertexPos.getX();
		this.posY = vertexPos.getY();
	}

	public void move(Directions dir) {
		if (!(Labyrinth.getInstanceLab().isWall(vertexPos, dir))) {
			switch (dir) {
			case NORTH:
				vertexPos = Labyrinth.getInstanceLab().getGraph().getVertex(new Vertex(posX, ++posY, -1));
				break;

			case SOUTH:
				vertexPos = Labyrinth.getInstanceLab().getGraph().getVertex(new Vertex(posX, --posY, -1));
				break;

			case WEST:
				vertexPos = Labyrinth.getInstanceLab().getGraph().getVertex(new Vertex(--posX, posY, -1));
				break;

			case EAST:
				vertexPos = Labyrinth.getInstanceLab().getGraph().getVertex(new Vertex(++posX, posY, -1));
				break;
			}
		} else
			System.out.println("Wall");
	}

}
