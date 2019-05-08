package ecosysteme;

import Gestion.Gestionnaire;

/**
 * Cette classe gère les cases de type arbre
 * @author Paul, Armand et Louise
 *
 */
public class Arbre extends Case{
	/**
	 * stock de nourriture que contient la foret
	 */
	private int nourriture;

	/**
	 * Contructeur
	 * @param position : position de la case
	 */
	public Arbre(int[] position) {
		super(3, true, false, position);
		this.nourriture=20;
	}
	
	/**
	 * Constrcuteur
	 * @param typeOccupation : le type d'occupation : herbe, sol nu, neige, ...
	 * @param estvide : contient-elle un animal ou non ? 
	 * @param cadavre : contient-elle un cadavre ? 
	 * @param position : position de la case
	 */
	public Arbre(int typeOccupation, boolean estvide, boolean cadavre, int[] position) {
		super(3, estvide, cadavre, position);
		this.nourriture=20;
	}


	/**
	 * Getter
	 * @return la quantité de nourriture que contient la case
	 */
	public int getNourriture() {
		return nourriture;
	}


	/**
	 * Setter
	 * @param nourriture : la quantité de nourriture que contient la case
	 */
	public void setNourriture(int nourriture) {
		this.nourriture = nourriture;
	}
	



	/**
	 * mÃ©thode qui recharge le stock de nourriture que contient le buisson si il est vide
	 */
	public void recuperation() {

		if (nourriture==0) {

			int tourDeRecup = Gestionnaire.getTour();

			int recuperation=0;

			while(recuperation <= 3) {
				recuperation = Gestionnaire.getTour() - tourDeRecup;
				if(recuperation==3) {
					this.nourriture=20;
				}
			}
		}
	}
	
	/**
	 * getter
	 */
	@Override
	public int getTypeOccupation() {
		return 3;
	}
	
}
