package modele;
import org.jgrapht.graph.DefaultEdge;

@SuppressWarnings("serial")
public class Edge extends DefaultEdge implements Comparable<Edge> {
	/**
	 * Permet de déterminer le type de porte (à retravailler suivant l'implémentation)
	 */
	private int doorType;
	
	public Edge(int doorType) {
		super();
		this.setDoorType(doorType);
	}
	
	@Override
	public int compareTo(Edge o) {
		int diffSource = ((Vertex)this.getSource()).compareTo((Vertex)o.getSource());
		if (diffSource !=0)
			return diffSource;
		else
			return  ((Vertex)this.getTarget()).compareTo((Vertex)o.getTarget());
	}
	
	public String toString() {
		String s = "[" + this.getSource().toString() + "<->" + this.getTarget().toString() + "]";
		return s;
	}

	public int getDoorType() {
		return doorType;
	}

	public void setDoorType(int doorType) {
		this.doorType = doorType;
	}	
}
