package ecosysteme;
/**
 * Classe gérant les cases avec de l'eau
 * @author Paul,Armand et Louise
 *
 */
public class Eau extends Case{
	/**
	 * Constructeur
	 * @param position
	 */
	public Eau(int[] position) {
		super(2, true, false, position);
	}
	/**
	 * Constrcuteur
	 * @param typeOccupation
	 * @param estvide
	 * @param cadavre
	 * @param position
	 */
	public Eau(int typeOccupation, boolean estvide, boolean cadavre, int[] position) {
		super(2, estvide, cadavre, position);
	}

	/**
	 * getters et setters
	 */
	@Override
	public int getTypeOccupation() {
		return 2;
	}

	@Override
	public int getNourriture() {
		return 0;
	}

	@Override
	public void setNourriture(int nourriture) {		
	}

	@Override
	public void recuperation() {
	}
	
}
