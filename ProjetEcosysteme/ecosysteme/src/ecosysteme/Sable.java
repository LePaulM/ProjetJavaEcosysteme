package ecosysteme;

/**
 * Classe gérant les cases contenant du sable
 * @author formation
 *
 */
public class Sable extends Case{
	/**
	 * Constrcuteur
	 * @param position
	 */
	public Sable(int[] position) {
		super(4, true, false, position);
	}
	
	/**
	 * Constructeur
	 * @param typeOccupation
	 * @param estvide
	 * @param cadavre
	 * @param position
	 */
	public Sable(int typeOccupation, boolean estvide, boolean cadavre, int[] position) {
		super(4, estvide, cadavre, position);
	}

	/**
	 * getters et setters
	 */
	@Override
	public int getTypeOccupation() {
		return 4;
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
