package modele;

/**
 * 
 * @author 
 *
 */
public abstract class Character extends Entity implements ICharacter {

	/**
	 * Déplace le character dans la direction dir si il n'y a pas de mur 
	 * @param lab : Le labyrinthe
	 * @param dir : La direction
	 */
	public void move(Labyrinth lab, Directions dir) {
		if (!(lab.isWall(vertexPos, dir))) {
			switch (dir) {
			case NORTH:
				posY--;
				vertexPos = lab.getGraph().getVertex(posX, posY);
				break;

			case SOUTH:
				posY++;
				vertexPos = lab.getGraph().getVertex(posX, posY);
				break;

			case WEST:
				posX--;
				vertexPos = lab.getGraph().getVertex(posX, posY);
				break;

			case EAST:
				posX++;
				vertexPos = lab.getGraph().getVertex(posX, posY);
				break;
			}
		} else
			System.out.println("Wall");
	}
	
	// TODO Implémenter les collisions ici
	public boolean collision(Collidable c) {
		return false;
	}
}
