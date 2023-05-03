package fr.eseo.e3.poo.projet.blox.vue;
import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class VuePiece {
	
	public static final double MULTIPLIER_TEINTE = 0.2;
	
	private final Piece piece;
	
	private final int taille;
		
	public VuePiece (Piece piece, int taille) {
		this.piece = piece;
		this.taille = taille;
	}
	 
	public java.awt.Color teinte (java.awt.Color couleur){
		double r = couleur.getRed();
		double g = couleur.getGreen();
		double b = couleur.getBlue();
		
		r = r + (255 - r) * MULTIPLIER_TEINTE;
		g = g + (255 - g) * MULTIPLIER_TEINTE;
		b = b + (255 - b) * MULTIPLIER_TEINTE;
		
		couleur = new java.awt.Color((int)r,(int)g,(int)b);

		return couleur;
	}  
	
	private int abs (int num) {
		return piece.getElements().get(num).getCoordonnees().getAbscisse();
	}
	private int ord (int num) {
		return piece.getElements().get(num).getCoordonnees().getOrdonnee();
	}
	
	public void afficherPiece(java.awt.Graphics2D g2D) { 
		 
		g2D.setColor(teinte(piece.getElements().get(0).getCouleur().getCouleurPourAffichage()));
		
		g2D.fill3DRect(abs(0)*taille, ord(0)*taille, taille, taille, true);
		
		g2D.setColor(piece.getElements().get(0).getCouleur().getCouleurPourAffichage());
		
		for(int i=1;i<4;i++) {
			g2D.fill3DRect(abs(0)*taille +(abs(i)-abs(0))*taille, ord(0)*taille+(ord(i)-ord(0))*taille, taille, taille, true);
		}
		
	}
	
}
