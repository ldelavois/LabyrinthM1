package modele;

public class Item implements IItem, Collidable {

	@Override
	public void setPosition(int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onPlayer(Player player) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean collision(Collidable c) {
		// TODO Auto-generated method stub
		return false;
	}

}
