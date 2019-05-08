package ecosysteme;

/**
 * Classe gérant les cases contenant du sable
 * @author formation
 *
 */
public class Sable extends Case{
	/**
	 * Constrcuteur
	 * @param position : position de la case
	 */
	public Sable(int[] position) {
		super(4, true, false, position);
	}
	
	/**
	 * Constructeur
	 * @param typeOccupation : quel est le type d'occupation de cette case (ici du sable)
	 * @param estvide : la case contient-elle un animal
	 * @param cadavre : la case contient-elle un cadavre
	 * @param position : position de la case
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
