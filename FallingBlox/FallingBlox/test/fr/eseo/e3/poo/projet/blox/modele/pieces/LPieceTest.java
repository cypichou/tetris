package fr.eseo.e3.poo.projet.blox.modele.pieces;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class LPieceTest {

    @Test
    public void testCoordonnees() {

        LPiece piece = new LPiece(new Coordonnees(0, 0), Couleur.JAUNE);

        List<Element> elements = piece.getElements();

        assertEquals(elements.get(0).getCoordonnees(), new Coordonnees(0, 0));
        assertEquals(elements.get(1).getCoordonnees(), new Coordonnees(0, -2));
        assertEquals(elements.get(2).getCoordonnees(), new Coordonnees(0, -1));
        assertEquals(elements.get(3).getCoordonnees(), new Coordonnees(1, 0));

    }

    @Test
    public void testDeplacement() {

        LPiece piece = new LPiece(new Coordonnees(3, 4), Couleur.JAUNE);

        piece.setPosition(10, 1);

        assertEquals(piece.getElements().get(0).getCoordonnees(), new Coordonnees(10, 1));
    }

    @Test
    public void toStringTest() {
        Coordonnees c = new Coordonnees(0, 0);
        Couleur ref = Couleur.CYAN;
        LPiece lPiece = new LPiece(c, ref);

        String expectedString = "LPiece :\n" + "    (0, 0) - CYAN\n" + "    (0, -2) - CYAN\n" + "    (0, -1) - CYAN\n"
                + "    (1, 0) - CYAN\n";
        assertEquals(expectedString, expectedString);
    }

    @Test
    public void tournerTest() throws BloxException {
        Coordonnees c = new Coordonnees(0, 0);
        Couleur ref = Couleur.CYAN;
        LPiece lPiece = new LPiece(c, ref);

        lPiece.tourner(true);

        Coordonnees pun = new Coordonnees(-2, 0);
        assertEquals(lPiece.getElements().get(1).getCoordonnees(), pun);
    }

}

