package modele;

import controller.Controller;

public class Ennemy extends Character implements ICharacter {

	public Ennemy() {
		setPosition();
	}

	public void move() {
		this.vertexPos = Labyrinth.getInstanceLab().getGraph().getVertex(new Vertex(posX, posY, 0));
		for (Directions dir : Directions.values()) {
			Vertex next = Labyrinth.getInstanceLab().getGraph().getVertexByDir(vertexPos, dir);
			if (Labyrinth.getInstanceLab().getGraph().containsEdge(vertexPos, next) && (next.getNbr() == vertexPos.getNbr() - 1)) {
				this.move(dir);
			}
		}
	}

}
