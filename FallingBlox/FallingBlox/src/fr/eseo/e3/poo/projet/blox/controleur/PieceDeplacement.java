package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.SwingUtilities;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceDeplacement implements MouseMotionListener, MouseWheelListener, MouseListener   {
	    
	private VuePuits vuePuits;
    private Puits puits;
    private int tempCo;
	    
    public PieceDeplacement(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
        this.puits = vuePuits.getPuits();
        this.tempCo = -1;
    } 
	
    @Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}  

	@Override
	public void mouseMoved(MouseEvent e) {	
		int X = e.getX();
		if(puits.getPieceActuelle() != null) 
		{
			
			if(this.tempCo == -1) 
			{
				this.tempCo=X/this.vuePuits.getTaille();
			}
			else 
			{
				int colonne=X/vuePuits.getTaille()-this.tempCo;		
				if(colonne != 0) 
				{ 
					try 
					{
						this.puits.getPieceActuelle().deplacerDe(colonne, 0);
					} catch (BloxException erreur) 
					{
						System.err.println("le deplacement de la piece ne peut pas se faire");
					}
				}
				this.tempCo=X/vuePuits.getTaille();
			}
			
			vuePuits.repaint();
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(SwingUtilities.isLeftMouseButton(e)) {
			try {
				puits.getPieceActuelle().tourner(false);
			} catch (BloxException e1) {
				System.err.println("rotation anti horaire ne peut se lancer");
			}
		}
		if(SwingUtilities.isRightMouseButton(e)){
			try {
				puits.getPieceActuelle().tourner(true);
			} catch (BloxException e1) {
				System.err.println("rotation horaire ne peut se lancer");
			}
		}
		vuePuits.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.tempCo = -1;		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent event) {
		if(puits.getPieceActuelle() != null) {
			if(event.getWheelRotation() > 0) {
				try {
					puits.getPieceActuelle().deplacerDe(0, 1);
					vuePuits.repaint();
				} catch (IllegalArgumentException | BloxException e) {
					System.err.println("la piece ne peut plus tomber plus bas");
				}
			}
		}
	}

}
