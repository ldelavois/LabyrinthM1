package app;

import controller.Controller;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Classe permettant de lancer l'application javaFX
 * @author Ludovic, Julien, Andy, Matthias
 *
 */
public class Main extends Application {

	private static Controller controller;
	
	/**
	 * Méthode principale de l'application
	 * @param args Arguments
	 */
	public static void main(String[] args) {
		controller = Controller.getInstance();
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		controller.start(primaryStage);
	}

	@Override
	public void stop() {
		System.exit(0);
	}

}