package modele;

public interface ICharacter {

	public void setPosition();
	public void move(Directions dir);
	public int getposX();
	public int getposY();
	public Vertex getVertexPos();
}
