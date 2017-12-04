package app;

import controller.Controller;

public class Main {
	private static Controller controller;

	public static void main(String[] args) {

		controller = Controller.getInstance();
		System.out.println(controller.getLabyrinth().getGraph());
		controller.testplayer();
	}
}