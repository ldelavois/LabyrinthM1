package view;

import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;


public class View {
	static final int SPAN=4;
	static final int WALL=2;
	static final int CELL=9;
	public static final Paint WALL_COLOR= Color.BURLYWOOD;
	public static final Paint SCENE_COLOR= Color.WHITE;
	private Scene scene;
	public static Group pane = new Group();

	
public View(int nbrX, int nbrY)
{
	scene = new Scene(pane, ((WALL + CELL)* nbrX + WALL)* SPAN,
			((WALL+CELL)* nbrY + WALL)*SPAN);
	scene.setFill(SCENE_COLOR);
	
	Rectangle square;
	
	square= new Rectangle(0,0,SPAN * ( nbrX * (CELL+WALL) + WALL) , WALL * SPAN ) ;
	square.setFill (WALL_COLOR) ;
	pane.getChildren().add(square) ;
	
	square= new Rectangle(0,SPAN*(nbrY*(CELL+WALL)),SPAN * (nbrX*(CELL+WALL)+WALL),WALL*SPAN) ;
	square.setFill (WALL_COLOR) ;
	pane.getChildren().add(square) ;
	
	
	square=new Rectangle(0, 0, WALL*SPAN,SPAN*(nbrY*(CELL+WALL)+WALL));
	square.setFill (WALL_COLOR) ;
	pane.getChildren().add(square) ;
	
	square = new Rectangle(SPAN*(nbrX*(CELL+WALL)), 0, WALL*SPAN,SPAN*(nbrY*(CELL+WALL)+WALL)) ;
	square.setFill (WALL_COLOR) ;
	pane.getChildren().add(square) ;
	
	
	for (int x=0; x<(nbrX-1); ++x)
		{
		int offsetX= ((WALL+CELL) + (WALL+CELL)* x)* SPAN;
		for (int y=0; y<(nbrY-1); ++y )
			{
			int offsetY = ((WALL+CELL)+(WALL+CELL)*y)* SPAN;
			square = new Rectangle(offsetX,offsetY,WALL*SPAN, WALL*SPAN ) ;
			square.setFill(WALL_COLOR) ;
			pane.getChildren().add(square);
			}
		}	
}
public void start(Stage primaryStage) {
	primaryStage.setScene(scene);
	primaryStage.setTitle("Labyrinthe");
	primaryStage.show();
}



}
