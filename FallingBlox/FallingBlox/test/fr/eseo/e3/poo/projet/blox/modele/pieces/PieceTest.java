package fr.eseo.e3.poo.projet.blox.modele.pieces;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;

public class PieceTest {

    @Test
    public void testToString() {
        Piece piece = new IPiece(new Coordonnees(0, 2), Couleur.BLEU);
        String expectedString = "IPiece :\n" + 
                "	(0, 2) - BLEU\n" + 
                "	(0, 1) - BLEU\n" + 
                "	(0, 0) - BLEU\n" + 
                "	(0, 3) - BLEU\n";
        assertEquals(expectedString, piece.toString());
    }
    
    @Test
    public void testSetPosition() {
        Piece piece = new IPiece(new Coordonnees(0, 0), Couleur.BLEU);
        piece.setPosition(3, 5);
        Coordonnees expectedCoord1 = new Coordonnees(3, 5);
        Coordonnees expectedCoord2 = new Coordonnees(3, 4);
        Coordonnees expectedCoord3 = new Coordonnees(3, 3);
        Coordonnees expectedCoord4 = new Coordonnees(3, 6);
        assertEquals(expectedCoord1, piece.getElements().get(0).getCoordonnees());
        assertEquals(expectedCoord2, piece.getElements().get(1).getCoordonnees());
        assertEquals(expectedCoord3, piece.getElements().get(2).getCoordonnees());
        assertEquals(expectedCoord4, piece.getElements().get(3).getCoordonnees());
    }
    
    @Test
    void testGetPuits() {
        Puits puits = new Puits(10, 20);
        Piece piece = new OPiece(new Coordonnees(0, 0), Couleur.JAUNE);
        piece.setPuits(puits);
        assertEquals(puits, piece.getPuits());
    }

    @Test
    void testSetPuits() {
        Puits puits1 = new Puits(10, 20);
        Puits puits2 = new Puits(15, 25);
        Piece piece = new OPiece(new Coordonnees(0, 0), Couleur.JAUNE);
        piece.setPuits(puits1);
        assertEquals(puits1, piece.getPuits());
        piece.setPuits(puits2);
        assertEquals(puits2, piece.getPuits());
    }
    
    @Test
    public void testDeplacerDe() throws IllegalArgumentException, BloxException {

        Piece piece = new IPiece(new Coordonnees(3, 4), Couleur.BLEU);
		Puits puits = new Puits(8,16,10,3);
		
		piece.setPuits(puits);
		
        Coordonnees expectedCoord1 = new Coordonnees(3, 4);
        Coordonnees expectedCoord2 = new Coordonnees(3, 3);
        Coordonnees expectedCoord3 = new Coordonnees(3, 2);
        Coordonnees expectedCoord4 = new Coordonnees(3, 5);

        piece.deplacerDe(0, 1);

        assertEquals(expectedCoord1.getAbscisse(), piece.getElements().get(0).getCoordonnees().getAbscisse());
        assertEquals(expectedCoord1.getOrdonnee() + 1, piece.getElements().get(0).getCoordonnees().getOrdonnee());
        assertEquals(expectedCoord2.getAbscisse(), piece.getElements().get(1).getCoordonnees().getAbscisse());
        assertEquals(expectedCoord2.getOrdonnee() + 1, piece.getElements().get(1).getCoordonnees().getOrdonnee());
        assertEquals(expectedCoord3.getAbscisse(), piece.getElements().get(2).getCoordonnees().getAbscisse());
        assertEquals(expectedCoord3.getOrdonnee() + 1, piece.getElements().get(2).getCoordonnees().getOrdonnee());
        assertEquals(expectedCoord4.getAbscisse(), piece.getElements().get(3).getCoordonnees().getAbscisse());
        assertEquals(expectedCoord4.getOrdonnee() + 1, piece.getElements().get(3).getCoordonnees().getOrdonnee());


        piece.deplacerDe(-1, 0);

        assertEquals(expectedCoord1.getAbscisse() - 1, piece.getElements().get(0).getCoordonnees().getAbscisse());
        assertEquals(expectedCoord1.getOrdonnee() + 1, piece.getElements().get(0).getCoordonnees().getOrdonnee());
        assertEquals(expectedCoord2.getAbscisse() - 1, piece.getElements().get(1).getCoordonnees().getAbscisse());
        assertEquals(expectedCoord2.getOrdonnee() + 1, piece.getElements().get(1).getCoordonnees().getOrdonnee());
        assertEquals(expectedCoord3.getAbscisse() - 1, piece.getElements().get(2).getCoordonnees().getAbscisse());
        assertEquals(expectedCoord3.getOrdonnee() + 1, piece.getElements().get(2).getCoordonnees().getOrdonnee());
        assertEquals(expectedCoord4.getAbscisse() - 1, piece.getElements().get(3).getCoordonnees().getAbscisse());
        assertEquals(expectedCoord4.getOrdonnee() + 1, piece.getElements().get(3).getCoordonnees().getOrdonnee());


        try {
            piece.deplacerDe(-3, 0);
        } catch (BloxException e) {
            assertEquals("le deplacement n'est pas possible, collision puit", e.getMessage());
            assertEquals(BloxException.BLOX_SORTIE_PUITS, 0);
     
}
        puits = new Puits(8,8,32,4);
		piece.setPuits(puits);
		
		 try {
		        piece.deplacerDe(0, 1);
	        } catch (BloxException e) {
	            assertEquals("le deplacement n'est pas possible, collision bloc", e.getMessage());
	            assertEquals(BloxException.BLOX_COLLISION, 0);
	        }
		 
		 try {
		        piece.deplacerDe(0, -3);
	        } catch (IllegalArgumentException e) {
	            assertEquals("Y doit pas être négatif", e.getMessage());
	        }
		
		 try {
			 piece.deplacerDe(puits.getLargeur()-piece.getElements().get(0).getCoordonnees().getAbscisse(),0);
		 }catch(BloxException e){
			 assertEquals("le deplacement n'est pas possible, collision puit", e.getMessage());
			 }
		 
//		 try {
//			 piece.deplacerDe(0,puits.getProfondeur()-piece.getElements().get(0).getCoordonnees().getOrdonnee());
//		 }catch(BloxException e){
//			 assertEquals("le deplacement n'est pas possible, collision puit", e.getMessage());
//			 }
		 
		 }
    
    	@Test
    	public void testTourner() throws BloxException {
    	    Piece ipiece = new IPiece(new Coordonnees(5,5), Couleur.JAUNE);
    	    Puits puits = new Puits(10, 20);
    	    ipiece.setPuits(puits);
    	    
    	    Coordonnees[] coordsAvantRotation = new Coordonnees[4];
    	    coordsAvantRotation[0] = new Coordonnees(5,5);
    	    coordsAvantRotation[1] = new Coordonnees(5,4);
    	    coordsAvantRotation[2] = new Coordonnees(5,3);
    	    coordsAvantRotation[3] = new Coordonnees(5,6);
    	    
    	    ipiece.tourner(true);
    	    
    	    Coordonnees[] coordsApresRotation = new Coordonnees[4]; 
    	    coordsApresRotation[0] = new Coordonnees(5,5) ;
    	    coordsApresRotation[1] =  new Coordonnees(6,5);
    	    coordsApresRotation[2] =  new Coordonnees(7,5);
    	    coordsApresRotation[3] =  new Coordonnees(4,5);
    	    
    	    for(int i=0; i < 4; i++) {
    	        assertTrue(ipiece.getElements().get(i).getCoordonnees().equals(coordsApresRotation[i]));
    	    }
    	    
    	    ipiece.tourner(false);
    	    
    	    for(int i=0; i < 4; i++) {
    	        assertTrue(ipiece.getElements().get(i).getCoordonnees().equals(coordsAvantRotation[i]));
    	    }
    	}
    	
    	@Test
    	void testRotationCollisionTas() throws BloxException {
    		Piece piece = new IPiece(new Coordonnees(5, 2), Couleur.BLEU);
    		Puits puits = new Puits(10,10,50,5);
    		
    		piece.setPuits(puits);
    		puits.setPieceSuivante(piece);
    		puits.setPieceSuivante(piece);
    		puits.getPieceActuelle().setPosition(5, 4);
    		
    		try {
    			piece.tourner(true);
    			piece.tourner(true);

    		}catch(BloxException i) {
     			 assertEquals("le deplacement n'est pas possible, collision tas", i.getMessage());
       		}
    	}
    	
    	@Test
    	void testRotationCollisionPuits() throws BloxException {
    		Piece piece = new IPiece(new Coordonnees(5, 2), Couleur.BLEU);
    		Puits puits = new Puits(10,15);
    		
    		piece.setPuits(puits);
    		puits.setPieceSuivante(piece);
    		puits.setPieceSuivante(piece);
    		puits.getPieceActuelle().setPosition(5, 14);

    		try {
    			piece.tourner(false);

    			piece.tourner(false);

    		}catch(BloxException i) {
     			 assertEquals("le deplacement n'est pas possible, collision puit", i.getMessage());
       		}
    	}
    	
    	@Test
    	void testRotationCollisionElements() throws BloxException {
    		Piece piece = new IPiece(new Coordonnees(5, 2), Couleur.BLEU);
    		Puits puits = new Puits(10,15,100,10);
    		
    		piece.setPuits(puits);
    		puits.setPieceSuivante(piece);
    		puits.setPieceSuivante(piece);
    		puits.getPieceActuelle().setPosition(5, 8);

    		try {
    			piece.tourner(false);
    			piece.deplacerDe(0, 1);
    			piece.tourner(false);

    		}catch(BloxException i) {
     			 assertEquals("le deplacement n'est pas possible, collision tas", i.getMessage());
       		}
    		
    		puits.getPieceActuelle().setPosition(5, 8);

    		
    		try {
    			piece.tourner(true);
    			piece.deplacerDe(0, 1);
    			piece.tourner(true);

    		}catch(BloxException i) {
     			 assertEquals("le deplacement n'est pas possible, collision tas", i.getMessage());
       		}
    	}
    	
    }