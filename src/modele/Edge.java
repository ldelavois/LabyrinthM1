package modele;

import org.jgrapht.graph.DefaultEdge;

/**
 * 
 * @author Ludovic, Julien, Andy, Matthias
 *
 */
@SuppressWarnings("serial")
public class Edge extends DefaultEdge implements Comparable<Edge> {

	/**
	 * Constructeur de la classe.
	 */
	public Edge() {
		super();
	}

	@Override
	public int compareTo(Edge o) {
		int diffSource = ((Vertex) this.getSource()).compareTo((Vertex) o.getSource());
		if (diffSource != 0)
			return diffSource;
		else
			return ((Vertex) this.getTarget()).compareTo((Vertex) o.getTarget());
	}

	/**
	 * 
	 * @return Le sommet de d��part.
	 */
	public Vertex source() {
		return (Vertex) this.getSource();
	}

	/**
	 * 
	 * @return Le sommet cible.
	 */
	public Vertex target() {
		return (Vertex) this.getTarget();
	}

	@Override
	public String toString() {
		String s = "(" + this.getSource().toString() + "<->" + this.getTarget().toString() + ")";
		return s;
	}
}
