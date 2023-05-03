package fr.eseo.e3.poo.projet.blox.modele.pieces;

import java.util.List;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class TPiece extends Piece {
	
	public TPiece(Coordonnees coo, Couleur coul) {
		super(coo, coul);
		setElements(coo, coul);
	}

	@Override
	protected void setElements(Coordonnees coordonnees, Couleur couleur) {
		getElements().clear();
		
		Element element1 = new Element(coordonnees.getAbscisse(),     coordonnees.getOrdonnee(), couleur);
		Element element2 = new Element(coordonnees.getAbscisse() - 1, coordonnees.getOrdonnee(), couleur);
		Element element3 = new Element(coordonnees.getAbscisse() + 1, coordonnees.getOrdonnee(), couleur);
		Element element4 = new Element(coordonnees.getAbscisse(),     coordonnees.getOrdonnee() + 1, couleur);
		
		getElements().add(element1);
		getElements().add(element2);
		getElements().add(element3);
		getElements().add(element4);
	}
	
	@Override
	public String toString() {
		String tempS = "";
		tempS += "TPiece :\n";
		tempS += "    (" + getElements().get(0).getCoordonnees().getAbscisse() + ", " + getElements().get(0).getCoordonnees().getOrdonnee() + ") - " + getElements().get(0).getCouleur() + '\n';
		tempS += "    (" + getElements().get(1).getCoordonnees().getAbscisse() + ", " + getElements().get(1).getCoordonnees().getOrdonnee() + ") - " + getElements().get(1).getCouleur() + '\n';
		tempS += "    (" + getElements().get(2).getCoordonnees().getAbscisse() + ", " + getElements().get(2).getCoordonnees().getOrdonnee() + ") - " + getElements().get(2).getCouleur() + '\n' ;
		tempS += "    (" + getElements().get(3).getCoordonnees().getAbscisse() + ", " + getElements().get(3).getCoordonnees().getOrdonnee() + ") - " + getElements().get(3).getCouleur() + '\n';
	    return tempS;
	}
}
