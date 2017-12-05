package app;

import controller.Controller;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{
	
	private static Controller controller;

	public static void main(String[] args) {

		controller = Controller.getInstance();
		System.out.println(controller.getLabyrinth().getGraph());
		controller.testplayer();
		launch();
	}

	@Override
	public void start(Stage stage)  {
		Controller.makeInstance(); //à créer (voir TD3)
		Controller.start(stage); 	//à créer (voir TD3)
	}
		
	@Override 
	public void stop()
	{
		System.exit(0);
	}
	
		
		
		
	}