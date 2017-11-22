package modele;

public class Vertex implements Comparable<Vertex> {
	private int x, y;
	
	public Vertex(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toDot() {
		StringBuilder s = new StringBuilder();
		s.append('a' + x + '_' + y);
		return s.toString();		
	}
	
	@Override
	public int compareTo(Vertex o) {
		if (o.x < x)
			return -1;
		else if (o.x > x)
			return 1;
		else
		{
			if (o.y > y)
				return 1;
			else if (o.y < y)
				return -1;
		}
		return 0;
	}

}
