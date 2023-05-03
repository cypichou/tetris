package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Scanner;

import javax.swing.JFrame;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.vue.PanneauInformation;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class GraviteTest {
	public static void main (String [] args) {
		Puits puits = new Puits(8,16);
		Piece piece = new IPiece(new Coordonnees(1,2),Couleur.BLEU);
		PanneauInformation panneau = new PanneauInformation(puits);
		VuePuits vuePuits = new VuePuits(puits, 20);
		UsineDePiece.setMode(2);
		
		JFrame frame = new JFrame("Puits et taille");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panneau.setBounds(300,300,300,300);
		
		vuePuits.add(panneau,BorderLayout.EAST);
		
		frame.getContentPane().add(vuePuits, BorderLayout.WEST);
		frame.getContentPane().add(panneau);

		frame.setPreferredSize(new Dimension(350,400));
		frame.pack();
		frame.setLocationRelativeTo(null); 
		frame.setVisible(true);	
		
		Gravite gravite = new Gravite(vuePuits);	
		gravite.start();
		
		while(true) { 

		}
	}
}
