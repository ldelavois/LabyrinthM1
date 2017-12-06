package controller;

import modele.Labyrinth;
import view.View;

public class LabyrinthController {
	private Labyrinth labyrinth;
	private View viewframe;
	
	private LabyrinthController(Labyrinth lab, View vf) {
		labyrinth = lab;
		viewframe = vf;
	}
}
