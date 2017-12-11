package view;

import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modele.Edge;
import modele.Graph;
import modele.Labyrinth;
import modele.Vertex;
import controller.Controller;
import controller.LabyrinthController;
import controller.PlayerController;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * 
 * @author 
 *
 */
public class View {

	static final int SPAN = 4;
	static final int WALL = 2;
	static final int CELL = 9;
	/**
	 * 
	 */
	public static final Paint WALL_COLOR = Color.BURLYWOOD;
	/**
	 * 
	 */
	public static final Paint SCENE_COLOR = Color.WHITE;
	private Scene scene;
	public static Pane pane = new Pane();
	private Image imagePlayer = new Image("file:resources/player.png");
	ImageView player = new ImageView(imagePlayer);
	private Image imageEnnemy = new Image("file:resources/bad.png");
	ImageView ennemy = new ImageView(imageEnnemy);

	/**
	 * 
	 * @param nbrX
	 * @param nbrY
	 */
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

	/**
	 * 
	 * @param g
	 */
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
						} else if (e != null && (e.getDoorType() == Edge.DoorType.CLOSED)) {
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
						} else if (e != null && (e.getDoorType() == Edge.DoorType.CLOSED)) {
							drawWall(x, y, x + 1, y, Color.RED);
						}
					}

				}
			}
		}
	}

	/**
	 * 
	 * @param xs
	 * @param ys
	 * @param xt
	 * @param yt
	 * @param color
	 */
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

	/**
	 * 
	 * @param c
	 */
	public void updatePlayerPosition(Vertex c) {
		// TODO Ici on dessine les personnages (Vertex à remplacer par Character)

		player.setX((int) ((WALL + c.getX() * (WALL + CELL)) * SPAN));
		player.setY((int) ((WALL + c.getY() * (WALL + CELL)) * SPAN));
	}

	/**
	 * 
	 * @param c
	 */
	public void updateEnnemyPosition(Vertex c) {
		// TODO Ici on dessine les ennemies (Vertex à remplacer par Character)

		ennemy.setX((int) ((WALL + c.getX() * (WALL + CELL)) * SPAN));
		ennemy.setY((int) ((WALL + c.getY() * (WALL + CELL)) * SPAN));
	}

	/**
	 * 
	 * @param primaryStage
	 * @param lab
	 */
	public void start(Stage primaryStage, Labyrinth lab) {
		primaryStage.setScene(scene);
		primaryStage.setTitle("Labyrinthe");
		primaryStage.show();
		drawGraph(lab.getGraph());
		pane.getChildren().add(player);
		pane.getChildren().add(ennemy);
	}

	/**
	 * 
	 * @param eventhandler
	 */
	public void keyPressed(PlayerController eventhandler) {
		scene.setOnKeyPressed(eventhandler);
	}
}
