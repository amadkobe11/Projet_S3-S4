package systeme;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WindowGame {
	private Distributeur distributeur;
	private Joueur joueurPropri;
	private List<Joueur> autreJoueur;
	private TasJeton tasJetonCoupDePouce;
	private TasJeton tasJetonCompetence;
	private List<TasPotion> pioche;
	
	public WindowGame(int nbjoueur,String prenom,String nom,List<String> prenomJ,List<String> nomJ,List<String> potionBani) {
		this.distributeur=new Distributeur();
		this.tasJetonCoupDePouce=new TasJetonCoupDePouce();
		
		//création du joueur qui agira sur le système de cette machine
		this.joueurPropri=new Joueur(prenom,nom,this);
		
		//création des autres joueur pour le score
		this.autreJoueur= new ArrayList<Joueur>();
		for(int i=0;i<prenomJ.size();i++) {
			this.autreJoueur.add(new Joueur(prenomJ.get(i),nomJ.get(i),this));
		}
		//création du tas de jeton compétence selon le nombre de joueur
		if(nbjoueur==2) {
			this.tasJetonCompetence=new TasJetonCompetence(4);
		}else if(nbjoueur==3) {
			this.tasJetonCompetence=new TasJetonCompetence(5);
		}else {
			this.tasJetonCompetence=new TasJetonCompetence(6);
		}
		
		//création de la pioche
		this.pioche=new ArrayList<TasPotion>();
		this.creePioche(potionBani);
	}

	private void creePioche(List<String> potionBani) {
		//8 type de potion
		//8 potion par type
		//5 tas
		//13 par tas + 12 dans un
		
		//création de toute les variables pour le nombre de potion de chaque type
		int nbSagesse=8;
		int nbElixirAmour=8;
		int nbAtractionMagnetique=8;
		int nbJoiePrismatique=8;
		int nbAbyssale=8;
		int nbSableTemps=8;
		int nbBaumeViscosité=8;
		int nbLavamancie=8;
		
		//mise a zero des potion bani
		
		if(potionBani.contains("Potion de sagesse")) {
			nbSagesse=0;
		}
		if(potionBani.contains("Elixir d'amour aveugle")) {
			nbElixirAmour=0;
		}
		if(potionBani.contains("Potion d'attraction magnétique")) {
			nbAtractionMagnetique=0;
		}
		if(potionBani.contains("Potion de joie prismatique")) {
			nbJoiePrismatique=0;
		}
		if(potionBani.contains("Potion abyssale")) {
			nbAbyssale=0;
		}
		if(potionBani.contains("Sables du temps")) {
			nbSableTemps=0;
		}
		if(potionBani.contains("Baume de viscosité suprême")) {
			nbBaumeViscosité=0;
		}
		if(potionBani.contains("Filtre de lavamancie")) {
			nbLavamancie=0;
		}
		
		//création des tas de potions
		for(int i=0;i<5;i++) {
			TasPotion tp = new TasPotion();
			if(i<4) {
				for(int j=0;j<13;j++) {
					//crée les potions
					Random rtype = new Random();
					Random rpuissance = new Random();
					
					int type = rtype.nextInt(8);
					if(type == 0) {
						if(nbSagesse!=0) {
							//il faut regarder combien il y de potion de differente puissance par type + les trou de chaque couleur de chaque potion
							//tp.getPotion().add(new Potion());
						}else {
							j=j-1;
						}
					}else if(type == 1){
						if(nbElixirAmour!=0) {
							//il faut regarder combien il y de potion de differente puissance par type + les trou de chaque couleur de chaque potion
							//tp.getPotion().add(new Potion());
						}else {
							j=j-1;
						}
					}else if(type == 2) {
						if(nbAtractionMagnetique!=0) {
							//il faut regarder combien il y de potion de differente puissance par type + les trou de chaque couleur de chaque potion
							//tp.getPotion().add(new Potion());
						}else {
							j=j-1;
						}
					}else if(type == 3) {
						if(nbJoiePrismatique!=0) {
							//il faut regarder combien il y de potion de differente puissance par type + les trou de chaque couleur de chaque potion
							//tp.getPotion().add(new Potion());
						}else {
							j=j-1;
						}
					}else if(type == 4) {
						if(nbAbyssale!=0) {
							//il faut regarder combien il y de potion de differente puissance par type + les trou de chaque couleur de chaque potion
							//tp.getPotion().add(new Potion());
						}else {
							j=j-1;
						}
					}else if(type == 5) {
						if(nbSableTemps!=0) {
							//il faut regarder combien il y de potion de differente puissance par type + les trou de chaque couleur de chaque potion
							//tp.getPotion().add(new Potion());
						}else {
							j=j-1;
						}
					}else if(type == 6) {
						if(nbBaumeViscosité!=0) {
							//il faut regarder combien il y de potion de differente puissance par type + les trou de chaque couleur de chaque potion
							//tp.getPotion().add(new Potion());
						}else {
							j=j-1;
						}
					}else if(type == 7) {
						if(nbLavamancie!=0) {
							//il faut regarder combien il y de potion de differente puissance par type + les trou de chaque couleur de chaque potion
							//tp.getPotion().add(new Potion());
						}else {
							j=j-1;
						}
					}
				}
				this.pioche.add(tp);
			}else {
				for(int j=0;j<12;j++) {
					//crée les potions
					Random rtype = new Random();
					Random rpuissance = new Random();
					
					int type = rtype.nextInt(8);
					if(type == 0) {
						if(nbSagesse!=0) {
							//il faut regarder combien il y de potion de differente puissance par type + les trou de chaque couleur de chaque potion
							//tp.getPotion().add(new Potion());
						}else {
							j=j-1;
						}
					}else if(type == 1){
						if(nbElixirAmour!=0) {
							//il faut regarder combien il y de potion de differente puissance par type + les trou de chaque couleur de chaque potion
							//tp.getPotion().add(new Potion());
						}else {
							j=j-1;
						}
					}else if(type == 2) {
						if(nbAtractionMagnetique!=0) {
							//il faut regarder combien il y de potion de differente puissance par type + les trou de chaque couleur de chaque potion
							//tp.getPotion().add(new Potion());
						}else {
							j=j-1;
						}
					}else if(type == 3) {
						if(nbJoiePrismatique!=0) {
							//il faut regarder combien il y de potion de differente puissance par type + les trou de chaque couleur de chaque potion
							//tp.getPotion().add(new Potion());
						}else {
							j=j-1;
						}
					}else if(type == 4) {
						if(nbAbyssale!=0) {
							//il faut regarder combien il y de potion de differente puissance par type + les trou de chaque couleur de chaque potion
							//tp.getPotion().add(new Potion());
						}else {
							j=j-1;
						}
					}else if(type == 5) {
						if(nbSableTemps!=0) {
							//il faut regarder combien il y de potion de differente puissance par type + les trou de chaque couleur de chaque potion
							//tp.getPotion().add(new Potion());
						}else {
							j=j-1;
						}
					}else if(type == 6) {
						if(nbBaumeViscosité!=0) {
							//il faut regarder combien il y de potion de differente puissance par type + les trou de chaque couleur de chaque potion
							//tp.getPotion().add(new Potion());
						}else {
							j=j-1;
						}
					}else if(type == 7) {
						if(nbLavamancie!=0) {
							//il faut regarder combien il y de potion de differente puissance par type + les trou de chaque couleur de chaque potion
							//tp.getPotion().add(new Potion());
						}else {
							j=j-1;
						}
					}
					
				}
				this.pioche.add(tp);
			}
		}
	}
	
	public void AfficherPartie() {
		
	}
	
	public void CréerPartie() {
		
	}
	public void RejoindrePartie() {
		
	}
	//normalement inutile//
	public void VerifPotion() {
		
	}
	///////////////////////////
	public void AfficherPotion() {
		
	}
	public void FinirPartie() {
		
	}
	public void afficherBilles() {
		
	}
	public void selectionneBille() {
		
	}
	
	//distribue les billes dans le distributeur
	public void distribuer(List<Bille> billes) {
		this.distributeur.distribuer(billes);
	}
	
	//geteur
	public Distributeur getDistributeur() {
		return distributeur;
	}

	public Joueur getJoueurPropri() {
		return joueurPropri;
	}

	public List<Joueur> getAutreJoueur() {
		return autreJoueur;
	}

	public TasJeton getTasJetonCoupDePouce() {
		return tasJetonCoupDePouce;
	}

	public TasJeton getTasJetonCompetence() {
		return tasJetonCompetence;
	}

	public List<TasPotion> getPioche() {
		return pioche;
	}

	public void piocheVide() {
		boolean vide = true;
		for(int i =0 ; i<this.pioche.size();i++) {
			if(!this.pioche.get(i).isEmpty()) {
				vide=false;
			}
		}
		if(vide) {
			this.FinirPartie();
		}
		
	}
	
	
}
