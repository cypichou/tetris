package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.junit.Test;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class VuePuitsAffichageTest {
	
	
	public static void main (String [] args) {
		SwingUtilities.invokeLater(new Runnable () {
		@Override
		public void run() {
			new VuePuitsAffichageTest (); 
		}
		});

	}
	
	public VuePuitsAffichageTest() {
		testConstructeurPuits();
		testConstructeurPuitsTaille();
		}

	
		
	private void testConstructeurPuits() {
		JFrame frame = new JFrame("Puits");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Puits puits = new Puits();
		
		Piece piece = UsineDePiece.genererPiece();
		
		puits.setPieceActuelle(piece);

		VuePuits vuePuits = new VuePuits(puits);
		

		frame.getContentPane().add(vuePuits);
		frame.setPreferredSize(vuePuits.getPreferredSize());
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	} 
	
	private void testConstructeurPuitsTaille() {
		Puits puits = new Puits(10,20);
		Piece piece = new IPiece(new Coordonnees(10,20),Couleur.BLEU);
		
		puits.setPieceSuivante(UsineDePiece.genererPiece());
		puits.setPieceSuivante(UsineDePiece.genererPiece());
		
		JFrame frame = new JFrame("Puits et taille");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		VuePuits vuePuits = new VuePuits(puits, 50);

		frame.getContentPane().add(vuePuits);
		frame.setPreferredSize(vuePuits.getPreferredSize());
		frame.pack(); 
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);		
		
	}
	
	
	
	
}
