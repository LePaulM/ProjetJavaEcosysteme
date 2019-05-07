package ecosysteme;
/**
 * Classe gérant les cases contenant de la neige
 * @author Paul,Armand et Louise
 *
 */

public class Neige extends Case{
	/**
	 * Constructeur
	 * @param position
	 */
	public Neige(int[] position) {
		super(5, true, false, position);
	}
	/**
	 * Constructeur
	 * @param typeOccupation
	 * @param estvide
	 * @param cadavre
	 * @param position
	 */
	public Neige(int typeOccupation, boolean estvide, boolean cadavre, int[] position) {
		super(5, estvide, cadavre, position);
	}
	
	/**
	 * getters et setters
	 */
	@Override
	public int getTypeOccupation() {
		return 5;
	}
	
	@Override
	public int getNourriture() {
		return 0;
	}

	@Override
	public void setNourriture(int nourriture) {		
	}
	
	/**
	 * 
	 */
	@Override
	public void recuperation() {
	}
}
