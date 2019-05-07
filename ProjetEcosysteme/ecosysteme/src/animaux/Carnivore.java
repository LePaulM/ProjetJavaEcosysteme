package animaux;
import java.awt.Color;
/**
 * Cette classe définit les carnivores hérités de la classe animal.
 * @author Paul,Armand et Louise
 *
 */
import java.util.ArrayList;

import ecosysteme.Case;
import ecosysteme.Grille;

public abstract class Carnivore extends Animal{
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
	public Carnivore(int dateNaissance, Case emplacement, 
			int tpDecomposition, int remplissageEstomac,  int maturite,
			boolean aProcree,int meurtFaim) {
		super(dateNaissance,emplacement, tpDecomposition,
				remplissageEstomac, maturite,aProcree,meurtFaim);
	}
	
	/**
	 * Cette méthode définit les cases adjacentes à l'emplacement de l'animal
	 * @return liste des cases adjacentes
	 */
	public ArrayList<Case> adjacentes(){
				ArrayList<Case> cases = new ArrayList<Case>();
				Case case1 = Grille.getCase(this.getEmplacement().getX()-1,this.getEmplacement().getY()-1);	// marche avec les coordonn�es de la case
				cases.add(case1);
				Case case2 = Grille.getCase(this.getEmplacement().getX(),this.getEmplacement().getY()-1);
				cases.add(case2);
				Case case3 = Grille.getCase(this.getEmplacement().getX()+1,this.getEmplacement().getY()-1);
				cases.add(case3);
				Case case4 = Grille.getCase(this.getEmplacement().getX()-1,this.getEmplacement().getY());
				cases.add(case4);
				Case case5 = Grille.getCase(this.getEmplacement().getX()+1,this.getEmplacement().getY());
				cases.add(case5);
				Case case6 = Grille.getCase(this.getEmplacement().getX()-1,this.getEmplacement().getY()+1);
				cases.add(case6);
				Case case7 = Grille.getCase(this.getEmplacement().getX(),this.getEmplacement().getY()+1);
				cases.add(case7);
				Case case8 = Grille.getCase(this.getEmplacement().getX()+1,this.getEmplacement().getY()+1);
				cases.add(case8);
				return(cases);
	}
	
	/**
	 * Cette méthode remplit l'estomac de l'animal s'il n'est pas déjà plein. 
	 * La case sur laquelle il est diminue également en quantité de nourriture.
	 */
	@Override
	public void seNourrir(){
		if (getEstVivant() == false) {
		} else {
			if (this.getRemplissageEstomac() < this.getTailleEstomac()) {
				ArrayList<Case> cases=this.adjacentes();
				for (Case c : cases) {
					// si la case contient un animal, et que l'animal n'est pas un autre carnivore, 
					// le carnivore le tue
					if(c.getEstVide() == true || c.getAnimal().getEspece() != this.getEspece()) {
						c.getAnimal().decede();
						if (getRemplissageEstomac() < getTailleEstomac()) {
							// si l'animal tué contient plus de nourriture que l'animal n'a de place dans son estomac, 
							// alors il mange juste à sa faim
							if (c.getAnimal().getViande() > (this.getTailleEstomac() - this.getRemplissageEstomac())) {
								c.getAnimal().setViande(c.getAnimal().getViande() - (this.getTailleEstomac() - this.getRemplissageEstomac()));
								this.setRemplissageEstomac(this.getTailleEstomac());
								this.setRemplissageEstomac(getRemplissageEstomac() + c.getAnimal().getViande());
							} 
							// sinon si l'animal a suffisament faim et que la case ne contient pas suffisament ou juste assez
							// de nourriture pour le rassasier, il mange tout la nourriture présente sur la case
							// le stock de nourriture tombe donc à 0
							else if (getRemplissageEstomac() + c.getAnimal().getViande() <= getTailleEstomac()){
								this.setRemplissageEstomac(getRemplissageEstomac() + c.getAnimal().getViande());
								c.getAnimal().setViande(this.getTailleEstomac() - this.getRemplissageEstomac());
								c.getAnimal().setViande(0);
								c.setACadavre(false); 
							}
						}
					}			
					break;			//une fois que l'animal s'est nourri on arrête la boucle (un animal ne se nourrit qu'une seule fois par tour
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
