package fr.eseo.e3.poo.projet.blox.modele.pieces;

import java.util.ArrayList;
import java.util.List;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;

public abstract class Piece {
	
	 private List<Element> elements = new ArrayList <Element>();;
	
	 Puits puits;
	 
	 public Piece ( Coordonnees coo, Couleur coul) {
		 
	} 
	 
	public void deplacerDe (int deltaX, int deltaY) throws IllegalArgumentException, BloxException {

		if (deltaY>=0 && deltaY<=1 ) {
			String deplacement = "ok"; 
			
			for (int i = 0; i < elements.size();i++) { // tester si la piece actuelle est bien dans le puit visible
				Element element = elements.get(i);
				if ( element.getCoordonnees().getOrdonnee() < 0 ) {
					deplacement = "ordonnee negative" ;
				}
			}
			
			if(getPuits() != null) 
			{
				for(int i=0;i<elements.size();i++) { 
					
					if(elements.get(i).getCoordonnees().getAbscisse()+deltaX < 0 
							|| elements.get(i).getCoordonnees().getAbscisse()+deltaX+1 > getPuits().getLargeur() 
							|| elements.get(i).getCoordonnees().getOrdonnee()+deltaY+1 > getPuits().getProfondeur() ) {        
						
						deplacement = "collision puits";
					}
				}
				
				if(deplacement == "ok" && !deplacement.equals("ordonnee negative")) {
					for(int i=0;i<elements.size();i++) { // pour chaque elements
						
						for(int z=0;z < puits.getTas().getElements().length;z++) { //pour chaque element dans le tableau
							
							for(int j=0;j < puits.getTas().getElements()[z].length;j++) {
								
								if(puits.getTas().getElements()[z][j] != null) {
									
									if( elements.get(i).getCoordonnees().getAbscisse()+deltaX == puits.getTas().getElements()[z][j].getCoordonnees().getAbscisse()
											&& elements.get(i).getCoordonnees().getOrdonnee()+deltaY == puits.getTas().getElements()[z][j].getCoordonnees().getOrdonnee())
									{
										deplacement = "collision element";
									}
								}
							}
						}
					}
				}

			}
			
			if(deplacement.equals("ok") || deplacement.equals("ordonnee negative") ) {
				elements.get(0).deplacerDe(deltaX, deltaY);
				elements.get(1).deplacerDe(deltaX, deltaY);
				elements.get(2).deplacerDe(deltaX, deltaY);
				elements.get(3).deplacerDe(deltaX, deltaY);
			}else {
				if(deplacement.equals("collision element")) {
					throw new BloxException("le deplacement n'est pas possible, collision bloc",BloxException.BLOX_COLLISION);
				}else {
					throw new BloxException("le deplacement n'est pas possible, collision puit",BloxException.BLOX_SORTIE_PUITS);
				}
			}
		}else {
			throw new IllegalArgumentException("Y doit pas être négatif");
		}
	}
	
	public String toString() {
		String tempS = "piece to string, impossible";
	    return tempS;
	}
	
	
	public void setPosition(int abs, int ordo) {
		int decX = abs - elements.get(0).getCoordonnees().getAbscisse();
		int decY = ordo - elements.get(0).getCoordonnees().getOrdonnee();
		
		elements.get(0).setCoordonnees(new Coordonnees(abs,ordo));
		elements.get(1).setCoordonnees(new Coordonnees (elements.get(1).getCoordonnees().getAbscisse() +decX,elements.get(1).getCoordonnees().getOrdonnee()+decY));
		elements.get(2).setCoordonnees(new Coordonnees (elements.get(2).getCoordonnees().getAbscisse() +decX,elements.get(2).getCoordonnees().getOrdonnee()+decY));
		elements.get(3).setCoordonnees(new Coordonnees (elements.get(3).getCoordonnees().getAbscisse() +decX,elements.get(3).getCoordonnees().getOrdonnee()+decY));

	}
	
	protected abstract void setElements(Coordonnees coordonnees, Couleur couleur);
	
	public List<Element> getElements() {
		return elements;
	}
		
	public Puits getPuits() {
		return this.puits;
	}
	
	public void setPuits(Puits puit) {
		this.puits = puit;
	}
	
	public void tourner( boolean sensHoraire) throws BloxException {
			String deplacement = "ok";
			
			if(deplacement.equals("ok")) {
				// decaler notre piece a l'origine du repere
				int deltaX = -getElements().get(0).getCoordonnees().getAbscisse();
				int deltaY = -getElements().get(0).getCoordonnees().getOrdonnee();
				
				getElements().get(0).deplacerDe(deltaX, deltaY);
				getElements().get(1).deplacerDe(deltaX, deltaY);
				getElements().get(2).deplacerDe(deltaX, deltaY);
				getElements().get(3).deplacerDe(deltaX, deltaY);
			
					if(sensHoraire) {
						if(getElements().get(1).getCoordonnees().getOrdonnee() == -1 || getElements().get(1).getCoordonnees().getOrdonnee() == 1) {
							for (int i=1;i<4;i++) {		
								int ord = getElements().get(i).getCoordonnees().getOrdonnee();
								getElements().get(i).getCoordonnees().setAbscisse( -getElements().get(i).getCoordonnees().getAbscisse() );
								getElements().get(i).getCoordonnees().setOrdonnee( -ord );
							}
						}
					}else {
						if(getElements().get(1).getCoordonnees().getAbscisse() == -1 || getElements().get(1).getCoordonnees().getAbscisse() == 1) {
							for (int i=1;i<4;i++) {		
								int ord = getElements().get(i).getCoordonnees().getOrdonnee();
								getElements().get(i).getCoordonnees().setAbscisse( -getElements().get(i).getCoordonnees().getAbscisse() );
								getElements().get(i).getCoordonnees().setOrdonnee( -ord );
							}
						}
					}
				
					// d'abord changement absicces et ordonnees
				
					for (int i=1;i<4;i++) {			
						int abs = getElements().get(i).getCoordonnees().getAbscisse();
						getElements().get(i).getCoordonnees().setAbscisse(getElements().get(i).getCoordonnees().getOrdonnee());
						getElements().get(i).getCoordonnees().setOrdonnee(abs);
					 }
				
				if(getPuits()!=null && deplacement.equals("ok")) { // si il y a collision apres avoir tourner la piece 
					
					for(int i=0;i<elements.size();i++) { // pour chaque elements verifie si il y a collision
							
							int ord = getElements().get(i).getCoordonnees().getOrdonnee()-deltaY;
							
							try {
								Element x = puits.getTas().getElements()[ord][getElements().get(i).getCoordonnees().getAbscisse()-deltaX];
							
							if(x != null) {
								deplacement = "collision tas";
							}
							}catch(ArrayIndexOutOfBoundsException e){
								deplacement = "collision puits";
							}
							
					}
				} 
					
					if(deplacement.equals("collision tas") || deplacement.equals("collision puits")){
						
						// changer l'abs et ord
						if(!sensHoraire) {
							if(getElements().get(1).getCoordonnees().getOrdonnee() == -1 || getElements().get(1).getCoordonnees().getOrdonnee() == 1) {
								for (int i=1;i<4;i++) {		
									int ord = getElements().get(i).getCoordonnees().getOrdonnee();
									getElements().get(i).getCoordonnees().setAbscisse( -getElements().get(i).getCoordonnees().getAbscisse() );
									getElements().get(i).getCoordonnees().setOrdonnee( -ord );
								}
							}
						}else {
							if(getElements().get(1).getCoordonnees().getAbscisse() == -1 || getElements().get(1).getCoordonnees().getAbscisse() == 1) {
								for (int i=1;i<4;i++) {		
									int ord = getElements().get(i).getCoordonnees().getOrdonnee();
									getElements().get(i).getCoordonnees().setAbscisse( -getElements().get(i).getCoordonnees().getAbscisse() );
									getElements().get(i).getCoordonnees().setOrdonnee( -ord );
								}
							}
						}
						
						for (int i=1;i<4;i++) {			
							int abs = getElements().get(i).getCoordonnees().getAbscisse();
							getElements().get(i).getCoordonnees().setAbscisse(getElements().get(i).getCoordonnees().getOrdonnee());
							getElements().get(i).getCoordonnees().setOrdonnee(abs);
						 }
					}
				
						getElements().get(0).deplacerDe(-deltaX, -deltaY);
						getElements().get(1).deplacerDe(-deltaX, -deltaY);
						getElements().get(2).deplacerDe(-deltaX, -deltaY);
						getElements().get(3).deplacerDe(-deltaX, -deltaY);
			} 
				
				if(deplacement.equals("collision puits")) {

					throw new BloxException("le deplacement n'est pas possible, collision puit",BloxException.BLOX_SORTIE_PUITS);

				}
				if(deplacement.equals("collision tas")) {
					throw new BloxException("le deplacement n'est pas possible, collision tas",BloxException.BLOX_COLLISION);

				}
			}
		} 
		
	

