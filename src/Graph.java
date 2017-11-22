import org.jgrapht.graph.SimpleGraph;

@SuppressWarnings("serial")
public class Graph extends SimpleGraph<Vertex, Edge>{
	
	public Graph() {
		super(Edge.class);
	}
	
	public String toDot() {
		StringBuilder s = new StringBuilder();
		s.append("graph {\n");
		for (Vertex v: this.vertexSet())
			s.append(v.toDot() + ';');
		for (Edge e: this.edgeSet())
			s.append(e.toDot() + ';');
		s.append("\n}");
		return s.toString();
	}
}
