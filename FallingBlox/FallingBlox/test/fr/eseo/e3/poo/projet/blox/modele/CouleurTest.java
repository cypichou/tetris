package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.Assert.assertEquals;

import java.awt.Color;

import org.junit.Test;

public class CouleurTest {

	    @Test
	    public void testGetCouleurPourAffichage() {
	    	assertEquals(Color.CYAN, Couleur.CYAN.getCouleurPourAffichage());
	    	
	        assertEquals(Color.GREEN, Couleur.VERT.getCouleurPourAffichage());
	       
	        assertEquals(Color.YELLOW, Couleur.JAUNE.getCouleurPourAffichage());
	       
	        
	        assertEquals(Color.MAGENTA, Couleur.VIOLET.getCouleurPourAffichage());
	       
	        assertEquals(Color.RED, Couleur.ROUGE.getCouleurPourAffichage());
	       
	        assertEquals(Color.ORANGE, Couleur.ORANGE.getCouleurPourAffichage());
	      
	        assertEquals(Color.BLUE, Couleur.BLEU.getCouleurPourAffichage());
	    }
	}

