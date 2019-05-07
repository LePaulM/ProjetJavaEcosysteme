package ecosysteme;

import java.awt.Color;
import java.awt.GridLayout;
import ecosysteme.Grille; 

import javax.swing.JPanel;

public class AffichageGrille extends JPanel {

	private JPanel[] buttons;
	
	public AffichageGrille(Grille grille)  {
		setLayout(new GridLayout(grille.getTaille(),grille.getTaille()));
		buttons = new JPanel[(int)Math.pow(grille.getTaille(),2)];
		
		// création des couleurs de l'environnement (R,G,B)
		Color herbe = new Color(87, 213, 59);
		Color buisson = new Color(58, 137, 35);
		Color eau = new Color(0, 127, 255);
		Color foret = new Color(0, 86, 27);
		Color sable = new Color(224, 205, 169);
		Color neige = new Color(240, 240, 240);
		Color terrainNu = new Color(167, 103, 38);
		Color montagne = new Color(132, 132, 132);

		for(int i = 0; i <= grille.getTaille()-1; i++)
		{
			for(int j = 0; j <= grille.getTaille()-1; j++)
			{
				int occupation = grille.getCase(i,j).getTypeOccupation();

				buttons[j] = new JPanel();
				if (occupation == 0) {
					buttons[j].setBackground(herbe);
				}
				if (occupation == 1) {
					buttons[j].setBackground(buisson);
				}
				if (occupation == 2) {					
					buttons[j].setBackground(eau);
				}
				if (occupation == 3) {					
					buttons[j].setBackground(foret);
				}
				if (occupation == 4) {					
					buttons[j].setBackground(sable);
				}
				if (occupation == 5) {					
					buttons[j].setBackground(neige);
				}
				if (occupation == 6) {					
					buttons[j].setBackground(terrainNu);
				}
				if (occupation == 7) {					
					buttons[j].setBackground(montagne);
				}

				add(buttons[j]); 
				//adds this button to JPanel (note: no need for JPanel.add(...)
				//because this whole class is a JPanel already           
			}
		}
	} 

}
