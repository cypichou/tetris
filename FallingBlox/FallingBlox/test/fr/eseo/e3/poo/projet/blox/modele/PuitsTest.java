package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class PuitsTest {

    
    @Test
    public void testGetSetLargeur () {
    	 Puits puits = new Puits(10, 20);
    	 puits.setLargeur(10);
    	 assertEquals(10, puits.getLargeur());
    }
    
    @Test
    public void LargeurError () {
    	Puits puits = new Puits();
        assertThrows(IllegalArgumentException.class, () -> { puits.setLargeur(3);});
        assertThrows(IllegalArgumentException.class, () -> new Puits(16, 20));
        assertThrows(IllegalArgumentException.class, () -> new Puits(10, 14));
        assertThrows(IllegalArgumentException.class, () -> new Puits(3, 20));
        assertThrows(IllegalArgumentException.class, () -> new Puits(10, 10));
        assertDoesNotThrow(() -> new Puits(5, 15));
        assertDoesNotThrow(() -> new Puits(10, 20));
        assertDoesNotThrow(() -> new Puits(15, 25));
        assertThrows(IllegalArgumentException.class, () -> {puits.setProfondeur(0);});
        assertThrows(IllegalArgumentException.class, () -> {puits.setProfondeur(26);});
        puits.setProfondeur(20);
        assertEquals(puits.getProfondeur(),20);
    }

    @Test
    public void testSetPieceSuivante() {
    	Puits puits = new Puits();    	

    	Coordonnees c = new Coordonnees(5, 5);
        Couleur ref = Couleur.CYAN;

        Piece pieceSuivante = new OPiece(c,ref);
        
        puits.setPieceSuivante(pieceSuivante);
        assertEquals(pieceSuivante, puits.getPieceSuivante());

    }

    @Test
    public void testToString() {
    	Puits puits = new Puits(10,15);    	
        
    	String expected = "Puits : Dimension 10 x 15\n";
        expected += "Piece Actuelle : <aucune>\n";
        expected += "Piece Suivante : IPiece :\n";
        expected += "\t(7, 8) - CYAN\n\t(7, 7) - CYAN\n\t(7, 6) - CYAN\n\t(7, 9) - CYAN\n" ;
        
        Couleur ref = Couleur.CYAN;
        Piece pieceSuivante = new IPiece(new Coordonnees(7, 8),ref);
        
        puits.setPieceSuivante(pieceSuivante);

        Assertions.assertEquals(expected, puits.toString());
        
        puits.setPieceActuelle(pieceSuivante);
        puits.setPieceSuivante(null);
        expected = "Puits : Dimension 10 x 15\n";
        expected += "Piece Actuelle : IPiece :\n";
        expected += "\t(5, -4) - CYAN\n\t(5, -5) - CYAN\n\t(5, -6) - CYAN\n\t(5, -3) - CYAN\n" ;
        expected += "Piece Suivante : <aucune>\n";
        
        Assertions.assertEquals(expected, puits.toString());
    }
    
    @Test
    public void testGravite() {
    	Puits puits = new Puits(10,15,80,8);    	
        Piece p = new IPiece(new Coordonnees(7, 8),Couleur.ROUGE);
        puits.setPieceSuivante(p);
        puits.setPieceSuivante(p);
        puits.getPieceActuelle().setPosition(5, 5);
        puits.gravite();
        
        assertEquals(p.getElements().get(0).getCoordonnees().getAbscisse(),5);
        assertEquals(p.getElements().get(0).getCoordonnees().getOrdonnee(),6);
        
        try {
	        p.deplacerDe(0, 1);
	        p.deplacerDe(0, 1);
	        p.deplacerDe(0, 1);
	        p.deplacerDe(0, 1);
	        p.deplacerDe(0, 1);
        } catch (BloxException e) {
        	assertEquals((String)"le deplacement n'est pas possible, collision bloc", (String)e.getMessage());
        }
    }
    
 
    
    @Test
    public void gererCollision() throws IllegalArgumentException, BloxException {
    	Puits puits = new Puits(10,15,110,11);    
        Piece p = new IPiece(new Coordonnees(7, 8),Couleur.ROUGE);
        puits.setPieceSuivante(p);
        puits.setPieceSuivante(p);
        
        p.deplacerDe(0, 1);
        p.deplacerDe(0, 1);
        p.deplacerDe(0, 1);
        p.deplacerDe(0, 1);
        p.deplacerDe(0, 1);
        p.deplacerDe(0, 1);
        p.deplacerDe(0, 1);
        p.deplacerDe(0, 1);

        
    }
    
    @Test
    public void testMaximumCapa() throws IllegalArgumentException, BloxException {
    	Puits puits = new Puits(10,15,110,11);    // TODO REFAIRE CE TEST DE MERDE 	
        Piece p = new IPiece(new Coordonnees(7, 8),Couleur.ROUGE);
       
        p.setPuits(puits);
        puits.setPieceSuivante(p);
        puits.setPieceSuivante(p);
        puits.getPieceActuelle().setPosition(5, 3);
        puits.gravite();

        assertEquals(puits.tasIsOut(),true);

        
    }
    
    
    
    

}
