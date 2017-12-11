package modele;

import controller.Controller;

/**
 * 
 * @author 
 *
 */
public class Ennemy extends Character implements ICharacter {

	/**
	 * 
	 */
	public Ennemy() {
		setPosition(Controller.getLabyrinth(), (int) (Math.random() * Graph.WIDTH),
				(int) (Math.random() * Graph.WIDTH));
	}

	/**
	 * 
	 * @param lab
	 */
	public void move(Labyrinth lab) {
		this.vertexPos = lab.getGraph().getVertex(posX, posY);
		for (Directions dir : Directions.values()) {
			Vertex next = lab.getGraph().getVertexByDir(vertexPos, dir);
			if (lab.getGraph().containsEdge(vertexPos, next)
					&& (next.getNbr() == vertexPos.getNbr() - 1)) {
				this.move(lab, dir);
			}
		}
	}

}
