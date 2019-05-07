package Gestion;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import animaux.Animal;

public class Gestionnaire {
	protected static int tour = 0;
	private static int cadence = 1000;
	private static ArrayList<Animal> animaux = new ArrayList<Animal>();
	
	/**
	 * getter et setter
	 * 
	 */

	/**
	 * La méthode suivante renvoie le tour actuel de jeu
	 * @return
	 */
	public static int getTour() {
		return tour;
	}
	
	/**
	 * La méthode suivante change le numéro de tour en cours
	 * @return
	 */
	public void setTour(int tour) {
		Gestionnaire.tour = tour;
	}
	
	/**
	 * La méthode suivante renvoie le nombre de tours s'étant écoulés
	 * @return
	 */
	public int getCadence() {
		return cadence;
	}
	
	/**
	 * La méthode suivante permet de changer la vitesse de rafraichissement du jeu
	 * @return
	 */
	public void setCadence(int newCadence) {
		Gestionnaire.cadence = newCadence;
	}

	/**
	 * La méthode suivante renvoie un animal en particulier depuis la liste des animaux
	 * @return
	 */
	public Animal getAnimal(int id) {
		return animaux.get(id);
	}
	
	/**
	 * La méthode suivante renvoie la liste contenant tous les animaux du jeu, vivants ou morts
	 * @return
	 */
	public static ArrayList<Animal> getAnimaux(){
		return animaux;
	}
	
	/**
	 * La méthode suivante permet d'ajouter un animal au gestionnaire
	 * @return
	 */
	public static void addAnimal(Animal animal) {
		animaux.add(animal);
	}

	/**
	 * La méthode suivante gère le déroulement d'un tour de jeu
	 * @return
	 */
	public void nouveauTour() {
		tour = tour++;
		TimerTask task = new TimerTask() {
			public void run() { 
				for (Animal e : animaux) {								// pour chaque animal présent dans la simulation
					if (e.getEstVivant() == false){						// si l'animal est decedé,
						e.seDecomposer();								// on applique la fonction seDecomposer()
						continue;										// et on termine le tour de l'animal
					}
					else {												// sinon,
						if (e.getEsperanceVie() <= tour - e.getDateNaissance() || e.famine() == true ) {	//si l'animal a atteint son esperance de vie, ou si il est en famine avancée
							e.decede();												// il décede
							continue;												// et on termine le tour de l'animal
						}else {														//sinon,
							e.seDeplacer();											// l'animal se déplace,
							e.seNourrir();											// se nourrit si il le peut
							e.seReproduire();										// et se reproduit si il le peut
						}
					}

				}
			}
		};
		Timer timer = new Timer(); timer.scheduleAtFixedRate(task, 0, cadence); 		// le tour en cours reste affiché à l'écran le temps de la cadence
	}
}


/*
 * code qui sert à faire tourner le gestionnaire :
 * for (int e : Zdialog.getTps()) {
 * 		Gestionnaire.nouveauTour();
 * }
 */
