package Gestion;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import animaux.Animal;

/**
 * Cette classe permet de gérer le timing du jeu. Elle définit les tours de jeu et crée un fichier CSV de sortie.
 * @author Paul,Armand et Louise
 *
 */
public class Gestionnaire {
	protected static int tour = 0;
	private static int cadence = 1000;
	private static ArrayList<Animal> animaux = new ArrayList<Animal>();
	
	/**
	 * getters et setters
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
		List<String> ListeNomAnimaux=new ArrayList();
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
						} else {														//sinon,
							e.seDeplacer();											// l'animal se déplace,
							e.seNourrir();											// se nourrit si il le peut
							e.seReproduire();										// et se reproduit si il le peut
						}
					}
					ListeNomAnimaux.add(Integer.toString(e.getId()));
				}
			}
		};
		String filename="tour_"+Integer.toString(tour);
		writeToCsvFile(ListeNomAnimaux,";",filename);
		Timer timer = new Timer(); timer.scheduleAtFixedRate(task, 0, cadence); 		// le tour en cours reste affiché à l'écran le temps de la cadence
		
	}

/**
 * Méthode permettant d'écrire un fichier CSV. Inspirée par le site : https://riptutorial.com/fr/csv/example/27605/lire-et-ecrire-en-java
 * @param thingsToWrite : Liste des choses que l'on veut écrire dans notre fichier CSV
 * @param separator : Le séparateur entre les différents éléments écrits dans notre fichier
 * @param fileName : Le nom de notre fichier
 */
public void writeToCsvFile(List<String> thingsToWrite, String separator, String fileName){
    try (FileWriter writer = new FileWriter(fileName)){
        for (String strings : thingsToWrite) {
               writer.append(strings);
               writer.append(separator);
               writer.append(System.lineSeparator());
        }
        writer.flush();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}


/*
 * code qui sert à faire tourner le gestionnaire :
 * for (int e : Zdialog.getTps()) {
 * 		Gestionnaire.nouveauTour();
 * }
 */
