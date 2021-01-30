package systeme;

import java.util.ArrayList;
import java.util.List;

public class Reserve {
	private Joueur joueur;
	private List<Bille> billes;
	
	public Reserve(Joueur joueur) {
		this.joueur = joueur;
		this.billes=new ArrayList<Bille>();
	}
	
	
	public Joueur getJoueur() {
		return joueur;
	}
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}
	public List<Bille> getBilles() {
		return billes;
	}
	public void setBilles(List<Bille> billes) {
		this.billes = billes;
	}
	
	
}
