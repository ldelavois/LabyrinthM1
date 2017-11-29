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
	
	@Override
	public boolean equals(Object o) {
		return x == ((Vertex) o).getX() && y == ((Vertex) o).getY();
	}

	public boolean inBorders(Directions dir) {
		boolean verif = false;
		switch(dir)
		{
		case NORTH:
			verif = x >= 0 && x < Graph.WIDTH && y - 1 >= 0 && y - 1 < Graph.HEIGHT;
			break;
		case SOUTH:   
			verif = x >= 0 && x < Graph.WIDTH && y + 1 >= 0 && y + 1 < Graph.HEIGHT;
			break;
		case EAST:
			verif = x + 1 >= 0 && x + 1 < Graph.WIDTH && y >= 0 && y < Graph.HEIGHT;
			break;
		case WEST:
			verif = x - 1 >= 0 && x - 1 < Graph.WIDTH && y >= 0 && y < Graph.HEIGHT;
			break;
		}
		return verif;
	}
	
	public int getNbr() {
		return nbr;
	}

	public void setNbr(int i) {
		nbr=i;
	}	
}
