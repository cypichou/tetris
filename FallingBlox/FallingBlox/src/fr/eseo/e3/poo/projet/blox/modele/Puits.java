package fr.eseo.e3.poo.projet.blox.modele;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class Puits {
	
	public static final String MODIFICATION_PIECE_ACTUELLE = "actuelle";
	public static final String MODIFICATION_PIECE_SUIVANTE = "suivante";
	public static final String MODIFICATION_SCORE = "score";

	public static final int LARGEUR_PAR_DEFAUT = 15;
	public static final int PROFONDEUR_PAR_DEFAUT = 25;
	public static final String GAME_OVER = "game over";
	
	int largeur;
	int profondeur;
	
	private Piece pieceActuelle;
	private Piece pieceSuivante;
	
	private PropertyChangeSupport pcs;
	
	private Tas tas;
	
	public Puits () {
		this.largeur = LARGEUR_PAR_DEFAUT;
		this.profondeur = PROFONDEUR_PAR_DEFAUT;
		pcs = new PropertyChangeSupport(this);
		
		tas = new Tas(this);
	}
	
	public Puits(int larg, int hau) {
		if (larg < 5 || larg > 15 || hau < 15 || hau > 25) {
            throw new IllegalArgumentException("La largeur doit être comprise entre 5 et 15, et la profondeur doit être comprise entre 15 et 25.");
        }
		this.largeur = larg;
        this.profondeur = hau;
		pcs = new PropertyChangeSupport(this);
		tas = new Tas(this);
	}
	
	public Puits(int largeur, int profondeur, int nbElement ,int nbLignes) {
		Random rand = new Random();
		this.largeur = largeur;
		this.profondeur = profondeur;
		tas = new Tas(this, nbElement, nbLignes, rand);
		pcs = new PropertyChangeSupport(this);

	}

	public void setPieceSuivante(Piece pieceSuiv) { 	
		
	    if (pieceSuivante != null) {
	    	Piece pieceActuelleCopie = pieceActuelle;
	        
	    	pieceActuelle = pieceSuivante;

	        pieceActuelle.setPosition(largeur / 2, -4);
	    	
	        pcs.firePropertyChange(MODIFICATION_PIECE_ACTUELLE, pieceActuelleCopie, pieceActuelle); 

	    }
	    pcs.firePropertyChange(MODIFICATION_PIECE_SUIVANTE, pieceSuivante, pieceSuiv ); 
	    pieceSuivante = pieceSuiv;
	} 
	
	private void gererCollision() {
		boolean passed = true;
		
		for (int i = 0; i < pieceActuelle.getElements().size();i++) { 
			Element element = pieceActuelle.getElements().get(i);
			if ( element.getCoordonnees().getOrdonnee() < 0 ) {
				passed = false;
			}
		}
		
		if(passed) {
			
			tas.ajouterElements(pieceActuelle);
		    
			pcs.firePropertyChange(MODIFICATION_SCORE, 0, tas.retirerElement());

			Piece piece = UsineDePiece.genererPiece();
			piece.setPuits(this);
			
			setPieceSuivante(piece); 
			
		} 
	}
	
	public void gravite() {
		try {
			if(getPieceActuelle()!=null) {
				getPieceActuelle().deplacerDe(0, 1);
			}else {
				Piece piece = UsineDePiece.genererPiece();
				piece.setPuits(this);
				setPieceSuivante(piece);
				piece = UsineDePiece.genererPiece();
				piece.setPuits(this);
				setPieceSuivante(piece); 
			}
		}catch(BloxException bloxE){ // peut rencontrer le fond du tas ou le fond du puit, mais on s'en fout dans tous les cas il faut ajouter au tas			
			gererCollision();
		}
	}
	
	public boolean tasIsOut() {
		for(int i=0;i<getLargeur();i++) {
			if(tas.getElements()[0][i] != null) {
				return true;
			}
		}
		return false;
	}
	
	public void messageStop() {
		pcs.firePropertyChange(GAME_OVER, 0, 1);
	}

	public Tas getTas() {
		return tas;
	}

	public void setTas(Tas tas) {
		this.tas = tas;
	}

	public String toString () {
		String s = "";
		s+= "Puits : Dimension " + largeur + " x " + profondeur + "\n";
		s+= "Piece Actuelle : ";
		
		if (pieceActuelle == null) {
			s+="<aucune>\n";
		}else {
			s += pieceActuelle.toString();
		}
		s+= "Piece Suivante : ";
		if (pieceSuivante == null) {
			s+="<aucune>\n";
		}else {
			s += pieceSuivante.toString();
		}
		return s;
	}
	
	public int getLargeur() {
		return largeur;
	}

	public void setLargeur(int largeur) {
	  if (largeur < 5 || largeur > 15) {
            throw new IllegalArgumentException("La largeur doit être entre 5 et 15");
        }
        this.largeur = largeur;
	}

	public int getProfondeur() {
		return profondeur;
	}

    public void setProfondeur(int profondeur) {
        if (profondeur < 15 || profondeur > 25) {
            throw new IllegalArgumentException("La profondeur doit être entre 15 et 25");
        }
        this.profondeur = profondeur;
    }

	public Piece getPieceActuelle() {
		return pieceActuelle;
	}

	public void setPieceActuelle(Piece pieceActuelle) {
		this.pieceActuelle = pieceActuelle;
	}

	public Piece getPieceSuivante() {
		return pieceSuivante;
	}

	
	public void addPropertyChangeListener (PropertyChangeListener listener ) {
		pcs.addPropertyChangeListener(listener);
	}
	
	public void removePropertyChangeListener (PropertyChangeListener listener) {
		pcs.removePropertyChangeListener(listener);
	}
	
}
