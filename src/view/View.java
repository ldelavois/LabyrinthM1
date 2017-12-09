package view;

import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import modele.Edge;
import modele.Graph;
import modele.Labyrinth;
import controller.Controller;
import controller.LabyrinthController;
import controller.PlayerController;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class View {
	
	static final int SPAN = 4;
	static final int WALL = 2;
	static final int CELL = 9;
	public static final Paint WALL_COLOR = Color.BURLYWOOD;
	public static final Paint SCENE_COLOR = Color.WHITE;
	private Scene scene;
	public static Group pane = new Group();

	
	public View(int nbrX, int nbrY) {
		scene = new Scene(pane, ((WALL + CELL) * nbrX + WALL) * SPAN, ((WALL + CELL) * nbrY + WALL) * SPAN);
		scene.setFill(SCENE_COLOR);

		Rectangle square;

		square = new Rectangle(0, 0, SPAN * (nbrX * (CELL + WALL) + WALL), WALL * SPAN);
		square.setFill(WALL_COLOR);
		pane.getChildren().add(square);

		square = new Rectangle(0, SPAN * (nbrY * (CELL + WALL)), SPAN * (nbrX * (CELL + WALL) + WALL), WALL * SPAN);
		square.setFill(WALL_COLOR);
		pane.getChildren().add(square);

		square = new Rectangle(0, 0, WALL * SPAN, SPAN * (nbrY * (CELL + WALL) + WALL));
		square.setFill(WALL_COLOR);
		pane.getChildren().add(square);

		square = new Rectangle(SPAN * (nbrX * (CELL + WALL)), 0, WALL * SPAN, SPAN * (nbrY * (CELL + WALL) + WALL));
		square.setFill(WALL_COLOR);
		pane.getChildren().add(square);

		for (int x = 0; x < (nbrX - 1); ++x) {
			int offsetX = ((WALL + CELL) + (WALL + CELL) * x) * SPAN;
			for (int y = 0; y < (nbrY - 1); ++y) {
				int offsetY = ((WALL + CELL) + (WALL + CELL) * y) * SPAN;
				square = new Rectangle(offsetX, offsetY, WALL * SPAN, WALL * SPAN);
				square.setFill(WALL_COLOR);
				pane.getChildren().add(square);
			}
		}
	}
	
	public void drawGraph(Graph g) {
		Edge e;
		for (int x = 0; x < Graph.WIDTH; x++) {
			for (int y = 0; y < Graph.HEIGHT; y++) {
				if (x + 1 < Graph.WIDTH) {
					e = g.getEdge(g.getVertex(x, y), g.getVertex(x + 1, y));
					if (e == null || (e.getDoorType() != Edge.DoorType.NONE)) {
						drawWall(x, y, x + 1, y, WALL_COLOR);
						if (e != null && (e.getDoorType() == Edge.DoorType.OPENED)) {
							drawWall(x, y, x + 1, y, Color.RED);
						}
						else if (e != null && (e.getDoorType() == Edge.DoorType.CLOSED)) {
							drawWall(x, y, x + 1, y, Color.GREEN);
						}
					}
				}

				if (y + 1 < Graph.HEIGHT) {
					e = g.getEdge(g.getVertex(x, y), g.getVertex(x, y + 1));
					if (e == null || (e.getDoorType() != Edge.DoorType.NONE)) {
						drawWall(x, y, x, y + 1, WALL_COLOR);
						if (e != null && (e.getDoorType() == Edge.DoorType.OPENED)) {
							drawWall(x, y, x, y + 1, Color.GREEN);
						}
						else if (e != null && (e.getDoorType() == Edge.DoorType.CLOSED)) {
							drawWall(x, y, x + 1, y, Color.RED);
						}
					}

				}
			}
		}
	}
	
	public void drawWall(int xs, int ys, int xt, int yt, Paint color) {
		int x = 0, y = 0, xspan = 0, yspan = 0;
		if (ys == yt) {
			x = ((WALL + CELL) + (WALL + CELL) * ((int) (xs + xt) / 2)) * SPAN;
			y = (WALL + ys * (WALL + CELL)) * SPAN;
			xspan = WALL * SPAN;
			yspan = CELL * SPAN;
			Rectangle square = new Rectangle(x, y, xspan, yspan);
			square.setFill(color);
			pane.getChildren().add(square);
		} else if (xs == xt) {
			x = (WALL + xs * (WALL + CELL)) * SPAN;
			y = ((WALL + CELL) + (WALL + CELL) * ((int) (ys + yt) / 2)) * SPAN;
			xspan = CELL * SPAN;
			yspan = WALL * SPAN;
			Rectangle square = new Rectangle(x, y, xspan, yspan);
			square.setFill(color);
			pane.getChildren().add(square);
		}
	}


	public void start(Stage primaryStage, Labyrinth lab) {
		primaryStage.setScene(scene);
		primaryStage.setTitle("Labyrinthe");
		primaryStage.show();
		drawGraph(lab.getGraph());
	}

	public void keyPressed(PlayerController eventhandler) {
		scene.setOnKeyPressed(eventhandler);
	}
}
