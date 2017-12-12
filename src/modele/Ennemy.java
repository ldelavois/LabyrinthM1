package modele;

import controller.Controller;

/**
 * 
 * @author
 *
 */
public class Ennemy extends Character implements ICharacter {

	/**
	 * Contructeur de l'ennemi qui initialise sa position de façon aléatoire
	 */
	public Ennemy() {
		setPosition(Controller.getLabyrinth(), (int) (Math.random() * Graph.WIDTH),
				(int) (Math.random() * Graph.WIDTH));
	}

	/**
	 * Permet de faire déplacer l'ennemi en fonction de la position du joueur à l'aide l'algorithme de Manhattan
	 * @param lab : le labyrinth
	 */
	public void move(Labyrinth lab) {
		this.vertexPos = lab.getGraph().getVertex(posX, posY);
		for (Directions dir : Directions.values()) {
			Vertex next = lab.getGraph().getVertexByDir(vertexPos, dir);
			if (lab.getGraph().containsEdge(vertexPos, next) && (next.getNbr() == vertexPos.getNbr() - 1)) {
				this.move(lab, dir);
			}
		}
	}
	
	/**
	 * Permet de de savoir si l'ennemi est à la même position que le joueur
	 * @param player : le joueur
	 * @return : true si le joueur est à la même position que l'ennemi sinon false
	 */
	boolean onPlayer(Player player) {
		return (player.getposX() == this.getposX() && (player.getposY() == this.getposY()));
	}

}
