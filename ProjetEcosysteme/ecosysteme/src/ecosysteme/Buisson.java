package ecosysteme;

import Gestion.Gestionnaire;

/**
 * Cette classe gère les cases représentant les buissons
 * @author Paul,Armand et Louise
 *
 */
public class Buisson extends Case{

	/**
	 * stock de nourriture que contient le buisson
	 */
	private int nourriture;

	/**
	 * Constructeur
	 * @param position
	 */
	public Buisson(int[] position) {
		super(1, true, false, position);
		this.nourriture=10;
	}
	
	/**
	 * Constructeur
	 * @param typeOccupation
	 * @param estvide
	 * @param cadavre
	 * @param position
	 */
	public Buisson(int typeOccupation, boolean estvide, boolean cadavre, int[] position) {
		super(typeOccupation, estvide, cadavre, position);
		this.nourriture=10;
	}

	/**
	 * Getters
	 * @return
	 */
	public int getNourriture() {
		return nourriture;
	}
	

	public int getTypeOccupation() {
		return 1;
	}

	/**
	 * Setter
	 * @param nourriture
	 */
	public void setNourriture(int nourriture) {
		this.nourriture = nourriture;
	}


	/**
	 * methode qui recharge le stock de nouriiture que contient le buisson si il est vide
	 */
	public void recuperation() {

		if (nourriture==0) {

			int tourDeRecup = Gestionnaire.getTour();

			int recuperation=0;

			while(recuperation <= 3) {
				recuperation = Gestionnaire.getTour() - tourDeRecup;
				if(recuperation==3) {
					this.nourriture=10;
				}
			}
		}
	}
	
	
}
