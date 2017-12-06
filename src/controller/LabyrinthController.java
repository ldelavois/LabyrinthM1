package controller;

import modele.Labyrinth;
import view.ViewFrame;

public class LabyrinthController {
	private Labyrinth labyrinth;
	private ViewFrame viewframe;
	
	private LabyrinthController(Labyrinth lab, ViewFrame vf) {
		labyrinth = lab;
		viewframe = vf;
	}
}
