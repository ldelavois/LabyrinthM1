package controller;

import modele.Item;
import view.View;

/**
 * Controlleur pour les items placés sur le plateau de jeu.
 * 
 * @author Ludovic, Julien, Andy, Matthias
 *
 */
public class ItemController {
	
	private Item item;
	
	/**
	 * Constructeurbde la classe.
	 * @param view View sur laquelle on veut afficher la porte.
	 */
	public ItemController(View view) {
		item = new Item(Controller.getLabyrinth());
		view.placeItem(item);
	}
	
	/**
	 * 
	 * @return item L'item.
	 */
	public Item getItem() {
		return item;
	}
	
	/**
	 * Supprime l'item quand il a été mangé ou qu'il disparaît.
	 */
	public void deleteItem() {
		item = null;
	}
}
