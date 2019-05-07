package animaux;
import java.awt.Color;

import ecosysteme.Case;
/**
 * Cette classe définit les charognards hérités de la classe animal
 * @author Paul,Armand et Louise
 *
 */

public abstract class Charognard extends Animal {
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
	public Charognard(int dateNaissance, Case emplacement,  
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
		// si l'animal est vivant
		if (getEstVivant() == true) {
			// si l'animal n'est pas rassasi� 
			if (this.getRemplissageEstomac() < this.getTailleEstomac()) {
				// si la case contient un cadavre, le charognard peut manger
				if(this.getEmplacement().getCadavre() == true) {
					if (this.getEmplacement().getAnimal().getViande() > 0) {			// si le cadavre a de la viande
						if (getRemplissageEstomac() < getTailleEstomac()) {
							// si la case contient plus de nourriture que l'animal ne peut en manger, 
							// alors il mange juste à sa faim
							if (this.getEmplacement().getAnimal().getViande() > (this.getTailleEstomac() - this.getRemplissageEstomac())) {
								this.getEmplacement().getAnimal().setViande(this.getEmplacement().getAnimal().getViande() - (this.getTailleEstomac() - this.getRemplissageEstomac()));
								this.setRemplissageEstomac(this.getTailleEstomac());
								this.setRemplissageEstomac(getRemplissageEstomac() + this.getEmplacement().getAnimal().getViande());
							} 
							// sinon si l'animal a suffisament faim et que la case ne contient pas suffisament ou juste assez
							// de nourriture pour le rassasier, il mange tout la nourriture présente sur la case
							// le stock de nourriture tombe donc à 0 et la case ne contient plus de cadavre
							else if (getRemplissageEstomac() + this.getEmplacement().getAnimal().getViande() <= getTailleEstomac()){
								this.setRemplissageEstomac(getRemplissageEstomac() + this.getEmplacement().getAnimal().getViande());
								this.getEmplacement().getAnimal().setViande(this.getTailleEstomac() - this.getRemplissageEstomac());
								this.getEmplacement().getAnimal().setViande(0);
								this.getEmplacement().setACadavre(false); 
							}
						}
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
