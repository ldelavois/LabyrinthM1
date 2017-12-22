package controller;

import modele.Door;
import view.View;

/**
 * Controlleur pour les portes du plateau de jeu.
 * 
 * @author Ludovic, Julien, Andy, Matthias
 *
 */
public class DoorController {

	private Door door;
	
	/**
	 * Constructeur de la classe.
	 * @param view View sur laquelle on veut afficher la porte.
	 */
	protected DoorController(View view) {
		door = new Door(Controller.getLabyrinth(), true);
		//System.out.println(door.getVertexPos());
		view.placeDoor(door);
	}
	
	/**
	 * @return door La porte.
	 */
	public Door getDoor() {
		return door;
	}
}
