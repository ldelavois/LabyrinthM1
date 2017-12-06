package modele;

import controller.Controller;

public class Player extends Character implements ICharacter{

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

	


}
