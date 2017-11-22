package modele;
import org.jgrapht.graph.DefaultEdge;

public class Edge extends DefaultEdge implements Comparable<Edge> {

	private static final long serialVersionUID = 1L;

	public Edge() {
		super();
	}
	
	@Override
	public int compareTo(Edge o) {
		return 0;
	}
	
	public String toDot() {
		return ((Vertex) this.getSource()).toDot() + "--" + ((Vertex) this.getTarget()).toDot();
	}
	
}
