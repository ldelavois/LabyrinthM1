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
			posY++;
		}
	}

	@Override
	public void moveDown() {
		if (posY > 0) {
			//
			posY--;
		}
	}

	@Override
	public void moveLeft() {
		if (posX > 0) {
			//
			posX --;
		}
	}

	@Override
	public void moveRight() {

		if (posX < Graph.WIDTH) {
			//
			posX ++;
		}
	}

}
