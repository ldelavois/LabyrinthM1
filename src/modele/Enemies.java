package modele;

import controller.Controller;

public class Enemies extends Character implements ICharacter {

	public Enemies() {
		setPosition();
	}

	@Override
	public void setPosition() {
		this.vertexPos = lab.getGraph()
				.getVertex(new Vertex((int) (Math.random() * 16), (int) (Math.random() * 16), 0));
		this.posX = vertexPos.getX();
		this.posY = vertexPos.getY();
	}

	public void move() {
		this.vertexPos = lab.getGraph().getVertex(new Vertex(posX, posY, 0));
		for (Directions dir : Directions.values()) {
			Vertex next = lab.getGraph().getVertexByDir(vertexPos, dir);
			if (lab.getGraph().containsEdge(vertexPos, next) && (next.getNbr() == vertexPos.getNbr() - 1)) {
				this.move();
			}
		}
	}



}
