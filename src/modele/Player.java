package modele;

import controller.Controller;

public class Player extends Character {

	public Player() {
		setPosition();
	}

	@Override
	public void setPosition() {
		this.vertexPos = Controller.getInstance().getLabyrinth().getGraph()
				.getVertex(new Vertex(Graph.WIDTH / 2, Graph.HEIGHT / 2, -1));
		this.posX = vertexPos.getX();
		this.posY = vertexPos.getY();
	}

	public void move(Directions dir) {
		if (!(Controller.getInstance().getLabyrinth().isWall(vertexPos, dir))) {
			switch (dir) {
			case NORTH:
				vertexPos = Controller.getInstance().getLabyrinth().getGraph().getVertex(new Vertex(posX, ++posY, -1));
				break;

			case SOUTH:
				vertexPos = Controller.getInstance().getLabyrinth().getGraph().getVertex(new Vertex(posX, --posY, -1));
				break;

			case WEST:
				vertexPos = Controller.getInstance().getLabyrinth().getGraph().getVertex(new Vertex(--posX, posY, -1));
				break;

			case EAST:
				vertexPos = Controller.getInstance().getLabyrinth().getGraph().getVertex(new Vertex(++posX, posY, -1));
				break;
			}
		} else
			System.out.println("Wall");
	}

}
