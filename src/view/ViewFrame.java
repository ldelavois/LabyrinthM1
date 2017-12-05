package view;

import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class ViewFrame {
	static final int SPAN=4;
	static final int WALL=2;
	static final int CELL=9;
	public static final Paint WALL_COLOR= Color.BURLYWOOD;
	public static final Paint SCENE_COLOR= Color.WHITE;
	private static Scene scene;

	
public static void drawFrame(Stage stage, int nbrX, int nbrY)
{
	Group pane= new Group();
	scene = new Scene(pane, ((WALL + CELL)* nbrX + WALL)* SPAN,
			((WALL+CELL)* nbrY + WALL)*SPAN);
	scene.setFill(SCENE_COLOR);
	
	Rectangle square;
	stage.setScene(scene);
	
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



}
