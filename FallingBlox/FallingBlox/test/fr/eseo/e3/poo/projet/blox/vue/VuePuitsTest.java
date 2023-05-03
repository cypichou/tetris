package fr.eseo.e3.poo.projet.blox.vue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import org.junit.Before;
import org.junit.Test;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class VuePuitsTest {

	private Puits puits;
	private VuePuits vuePuits;

	@Before
	public void setUp() {
		puits = new Puits(10, 20);
		vuePuits = new VuePuits(puits);
	}

	@Test
	public void testConstructeurAvecPuits() {
		assertEquals(puits, vuePuits.getPuits());
		assertEquals(VuePuits.TAILLE_PAR_DEFAUT, vuePuits.getTaille());
		assertEquals(new Dimension(10 * VuePuits.TAILLE_PAR_DEFAUT, 20 * VuePuits.TAILLE_PAR_DEFAUT),vuePuits.getPreferredSize());
	}

	@Test
	public void testConstructeurAvecPuitsEtTaille() {
		vuePuits = new VuePuits(puits, 50);
		assertEquals(puits, vuePuits.getPuits());
		assertEquals(50, vuePuits.getTaille());
		assertEquals(new Dimension(10 * 50, 20 * 50), vuePuits.getPreferredSize());
	}

	@Test
	public void testSetPuits() {
		Puits newPuits = new Puits(5, 15);
		vuePuits.setPuits(newPuits);
		assertEquals(newPuits, vuePuits.getPuits());
	}

	@Test
	public void testSetTaille() {
		vuePuits.setTaille(40);
		assertEquals(40, vuePuits.getTaille());
		assertEquals(new Dimension(10 * 40, 20 * 40), vuePuits.getPreferredSize());
	}
	
	@Test
	public void testVuePuits() {
	    Puits puits = new Puits(10, 20);
	    
	    VuePuits vuePuits = new VuePuits(puits);
	    
	    Piece opiece = new OPiece(new Coordonnees(20,10),Couleur.BLEU);
	    puits.setPieceSuivante(opiece);
	    puits.setPieceSuivante(opiece);

	    VuePiece vuePiece = new VuePiece(opiece,30);
	    
	    VuePiece nouvelleVuePiece = new VuePiece(new OPiece(new Coordonnees(20,10),Couleur.BLEU), 40);
	    
	    assertTrue(!nouvelleVuePiece.equals(vuePuits.getVuePiece()) );
	   
	}
	

	
}
