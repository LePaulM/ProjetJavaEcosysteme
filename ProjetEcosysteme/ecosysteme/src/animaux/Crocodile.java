package animaux;

import java.awt.Color;
import java.util.ArrayList;

import AffichageGraphique.ZDialog;
import Gestion.Gestionnaire;
import ecosysteme.Case;
import ecosysteme.Grille;

/**
 * Cette classe définit les crocodiles en rédéfinissant les méthodes de la classe mère Carnivore.
 * @author Paul,Armand et Louise
 *
 */

public class Crocodile extends Carnivore{
	/**
	 * Constructeur
	 * @param dateNaissance : int numéro du tour où l'animal est né
	 * @param emplacement : objet de type Case sur laquelle se trouve l'animal
	 * @param tpDecomposition : int temps que l'animal met à disparaitre après sa mort. Laisse du temps aux charognards pour manger le cadavre
	 * @param couleur : Color couleur de l'animal sur la carte
	 * @param remplissageEstomac : int définit l'appétit de l'animal. plus ce nombre est faible plus l'animal aura besoin de nourriture ce nombre décroit chaque tour
	 * @param maturite : définit l'age auquel l'animal est assez grand pour se reproduire
	 * @param aProcree : si l'animal a procréé récemment
	 * @param meurtFaim : Indique le nombre de tours restants lorsque l'animal est en état de famine
	 */
	public Crocodile(int dateNaissance,  Case emplacement,
			int tpDecomposition,  Color couleur, int remplissageEstomac,  int maturite,
			boolean aProcree,int meurtFaim) {
		super(dateNaissance, emplacement, tpDecomposition,
				remplissageEstomac,maturite,aProcree,meurtFaim);

		// on donne un id à l'animal
		this.id = Gestionnaire.getAnimaux().size() + 1;

		//		donne une espérance de vie d'au moins 70 tours et pouvant aller jusqu'à 1/5 de plus
		this.esperanceVie = 70;
		esperanceVie = esperanceVie + (int)(Math.random() * this.esperanceVie/5);

		// le crocodile a accès aux cases de forêt
		accesForet = true;

		// le crocodile a une vitesse de 1
		vitesse = 1;
		
		//le crocodile est vert
		couleur=Color.green;
	}

	/**
	 * 	Cette méthode permet à 2 animaux de la même espèce de se reproduire s'ils sont sur des cases adjacentes et de produire ainsi 
	 *  un nouvel animal de la même espèce.
	 */
	@Override
	public void seReproduire() {
		if (this.getEstVivant() == false) {					// on vérifie que l'animal est vivant (on ne se reproduit que vivant, c'est la règle...)
		} else {
			if (this.getAProcree() == true) {				// on vérifie que l'animal est mature et ne s'est pas reproduit récemment
			} else {
				if (Gestionnaire.getAnimaux().size() == ZDialog.getAnimauxTot()) {		// on vérifie qu'il n'y a pas trop d'animaux sur le plateau
				} else {
					// il faut mettre la reproduction dans les classes des animaux 
					// car Animal est une classe abstraite (on ne peut pas instancier un objet d'une classe abstraite
					// Création de la liste des cases adjacentes
					ArrayList<Case> cases = new ArrayList<Case>();
					// Définition des cases adjacentes
					Case case1 = Grille.getCase(this.getEmplacement().getX()-1, this.getEmplacement().getY()-1);
					cases.add(case1);
					Case case2 = Grille.getCase(this.getEmplacement().getX(), this.getEmplacement().getY()-1);
					cases.add(case2);
					Case case3 = Grille.getCase(this.getEmplacement().getX()+1, this.getEmplacement().getY()-1);
					cases.add(case3);
					Case case4 = Grille.getCase(this.getEmplacement().getX()-1, this.getEmplacement().getY());
					cases.add(case4);
					Case case5 = Grille.getCase(this.getEmplacement().getX()+1, this.getEmplacement().getY());
					cases.add(case5);
					Case case6 = Grille.getCase(this.getEmplacement().getX()-1, this.getEmplacement().getY()+1);
					cases.add(case6);
					Case case7 = Grille.getCase(this.getEmplacement().getX(), this.getEmplacement().getY()+1);
					cases.add(case7);
					Case case8 = Grille.getCase(this.getEmplacement().getX()+1, this.getEmplacement().getY()+1);
					cases.add(case8);
					for (Case c : cases){ 
						if (c.getEstVide() == false) {											//			Si une des cases adjacentes n'est pas vide, 
						}																		
						if (c.getAnimal().getEstVivant() == true )								// si l'animal présent sur la case adjacente est vivant
							if (c.getAnimal().getEspece().equals(this.getEspece()))	{			// si l'animal présent sur la case adjacente est de la même espèce, 
								if (c.getAnimal().getAProcree() == false) {						// et enfin si l'autre animal n'a pas déjà procréé récemment 
									this.setAProcree(true);											// 			la variable permettant de savoir si l'animal a procree devient true
									for (Case cbis : cases){											// 			on cherche ensuite  
										if (c.getEstVide() == true) {									//			une case vide 
											Animal tigre = new Tigre (Gestionnaire.getTour(),cbis,
													this.getTempsDecomposition(),  this.couleur, this.tailleEstomac/2,  this.getMaturite(),	// pour créer un nouvel individu
													this.getAProcree(),this.getMeurtFaim());
											Gestionnaire.addAnimal(tigre);								//			on ajoute l'animal au gestionnaire
											break;														//			l'animal se reproduit et arrête de vérifier 
										}
									}
								}
							}
					}
				}
			}
		}
	}
	
	/**
	 * définition de la taille de l'estomac et de la viande disponible sur l'animal en fonction de son âge et de 
	 * son espèce.
	 * cette fonction est activée par le Gestionnaire en début de tour
	 */
	public void croissance() {

		if ((Gestionnaire.getTour()-getDateNaissance())<=(esperanceVie/4)) {
			setViande(2);
			setTailleEstomac(2);
		}
		else if((Gestionnaire.getTour()-getDateNaissance())<=(esperanceVie/2)) {
			setViande(5);
			setTailleEstomac(4);
		}
		else {
			setTailleEstomac(8);
			setViande(10);
		}
	}

}
