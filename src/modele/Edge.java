package modele;

import org.jgrapht.graph.DefaultEdge;

/**
 * 
 * @author 
 *
 */
@SuppressWarnings("serial")
public class Edge extends DefaultEdge implements Comparable<Edge> {
	public enum DoorType {
		OPENED, CLOSED, NONE
	}

	/**
	 * Permet de déterminer le type de porte (à retravailler suivant
	 * l'implémentation)
	 */
	private DoorType doorType;

	/**
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
	 * @return
	 */
	public Vertex source() {
		return (Vertex) this.getSource();
	}

	/**
	 * 
	 * @return
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
	 * @return
	 */
	public DoorType getDoorType() {
		return doorType;
	}

	/**
	 * 
	 * @param doorType
	 */
	private void setDoorType(DoorType doorType) {
		this.doorType = doorType;
	}
}
