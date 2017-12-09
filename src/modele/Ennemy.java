package modele;

import controller.Controller;

public class Ennemy extends Character implements ICharacter {

	public Ennemy() {
		setPosition(Labyrinth.getInstanceLab(), (int) (Math.random() * Graph.WIDTH),
				(int) (Math.random() * Graph.WIDTH));
	}

	public void move(Labyrinth lab) {
		this.vertexPos = Labyrinth.getInstanceLab().getGraph().getVertex(posX, posY);
		for (Directions dir : Directions.values()) {
			Vertex next = Labyrinth.getInstanceLab().getGraph().getVertexByDir(vertexPos, dir);
			if (Labyrinth.getInstanceLab().getGraph().containsEdge(vertexPos, next)
					&& (next.getNbr() == vertexPos.getNbr() - 1)) {
				this.move(lab, dir);
			}
		}
	}

}
