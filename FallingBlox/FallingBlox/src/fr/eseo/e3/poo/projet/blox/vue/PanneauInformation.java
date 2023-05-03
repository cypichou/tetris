package fr.eseo.e3.poo.projet.blox.vue;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PanneauInformation extends JPanel implements PropertyChangeListener {

    private static final int TAILLE_PANNEAU = 70;
    private VuePiece vuePiece;
    private final Puits puits;
    public int score; 
    boolean finish;
    
    public PanneauInformation(Puits puits) {
        this.puits = puits;
        puits.addPropertyChangeListener(this);
        setPreferredSize(new Dimension(TAILLE_PANNEAU, TAILLE_PANNEAU));
        setLocation(500,100);
        this.score = 0;
        this.finish = false;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
		
		Graphics2D g2D = (Graphics2D)g.create();
        if (vuePiece != null) {
            vuePiece.afficherPiece(g2D);
        }
        
        g2D.setColor(Color.BLACK);
        Font font = new Font("Arial", Font.BOLD, 30);
        g2D.setFont(font);
        g2D.drawString(Integer.toString(score), 30, 130);
        
        if(finish) {
        	 font = new Font("Arial", Font.BOLD, 35);
             g2D.setFont(font);
             g2D.drawString("GAME" , 30, 165);
             g2D.drawString("OVER " , 30, 198);
        	 
             font = new Font("Arial", Font.BOLD, 30);

             g2D.drawString("Score de " + Integer.toString(score), 30, 230);
        }
        
        g2D.dispose();
        
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(Puits.MODIFICATION_PIECE_SUIVANTE)) {
            Piece nouvellePiece = (Piece) evt.getNewValue();
            nouvellePiece.setPosition(3, 3);
            vuePiece = new VuePiece(nouvellePiece, 10);
            repaint();
        }
        if (evt.getPropertyName().equals(Puits.MODIFICATION_SCORE)) {
            score += (int)evt.getNewValue();
            repaint();
        }
        if (evt.getPropertyName().equals(Puits.GAME_OVER)) {
            finish = true;
            repaint();
        }
    }
}
