package systeme;

import java.util.ArrayList;
import java.util.List;

public class Paillasse {
	private Joueur joueur;
	private List<Potion> potions;
	
	public Paillasse(Joueur j) {
		this.joueur=j;
		this.potions=new ArrayList<Potion>();
	}
	public void placerPotion(Potion p) {
		if(potions.size()<2) {
			potions.add(p);
		}else {
			System.out.println("il n'y a plus de place dans la paillasse");
		}	
	}
	public Joueur getJoueur() {
		return joueur;
	}
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}
	public List<Potion> getPotions() {
		return potions;
	}
	public void setPotions(List<Potion> potions) {
		this.potions = potions;
	}
	
}
