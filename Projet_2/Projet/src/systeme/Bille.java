package systeme;

public class Bille {
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
