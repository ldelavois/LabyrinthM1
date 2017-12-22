package modele;

/**
 * Cette classe permet de créer des items à intégrer sur un plateau de jeu.
 * @author Ludovic, Julien, Andy, Matthias
 *
 */
public class Item extends Entity  {
	private int value;
	
	/**
	 * Constructeur de la classe.
	 * @param laby Le labyrinthe sur lequel placer l'item.
	 */
	public Item (Labyrinth laby) {
		super (laby);
		value = (int) (Math.random() * 4);
	}
	
	/**
	 * Retourne la valeur de l'item. Peut être utilisé pour différencier des niveaux d'items.
	 * @return La valeur de l'item.
	 */
	public int getValue () {
		return value;
	}
	
}
