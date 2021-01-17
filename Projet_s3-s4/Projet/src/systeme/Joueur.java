package systeme;

import java.util.ArrayList;
import java.util.List;

public class Joueur {
	private String nom;
	private String prenom;
	private int score;
	private TasJeton jetonsCoupDePouce;
	private TasJeton jetonsCompetence;
	private TasPotion potionTerminer;
	private Paillasse paillasse;
	private Reserve reserve;
	private List<Bille> main;
	private WindowGame window;
	
	public Joueur(String nom, String prenom, WindowGame window) {
		this.nom = nom;
		this.prenom = prenom;
		this.score = 0;
		this.jetonsCoupDePouce = new TasJetonCoupDePouce(0);
		this.jetonsCompetence = new TasJetonCompetence(0);
		this.potionTerminer = new TasPotion();
		this.paillasse = new Paillasse(this);
		this.reserve=new Reserve(this);
		this.main = new ArrayList<Bille>();
		this.window = window;
	}
	
	public void utiliserPotion(Potion p) {
		if(this.potionTerminer.getPotion().contains(p) && p.isFinish()) {
			p.utiliserEffet();
		}
	}
	public void recevoirPCompetence() {
		if(!this.window.getTasJetonCompetence().isEmpty()) {
			jetonsCompetence.addJeton(this.window.getTasJetonCompetence().prendreJeton());
			if(this.window.getTasJetonCompetence().isEmpty()) {
				this.window.FinirPartie();
			}
		}else {
			this.window.FinirPartie();
		}
	}
	public void placerBille(Bille b,int numPotion) {
		// à faire ? peut etre faire par rapport a la main mais ca surement dans la vue qu'on fera ca
		Potion p = this.getPotionPaillasse().get(numPotion);
		if(!p.isFinish()) {
			if(b.getCouleur().equals("Noir")) {
				if(p.getTrouNoir()!=0) {
					p.placerBille(b);
				}
			}else if(b.getCouleur().equals("Jaune")){
				if(p.getTrouJaune()!=0) {
					p.placerBille(b);
				}
			}else if(b.getCouleur().equals("Rouge")) {
				if(p.getTrouRouge()!=0) {
					p.placerBille(b);
				}
			}else if(b.getCouleur().equals("Bleue")) {
				if(p.getTrouBleu()!=0) {
					p.placerBille(b);
				}
			}
			//le met en terminer s'il n'y a plus de trou vide
			if(p.getTrouNoir()==0 && p.getTrouBleu()==0 && p.getTrouJaune()==0 && p.getTrouRouge()==0){
				if(p.getEtat().equals("piochée")) {
					p.nextEtat();
					
					//surement devoir l'enlever quand on fera la vue (peut etre pas)
					this.potionTerminer.getPotion().add(p);
					this.paillasse.getPotions().remove(p);
					List<Bille> bille = p.getBilles();
					
					//enlever les billes de la potion
					p.getBilles().removeAll(p.getBilles());
					
					//mettre les billes dans le distributeur
					this.window.distribuer(bille);
					
				}
			}
		}
		
	}
	public void placerBille(Bille b) {
		if(this.reserve.getBilles().size()<3) {
			this.reserve.getBilles().add(b);
		}else {
			//faire quelque chose si la reserve est pleine ?
		}
	}
	public void prendreJetonCoupDePouce() {
		jetonsCoupDePouce.addJeton(window.getTasJetonCoupDePouce().prendreJeton());
	}
	public List<Potion> getPotionTermine() {
		return this.potionTerminer.getPotion();
	}
	public List<Potion> getPotionPaillasse() {
		return this.paillasse.getPotions();
	}
	public void PrendrePotion(int numPioche) {
		if(this.paillasse.getPotions().size()<2) {
			if(!this.window.getPioche().get(numPioche).isEmpty()) {
				this.paillasse.getPotions().add(this.window.getPioche().get(numPioche).retirerPotion());
				this.window.piocheVide();
			}else {
				//lui dire qu'il doit choisir autre chose ?
			}
		}
	}
	public void setScore(int score) {
		this.score=score;
	}
	public void refreshScore() {
		int sco = 0;
		//score pour les jetons competence
		sco = sco + 4*this.jetonsCompetence.getNbElement();
		//score pour les jetons coup de pouce
		sco = sco + (-2)*this.jetonsCoupDePouce.getNbElement();
		//score pour les potions
		for(int i=0;i<this.potionTerminer.getNbElement();i++) {
			sco = sco + this.potionTerminer.getPotion().get(i).getPuissance();
		}
		this.score=sco;
	}
	
}
