package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class CoordonneesTest {
	
	@Test
    public void testConstructeur() {
        Coordonnees a = new Coordonnees(1, 2);        
        Assertions.assertEquals(1, a.getAbscisse());
        Assertions.assertEquals(2, a.getOrdonnee());
    }

	    @Test
	    public void testEquals() {
	        Coordonnees obj1 = new Coordonnees(1, 2);
	        Coordonnees obj2 = new Coordonnees(1, 2);
	        Coordonnees obj3 = new Coordonnees(3, 4);
	        Piece p = new IPiece(obj1,Couleur.BLEU); 
	       
	        assertTrue(obj1.equals(obj1));
	        
	        assertTrue(obj1.equals(obj2));
	        
	        assertFalse(obj1.equals(obj3));
	        
	        assertFalse(obj1.equals(null));
	        
	        assertFalse(obj1.equals(p));
	    }
	    
	    @Test
	    public void testToString() {
	        Coordonnees a = new Coordonnees(1, 2);
	        Assertions.assertEquals("(1, 2)", a.toString());
	    }
	    
	    @Test
		public void testHashCode() {
			Coordonnees c1 = new Coordonnees(2, 3);
			Coordonnees c2 = new Coordonnees(2, 3);
			assertEquals(c1.hashCode(), c2.hashCode());
			Coordonnees c3 = new Coordonnees(4, 5);
			assertNotEquals(c1.hashCode(), c3.hashCode());
		}
	    
	    @Test
		public void testSetAbscisse() {
			Coordonnees c = new Coordonnees(2, 3);
			c.setAbscisse(4);
			assertEquals(4, c.getAbscisse());
		}
		
		@Test
		public void testSetOrdonnee() {
			Coordonnees c = new Coordonnees(2, 3);
			c.setOrdonnee(5);
			assertEquals(5, c.getOrdonnee());
		}
	    
	    
}

