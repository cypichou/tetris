package fr.eseo.e3.poo.projet.blox.controleur;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.junit.Test;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;
import java.util.Scanner;

public class PieceDeplacementTest { 
	
	public static void main (String [] args) {
		Puits puits = new Puits(8,16,20,5);
		Piece piece = new IPiece(new Coordonnees(1,2),Couleur.BLEU);
		Scanner scanner = new Scanner(System.in);
		
		piece.setPuits(puits);
		JFrame frame = new JFrame("Puits et taille");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		VuePuits vuePuits = new VuePuits(puits, 20);
 
		frame.getContentPane().add(vuePuits);
		frame.setPreferredSize(vuePuits.getPreferredSize());
		frame.pack();
		frame.setLocationRelativeTo(null); 
		frame.setVisible(true);	
		
		puits.setPieceSuivante(piece);

		puits.setPieceSuivante(piece); 
		Gravite gravite = new Gravite(vuePuits);	
		
		//gravite.setPeriodicite(1500);
		gravite.start();
		
		while(true) { 

		}
	}
}
