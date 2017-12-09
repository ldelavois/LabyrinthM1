package modele;

public interface ICharacter {

	public void setPosition(Labyrinth lab, int x, int y);

	public void move(Labyrinth lab, Directions dir);

	public int getposX();

	public int getposY();

	public Vertex getVertexPos();
}
