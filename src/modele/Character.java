package modele;

public abstract class Character {

	protected int posX;
	protected int posY;
	protected Vertex vertexPos;

	public abstract void setPosition();

	public int getposX() {
		return this.vertexPos.getX();
	}

	public int getposY() {
		return this.vertexPos.getY();
	}

	public abstract void move(Directions dir);
}