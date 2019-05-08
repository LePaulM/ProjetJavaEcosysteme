package ecosysteme;
/**
 * Classe gérant les cases contenant de la neige
 * @author Paul,Armand et Louise
 *
 */

public class Neige extends Case{
	/**
	 * Constructeur
	 * @param position : position de la case
	 */
	public Neige(int[] position) {
		super(5, true, false, position);
	}
	/**
	 * Constructeur
	 * @param typeOccupation : quel est le type d'occupation de la case (ici de la neige)
	 * @param estvide : contient-elle un animal ? 
	 * @param cadavre : contient-elle un cadavre ? 
	 * @param position : position de la case
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
