package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.JPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.LPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.SPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.TPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.ZPiece;

public class UsineDePieceTest {

    @Before
    public void setUp() {
        // Initialiser les variables nécessaires à l'exécution des tests
    }

    @Test
    public void testGenererPieceAleatoireComplet() {
        UsineDePiece.setMode(UsineDePiece.ALEATOIRE_COMPLET);
        Piece piece = UsineDePiece.genererPiece();
        
        while(!(piece instanceof IPiece)){
        	piece = UsineDePiece.genererPiece();
        }
        assertEquals(true, piece instanceof IPiece );
        
        while(!(piece instanceof OPiece)){
        	piece = UsineDePiece.genererPiece();
        }
        assertEquals(true, piece instanceof OPiece );
    }

    @Test
    public void testGenererPieceAleatoirePiece() {
        UsineDePiece.setMode(UsineDePiece.ALEATOIRE_PIECE);
        
        Piece piece = UsineDePiece.genererPiece();
        
        assertEquals(true, (piece instanceof IPiece || piece instanceof OPiece
        		|| piece instanceof JPiece
        		|| piece instanceof LPiece
        		|| piece instanceof ZPiece
        		|| piece instanceof SPiece
        		|| piece instanceof TPiece));
         
        while(!(piece instanceof IPiece)){
        	piece = UsineDePiece.genererPiece();
        }
        assertEquals(piece.getElements().get(0).getCouleur(),Couleur.ORANGE);
        
        while(!(piece instanceof OPiece)){
        	piece = UsineDePiece.genererPiece();
        }
        assertEquals(piece.getElements().get(0).getCouleur(),Couleur.ROUGE);
        
        while(!(piece instanceof TPiece)){
        	piece = UsineDePiece.genererPiece();
        }
        assertEquals(piece.getElements().get(0).getCouleur(),Couleur.BLEU);
        
        while(!(piece instanceof ZPiece)){
        	piece = UsineDePiece.genererPiece();
        }
        assertEquals(piece.getElements().get(0).getCouleur(),Couleur.CYAN);
        
        while(!(piece instanceof LPiece)){
        	piece = UsineDePiece.genererPiece();
        }
        assertEquals(piece.getElements().get(0).getCouleur(),Couleur.VERT);
        
        while(!(piece instanceof JPiece)){
        	piece = UsineDePiece.genererPiece();
        }
        assertEquals(piece.getElements().get(0).getCouleur(),Couleur.JAUNE);
        
        while(!(piece instanceof SPiece)){
        	piece = UsineDePiece.genererPiece();
        }
        assertEquals(piece.getElements().get(0).getCouleur(),Couleur.VIOLET);
    }

    @Test
    public void testGenererPieceCyclic() {
        UsineDePiece.setMode(UsineDePiece.CYCLIC);
        
        Piece piece1 = UsineDePiece.genererPiece();
        assertEquals(OPiece.class, piece1.getClass());
        assertEquals(Couleur.ROUGE, piece1.getElements().get(0).getCouleur());
        
        Piece piece2 = UsineDePiece.genererPiece();
        assertEquals(IPiece.class, piece2.getClass());
        assertEquals(Couleur.ORANGE, piece2.getElements().get(0).getCouleur());
        
        Piece piece3 = UsineDePiece.genererPiece();
        assertEquals(TPiece.class, piece3.getClass());
        assertEquals(Couleur.BLEU, piece3.getElements().get(0).getCouleur());
        
        piece3 = UsineDePiece.genererPiece();
        assertEquals(LPiece.class, piece3.getClass());
        assertEquals(Couleur.VERT, piece3.getElements().get(0).getCouleur());
        
        piece3 = UsineDePiece.genererPiece();
        assertEquals(JPiece.class, piece3.getClass());
        assertEquals(Couleur.JAUNE, piece3.getElements().get(0).getCouleur());
        
        piece3 = UsineDePiece.genererPiece();
        assertEquals(ZPiece.class, piece3.getClass());
        assertEquals(Couleur.CYAN, piece3.getElements().get(0).getCouleur());
        
        piece3 = UsineDePiece.genererPiece();
        assertEquals(SPiece.class, piece3.getClass());
        assertEquals(Couleur.VIOLET, piece3.getElements().get(0).getCouleur());
    }

}
