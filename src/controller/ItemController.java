package controller;

import modele.Item;
import view.View;

public class ItemController {
	
	private Item item;
	


	protected ItemController(View view) {
		item = new Item(Controller.getLabyrinth());
		view.placeItem(item);
	}
	
	public Item getItem() {
		return item;
	}
	
	public void deleteItem() {
		item = null;
	}
}
