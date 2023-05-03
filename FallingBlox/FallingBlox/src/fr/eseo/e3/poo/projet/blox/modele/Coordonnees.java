package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Objects;

public class Coordonnees {
	
	private int abscisse;
	private int ordonnee;
	
	public Coordonnees(int Abscisse, int Ordonnee){
		this.abscisse = Abscisse;
		this.ordonnee = Ordonnee;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordonnees other = (Coordonnees) obj;
		return abscisse == other.abscisse && ordonnee == other.ordonnee;
	}

	@Override
	public int hashCode() {
		return Objects.hash(abscisse, ordonnee);
	}

	@Override
	public String toString() {
		return  "(" + getAbscisse() + ", " + getOrdonnee()+")" ; 
	}
	
	public int getAbscisse() {
		return abscisse;
	}

	public void setAbscisse(int abscisse) {
		this.abscisse = abscisse;
	}

	public int getOrdonnee() {
		return ordonnee;
	}

	public void setOrdonnee(int ordonnee) {
		this.ordonnee = ordonnee;
	}
	
	
	
	
}
