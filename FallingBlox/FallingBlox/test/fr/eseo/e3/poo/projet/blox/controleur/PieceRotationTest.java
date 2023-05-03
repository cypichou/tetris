package fr.eseo.e3.poo.projet.blox.controleur;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuitsAffichageTest;

public class PieceRotationTest {
		
		
		public static void main (String [] args) {
			SwingUtilities.invokeLater(new Runnable () {
			@Override
			public void run() {
				new VuePuitsAffichageTest (); 
			}
			});

		}
		
		public void VuePuitsAffichageTest() {
			testConstructeurPuits();
			}

		
		private void testConstructeurPuits() {
			JFrame frame = new JFrame("Rotation tourner");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			Puits puits = new Puits();
			
			Piece piece = UsineDePiece.genererPiece();
			
			VuePuits vuePuits = new VuePuits(puits);
			
			puits.setPieceSuivante(piece);
			puits.setPieceSuivante(piece);
			puits.getPieceActuelle().setPosition(2, 4);
			vuePuits.repaint();
			frame.getContentPane().add(vuePuits);
			frame.setPreferredSize(vuePuits.getPreferredSize());
			frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			
		} 
		
	}


