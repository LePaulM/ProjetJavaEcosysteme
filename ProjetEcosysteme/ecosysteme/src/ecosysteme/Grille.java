package ecosysteme;
//maj le 25 mai
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;

/**
 * Classe gÃ©rant la grille de jeu
 * @author Paul,Armand et Louise
 *
 */
public abstract class Grille {

	/**
	 * attribut qui gere la taille de notre grille carree
	 */
	private int taille;

	/**
	 * attribut qui gere la grille, sous forme de matrice
	 */
	private static ArrayList<ArrayList<Case>> grille;


	/**
	 * Les getters et setters
	 * @return taille, grille
	 */

	public int getTaille() {
		return taille;
	}
	
	public void setTaille(int taille) {
		this.taille = taille;
	}
	
	public ArrayList<ArrayList<Case>> getGrille() {
		return grille;
	}
	
	
	/**
	 * getter qui recupere le contenu de la grille a une position (x,y)
	 * @param x : valeur de l'abscisse
	 * @param y : valeur de l'ordonnée
	 * @return
	 */
	public static Case getCase(int x, int y) {
		return grille.get(x).get(y);
	}

	
	/**
	 * constructeur de la grille sous forme de matrice (initialisation avec uniquement de l'herbe)
	 * @param taille : taille d'un côté de la grille
	 */
	public Grille(int taille) {
		this.taille = taille;
		this.grille = new ArrayList<ArrayList<Case>>();
		for(int i = 0; i<this.taille; i++) {
			ArrayList<Case> colonne = new ArrayList<Case>();
			for ( int j = 0; j<this.taille; j++) {
				int[] coord = new int[2];
				coord[0] = i;
				coord[1] = j;
				Herbe herbe = new Herbe(coord);
				colonne.add(herbe);
			}
			grille.add(colonne);
		}
	}
	
	/**
	 * Test si l'occupation du sol n'est pas de type herbe ou sable. 
	 */
	public boolean herbeOuSable() {
		int x=(int)Math.random()*this.taille;
		int y=(int)Math.random()*this.taille;
		if(grille.get(x).get(y).getTypeOccupation()==1||
			   grille.get(x).get(y).getTypeOccupation()==2||
			   grille.get(x).get(y).getTypeOccupation()==3||
			   grille.get(x).get(y).getTypeOccupation()==5||
			   grille.get(x).get(y).getTypeOccupation()==7) {
			   return true;
			}
		else {
			return false;
		}
	}
	
	/**
	 * Une methode qui cree les buissons, applicable a toutes les classes filles, c'est une gï¿½nï¿½ration dans l'espace alï¿½atoirement 
	 * d'une quantitee de buisson definie en parametres. Lors de la creation de la grille un buisson ne peut etre 
	 * place ni sur un autre buisson, ni sur aucun autre sol excepte l'herbe et le sable.
	 * @param nbrebuisson : nombre de buisson souhaité
	 */
	public void creationBuisson(int nbrebuisson) {
		int i=0;

		int x=(int)Math.random()*this.taille;
		int y=(int)Math.random()*this.taille;
		while(i<nbrebuisson) {
			if (herbeOuSable()) {
				continue;
			}
			int[] coord = new int[2];
			coord[0]=x;
			coord[1]=y;
			Buisson buisson = new Buisson(coord);
			grille.get(x).set(y,buisson);
			i=i+1;
		}
	}

	/**
	 * Une methode qui cree les arbres, applicable a toutes les classes filles, c'est une gï¿½nï¿½ration dans l'espace alï¿½atoirement 
	 * d'une quantitee d'arbre definie en parametre. Un arbre est grand et donc occupe plusieurs cases. Lors de la 
	 * creation de la grille un arbre ne peut etre place sur aucun autre sol excepte l'herbe, le sable et 
	 * les buissons, il ne peut superposer que legerement avec un autre arbre.
	 * @param arbre : nombre d'abres souhaité
	 */
	public void creationArbre(int arbre) {
		int i=0;
		while(i<arbre) {
			double a=Math.random()*this.taille;
			double b=Math.random()*this.taille;
			int x=(int)a;
			int y=(int)b;
			if((x-2)<0 || (x+2)>(this.taille-1) || (y-2)<0 || (y+2)>(this.taille-1)) {
				continue;
			}

			if( grille.get(x).get(y).getTypeOccupation()==3||
			grille.get(x-1).get(y-1).getTypeOccupation()==3||
			grille.get(x-1).get(y).getTypeOccupation()==3||
			grille.get(x-1).get(y+1).getTypeOccupation()==3||
			grille.get(x).get(y-1).getTypeOccupation()==3||
			grille.get(x).get(y+1).getTypeOccupation()==3||
			grille.get(x+1).get(y-1).getTypeOccupation()==3||
			grille.get(x+1).get(y).getTypeOccupation()==3||
			grille.get(x+1).get(y+1).getTypeOccupation()==3||
			grille.get(x).get(y).getTypeOccupation()==7||
			grille.get(x).get(y).getTypeOccupation()==5||
			grille.get(x).get(y).getTypeOccupation()==2 )  {
				continue;
			}

			int[] coord = new int[2];
			coord[0]=x;
			coord[1]=y;
			Arbre arbre1 = new Arbre(coord);
			grille.get(x).set(y, arbre1);
			grille.get(x-1).set(y-1, arbre1);
			grille.get(x-1).set(y, arbre1);
			grille.get(x-1).set(y+1, arbre1);
			grille.get(x).set(y-1, arbre1);
			grille.get(x).set(y+1, arbre1);
			grille.get(x+1).set(y-1, arbre1);
			grille.get(x+1).set(y, arbre1);
			grille.get(x+1).set(y+1, arbre1);
			grille.get(x-2).set(y-1, arbre1);
			grille.get(x-2).set(y, arbre1);
			grille.get(x-2).set(y+1, arbre1);
			grille.get(x-1).set(y-2, arbre1);
			grille.get(x).set(y-2, arbre1);
			grille.get(x+1).set(y-2, arbre1);
			grille.get(x+2).set(y-1, arbre1);
			grille.get(x+2).set(y, arbre1);
			grille.get(x+2).set(y+1, arbre1);
			grille.get(x-1).set(y+2, arbre1);
			grille.get(x).set(y+2, arbre1);
			grille.get(x+1).set(y+2, arbre1);
			
			i=i+1;
		}
	}
	
	
	/**
	 * Une methode qui permet de creer du sable selon deux regles, l'ajout de sable ne peut se faire que sur 
	 * de l'herbe et doit etre distant de deux cases d'un arbre. 
	 */
	public void creationSable(){
		for(int x=2;x<=this.taille-3;x++) {
		for(int y=2;y<=this.taille-3;y++) {
		if( grille.get(x).get(y).getTypeOccupation()==0 &&
				grille.get(x+2).get(y).getTypeOccupation()!=3 &&
				grille.get(x+2).get(y+2).getTypeOccupation()!=3 &&
				grille.get(x).get(y+2).getTypeOccupation()!=3 &&
				grille.get(x-2).get(y+2).getTypeOccupation()!=3 &&
				grille.get(x-2).get(y).getTypeOccupation()!=3 &&
				grille.get(x-2).get(y-2).getTypeOccupation()!=3 &&
				grille.get(x).get(y-2).getTypeOccupation()!=3 &&
				grille.get(x+2).get(y-2).getTypeOccupation()!=3 ) {
			
			int[] coord = new int[2];
			coord[0]=x;
			coord[1]=y;
			Sable sable = new Sable(coord);
			grille.get(x).set(y, sable);
		}
		}
		}
	}
	
	/**
	 * methodes abstraites redefinies dans les classes filles. Elles permettent respectivement de créer de la neige, 
	 * de l'eau et des montagnes
	 */
	public abstract void creationNeige();
	public abstract void creationEau();
	public abstract void creationMontagne();


	  
	/**
	 * Methode permettant de creer la grille a partir des methodes precedentes.
	 */
	public  abstract void creationGrille();
	  
	/**
	 * Methode qui affiche la grille dans la console sous forme de matrice d'entiers (ce n'est pas l'interface 
	 * graphique).
	 */
	public void afficher() {
		for(int i=0;i<this.taille;i++) {
			for (int j=0;j<this.taille;j++) {
				System.out.print(grille.get(i).get(j).getTypeOccupation()+"");
			}
			System.out.println(" ");
		}
	}
}
