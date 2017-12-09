package modele;

import controller.Controller;

public class Player extends Character implements ICharacter {

	public Player() {
		setPosition(Labyrinth.getInstanceLab(), (int) (Math.random() * Graph.WIDTH),
				(int) (Math.random() * Graph.WIDTH));
	}

}
