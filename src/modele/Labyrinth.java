package modele;

import java.util.ArrayDeque;
import java.util.Queue;
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
	
	private void calculateManhattanDistance(Vertex source, Vertex target) {
		Queue<Vertex> fifo = new ArrayDeque<Vertex>();
		target.setNbr(1);
		fifo.add(target);
		while(!fifo.isEmpty()) {
			Vertex current = fifo.remove();
			for(Directions dir : Directions.values()) {
				if(this.isOpened(current, dir)) {
					Vertex next = graph.getVertexByDir(current, dir);
					if(next.getNbr()==0) {
						next.setNbr(current.getNbr()+1);
						if(next!=source)
							fifo.add(next);
					}
				}
			}
		}
	}
	
	private boolean isOpened(Vertex v, Directions dir) {
		boolean verif = false;
		for(Edge e: graph.edgeSet()) {
			Vertex source = e.source();
			Vertex target = e.target();
			Vertex v2 = null;
			if(source.equals(v)) v2 = target;
			if(target.equals(v)) v2 = source;
			if(v.equals(source) || v.equals(target)) {
				switch(dir)
				{
				case NORTH:
					verif = v.getX() == v2.getX() && v.getY() == v2.getY() - 1;
					break;
				case SOUTH:   
					verif = v.getX() == v2.getX() && v.getY() == v2.getY() + 1;
					break;
				case EAST:
					verif = v.getX() == v2.getX() + 1 && v.getY() == v2.getY();
					break;
				case WEST:
					verif = v.getX() == v2.getX() - 1 && v.getY() == v2.getY();
					break;
				}
			}
			if(verif) return verif;
		}
		return verif;
	}

	public void launchManhattan(Vertex source, Vertex target) {
		for(Vertex vertex : graph.vertexSet())
			vertex.setNbr(0);
		calculateManhattanDistance(source, target);
	}
}
