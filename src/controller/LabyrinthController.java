package controller;

import modele.Labyrinth;
import view.View;

/**
 * 
 * @author 
 *
 */
public class LabyrinthController {
	private Labyrinth labyrinth;
	private View viewframe;
	
	/**
	 * 
	 * @param lab
	 * @param vf
	 */
	private LabyrinthController(Labyrinth lab, View vf) {
		labyrinth = lab;
		viewframe = vf;
	}
}
