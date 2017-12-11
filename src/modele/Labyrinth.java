package modele;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;
import java.util.Vector;

/**
 * 
 * @author 
 *
 */
public class Labyrinth {

	private Random rand;
	private Graph graph;
	private static Labyrinth lab;

	/**
	 * 
	 */
	public Labyrinth() {
		graph = new Graph();
		rand = new Random();
		Vertex v = new Vertex(0, 0, 0);
		graph.addVertex(v);
		buildRandomPath(v);
	}

	/**
	 * 
	 * @param vertex
	 */
	private void buildRandomPath(Vertex vertex) {
		Vector<Directions> v = new Vector<Directions>();
		for (int i = 0; i < 4; i++)
			v.add(Directions.values()[i]);

		Directions directions[] = new Directions[4];
		for (int i = 0; i < directions.length; i++) {
			int index = rand.nextInt(v.size());
			directions[i] = v.get(index);
			v.remove(index);
		}

		for (int i = 0; i < 4; i++) {
			Directions dir = directions[i];
			if (vertex.inBorders(dir) && graph.doesntExist(vertex, dir)) {
				int x = vertex.getX();
				int y = vertex.getY();
				int xt = 0, yt = 0;
				switch (dir) {
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

	/**
	 * 
	 * @return
	 */
	public Graph getGraph() {
		return graph;
	}

	public void setGraph(Graph graph) {
		this.graph = graph;
	}

	/**
	 * 
	 * @param source
	 * @param target
	 */
	private void calculateManhattanDistance(Vertex source, Vertex target) {
		Queue<Vertex> fifo = new ArrayDeque<Vertex>();
		target.setNbr(1);
		fifo.add(target);
		while (!fifo.isEmpty()) {
			Vertex current = fifo.remove();
			for (Directions dir : Directions.values()) {
				if (!this.isWall(current, dir)) {
					Vertex next = graph.getVertexByDir(current, dir);
					if (next.getNbr() == 0) {
						next.setNbr(current.getNbr() + 1);
						if (next != source)
							fifo.add(next);
					}
				}
			}
		}
	}

	/**
	 * 
	 * @param source
	 * @param target
	 */
	public void launchManhattan(Vertex source, Vertex target) {
		for (Vertex vertex : graph.vertexSet())
			vertex.setNbr(0);
		calculateManhattanDistance(source, target);
	}

	/**
	 * 
	 * @param vertex
	 * @param dir
	 * @return
	 */
	public boolean isWall(Vertex vertex, Directions dir) {
		Edge edge = graph.getEdge(vertex, dir);
		return (edge == null);
	}

}
