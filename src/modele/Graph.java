package modele;

import java.util.ArrayList;
import java.util.List;

import org.jgrapht.graph.SimpleGraph;

/**
 * 
 * @author Ludovic, Julien, Andy, Matthias
 *
 */
@SuppressWarnings("serial")
public class Graph extends SimpleGraph<Vertex, Edge> {
	/**
	 * Largeur du Graph
	 */
	public static final int WIDTH = 16;
	/**
	 * Hauteur du Graph
	 */
	public static final int HEIGHT = 16;

	/**
	 * Constructeur de la classe. Créé un Graph et lui donne la classe d'arrête
	 * associée.
	 */
	public Graph() {
		super(Edge.class);
	}

	/**
	 * Fonction qui indique la présence d'un Vertex dans un Graph.
	 * 
	 * @param vertex Le vertex que l'on cherche
	 * @return Vrai si le sommet se trouve dans le graph, faux sinon
	 */
	public boolean contains(Vertex vertex) {
		List<Vertex> vertices = new ArrayList<Vertex>(this.vertexSet());
		return vertices.contains(vertex);
	}

	/**
	 * Fonction qui permet de savoir si un Vertex existe dans une direction donnée.
	 * 
	 * @param vertex Vertex d'origine
	 * @param dir Direction dans laquel on cherche le Vertex
	 * @return Faux si le Vertex existe, vrai sinon
	 */
	public boolean doesntExist(Vertex vertex, Directions dir) {
		Vertex tmp = null;
		switch (dir) {
		case NORTH:
			tmp = new Vertex(vertex.getX(), vertex.getY() - 1, -1);
			break;
		case SOUTH:
			tmp = new Vertex(vertex.getX(), vertex.getY() + 1, -1);
			break;
		case EAST:
			tmp = new Vertex(vertex.getX() + 1, vertex.getY(), -1);
			break;
		case WEST:
			tmp = new Vertex(vertex.getX() - 1, vertex.getY(), -1);
			break;
		}
		if (contains(tmp))
			return false;
		return true;
	}

	/**	
	 * Permet de récupérer une arrête entre deux sommets en utilisant la direction.
	 * @param origin Le sommet de départ.
	 * @param dir La direction.
	 * @return L'arrête entre le sommet de départ et le premier sommet qui se trouve dans la direction {@value dir}.
	 */
	//Fonctionne pas
	public Edge getEdge(Vertex origin, Directions dir) {
		Vertex target = null;
		if (!doesntExist(origin, dir))
			target = getVertexByDir(origin, dir);
		return getEdge(origin, target);
	}
	
	/**
	 * Récupère un sommet en fonction de la direction.
	 * @param v Le sommet de départ.
	 * @param dir La direction
	 * @return Le sommet le plus proche de {@value v} dans la direction {@value d}.
	 */
	public Vertex getVertexByDir(Vertex v, Directions dir) {
		Vertex res = null;
		for (Edge e : this.edgeSet()) {
			Vertex source = e.source();
			Vertex target = e.target();
			Vertex v2 = null;
			if (v.equals(source)) {
				v2 = target;

				switch (dir) {
				case NORTH:
					if (v.getX() == v2.getX() && v.getY() == v2.getY() - 1) {
						res = v2;
					}
					break;
				case SOUTH:
					if (v.getX() == v2.getX() && v.getY() == v2.getY() + 1) {
						res = v2;
					}
					break;
				case EAST:
					if (v.getX() == v2.getX() + 1 && v.getY() == v2.getY()) {
						res = v2;
					}
					break;
				case WEST:
					if (v.getX() == v2.getX() - 1 && v.getY() == v2.getY()) {
						res = v2;
					}
					break;
				}
			}
		}
		return res;
	}

	/**
	 * Retourne le vertex dans le graph équivalent
	 * @param x La position en x. 
	 * @param y La position en y.
	 * @return Le sommet à la position ({@value x}, {@value y}).
	 */
	public Vertex getVertex(int x, int y) {
		for (Vertex v : vertexSet())
			if (v.getX() == x && v.getY() == y)
				return v;
		return null;
	}
}
