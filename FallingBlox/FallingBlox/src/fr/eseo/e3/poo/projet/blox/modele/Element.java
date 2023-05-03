package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Objects;

public class Element {
	
	private Coordonnees coordonnees;
	private Couleur couleur;
	
	public Element (Coordonnees c){
		this.coordonnees = c;
		this.couleur = Couleur.ROUGE;
	}
	
	public Element (int abscisse , int ordonnee){
		coordonnees = new Coordonnees (abscisse,ordonnee);
		this.couleur = Couleur.ROUGE;

	}

	public Element (Coordonnees c, Couleur coul){
		this.coordonnees = c;
		this.couleur = coul;
	}
	
	public Element (int ab, int or, Couleur helicoptereDeCombat){
		coordonnees = new Coordonnees (ab,or);
		couleur = helicoptereDeCombat;
	}

	public Coordonnees getCoordonnees() {
		return coordonnees;
	}

	@Override
	public String toString() {
		return "(" + coordonnees.getAbscisse() + ", " + coordonnees.getOrdonnee() +") - " + couleur ;
	}
	
	public void setCoordonnees(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	@Override
	public int hashCode() {
		return Objects.hash(coordonnees, couleur);
	} 

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Element other = (Element) obj;
		return Objects.equals(coordonnees, other.coordonnees) && couleur == other.couleur;
	}
	
	public void deplacerDe( int deltaX, int deltaY) {
		Coordonnees vecteur = new Coordonnees(getCoordonnees().getAbscisse()+deltaX,getCoordonnees().getOrdonnee()+deltaY);
		setCoordonnees(vecteur);
	}

}
