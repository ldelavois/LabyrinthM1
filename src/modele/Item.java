package modele;

public class Item extends Entity implements IItem {

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
