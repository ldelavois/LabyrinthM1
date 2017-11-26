package modele;

public class Enemies extends Character {

	public Enemies() {
		setInitialPosition();
	}

	@Override
	public void setInitialPosition() {
		
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
