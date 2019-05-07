package ecosysteme;

import Gestion.Gestionnaire;
import animaux.Animal;
/**
 * Classe gérant les cases 
 * @author Paul,Armand et Louise
 *
 */
public abstract class Case {
	
	private int typeOccupation;
	private boolean estVide;
	private boolean cadavre;
	private int position[];
	
	
	/**
	 * Constructeur
	 * @param typeOccupation
	 * @param estvide
	 * @param cadavre
	 * @param position
	 */
	public Case(int typeOccupation, boolean estvide, boolean cadavre, int[] position) {
		super();
		this.typeOccupation = typeOccupation;
		this.estVide = estvide;
		this.cadavre = cadavre;
		this.position = position;
	}
	/**
	 * getters et setters
	 * @return
	 */
	/*
	public int getTypeOccupation() {
		return typeOccupation;
	}
*/
	public boolean getEstVide() {
		return estVide;
	}
	
	public void setEstVide(boolean b) {
		// TODO Auto-generated method stub
		this.estVide = b;
	}

	public boolean getCadavre() {
		return cadavre;
	}
	
	public void setACadavre(boolean b) {
		this.cadavre = b;
	}

	public int[] getPosition() {
		return position;
	}
	
	public int getX() {
		return position[0];
	}

	public int getY() {
		return position[1];
	}
	
	public abstract int getNourriture();
	
	public abstract void setNourriture(int nourriture);
	
	public abstract void recuperation();

	
	public Animal getAnimal() {
		Animal animalRetour = null;
		if (this.getEstVide() == false) {
			for (Animal animal : Gestionnaire.getAnimaux()) {
				if (animal.getEmplacement().getPosition().equals(this.getPosition())){
					animalRetour = animal;
				}
			}
		}
		return animalRetour;
	}
	
	public int[] getCoordonnees(int x,int y) {
		int[] coord = new int[2];
		coord[0]=x;
		coord[1]=y;
		return coord;
	}

	public abstract int getTypeOccupation();
	
}
