package AffichageGraphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import ecosysteme.Jungle;
import ecosysteme.MassifMontagneux;
import ecosysteme.Savane;
import ecosysteme.Steppe;
import ecosysteme.Syberie;

public class ZDialog extends JDialog{
	private ZDialogInfo zInfo = new ZDialogInfo();
	//private Personnalise perso = new Personnalise("Personnalisé");
	private boolean sendData;
	private JLabel nomLabel, tplateauLabel, ecostmeLabel, tpsLabel,tpsLabel2, nbreAnimauxLabel, nbreAnimauxLabel2, icon;
	private JRadioButton tranche1, tranche2, tranche3, tranche4;
	private JComboBox tplateau, ecostme;
	private JTextField nom;
	private static JTextField nbreAnimaux;
	private JTextField tps;
	private String environnementChoisi;
	boolean okclique = false;
	private int tPlateauInt, nbrTotAnimaux;
	private static String nbrAnimauxString;


	public JComboBox getEcostme() {
		return ecostme;
	}

	public ZDialog(JFrame parent, String title, boolean modal){
		super(parent, title, modal);
		this.setSize(550, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		this.initComponent();
	}

	public ZDialogInfo showZDialogI(){
		this.sendData = false;
		this.setVisible(true);      
		return this.zInfo;      
	}

	public void showPersonnalise(){
		Personnalise perso = new Personnalise(nom.getText());

		perso.setSendData(false);
		perso.setVisible(true);          
	}

	public static String getNbreAnimaux(){
		nbrAnimauxString = nbreAnimaux.getText();
		return (nbrAnimauxString.equals("")) ? "180" : nbrAnimauxString;
	};

	public String getTps(){
		return (tps.getText().equals("")) ? "180" : tps.getText();
	};

	public int getTaille() {
		String tPlateauChoisi = (String) tplateau.getSelectedItem();
		if (tPlateauChoisi.equals("200*200")) {
			tPlateauInt = 200;
			return tPlateauInt;
		} else if (tPlateauChoisi.equals("100*100")) {
			tPlateauInt = 100;
			return tPlateauInt;
		} else {
			tPlateauInt = 60;
			return tPlateauInt;
		}
	}

	public static int getAnimauxTot() {
		return Integer.parseInt(getNbreAnimaux());
	}

	private void initComponent(){
		//Icône
		icon = new JLabel(new ImageIcon("images/icone.jpg"));
		JPanel panIcon = new JPanel();
		panIcon.setBackground(Color.white);
		panIcon.setLayout(new BorderLayout());
		panIcon.add(icon);

		//Le nom
		JPanel panNom = new JPanel();
		panNom.setBackground(Color.white);
		panNom.setPreferredSize(new Dimension(220, 60));
		nom = new JTextField();
		nom.setPreferredSize(new Dimension(100, 25));
		panNom.setBorder(BorderFactory.createTitledBorder("Nom de l'expérimentation"));
		nomLabel = new JLabel("Saisir un nom :");
		panNom.add(nomLabel);
		panNom.add(nom);

		//Taille du plateau
		JPanel taillePlateau = new JPanel();
		taillePlateau.setBackground(Color.white);
		taillePlateau.setPreferredSize(new Dimension(220, 60));
		taillePlateau.setBorder(BorderFactory.createTitledBorder("Taille du plateau"));
		tplateau = new JComboBox();
		tplateau.addItem("60*60");
		tplateau.addItem("100*100");
		tplateau.addItem("200*200");
		tplateauLabel = new JLabel("taille du plateau : ");
		taillePlateau.add(tplateauLabel);
		taillePlateau.add(tplateau);


		//Choix des ecosystèmes
		JPanel ecosysteme = new JPanel();
		ecosysteme.setBackground(Color.white);
		ecosysteme.setPreferredSize(new Dimension(220, 60));
		ecosysteme.setBorder(BorderFactory.createTitledBorder("Choix de l'écosystème"));
		ecostme = new JComboBox();
		ecostme.addItem("Savane");
		ecostme.addItem("Jungle");
		ecostme.addItem("Sybérie");
		ecostme.addItem("Montagnes");
		ecostme.addItem("Steppes");
		ecostme.addItem("Personnalisé");
		ecostmeLabel = new JLabel("Sélectionnez écosystème : ");
		ecosysteme.add(ecostmeLabel);
		ecosysteme.add(ecostme);


		//Le nombre d'animaux
		JPanel panNbreAnimaux = new JPanel();
		panNbreAnimaux.setBackground(Color.white);
		panNbreAnimaux.setPreferredSize(new Dimension(500, 60));
		panNbreAnimaux.setBorder(BorderFactory.createTitledBorder("Nombre d'animaux"));
		nbreAnimauxLabel = new JLabel("Maximum d'animaux sur le plateau" );
		nbreAnimauxLabel2 = new JLabel("= (Nombre de cases du plateau/2)");
		nbreAnimaux = new JTextField("900");
		nbreAnimaux.setPreferredSize(new Dimension(90, 25));
		panNbreAnimaux.add(nbreAnimauxLabel);
		panNbreAnimaux.add(nbreAnimauxLabel2);
		panNbreAnimaux.add(nbreAnimaux);

		//Le temps de simulation
		JPanel panTps = new JPanel();
		panTps.setBackground(Color.white);
		panTps.setPreferredSize(new Dimension(220, 60));
		panTps.setBorder(BorderFactory.createTitledBorder("Temps de la simulation"));
		tpsLabel = new JLabel("En nombre de tours : ");
		tps = new JTextField("60");
		tps.setPreferredSize(new Dimension(90, 25));
		panTps.add(tpsLabel);
		panTps.add(tps);

		//Les paramètres de la fenêtre
		JPanel content = new JPanel();
		content.setBackground(Color.white);
		content.add(panNom);
		content.add(taillePlateau);
		content.add(ecosysteme);
		content.add(panTps);
		content.add(panNbreAnimaux);


		JPanel control = new JPanel();
		JButton okBouton = new JButton("OK");


		okBouton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				okclique = true;
				environnementChoisi = (String) ecostme.getSelectedItem();
				zInfo = new ZDialogInfo(nom.getText(), (String)tplateau.getSelectedItem(),(String)ecostme.getSelectedItem(), getNbreAnimaux(),getTps());
				showZDialogI();
				JOptionPane jop = new JOptionPane();
				jop.showMessageDialog(null, zInfo.toString(), "Options choisies", JOptionPane.INFORMATION_MESSAGE);
				setVisible(false); 
				if (environnementChoisi.equals("Montagnes")){
					MassifMontagneux massif = new MassifMontagneux(getTaille());
					massif.creationGrille();
				}
				if (environnementChoisi.equals("Savane")){
					Savane sav=new Savane(getTaille());
					sav.creationGrille();
				}
				if (environnementChoisi.equals("Sybérie")){
					Syberie sib = new Syberie(getTaille());
					sib.creationGrille();
				}
				if (environnementChoisi.equals("Jungle")){
					Jungle jun = new Jungle(getTaille());
					jun.creationGrille();
				}
				if (environnementChoisi.equals("Steppes")){
					Steppe steppe = new Steppe (getTaille());
					steppe.creationGrille();
				}
			}
		});

		JButton cancelBouton = new JButton("Annuler");
		cancelBouton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}      
		});

		control.add(okBouton);
		control.add(cancelBouton);

		this.getContentPane().add(panIcon, BorderLayout.WEST);
		this.getContentPane().add(content, BorderLayout.CENTER);
		this.getContentPane().add(control, BorderLayout.SOUTH);


	}

	public boolean isOkclique() {
		return okclique;
	}  
}