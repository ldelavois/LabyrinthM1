
public class Main {
	public static void main(String[] args) {
		Graph g = new Graph();
		for(int x = 0; x <= 2; x++)
			for(int y = 0; y <= 2; y++)
				g.addVertex(new Vertex(x, y));
		System.out.println(g.toDot());
	}
}
