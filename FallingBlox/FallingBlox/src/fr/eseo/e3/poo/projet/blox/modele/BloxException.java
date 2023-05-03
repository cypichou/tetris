package fr.eseo.e3.poo.projet.blox.modele;

public class BloxException extends Exception {
	

	private static final long serialVersionUID = 1L;
	public static final int BLOX_COLLISION = 0;
	public static final int BLOX_SORTIE_PUITS = 0;
	int entier;
	
	public BloxException(String msg,int entier) {
		super(msg);
		this.entier = entier;
	}

	public int getType() {
		return entier;
	}

	public void setEntier(int entier) {
		this.entier = entier;
	}
}
