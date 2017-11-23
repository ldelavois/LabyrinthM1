package modele;

public class Vertex implements Comparable<Vertex> {
	private int x, y, nbr;
	
	public Vertex(int x, int y, int nbr) {
		super();
		this.x = x;
		this.y = y;
		this.nbr = nbr;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean areNeighbors (Vertex o) {
		int dx = Math.abs(x - o.x);
		int dy = Math.abs(y - o.y);
		
		return (dx==0 && dy==1)||(dx==1 && dy==0);
	}
	
	@Override
	public int compareTo(Vertex o) {
		if(x < o.x)
			return -1;
		else if(x > o.x)
			return 1;
		else if(x == o.x) {
			if(y < o.y)
				return -1;
			else if(y > o.y)
				return 1;
			else return 0;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "(" + nbr + ")";
	}

	public boolean inBorders(Directions dir) {
		return (x >= 0 && x < Labyrinth.WIDTH && y >= 0 && y < Labyrinth.HEIGHT);
	}
	
	public int getNbr() {
		return nbr;
	}	
}
