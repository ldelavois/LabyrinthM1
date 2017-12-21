package modele;

import controller.Controller;

/**
 * 
 * @author Ludovic, Julien, Andy, Matthias
 *
 */
public class Ennemy extends Character implements ICharacter {

	/**
	 * Contructeur de l'ennemi qui initialise sa position de fa��on al��atoire
	 */
	public Ennemy() {
		setPosition(Controller.getLabyrinth(), (int) (Math.random() * Graph.WIDTH),
				(int) (Math.random() * Graph.WIDTH));
	}

	/**
	 * Permet de faire d��placer l'ennemi en fonction de la position du joueur �� l'aide l'algorithme de Manhattan.
	 * @param lab Le labyrinthe.
	 */
	public void move(Labyrinth lab) {
		this.vertexPos = lab.getGraph().getVertex(posX, posY);
		for (Directions dir : Directions.values()) {
			Vertex next = lab.getGraph().getVertexByDir(vertexPos, dir);
			if (lab.getGraph().containsEdge(vertexPos, next) && (next.getNbr() == vertexPos.getNbr() - 1)) {
				this.move(lab, dir);
				return;
			}
		}
	}
}
