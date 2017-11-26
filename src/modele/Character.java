package modele;

public abstract class Character {

	protected int posX;
	protected int posY;

	public abstract void setInitialPosition();

	public int getposX() {
		return this.posX;
	}

	public int getposY() {
		return this.posY;
	}

	public abstract void moveTop();

	public abstract void moveDown();

	public abstract void moveLeft();

	public abstract void moveRight();
}
