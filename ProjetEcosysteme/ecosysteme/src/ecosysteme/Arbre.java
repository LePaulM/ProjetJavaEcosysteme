package ecosysteme;

import Gestion.Gestionnaire;

/**
 * Cette classe gère les cases représentant les arbres
 * @author Paul,Armand et Louise
 *
 */
public class Arbre extends Case{
	/**
	 * stock de nourriture que contient la foret
	 */
	private int nourriture;

	/**
	 * Constructeur
	 * @param position : 
	 */
	public Arbre(int[] position) {
		super(3, true, false, position);
		this.nourriture=20;
	}
	
	/**
	 * Constructeur 
	 * @param typeOccupation
	 * @param estvide
	 * @param cadavre
	 * @param position
	 */
	public Arbre(int typeOccupation, boolean estvide, boolean cadavre, int[] position) {
		super(3, estvide, cadavre, position);
		this.nourriture=20;
	}


	/**
	 * Getters
	 * @return
	 */
	public int getNourriture() {
		return nourriture;
	}
	
	@Override
	public int getTypeOccupation() {
		return 3;
	}

	/**
	 * Setter
	 * @param nourriture
	 */
	public void setNourriture(int nourriture) {
		this.nourriture = nourriture;
	}

	/**
	 * méthode qui recharge le stock de nouriiture que contient le buisson si il est vide
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
	


	
}
