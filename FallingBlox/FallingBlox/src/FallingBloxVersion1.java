
	import java.awt.BorderLayout;
	import java.awt.Dimension;
	import java.util.Scanner;

	import javax.swing.JFrame;

import fr.eseo.e3.poo.projet.blox.controleur.Gravite;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
	import fr.eseo.e3.poo.projet.blox.modele.Couleur;
	import fr.eseo.e3.poo.projet.blox.modele.Puits;
	import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
	import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
	import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
	import fr.eseo.e3.poo.projet.blox.vue.PanneauInformation;
	import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class FallingBloxVersion1 {
		public static void main (String [] args) {
			Scanner scanner = new Scanner(System.in);
			
			int nbElements = 0;
			int nbLignes = Puits.PROFONDEUR_PAR_DEFAUT;
			
			System.out.println("Bienvenue dans tetris ! Rentre une 0 pour jouer sans elements, 1 pour jouer avec le nombre d'elements de ton choix sur 2 lignes (ne peut être supérieur à 16) et enfin");
			
			nbElements = scanner.nextInt();
		
			Puits puits = new Puits(8,16);
 
			if (nbElements == 1) {
				System.out.println("Renter maintenant le nombre d'élèments avec lesquelles tu veux jouer");
				nbElements = scanner.nextInt();
	            puits = new Puits(8,16,nbElements,2);


	        }else if (nbElements == 2) {
				
	        	System.out.println("Rentre maintenant le nombre d'elements de ton choix pour ton tas, ne doit pas depasser 128");

	        	nbElements = scanner.nextInt();
	        	
	        	System.out.println("Rentre maintenant le nombre de lignes de ton choix pour ton tas, ne doit pas dépasser le nombre d'élèments diviser pas 8");

				nbLignes = scanner.nextInt();
	            
				puits = new Puits(8,16,nbElements,nbLignes);
	        }
	        	
			PanneauInformation panneau = new PanneauInformation(puits);
			
			VuePuits vuePuits = new VuePuits(puits, 20);

			JFrame frame = new JFrame("Falling Blox");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			vuePuits.add(panneau,BorderLayout.EAST);
			
			frame.getContentPane().add(vuePuits, BorderLayout.WEST);
			frame.getContentPane().add(panneau);

			frame.setPreferredSize(new Dimension(350,400));
			frame.pack();
			frame.setLocationRelativeTo(null); 
			frame.setVisible(true);	 
			
			Gravite gravite = new Gravite(vuePuits);	
		  
			gravite.start(); // ca c'est ma boucle while, c'est ici qu'on doit tout rythmer
			

		}

	}

