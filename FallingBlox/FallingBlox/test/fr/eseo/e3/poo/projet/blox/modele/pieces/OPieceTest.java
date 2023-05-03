package fr.eseo.e3.poo.projet.blox.modele.pieces;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;


public class OPieceTest {
	
	@Test
	public void testOpieceCoordonneesCouleur() {

		Coordonnees position2 = new Coordonnees(1,2);

		Piece piece= new OPiece(position2,Couleur.ROUGE);

		List<Element> elements = new ArrayList<Element>();

		elements.add(new Element(new Coordonnees(1,2),Couleur.ROUGE));

		elements.add(new Element(new Coordonnees(1,1),Couleur.ROUGE));

		elements.add(new Element(new Coordonnees(2,1),Couleur.ROUGE));

		elements.add(new Element(new Coordonnees(2,2),Couleur.ROUGE));

		assertEquals(elements,piece.getElements()); 

	}
	
	
	@Test
	public void setElementsTest() {
		Coordonnees c = new Coordonnees(5, 5);
        Couleur ref = Couleur.CYAN;
        Piece oPiece = new OPiece(c, ref);
        assertEquals(4, oPiece.getElements().size());
	}
	
	@Test
	public void toStringTest() {
		Coordonnees c = new Coordonnees(5, 5);
        Couleur ref = Couleur.CYAN;
        Piece oPiece = new OPiece(c, ref);
        
		String expectedString = "OPiece :\n	(5, 5) - CYAN\n	(5, 4) - CYAN\n	(6, 4) - CYAN\n	(6, 5) - CYAN\n" ;
        assertEquals(expectedString, oPiece.toString());
	}
 
	@Test
	public void testSetPos() {
		Coordonnees c = new Coordonnees(1, 2);
        Couleur ref = Couleur.CYAN;
        Piece oPiece = new OPiece(c, ref);
        
        oPiece.setPosition(3, 2);
        
	}
}
