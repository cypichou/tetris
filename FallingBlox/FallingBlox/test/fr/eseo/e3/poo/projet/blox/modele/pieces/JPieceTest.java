package fr.eseo.e3.poo.projet.blox.modele.pieces;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class JPieceTest {

    @Test
    public void testCoordonnees() {

        JPiece piece = new JPiece(new Coordonnees(3, 4), Couleur.JAUNE);

        List<Element> elements = piece.getElements();

        assertEquals(elements.get(0).getCoordonnees(), new Coordonnees(3, 4));
        assertEquals(elements.get(1).getCoordonnees(), new Coordonnees(2, 4));
        assertEquals(elements.get(2).getCoordonnees(), new Coordonnees(3, 3));
        assertEquals(elements.get(3).getCoordonnees(), new Coordonnees(3, 2));
 
    }

    @Test
    public void testDeplacement() {

        JPiece piece = new JPiece(new Coordonnees(3, 4), Couleur.JAUNE);

        piece.setPosition(10, 1);

        assertEquals(piece.getElements().get(0).getCoordonnees(), new Coordonnees(10, 1));
    }

    @Test
    public void toStringTest() {
        Coordonnees c = new Coordonnees(3, 4);
        Couleur ref = Couleur.CYAN;
        JPiece jPiece = new JPiece(c, ref);

        String expectedString = "JPiece :\n" + "    (3, 4) - CYAN\n" + "    (2, 4) - CYAN\n" + "    (3, 3) - CYAN\n"
                + "    (3, 2) - CYAN\n";
        assertEquals(expectedString, jPiece.toString());
    }

    @Test
    public void tournerTest() throws BloxException {
        Coordonnees c = new Coordonnees(0, 0);
        Couleur ref = Couleur.CYAN;
        JPiece jPiece = new JPiece(c, ref);

        jPiece.tourner(true);

        Coordonnees pun = new Coordonnees(0, -1);
        assertEquals(jPiece.getElements().get(1).getCoordonnees(), pun);
    }

}


