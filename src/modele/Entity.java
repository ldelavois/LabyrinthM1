package modele;

/**
 * Classe qui permet de représenter un "objet" inanimé ou animé sur un plateau de jeu.
 * @author Ludovic, Julien, Andy, Matthias
 *
 */
public abstract class Entity implements Collidable {
	protected int posX;
	protected int posY;
	protected Vertex vertexPos;
	
	protected Entity (Labyrinth laby) {
		setPosition(laby, (int) (Math.random() * Graph.WIDTH),
				(int) (Math.random() * Graph.WIDTH));
	}
	
	/**
	 * @return La position en x de l'objet.
	 */
	public int getposX() {
		return this.vertexPos.getX();
	}

	/**
	 * @return La position en y de l'objet.
	 */
	public int getposY() {
		return this.vertexPos.getY();
	}

	/**
	 * @return Le sommet où est positionné l'objet.
	 */
	public Vertex getVertexPos() {
		return this.vertexPos;
	}

	/**
	 * Défini la position de l'objet.
	 * @param lab Le labyrinthe.
	 * @param x Position en x.
	 * @param y Position en y.
	 */
	public void setPosition(Labyrinth lab, int x, int y) {

		this.posX = x;
		this.posY = y;
		this.vertexPos = lab.getGraph().getVertex(x, y);
	}
	
	/**
	 * Permet de savoir si deux objets sont en collision.
	 * @param c Objet avec lequel on veut tester la collision.
	 */
	public boolean collision(Collidable c) {
		return ((Entity) c).getposX() == posX && ((Entity) c).getposY() == posY;
	}
}
