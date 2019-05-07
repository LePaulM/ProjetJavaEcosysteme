package ecosysteme;
/**
 * Classe gérant les cases montagnes
 * @author Paul,Armand et Louise
 *
 */
public class Montagne extends Case{
	/**
	 * Constructeur
	 * @param position
	 */
	public Montagne(int[] position) {
		super(7, true, false, position);
	}
	
	/**
	 * Constructeur
	 * @param typeOccupation
	 * @param estvide
	 * @param cadavre
	 * @param position
	 */
	public Montagne(int typeOccupation, boolean estvide, boolean cadavre, int[] position) {
		super(7, estvide, cadavre, position);
	}
	
	/**
	 * getters et setters
	 */
	@Override
	public int getTypeOccupation() {
		return 7;
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
