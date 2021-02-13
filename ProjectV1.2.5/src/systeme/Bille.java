package systeme;

import java.io.Serializable;

public class Bille implements Serializable {
	private String couleur;
	
	public Bille(String couleur) {
		this.couleur=couleur;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	@Override
	public String toString() {
		return  couleur ;
	}
	
	
}
