package fr.eseo.e3.poo.projet.blox.modele;
import org.junit.Test;
import static org.junit.Assert.*;

public class ElementTest {

    @Test
    public void testGetCoordonnees() {
        Coordonnees c1 = new Coordonnees(10, 20);
        Element e1 = new Element(c1);
        assertEquals(c1, e1.getCoordonnees());
    }
    
    @Test
    public void testElement() {
    	 Element e = new Element(10,20);
         
    	 Coordonnees c1 = new Coordonnees(10, 20);

    	 assertEquals(c1, e.getCoordonnees());
    	 assertEquals(Couleur.ROUGE, e.getCouleur());
    }

    @Test
    public void testSetCoordonnees() {
        Coordonnees c1 = new Coordonnees(10, 20);
        Coordonnees c2 = new Coordonnees(30, 40);
        Element e = new Element(c1);
        e.setCoordonnees(c2);
        assertEquals(c2, e.getCoordonnees());
    }

    @Test
    public void testGetCouleur() {
        Couleur coul = Couleur.ROUGE;
        Element e = new Element(new Coordonnees(10, 20), coul);
        assertEquals(coul, e.getCouleur());
    }

    @Test
    public void testSetCouleur() {
        Couleur coul1 = Couleur.ROUGE;
        Couleur coul2 = Couleur.BLEU;
        Element e = new Element(new Coordonnees(10, 20), coul1);
        e.setCouleur(coul2);
        assertEquals(coul2, e.getCouleur());
    }

    @Test
    public void testEquals() {
        Element e1 = new Element(new Coordonnees(10, 20), Couleur.ROUGE);
        Element e2 = new Element(new Coordonnees(10, 20), Couleur.ROUGE);
        Element e3 = new Element(new Coordonnees(30, 40), Couleur.BLEU);
        Coordonnees c2 = new Coordonnees(30, 40);
        assertTrue(e1.equals(e2));
        assertTrue(e1.equals(e1));
        assertFalse(e1.equals(e3));
        assertFalse(e1.equals(c2));
        assertFalse(e1.equals(null));
    }
    
    @Test
	public void testHashCode() {
    	Element e1 = new Element(new Coordonnees(10, 20), Couleur.ROUGE);
    	Element e2 = new Element(new Coordonnees(10, 20), Couleur.ROUGE);
		assertEquals(e1.hashCode(), e2.hashCode());
		Element e3 = new Element(new Coordonnees(0, 20), Couleur.ROUGE);
		assertNotEquals(e1.hashCode(), e3.hashCode());
	}
    
    @Test
    public void testToString() {
    	Element e1 = new Element(new Coordonnees(10, 20), Couleur.ROUGE);
    	String expected = "(10, 20) - ROUGE";
    	assertEquals(expected, e1.toString());
    }

}
