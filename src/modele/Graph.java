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
	 * Constructeur de la classe. Cr���� un Graph et lui donne la classe d'arr��te
	 * associ��e.
	 */
	public Graph() {
		super(Edge.class);
	}

	/**
	 * Fonction qui indique la pr��sence d'un Vertex dans un Graph.
	 * 
	 * @param vertex Le vertex que l'on cherche
	 * @return Vrai si le sommet se trouve dans le graph, faux sinon
	 */
	public boolean contains(Vertex vertex) {
		List<Vertex> vertices = new ArrayList<Vertex>(this.vertexSet());
		return vertices.contains(vertex);
	}

	/**
	 * Fonction qui permet de savoir si un Vertex existe dans une direction donn��e.
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
	 * Permet de r��cup��rer une arr��te entre deux sommets en utilisant la direction.
	 * @param origin Le sommet de d��part.
	 * @param dir La direction.
	 * @return L'arr��te entre le sommet de d��part et le premier sommet qui se trouve dans la direction {@value dir}.
	 */
	//Fonctionne pas
	public Edge getEdge(Vertex origin, Directions dir) {
		Vertex target = null;
		if (!doesntExist(origin, dir))
			target = getVertexByDir(origin, dir);
		return getEdge(origin, target);
	}
	
	/**
	 * R��cup��re un sommet en fonction de la direction.
	 * @param v Le sommet de d��part.
	 * @param dir La direction
	 * @return Le sommet le plus proche de {@value v} dans la direction {@value d}.
	 */
	public Vertex getVertexByDir(Vertex v, Directions dir) {
		switch (dir) {
		case NORTH:
			return getVertex(v.getX(), v.getY() - 1);
		case SOUTH:
			return getVertex(v.getX(), v.getY() + 1);
		case EAST:
			return getVertex(v.getX() + 1, v.getY());
		case WEST:
			return getVertex(v.getX() - 1, v.getY());
		}
		return null;
	}

	/**
	 * Retourne le vertex dans le graph ��quivalent
	 * @param x La position en x. 
	 * @param y La position en y.
	 * @return Le sommet �� la position ({@value x}, {@value y}).
	 */
	public Vertex getVertex(int x, int y) {
		for (Vertex v : vertexSet())
			if (v.getX() == x && v.getY() == y)
				return v;
		return null;
	}
}
