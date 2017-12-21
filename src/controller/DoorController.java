package controller;

import modele.Door;
import modele.Player;
import view.View;

public class DoorController {

	private Door door;
	private View view;

	protected DoorController(View view) {
		door = new Door(Controller.getLabyrinth(), true);
		view.updatePlayerPosition(door.getVertexPos());
	}
	
	public Door getDoor() {
		return door;
	}
}
