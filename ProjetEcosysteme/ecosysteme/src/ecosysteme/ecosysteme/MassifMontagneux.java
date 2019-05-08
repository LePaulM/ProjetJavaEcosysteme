package ecosysteme;
/** 
 * Classe gÃ©rant l'Ã©cosystÃ¨me de type massif montagneux.
 * @author Paul,Armand et Louise
 *
 */

public class MassifMontagneux extends Grille{
	
	/**
	 * Le constructeur de la classe,  hÃ©ritant du constructeur de la classe mere
	 * @param taille
	 */
	public MassifMontagneux(int taille) {
		super(taille);
	}
	
	/**
	 * Une methode qui cree la zone montagneuse de notre grille, cette zone sera composee de quatres blocs de montagnes circulaire, ils vont etre créés indépendament les uns les autres.
	 * Si vous voulez comprendre le déroulé de cette méthode, vous trouverez l'explication plutot sur le rapport
	 */
	@Override
	public void creationMontagne() {
		// premier bloc
		double a=2*getTaille()/3; //le grand axe
		double b=getTaille()/4; //le petit axe, qui sera le meme pour les quatres blocs de montagne
		for(int x=0;x<=a;x++) { //quand on fait varier x de 0 à la taille désirée...
			for(int y=0;y<=(int)b*Math.sqrt(1-((x*x)/(a*a)));y++) { //...on fait varier y en fonction x
				int[] coord = new int[2]; //on créer un jeux de coordonnées
				coord[0]=x; //où l'on ajoute le x actuel
				coord[1]=y; //et le y actuel
				Montagne montagne = new Montagne(coord); //ensuite on créer une case de type montagne
				getGrille().get(x).set(y, montagne); // dans la grille, on modifie la case de coordonnées (x,y) par la case montagne
			}
			}
		// deuxieme bloc
		a=3*getTaille()/4; //on met a jour le grand axe qui sera different pour les DEUX blocs suivants
		for(int x=0;x<=a;x++) { //quand on fait varier x de 0 à la taille désirée...
			for(int y=(int)(-b*Math.sqrt(1-((x*x)/(a*a)))+2*(getTaille()/4)); y<=(getTaille()/2);y++) { //...on fait varier y en fonction de x en rajoutant un décalage d'un quart de la grille
				int[] coord = new int[2];
				coord[0]=x;
				coord[1]=y;
				Montagne montagne = new Montagne(coord);
				getGrille().get(x).set(y, montagne);
			}
			}
		// troisieme bloc
		for(int x=0;x<=a;x++) { //quand on fait varier x de 0 à la taille désirée...
			for(int y=getTaille()/2;y<=(int)b*Math.sqrt(1-((x*x)/(a*a)))+getTaille()/2;y++) { //...on fait varier y en fonction de x en rajoutant un décalage d'un demi de la grille
				int[] coord = new int[2];
				coord[0]=x;
				coord[1]=y;
				Montagne montagne = new Montagne(coord);
				getGrille().get(x).set(y, montagne);
			}
			}
		// quatrieme bloc
		a=4*getTaille()/5;  //on met a jour le grand axe qui sera different pour ce bloc
		for(int x=0;x<=a;x++) {  //quand on fait varier x de 0 à la taille désirée...
			for(int y=(int)((getTaille()/4)-b*Math.sqrt(1-((x*x)/(a*a)))+3*getTaille()/4); y<getTaille();y++) {//...on fait varier y en fonction de x en rajoutant un décalage de 3/4 de la grille
				int[] coord = new int[2];
				coord[0]=x;
				coord[1]=y;
				Montagne montagne = new Montagne(coord);
				getGrille().get(x).set(y, montagne);
			}
			}
	}
	
	/**
	 * Une methode qui crÃ©e les rivieres partant de la montagne. Elles seront larges de trois cases sauf quand celles qui sont sur une 
	 * zone de montagne ou une zone de neige : elles seront alors larges d'une case.
	 */
	@Override
	public void creationEau() {
		//premiere riviere
		int y=(int)this.getTaille()/4;
		for(int x=(int)this.getTaille()/9;x<this.getTaille();x++) {
			if(getGrille().get(x).get(y-1).getTypeOccupation()==7 ||
				getGrille().get(x).get(y-1).getTypeOccupation()==5) {
				int[] coord = new int[2];
				coord[0]=x;
				coord[1]=y;
				Eau eau = new Eau(coord);
				getGrille().get(x).set(y, eau);
			}
			else {
				int[] coord = new int[2];
				coord[0]=x;
				coord[1]=y;
				Eau eau = new Eau(coord);
				getGrille().get(x).set(y-1, eau);
				getGrille().get(x).set(y, eau);
				getGrille().get(x).set(y+1, eau);
			}
		}
		//seconde riviere
		int v=(int)3*this.getTaille()/4;
		for(int x=(int)this.getTaille()/9;x<this.getTaille();x++) {
			if(getGrille().get(x).get(v-1).getTypeOccupation()==7 ||
				getGrille().get(x).get(v-1).getTypeOccupation()==5) {
				int[] coord = new int[2];
				coord[0]=x;
				coord[1]=y;
				Eau eau = new Eau(coord);
				getGrille().get(x).set(v, eau);
			}
			else {
				int[] coord = new int[2];
				coord[0]=x;
				coord[1]=y;
				Eau eau = new Eau(coord);
				getGrille().get(x).set(v-1, eau);
				getGrille().get(x).set(v, eau);
				getGrille().get(x).set(v+1, eau);
			}
		}
	}
	
	/**
	 * Une methode qui cree le glacier au sommet de la montagne et un peu de neige dans les versants.
	 */
	public void creationNeige() {
		//creation du glacier
		for(int x=0;x<=(int)(this.getTaille()/4)*0.6;x++) {
			for(int y=0;y<(int)(this.getTaille());y++){
				int[] coord = new int[2];
				coord[0]=x;
				coord[1]=y;
				Neige neige = new Neige(coord);
				getGrille().get(x).set(y, neige);
			}
		}
		//creation de neige de facon aleatoire dans la montagne.
		int neige=(int)(getTaille()*100/30);
		int i=0;
		while(i<neige) {
			double a=Math.random()*this.getTaille();
			double b=Math.random()*this.getTaille();
			int x=(int)a;
			int y=(int)b;
			if(getGrille().get(x).get(y).getTypeOccupation()==5) {
				continue;
			}
			if (getGrille().get(x).get(y).getTypeOccupation()==7) {
				int[] coord = new int[2];
				coord[0]=x;
				coord[1]=y;
				Neige neige1 = new Neige(coord);
				getGrille().get(x).set(y, neige1);
			}
			i=i+1;
		}
	}
	
	/**
	 * Methode qui cree la grille avec ses composantes, l'ajout successif des sols suit un ordre bien precis
	 */
	@Override
	public void creationGrille() {
		int arbre = (int)(Math.pow(getTaille(),2)*5/(21*100));
		int buisson=(int)70*getTaille()/100;
		
		MassifMontagneux massif = new MassifMontagneux(getTaille());
		
		massif.creationMontagne();	
		massif.creationNeige();
		massif.creationArbre(arbre);
		//massif.creationBuisson(buisson);
		massif.creationEau();
		massif.afficher();
	}
	
	

	
	
	
}
