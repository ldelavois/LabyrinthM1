package view;

import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import modele.Door;
import modele.Edge;
import modele.Graph;
import modele.Item;
import modele.Labyrinth;
import modele.Vertex;
import controller.Controller;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * 
 * @author Ludovic, Julien, Andy, Matthias
 *
 */
public class View {

	static final int SPAN = 4;
	static final int WALL = 2;
	static final int CELL = 9;
	/**
	 * Couleur des murs
	 */
	public static final Paint WALL_COLOR = Color.BURLYWOOD;
	/**
	 * Couleur de fond de la scene
	 */
	public static final Paint SCENE_COLOR = Color.WHITE;
	private Scene scene;
	public static Pane pane = new Pane();
	private Image imagePlayer = new Image("file:resources/player.png");
	ImageView player = new ImageView(imagePlayer);
	private Image imageEnnemy = new Image("file:resources/bad.png");
	ImageView ennemy = new ImageView(imageEnnemy);
	private Image imageDoor = new Image("file:resources/door_open.png");
	ImageView door = new ImageView(imageDoor);
	private Image imageCandy1 = new Image("file:resources/candy-1.png");
	ImageView candy1= new ImageView(imageCandy1);


	/**
	 * Constructeur de la vue. Crée la fenêtre et le plateau de jeu.
	 * @param nbrX Taille en x.
	 * @param nbrY Taille en y.
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
	
	private void drawGraph(Graph g) {
		Edge e;
		for (int x = 0; x < Graph.WIDTH; x++) {
			for (int y = 0; y < Graph.HEIGHT; y++) {

				if (x + 1 < Graph.WIDTH) {
					e = g.getEdge(g.getVertex(x, y), g.getVertex(x + 1, y));
					if (e == null) {
						drawWall(x, y, x + 1, y, WALL_COLOR);
					}
				}

				if (y + 1 < Graph.HEIGHT) {
					e = g.getEdge(g.getVertex(x, y), g.getVertex(x, y + 1));
					if (e == null) {
						drawWall(x, y, x, y + 1, WALL_COLOR);
					}

				}
			}
		}
	}

	private void drawWall(int xs, int ys, int xt, int yt, Paint color) {
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
	 * Modifie la position du joueur.
	 * @param c La nouvelle position
	 */
	public void updatePlayerPosition(Vertex c) {
		placeSprite(player, c);
	}

	/**
	 * Met à jour la position d'un ennemi.
	 * @param c La nouvelle position
	 */
	public void updateEnnemyPosition(Vertex c) {
		placeSprite (ennemy, c);
	}
	
	/**
	 * Place la porte
	 * @param c La nouvelle position
	 */
	public void placeDoor (Door d) {
		placeSprite (door, d.getVertexPos());
	}
	
	/**
	 * Place les items à ramasser
	 * @param c La position de l'item
	 */
	public void placeItem(Item i) {
		placeSprite (candy1, i.getVertexPos());
	}
	


	private void placeSprite (ImageView i, Vertex v) {
		i.setX((int) ((WALL + v.getX() * (WALL + CELL)) * SPAN));
		i.setY((int) ((WALL + v.getY() * (WALL + CELL)) * SPAN));
	}
	
	public void deleteCandy(){
		pane.getChildren().remove(candy1);
		}
	/**
	 * Démare le jeu en dessinant le labyrinthe et en positionnant les personnages et collectibles.
	 * @param primaryStage L'objet stage de la fenêtre.
	 * @param lab Le labyrinthe à dessiner.
	 */
	public void start(Stage primaryStage, Labyrinth lab) {
		primaryStage.setScene(scene);
		primaryStage.setTitle("Labyrinthe");
	    System.out.println("A vous de jouer!");
		primaryStage.show();
		drawGraph(lab.getGraph());
		pane.getChildren().add(player);
		pane.getChildren().add(ennemy);
		pane.getChildren().add(door);
		pane.getChildren().add(candy1); 
		//pane.getChildren().remove(candy1);
	}

	/**
	 * Permet de désigner le traitant à utiliser pour les évennements.
	 * @param eventhandler Le traitant.
	 */
	public void keyPressed(Controller eventhandler) {
		scene.setOnKeyPressed(eventhandler);
	}

	
}
