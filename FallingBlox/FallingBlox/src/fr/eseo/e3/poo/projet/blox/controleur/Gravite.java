package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class Gravite implements ActionListener {
    
	private boolean boolSwitch = true;
    private VuePuits vuePuits;
    private Puits puits;
    private Timer timer;
    private int periodicite = 500;
    
    public Gravite(VuePuits vuePuits) {
        this.vuePuits = vuePuits;
        this.puits = vuePuits.getPuits();
        this.timer = new Timer(this.periodicite, this);
        timer.addActionListener(this);
    }
    
    public int getPeriodicite() {
        return periodicite;
    }
    
    public void setPeriodicite(int periodicite) {
        this.periodicite = periodicite;
        timer.setDelay(periodicite);
    }
    
    public void start() { 
        timer.start();
    }
    
    public void stop() {
        timer.stop(); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	if(boolSwitch) { 
    		puits.gravite();
    		boolSwitch = false;
    	}else {
    		boolSwitch = true;
    	}
		vuePuits.repaint();
		if(puits.tasIsOut()) {
			stop();
			puits.messageStop();
		}
    }

}
