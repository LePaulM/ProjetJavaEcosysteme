package ecosysteme;

/**
 * Cette classe définit les cases de type terrain nu
 * @author Paul, Armand et Louise
 *
 */
public class TerrainNu extends Case{
	
	/**
	 * Constructeur
	 * @param position de la case
	 */
	public TerrainNu(int[] position) {
		super(6, true, false, position);
	}
	
	/**
	 * Constrcuteur
	 * @param typeOccupation : occupation de la case
	 * @param estvide : contient-elle un animal
	 * @param cadavre : contient-elle un cadavre
	 * @param position : position de la case
	 */
	public TerrainNu(int typeOccupation, boolean estvide, boolean cadavre, int[] position) {
		super(6, estvide, cadavre, position);
	}

	/**
	 * getters et setters
	 */
	@Override
	public int getTypeOccupation() {
		return 6;
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
