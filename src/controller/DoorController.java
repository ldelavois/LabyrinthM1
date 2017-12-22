package controller;

import modele.Door;
import view.View;

public class DoorController {

	private Door door;

	protected DoorController(View view) {
		door = new Door(Controller.getLabyrinth(), true);
		System.out.println(door.getVertexPos());
		view.placeDoor(door);
	}
	
	public Door getDoor() {
		return door;
	}
}
