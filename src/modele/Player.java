package modele;

public class Player extends Character {

	public Player() {
		setInitialPosition();
	}

	@Override
	public void setInitialPosition() {
		this.posX = Graph.WIDTH / 2;
		this.posY = Graph.HEIGHT / 2;
	}

	@Override
	public void moveTop() {
		if (posY < Graph.HEIGHT) {
			// if
			posY += 1;
		}
	}

	@Override
	public void moveDown() {
		if (posY > 0) {
			//
			posY -= 1;
		}
	}

	@Override
	public void moveLeft() {
		if (posX < Graph.WIDTH) {
			//
			posX += 1;
		}
	}

	@Override
	public void moveRight() {
		if (posX > 0) {
			//
			posX -= 1;
		}

	}

}
