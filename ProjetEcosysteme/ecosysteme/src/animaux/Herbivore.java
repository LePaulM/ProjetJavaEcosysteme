package animaux;

import java.awt.Color;

import ecosysteme.Case;

/**
 * Cette classe définit les carnivores hérités de la classe animal.
 * @author Paul,Armand et Louise
 *
 */

public abstract class Herbivore extends Animal{
	/**
	 * Constructeur
	 * @param dateNaissance : int : numéro du tour où l'animal est né
	 * @param emplacement : objet de type Case sur laquelle se trouve l'animal
	 * @param tpDecomposition : int temps que l'animal met à disparaitre après sa mort. Laisse du temps aux charognards pour manger le cadavre
	 * @param remplissageEstomac : int : définit l'appétit de l'animal. plus ce nombre est faible plus l'animal aura besoin de nourriture ce nombre décroit chaque tour
	 * @param maturite : définit l'age auquel l'animal est assez grand pour se reproduire
	 * @param aProcree : si l'animal a procréé récemment 
	 * @param meurtFaim : Indique le nombre de tours restants lorsque l'animal est en état de famine
	 */

	public Herbivore(int dateNaissance,  Case emplacement, 
			int tpDecomposition,  int remplissageEstomac,  int maturite,
			boolean aProcree,int meurtFaim) {
		super(dateNaissance,emplacement,tpDecomposition, 
				remplissageEstomac, maturite,aProcree,meurtFaim);
	}

	/**
	 * Cette méthode remplit l'estomac de l'animal s'il n'est pas déjà plein. 
	 * La case sur laquelle il est diminue également en quantité de nourriture.
	 */
	@Override
	public void seNourrir(){
		if (this.getRemplissageEstomac() < this.getTailleEstomac()) {
			// si la case est de type "Herbe" (0), "Buisson" (1) ou Foret (3), l'herbivore peut manger
			if(this.getEmplacement().getTypeOccupation() == 0 || this.getEmplacement().getTypeOccupation() == 1
					|| this.getEmplacement().getTypeOccupation() == 3 ) {
				if (getRemplissageEstomac() < getTailleEstomac()) {
					// si la case contient plus de nourriture que l'animal ne peut en manger, 
					// alors il mange juste à sa faim
					if (this.getEmplacement().getNourriture() > (this.getTailleEstomac() - this.getRemplissageEstomac())) {
						this.getEmplacement().setNourriture(this.getEmplacement().getNourriture() - (this.getTailleEstomac() - this.getRemplissageEstomac()));
						this.setRemplissageEstomac(this.getTailleEstomac());
					} 
					// sinon si l'animal a suffisament faim et que la case ne contient pas suffisament ou juste assez
					// de nourriture pour le rassasier, il mange tout la nourriture présente sur la case
					// le stock de nourriture tombe donc à 0
					// la case lance alors son processus de recuperation
					else if (getRemplissageEstomac() + this.getEmplacement().getNourriture() <= getTailleEstomac()){
						this.setRemplissageEstomac(getRemplissageEstomac() + this.getEmplacement().getNourriture());
						this.getEmplacement().setNourriture(this.getTailleEstomac() - this.getRemplissageEstomac());
						this.getEmplacement().setNourriture(0);
						this.getEmplacement().recuperation();
					}
				}
			}
		}
	}
	
	/**
	 *  Cette méthode gère la reproduction de l'animal.
	 */
	@Override
	public abstract void seReproduire();
}
