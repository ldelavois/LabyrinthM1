package modele;

import java.util.ArrayList;
import java.util.List;

import org.jgrapht.graph.SimpleGraph;

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
	 * @param vertex
	 *            : le vertex que l'on cherche
	 * @return true si le vertex se trouve dans le graph, false sinon
	 */
	public boolean contains(Vertex vertex) {
		List<Vertex> vertices = new ArrayList<Vertex>(this.vertexSet());
		return vertices.contains(vertex);
	}

	/**
	 * Fonction qui permet de savoir si un Vertex existe dans une direction donnée.
	 * 
	 * @param vertex
	 *            Vertex d'origine
	 * @param dir
	 *            Direction dans laquel on cherche le Vertex
	 * @return false si le Vertex exist, true sinon
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

	public Edge getEdge(Vertex origin, Directions dir) {
		Vertex target = null;
		if (!doesntExist(origin, dir))
			target = getVertexByDir(origin, dir);
		return getEdge(origin, target);
	}

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

	// retourne le vertex dans le graph équivalent
	public Vertex getVertex(Vertex vertex) {
		List<Vertex> vertices = new ArrayList<Vertex>(this.vertexSet());
		for (Vertex v : vertices) {
			if (v.equals(vertex))
				return v;
		}
		return null;
	}

	public Vertex getVertex(int x, int y) {
		for(Vertex v : vertexSet())
			if(v.getX() == x && v.getY() == y)
				return v;
		return null;
	}
}
