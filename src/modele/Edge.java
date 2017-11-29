package modele;
import org.jgrapht.graph.DefaultEdge;

@SuppressWarnings("serial")
public class Edge extends DefaultEdge implements Comparable<Edge> {
	private enum DoorType {
		OPENED,
		CLOSED,
		NONE
	}
	/**
	 * Permet de déterminer le type de porte (à retravailler suivant l'implémentation)
	 */
	private DoorType doorType;
	
	public Edge() {
		super();
		setDoorType(DoorType.NONE);
	}
	
	@Override
	public int compareTo(Edge o) {
		int diffSource = ((Vertex)this.getSource()).compareTo((Vertex)o.getSource());
		if (diffSource != 0)
			return diffSource;
		else
			return  ((Vertex)this.getTarget()).compareTo((Vertex)o.getTarget());
	}
	
	public Vertex source() {
		return (Vertex) this.getSource();
	}
	
	public Vertex target() {
		return (Vertex) this.getTarget();
	}
	
	public String toString() {
		String s = "(" + this.getSource().toString() + "<->" 
					+ this.getTarget().toString() + ")";
		return s;
	}

	public DoorType getDoorType() {
		return doorType;
	}

	private void setDoorType(DoorType doorType) {
		this.doorType = doorType;
	}	
}
