package modele;
import java.util.ArrayList;
import java.util.List;

import org.jgrapht.graph.SimpleGraph;

@SuppressWarnings("serial")
public class Graph extends SimpleGraph<Vertex, Edge>{

	public static final int WIDTH = 16, HEIGHT = 16;
	
	public Graph() {
		super(Edge.class);
	}
		
	public boolean contains(Vertex vertex) {
		List<Vertex> vertices = new ArrayList<Vertex>(this.vertexSet());
		return vertices.contains(vertex);
	}

	public boolean doesntExist(Vertex vertex, Directions dir) {
		Vertex tmp = null;
		switch(dir) {
		case NORTH:
			tmp = new Vertex(vertex.getX(), vertex.getY()-1, -1);
			break;
		case SOUTH:
			tmp = new Vertex(vertex.getX(), vertex.getY()+1, -1);
			break;
		case EAST:
			tmp = new Vertex(vertex.getX()+1, vertex.getY(), -1);
			break;
		case WEST:
			tmp = new Vertex(vertex.getX()-1, vertex.getY(), -1);
			break;
		}
		if(contains(tmp))
			return false;
		return true;
	}
}
