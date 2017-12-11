package app;

import controller.Controller;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	private static Controller controller;

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