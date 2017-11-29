package modele;

import java.util.Random;
import java.util.Vector;

public class Labyrinth {

	private Random rand;
	private Graph graph;
	
	public Labyrinth () {
		graph = new Graph();
		rand = new Random();
		Vertex v = new Vertex(0, 0, 0);
		graph.addVertex(v);
		buildRandomPath(v);
	}
	
	private void buildRandomPath (Vertex vertex) {
		Vector<Directions> v = new Vector<Directions>();
		for(int i = 0; i < 4; i++)
			v.add(Directions.values()[i]);
		
		Directions directions[] = new Directions[4];
		for(int i = 0; i < directions.length; i++) {
			int index = rand.nextInt(v.size());
			directions[i] = v.get(index);
			v.remove(index);
		}
		
		for(int i = 0; i < 4; i++) {
			Directions dir = directions[i];
			if(vertex.inBorders(dir) && graph.doesntExist(vertex, dir)) {
				int	x = vertex.getX();
				int	y = vertex.getY();
				int	xt = 0, yt = 0;
				switch(dir)
				{
				case NORTH:
					xt = x;
					yt = y - 1;
					break;
				case SOUTH:   
					xt = x;
					yt = y + 1;
					break;
				case EAST:
					xt = x + 1;   
					yt = y;
					break;
				case WEST:
					xt = x - 1;
					yt = y;
					break;
				}
				Vertex next = new Vertex(xt, yt, vertex.getNbr() + 1);
				graph.addVertex(next);
				graph.addEdge(vertex, next);
				buildRandomPath(next);
			}
		}
	}

	public Graph getGraph() {
		return graph;
	}

	public void setGraph(Graph graph) {
		this.graph = graph;
	}
}
