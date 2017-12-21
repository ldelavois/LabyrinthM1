package modele;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;
import java.util.Vector;

/**
 * 
 * @author Ludovic, Julien, Matthias, Andy
 *
 */
public class Labyrinth {

	private Random rand;
	private Graph graph;

	/**
	 * Constructeur du labyrinth. G��n��re un chemin al��atoire (via {@link Graph}).
	 */
	public Labyrinth() {
		graph = new Graph();
		rand = new Random();
		Vertex v = new Vertex(0, 0, 0);
		graph.addVertex(v);
		buildRandomPath(v);
	}

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
	 * @return Le graph servant de base pour notre labyrinthe.
	 */
	public Graph getGraph() {
		return graph;
	}
	
	private void calculateManhattanDistance(Vertex source, Vertex target) {
		Queue<Vertex> fifo = new ArrayDeque<Vertex>();
		target.setNbr(1);
		fifo.add(target);
		while (!fifo.isEmpty()) {
			Vertex current = fifo.remove();
			for (Directions dir : Directions.values()) {
				if (!this.isWall(current, dir)) {
					Vertex next = graph.getVertexByDir(current, dir);
					if (next != null && next.getNbr() == 0) {
						next.setNbr(current.getNbr() + 1);
						if (next != source)
							fifo.add(next);
					}
				}
			}
		}
	}

	/**
	 * Lance l'aglorithme de Manhattan. Cel�� permet de chercher le chemin entre deux sommets dans un labyrinthe.
	 * @param source Le sommet de d��part.
	 * @param target Le sommet cible.
	 */
	public void launchManhattan(Vertex source, Vertex target) {
		for (Vertex vertex : graph.vertexSet())
			vertex.setNbr(0);
		calculateManhattanDistance(source, target);
	}

	/**
	 * Test si il y a un mur entre 2 sommets
	 * @param vertex Le sommet de d��part
	 * @param dir Le sommet cible
	 * @return Vrai si il y a un mur entre les commets (i.e pas d'arr��te), faux sinon
	 */
	public boolean isWall(Vertex vertex, Directions dir) {
		Edge edge = null;
		switch (dir) {
		case NORTH:
			edge = graph.getEdge(vertex, graph.getVertex(vertex.getX(), vertex.getY() - 1));
			break;
		case SOUTH:
			edge = graph.getEdge(vertex, graph.getVertex(vertex.getX(), vertex.getY() + 1));
			break;
		case WEST:
			edge = graph.getEdge(vertex, graph.getVertex(vertex.getX() - 1, vertex.getY()));
			break;
		case EAST:
			edge = graph.getEdge(vertex, graph.getVertex(vertex.getX() + 1, vertex.getY()));
			break;

		}
		return (edge == null);
	}

}
