package fr.eseo.e3.poo.projet.blox.modele.pieces;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class IPieceTest {
	
	@Test
	public void testCoordonnees () {
		
    IPiece piece = new IPiece(new Coordonnees(3, 4), Couleur.JAUNE);

    List<Element> elements = piece.getElements();
    
    assertEquals(elements.get(0).getCoordonnees(), new Coordonnees(3,4));
    assertEquals(elements.get(1).getCoordonnees(), new Coordonnees(3,3));
    assertEquals(elements.get(2).getCoordonnees(), new Coordonnees(3,2));
    assertEquals(elements.get(3).getCoordonnees(), new Coordonnees(3,5));

	}
	
	@Test
	public void testDeplacement() {
		
	    IPiece piece = new IPiece(new Coordonnees(3, 4), Couleur.JAUNE);
	   
	    piece.setPosition(10,1);
		
	    assertEquals(piece.getElements().get(0).getCoordonnees(), new Coordonnees(10,1));
	}
	
	@Test
	public void toStringTest() {
		Coordonnees c = new Coordonnees(3, 4);
        Couleur ref = Couleur.CYAN;
        IPiece iPiece = new IPiece(c, ref);
        
		String expectedString = "IPiece :\n	(3, 4) - CYAN\n	(3, 3) - CYAN\n	(3, 2) - CYAN\n	(3, 5) - CYAN\n" ;
        assertEquals(expectedString, iPiece.toString());
	}
	
	@Test
	public void tournerTest() throws BloxException {
		Coordonnees c = new Coordonnees(0, 0);
        Couleur ref = Couleur.CYAN;
        IPiece iPiece = new IPiece(c, ref);
        
        iPiece.tourner(true);
         
        
        Coordonnees pun = new Coordonnees(1, 0);
        assertEquals(iPiece.getElements().get(1).getCoordonnees(),pun);
	}

}
