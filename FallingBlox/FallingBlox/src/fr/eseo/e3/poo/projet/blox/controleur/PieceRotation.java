package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;

import javax.swing.SwingUtilities;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceRotation extends MouseAdapter implements MouseMotionListener{
	
	private Puits puits;
	private  VuePuits vuePuits;
	
	public PieceRotation (VuePuits vuePuits) {
		this.vuePuits = vuePuits;
		this.puits = vuePuits.getPuits();
	}
	
	@Override
	public void mouseClicked (java.awt.event.MouseEvent e) {
		if(SwingUtilities.isLeftMouseButton(e)) {
			try {
				puits.getPieceActuelle().tourner(false);
			} catch (BloxException e1) {
				System.err.println("Block Exception");
			}
		}
		if(SwingUtilities.isRightMouseButton(e)){
			try {
				puits.getPieceActuelle().tourner(true);
			} catch (BloxException e1) {
				System.err.println("Block Exception");
			}
		}
		vuePuits.repaint();
	}
}
