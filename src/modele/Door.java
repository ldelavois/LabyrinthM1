package modele;

/**
 * 
 * @author Ludovic, Julien, Andy, Matthias
 *
 */
public class Door extends Entity {
	
	private boolean openned;
	
	/**
	 * Constructeur de la classe Door
	 */
	public Door (Labyrinth laby, boolean openned) {
		super (laby);
		this.openned = openned;
	}
	
	/**
	 * Fonction permettant de savoir si une porte est ouverte.
	 * @return Vrai si la porte est ouverte faux sinon
	 */
	public boolean openned () {
		return openned;
	}
	
	/**
	 * Ouvre la porte si elle était fermée et inversement.
	 */
	public void toggle () {
		openned = !openned;
	}
}
