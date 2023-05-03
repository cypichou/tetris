package fr.eseo.e3.poo.projet.blox.modele.pieces;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class SPieceTest {

    @Test
    public void testCoordonnees() {

        SPiece piece = new SPiece(new Coordonnees(0, 0), Couleur.VERT);

        List<Element> elements = piece.getElements();

        assertEquals(elements.get(0).getCoordonnees(), new Coordonnees(0, 0));
        assertEquals(elements.get(1).getCoordonnees(), new Coordonnees(-1, 0));
        assertEquals(elements.get(2).getCoordonnees(), new Coordonnees(0, -1));
        assertEquals(elements.get(3).getCoordonnees(), new Coordonnees(1, -1));

    }

    @Test
    public void testDeplacement() {

        SPiece piece = new SPiece(new Coordonnees(3, 4), Couleur.VERT);

        piece.setPosition(10, 1);

        assertEquals(piece.getElements().get(0).getCoordonnees(), new Coordonnees(10, 1));
    }

    @Test
    public void toStringTest() {
        Coordonnees c = new Coordonnees(0, 0);
        Couleur ref = Couleur.CYAN;
        SPiece sPiece = new SPiece(c, ref);

        String expectedString = "SPiece :\n" + "    (0, 0) - CYAN\n" + "    (-1, 0) - CYAN\n" + "    (0, -1) - CYAN\n"
                + "    (1, -1) - CYAN\n";
        assertEquals(expectedString, sPiece.toString());
    }

    @Test
    public void tournerTest() throws BloxException {
        Coordonnees c = new Coordonnees(0, 0);
        Couleur ref = Couleur.CYAN;
        SPiece sPiece = new SPiece(c, ref);

        sPiece.tourner(true);

        Coordonnees pun = new Coordonnees(0, -1);
        assertEquals(sPiece.getElements().get(1).getCoordonnees(), pun);
    }
}

