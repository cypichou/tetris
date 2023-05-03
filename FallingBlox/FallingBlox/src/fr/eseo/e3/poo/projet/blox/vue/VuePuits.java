package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import fr.eseo.e3.poo.projet.blox.controleur.PieceDeplacement;
import fr.eseo.e3.poo.projet.blox.controleur.PieceRotation;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class VuePuits extends JPanel implements PropertyChangeListener{
	
	public VueTas getVueTas() {
		return vueTas;
	}

	private static final long serialVersionUID = 1L; 
	public static final int TAILLE_PAR_DEFAUT = 15;
	private Puits puits;
	private Piece piece;
	private int taille;
	private VuePiece vuePiece;
	
	private final VueTas vueTas;
	
	PieceDeplacement deplacement;
	PieceRotation rotation;
	
	public VuePuits(Puits puits) { 
		this(puits, TAILLE_PAR_DEFAUT);
	}

	public VuePuits(Puits puits, int taille) {
		this.puits = puits;
		this.taille = taille;
		this.vueTas = new VueTas(this);
		
		this.setPreferredSize(new Dimension(puits.getLargeur()*taille, puits.getProfondeur()*taille));
		this.setBackground(Color.WHITE);
		 
		puits.addPropertyChangeListener(this);
		
		deplacement = new PieceDeplacement(this);

		this.addMouseListener(deplacement);
	
		this.addMouseMotionListener(deplacement);
		
		this.addMouseWheelListener(deplacement);
		
		this.addMouseMotionListener(rotation);
	}

	public Puits getPuits() {
		return puits;
	}

	public void setPuits(Puits puits) {
		this.puits = puits;
		this.setPreferredSize(new Dimension(puits.getLargeur()*taille, puits.getProfondeur()*taille));
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
		this.setPreferredSize(new Dimension(puits.getLargeur()*taille, puits.getProfondeur()*taille));
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2D = (Graphics2D)g.create();
		
		getVueTas().afficher(g2D);

		g.setColor(java.awt.Color.LIGHT_GRAY);
		for(int i = 0; i <= puits.getLargeur(); i++) {
			g.drawLine(i*taille, 0, i*taille, puits.getProfondeur()*taille);
		}
		for(int i = 0; i <= puits.getProfondeur(); i++) {
			g.drawLine(0, i*taille, puits.getLargeur()*taille, i*taille);
		}
		
		if(vuePiece != null) {  
			vuePiece.afficherPiece(g2D);
		}
				
		g2D.dispose();

	}

	public VuePiece getVuePiece() {
		return vuePiece;
	}

	private void setVuePiece(VuePiece vuePiece) {
		this.vuePiece = vuePiece;
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		String propertyName = evt.getPropertyName();
	    if (propertyName.equals(Puits.MODIFICATION_PIECE_ACTUELLE)) {
	        piece = (Piece) evt.getNewValue();
	        setVuePiece(new VuePiece(piece, taille));
	        repaint();
	    }
	 
	}
}


