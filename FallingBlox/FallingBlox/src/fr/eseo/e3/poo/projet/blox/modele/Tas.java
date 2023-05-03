package fr.eseo.e3.poo.projet.blox.modele;

import java.util.List;
import java.util.Random;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class Tas {
	private Puits puits;
	
	
	private Element[][] elements;
	
	public Tas(Puits puits) {
		this.puits = puits;
		elements = new Element[puits.getProfondeur()][puits.getLargeur()];
	}
	
	public Tas(Puits puits, int nbElements) {
		this.puits = puits;
		int n = nbElements / puits.getLargeur() + 1; 
		int c = nbElements / n;
		
		elements = new Element[puits.getProfondeur()][puits.getLargeur()];
		
		Random rand = new Random();
		
		construireTas(nbElements,n,rand);

	}
	
	public Tas(Puits puits, int nbElements,int nbLignes) {
		this.puits = puits;
		Random rand = new Random();
		
		elements = new Element[puits.getProfondeur()][puits.getLargeur()];

		construireTas(nbElements, nbLignes, rand);
	}
	
	public Tas(Puits puits, int nbElements, int nbLignes, Random rand) {
		this.puits = puits;
		elements = new Element[puits.getProfondeur()][puits.getLargeur()];
		
		construireTas(nbElements,nbLignes,rand);
		
	}
	
	private void construireTas (int nbElements, int nbLignes, Random rand) {
		if(nbElements != 0 && nbElements <= puits.getLargeur()*nbLignes ) {
			int nbElementsPlaces = 0;
			
			while(nbElementsPlaces < nbElements) {
				int aleatoire = rand.nextInt(nbLignes)+1;
				int ord = puits.getProfondeur() - aleatoire;
				int abs = rand.nextInt(puits.getLargeur());
				
				if (elements[ord][abs] == null) {
					int indiceCouleur = rand.nextInt(Couleur.values().length);
					elements[ord][abs] = new Element(new Coordonnees(abs,ord), Couleur.values()[indiceCouleur]);
					nbElementsPlaces++;
				}
				
			}
				
		}else {
			throw new IllegalArgumentException("trop d'elements pour le puit, ou 0");
		}
	}
	
	public void ajouterElements(Piece piece) {
		
		for (int i = 0; i < piece.getElements().size();i++) {
			Element element = new Element(piece.getElements().get(i).getCoordonnees(),piece.getElements().get(i).getCouleur());
			elements[element.getCoordonnees().getOrdonnee()][element.getCoordonnees().getAbscisse()] = element;
		}   // apre ca les coordonnees sont bons
	}

	public int retirerElement () {
		
		boolean ligneComplete = true;
		int score = 0;
		for (int i=0; i<elements.length;i++) {
			
			for (int j=0; j<elements[i].length;j++) {
				if (elements[i][j] == null) 
				{
					ligneComplete = false;
				}
			}
			
			if(ligneComplete) {
				score = 1;
				score += score*puits.getLargeur();
				int index = i;
				for (int j=0; j<elements[i].length;j++) {
					elements[index][j] = null;
					if(index-1 > -1) {
						while(elements[index-1][j] != null && index-1 > -1) {
							elements[index][j] = elements[index-1][j];
							Coordonnees cord = new Coordonnees(elements[index-1][j].getCoordonnees().getAbscisse(),elements[index-1][j].getCoordonnees().getOrdonnee()+1);
							elements[index][j].setCoordonnees(cord);
							elements[index-1][j] = null;
							index--;
						}
						elements[index-1][j] = null;
					}
					index=i;
				}
			}
			ligneComplete = true;
		}
		return score;
		
	}
	
	public Puits getPuits() {
		return puits;
	}

	public void setPuits(Puits puits) {
		this.puits = puits;
	}

	public Element[][] getElements() {
		return elements;
	}

	public void setElements(Element[][] elements) {
		this.elements = elements;
	}
}
