package fr.eseo.e3.poo.projet.blox.vue;

import javax.lang.model.element.Element;

import fr.eseo.e3.poo.projet.blox.modele.Tas;

public class VueTas {
	public static final double MULTIPLIER_NUANCE = 0.7;

	private final Tas tas;
	private final VuePuits  vuePuits;
	
	public VueTas(VuePuits vuePuits) {
		this.vuePuits = vuePuits;
		this.tas = vuePuits.getPuits().getTas(); // hmmm c'est chelou
		
	}
	
	public VuePuits getVuePuits() {
		return vuePuits;
	}
	
	public void afficher(java.awt.Graphics2D g2D) { 
		
		for(int i = 0; i<tas.getElements().length;i++) {
			for(int j = 0; j<tas.getElements()[i].length;j++) {
				
				if(tas.getElements()[i][j]==null) {
					g2D.clearRect(j*vuePuits.getTaille(), i* vuePuits.getTaille(), vuePuits.getTaille(), vuePuits.getTaille());
				}
				if(tas.getElements()[i][j]!=null) {
					g2D.setColor(nuance(tas.getElements()[i][j].getCouleur().getCouleurPourAffichage()));
					g2D.fill3DRect(tas.getElements()[i][j].getCoordonnees().getAbscisse()*vuePuits.getTaille(), tas.getElements()[i][j].getCoordonnees().getOrdonnee()* vuePuits.getTaille(), vuePuits.getTaille(), vuePuits.getTaille(), true);
				}
				
			}

		}
		
	}

	public java.awt.Color nuance (java.awt.Color couleur){
		double r = couleur.getRed();
		double g = couleur.getGreen();
		double b = couleur.getBlue();
		
		r = r * (1-MULTIPLIER_NUANCE);
		g = g * (1-MULTIPLIER_NUANCE);
		b = b * (1-MULTIPLIER_NUANCE);
		
		couleur = new java.awt.Color((int)r,(int)g,(int)b);

		return couleur;
	}  
	public Tas getTas() {
		return tas;
	}
}
