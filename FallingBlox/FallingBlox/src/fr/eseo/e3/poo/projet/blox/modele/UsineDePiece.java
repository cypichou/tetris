package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Random;

import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.JPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.LPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.SPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.TPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.ZPiece;

public class UsineDePiece {
	
	public final static int ALEATOIRE_COMPLET = 0;
	public final static int ALEATOIRE_PIECE = 1;
	public final static int CYCLIC = 2;
	
	static int mode = 0;
	
    static int cptr = 0;
    
	  
	private UsineDePiece(){};
	
	public static void setMode(int modeC) {
		mode = modeC;
	}
	
	public static Piece genererPiece() {
		Coordonnees c = new Coordonnees(2,3);
		Couleur[] couleurs = Couleur.values();
       
		Random random = new Random();
       
        
		if (mode == ALEATOIRE_COMPLET) {
			 
			Couleur couleurAleatoire = couleurs[random.nextInt(couleurs.length)];
			 
			 int randomNumber = random.nextInt(7);
			 
			 if (randomNumber == 0) {
				 return new OPiece(c,couleurAleatoire);
			 }else if(randomNumber == 1) {
				 return new IPiece(c,couleurAleatoire); 
			 }else if(randomNumber == 2) {
				 return new JPiece(c,couleurAleatoire); 
			 }else if(randomNumber == 3) {
				 return new LPiece(c,couleurAleatoire); 
			 }else if(randomNumber == 4) {
				 return new ZPiece(c,couleurAleatoire); 
			 }else if(randomNumber == 5) {
				 return new SPiece(c,couleurAleatoire); 
			 }else if(randomNumber == 6) {
				 return new TPiece(c,couleurAleatoire); 
			 }
			 
		}else if(mode == ALEATOIRE_PIECE) {
						 
			int randomNumber = random.nextInt(7);
			
			if (randomNumber == 0) {
				 return new OPiece(c,Couleur.ROUGE);
			 }else if(randomNumber == 1) {
				 return new IPiece(c,Couleur.ORANGE);
			 }
				 else if(randomNumber == 2) {
				 return new TPiece(c,Couleur.BLEU);
			 }else if(randomNumber == 3) {
				 return new LPiece(c,Couleur.VERT);
			 }else if(randomNumber == 4) {
				 return new JPiece(c,Couleur.JAUNE);
			 }else if(randomNumber == 5) {
				 return new ZPiece(c,Couleur.CYAN);
			 }else if(randomNumber == 6) {
				 return new SPiece(c,Couleur.VIOLET);
			 }
			
		}else {
			
			Piece p;
			if(cptr == 0) {
			    p =  new OPiece(c,Couleur.ROUGE);
				cptr++;
			}else if(cptr == 1)  {
				p = new IPiece(c,Couleur.ORANGE);
				cptr++;
			}else if(cptr == 2) {
				p = new TPiece(c,Couleur.BLEU);
				cptr++;
			}else if(cptr == 3) {
				p = new LPiece(c,Couleur.VERT);
				cptr++;
			}else if(cptr == 4) {
				p = new JPiece(c,Couleur.JAUNE);
				cptr++;
			}else if(cptr == 5) {
				p = new ZPiece(c,Couleur.CYAN);
				cptr++;
			}else {
				p = new SPiece(c,Couleur.VIOLET);
				cptr = 0;
			}
			
			return p;
			 
		}
		return null;
	}
}
