package modele;

/**
 * 
 * @author Ludovic, Julien, Andy, Matthias
 *
 */
public class Item extends Entity  {
	private int value;
	
	public Item (Labyrinth laby) {
		super (laby);
		value = (int) (Math.random() * 4);
	}
	
	public int getValue () {
		return value;
	}
	
}
