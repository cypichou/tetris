package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class TasTest {
	
	@Test
	public void testConstr() {
		Puits puits = new Puits(8,16);
		
	}
	
	@Test
	public void testConstr1() {
		Puits puits = new Puits();
	}
	
	@Test
	public void testConstr2() {
		Puits puits2 = new Puits(2,6,2,1);

	}
	
	@Test
	public void testConstr3() {
		Puits puits = new Puits(6,6,36,6);
		
	}
	
	@Test
	public void testConstr4() {
		Puits puits = new Puits(6,6,30,5);
		
	}
	
	@Test
	public void testConstr5() {
		try {
			Puits puits = new Puits(6,6,130,5);
		}catch(IllegalArgumentException err) {
			assertEquals(err.getMessage(),"trop d'elements pour le puit, ou 0");
		}
		
	}
	
	@Test
	public void testAjouterElements() {
		Puits puits = new Puits(6,6,2,5);
		Piece p = new IPiece(new Coordonnees(3,4),Couleur.BLEU);
		
		puits.getTas().ajouterElements(p);	
		
		for(int i=0; i<4;i++) {
			assertEquals(p.getElements().get(i),puits.getTas().getElements()[p.getElements().get(i).getCoordonnees().getOrdonnee()][p.getElements().get(i).getCoordonnees().getAbscisse()]);
		}
			

	}
	
	@Test
	public void testRetirerElement() {
		Puits puits = new Puits(6,6,1,2);

		
		int score = puits.getTas().retirerElement();
		
		assertTrue(score == 0);
		
		puits = new Puits(6,6,6,1);
		score = puits.getTas().retirerElement();

		
		boolean test = true;
		for (int i = 0; i < puits.getProfondeur(); i++) {
			for (int j = 0; j < puits.getLargeur(); j++) {
				if(puits.getTas().getElements()[i][j] != null) {
					test = false;
				}
			}
		}
		assertTrue(test);
		assertEquals(score,7);

	}
	
	
}
