package app;

import modele.Labyrinth;
import modele.Vertex;

public class Main {
	public static void main(String[] args) {
		Labyrinth lab = new Labyrinth(new Vertex(0,0,1));
		System.out.println(lab.getGraph());
		
	}
}