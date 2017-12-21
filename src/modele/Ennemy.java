package modele;

/**
 * 
 * @author Ludovic, Julien, Andy, Matthias
 *
 */
public class Ennemy extends Character {

	/**
	 * Contructeur de l'ennemi qui initialise sa position de façon aléatoire
	 */
	public Ennemy(Labyrinth laby) {
		super (laby);
	}

	/**
	 * Permet de faire déplacer l'ennemi en fonction de la position du joueur à l'aide l'algorithme de Manhattan.
	 * Pour cela on a attribué une valeur à chaque sommet que l'ennemi suit par ordre décroissant.
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
