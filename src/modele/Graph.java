package modele;
import java.util.ArrayList;
import java.util.List;

import org.jgrapht.graph.SimpleGraph;

@SuppressWarnings("serial")
public class Graph extends SimpleGraph<Vertex, Edge>{
	private Vertex vertices[][];
	
	public Graph(int dimentionX, int dimentionY) {
		super(Edge.class);
		
		vertices = new Vertex[dimentionX][dimentionY];
		/* Identifiant de vertex */
		int num = 0;
		for(int x = 0; x < dimentionX; x++)
			for(int y = 0; y < dimentionY; y++) {
				vertices[x][y] = new Vertex(x, y, num++);
				addVertex(vertices[x][y]);
			}
	}
		
	public boolean contains(Vertex vertex) {
		List<Vertex> vertices = new ArrayList<Vertex>(this.vertexSet());
		return vertices.contains(vertex);
	}

	public boolean doesntExist(Vertex vertex, Directions dir) {
		switch(dir) {
		case NORTH:
			return vertex.equals(vertices[vertex.getX()][vertex.getY() - 1]);
		case SOUTH:
			return vertex.equals(vertices[vertex.getX()][vertex.getY() + 1]);		
		case EAST:
			return vertex.equals(vertices[vertex.getX() + 1][vertex.getY()]);
		case WEST:			
			return vertex.equals(vertices[vertex.getX() - 1][vertex.getY()]);
		}
		/* N'arrivera jamais */
		return false;
	}

	public Vertex getVertex(int x, int y) {
		return vertices[x][y];
	}
}
