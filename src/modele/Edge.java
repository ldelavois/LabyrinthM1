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
	 * 
	 * @author Ludovic, Julien, Andy, Matthias
	 *
	 */
	public enum DoorType {
		OPENED, CLOSED, NONE
	}

	/**
	 * Permet de déterminer le type de porte (à retravailler suivant
	 * l'implémentation)
	 */
	private DoorType doorType;

	/**
	 * Constructeur de la classe.
	 */
	public Edge() {
		super();
		setDoorType(DoorType.NONE);
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
	 * @return Le sommet de départ.
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

	/**
	 * 
	 * @return Le type de porte.
	 */
	public DoorType getDoorType() {
		return doorType;
	}

	/**
	 * Modifier (ou initialiser) le type de porte.
	 * @param doorType Le type de porte.
	 */
	private void setDoorType(DoorType doorType) {
		this.doorType = doorType;
	}
}
