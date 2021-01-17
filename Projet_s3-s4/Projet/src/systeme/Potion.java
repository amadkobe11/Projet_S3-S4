package systeme;

import java.util.ArrayList;
import java.util.List;

public class Potion {
	private String type;
	private int puissance;
	private String etat;
	private int trouNoir;
	private int trouRouge;
	private int trouBleu;
	private int trouJaune;
	private List<Bille> billes;
	
	public Potion(String type, int puissance, int trouNoir, int trouRouge, int trouBleu, int trouJaune) {
		this.type = type;
		this.puissance = puissance;
		this.etat = "non piochée";
		this.trouNoir = trouNoir;
		this.trouRouge = trouRouge;
		this.trouBleu = trouBleu;
		this.trouJaune = trouJaune;
		this.billes = new ArrayList<Bille>();
	}
	
	public void utiliserEffet() {
		//a faire
	}
	
	public boolean isFinish() {
		if(etat.equals("fini")) {
			return true;
		}else {
			return false;
		}
	}
	public void nextEtat() {
		if(this.etat.equals("non piochée")) {
			this.etat="piochée";
		}else if(this.etat.equals("piochée")) {
			this.etat="fini";
		}else if(this.isFinish()) {
			this.etat = "utilisé";
		}
	}
	public void placerBille(Bille b) {
		if(b.getCouleur().equals("Noir")) {
			this.trouNoir-=1;
			this.billes.add(b);
		}else if(b.getCouleur().equals("Jaune")){
			this.trouJaune-=1;
			this.billes.add(b);
		}else if(b.getCouleur().equals("Rouge")) {
			this.trouRouge-=1;
			this.billes.add(b);
		}else if(b.getCouleur().equals("Bleue")) {
			this.trouBleu-=1;
			this.billes.add(b);
		}
	}
	
	//getter
	public String getType() {
		return type;
	}

	public int getPuissance() {
		return puissance;
	}

	public String getEtat() {
		return etat;
	}

	public int getTrouNoir() {
		return trouNoir;
	}

	public int getTrouRouge() {
		return trouRouge;
	}

	public int getTrouBleu() {
		return trouBleu;
	}

	public int getTrouJaune() {
		return trouJaune;
	}

	public List<Bille> getBilles() {
		return billes;
	}
	
}
