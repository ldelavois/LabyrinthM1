package app;

import java.util.ArrayList;

import org.jgrapht.UndirectedGraph;

import modele.Edge;
import modele.Graph;
import modele.Labyrinth;
import modele.Vertex;

public class Main {
	public static void main(String[] args) {
		
		Labyrinth lab = new Labyrinth();
		System.out.println(lab.getGraph());
	}
}