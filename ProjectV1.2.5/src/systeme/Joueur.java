package systeme;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import interfaces.Joueurinterface;

public class Joueur implements Joueurinterface {
	private String nom;
	private String prenom;
	private int score;
	private boolean joyeux; // Vrai si l'effet d'une potion joie prismatique utilisé
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
		this.joyeux = false;
		this.jetonsCoupDePouce = new TasJetonCoupDePouce(0);
		this.jetonsCompetence = new TasJetonCompetence(0);
		this.potionTerminer = new TasPotion();
		this.paillasse = new Paillasse(this);
		this.reserve=new Reserve(this);
		this.main = new ArrayList<Bille>();
		this.window = window;
	}
	
	
	public void utiliserPotion(Potion p) throws RemoteException {
		if (p.getType() == "Potion de sagesse") {
			
			//A modifier dans la vue
			
			//permet de voir les billes de chaque glissière
			this.window.getDistributeur().afficheLigne();
			
			//permet de pouvoir demander la bille a retirer
			Scanner sc = new Scanner(System.in);
			System.out.println("Veuillez selectionner la ligne souhaitée : ");
			int i = sc.nextInt();
			System.out.println("Veuillez selectionner le numéro de la bille souhaitée : (sa commence a 0) ");
			int j = sc.nextInt();
			
			//retire la bille demandé
			this.main.addAll(this.window.getDistributeur().retirerBilleEffet(i,j));
			
			//passe la potion en utilisé
			p.nextEtat();
		}
		else if (p.getType() == "Elixir d'amour aveugle") {
			//A modifier dans la vue
			
			//affiche les joueurs et leurs reserve ainsi qu'un numero pour choisir celui souhaiter
			List<Integer> lj = new ArrayList<Integer>();
			List<Integer> lja = new ArrayList<Integer>();
			int nb = 0;
			for (int j = 0; j < 3; j++) {
				if (!this.window.getAutreJoueur().get(j).getNom().equals(this.nom)) {
					System.out.println("Nom : " + this.window.getAutreJoueur().get(j).getNom() + " numéro " + nb + " ");
					System.out.println(this.window.getAutreJoueur().get(j).getReserve().getBilles() );
					lj.add(nb);
					lja.add(j);
					nb++;
				}
			}
			if (!this.window.getJoueurPropri().getNom().equals(this.nom)) {
				System.out.println("Nom : " + this.window.getJoueurPropri().getNom() + " numéro " + nb + " ");
				System.out.println(this.window.getJoueurPropri().getReserve().getBilles() );
				lj.add(nb);
				nb++;
			}

			
			//permet de selectionner en entrant le numero du joueur
			Scanner sc = new Scanner(System.in);
			System.out.println("Veuillez selectionner le numéro du joueur a voler sa reserve : ");
			int k = sc.nextInt();
			while (!lj.contains(k)) {
				System.out.println("Erreur, veuillez selectionner le numéro du joueur a voler sa reserve : ");
				k = sc.nextInt();
			}
			
			//prend tout les billes de la reserve du joueur choisi dans la main
			List<Bille> rv = new ArrayList<Bille>();
			if (!this.window.getJoueurPropri().getNom().equals(this.nom) && k == 3) {
				rv = this.window.getJoueurPropri().getReserve().getBilles();
				this.window.getJoueurPropri().getReserve().setBilles(null);
			}
			else {
				rv = this.window.getAutreJoueur().get(lja.get(k)).getReserve().getBilles();
				this.window.getAutreJoueur().get(k).getReserve().setBilles(null);
			}
			for (int i = 0; i < rv.size(); i++) {
				System.out.println(rv.get(i));
				this.main.add(rv.get(i));
				
			}
			p.nextEtat();
		}
		else if (p.getType() == "Potion d'attraction magnétique") {
			
			//A modifier dans la vue
			this.window.getDistributeur().afficheLigne();
			Scanner sc = new Scanner(System.in);
			System.out.println("Veuillez selectionner la ligne : (sa commence a 0) ");
			int i = sc.nextInt();
			System.out.println("Veuillez selectionner la bille : (sa commence a 0) ");
			int j = sc.nextInt();
			this.main.addAll(this.window.getDistributeur().retirerBilleEffet(i,j));
			
			//demander de selectionner une bille a cote de celle prise
			System.out.println("Veuillez selectionner une bille a coté de celle que vous avez pris : " + (j+1) + " ou " + (j-1)  + "");
			boolean ok = false;
			int k = 0;
			while (!ok) {
				k = sc.nextInt();
				if (k == j+1) {
					this.main.addAll(this.window.getDistributeur().retirerBilleEffet(i,k-1));
					ok = true;
				}
				else if (k == j-1) {
					this.main.addAll(this.window.getDistributeur().retirerBilleEffet(i,k));
					ok = true;
				}
				else {
					System.out.println("Erreur, veuillez selectionner une des deux billes a coté de la première selectionner : ");
				}
			}
			p.nextEtat();
		}
		else if (p.getType() == "Potion de joie prismatique") {
			
			//permet d'utiliser l'effet de la potion
			this.joyeux = true;
			
			//demandez pour toute les billes ou il veut les placer
			Scanner sc = new Scanner(System.in);
			for (int k = 0; k < this.getReserve().getBilles().size() ; k++) {
				System.out.println(this.getPotionPaillasse().toString());
				System.out.println("Veuillez selectionner la potion a completer : ");
				int i = sc.nextInt();
				this.placerBille( this.getReserve().getBilles().get(k), i);
			}
			
			//retirer l'etat pour signifier la fin de l'effet de la potion
			this.joyeux = false;
			
			//passer la potion en utilisé
			p.nextEtat();
		}
		else if (p.getType() == "Potion abyssale") {
			//a modifier dans la vue 
			
			this.window.getDistributeur().afficheLigne();
			//permet de pouvoir demander la bille a retirer
			Scanner sc = new Scanner(System.in);
			System.out.println("Veuillez selectionner la ligne souhaitée : (sa commence a 0) ");
			int i = sc.nextInt();
			
			//garder la bille en mémoire pour garder la couleur puis la retirer
			Bille b = this.window.getDistributeur().getLignes().get(i).getBilles().get(0);
			List<String> couleurs = new ArrayList<String>();
			couleurs.add(b.getCouleur());
			List<Integer> ligne = new ArrayList<Integer>();
			ligne.add(i);
			this.main.addAll(this.window.getDistributeur().retirerBilleEffet(i,0));
			
			//permet de retire des billes d'autre couleurs sur les autres ligne si possible
			boolean ok = false;
			while (!ok) {
				//verifier que la couleur de chaque debut de ligne n'est pas deja dans la liste des couleurs prise
				if ((couleurs.contains(this.window.getDistributeur().getLignes().get(0).getBilles().get(0).getCouleur())) && (couleurs.contains(this.window.getDistributeur().getLignes().get(1).getBilles().get(0).getCouleur())) && (couleurs.contains(this.window.getDistributeur().getLignes().get(2).getBilles().get(0).getCouleur())) && (couleurs.contains(this.window.getDistributeur().getLignes().get(3).getBilles().get(0).getCouleur())) && (couleurs.contains(this.window.getDistributeur().getLignes().get(4).getBilles().get(0).getCouleur()))) {
					//demande la ligne souhaité
					System.out.println("Veuillez selectionner la ligne souhaitée avec comme premiere bille une qui est d'une autre couleur que vous avez deja pris : (sa commence a 0) ");
					i = sc.nextInt();
					
					//verifie que la couleur de la ligne demandé n'est pas deja prise
					if((!couleurs.contains(this.window.getDistributeur().getLignes().get(i).getBilles().get(0).getCouleur())) || (!ligne.contains(i))) {
						ligne.add(i);
						couleurs.add(this.window.getDistributeur().getLignes().get(i).getBilles().get(0).getCouleur());
						this.main.addAll(this.window.getDistributeur().retirerBilleEffet(i,0));
					}
					//si elle deja dedans envoie un message pour le signaler
					else {
						System.out.println("Erreur veuillez réessayer avec une ligne ou vous n'avez pas deja pris et avec une bille d'une couleur differentes des billes deja prise ");
					}	 
				}
				// si aucune ligne n'a une bille de couleur qui n'est pas présente dans la liste on termien la boucle
				else {
					ok = true;
				}
				
			}
			//passe la potion en utilisé
			p.nextEtat();
		}
		else if (p.getType() == "Sables du temps") {
			
			//A modifier dans la vue
			
			//afficher les potions terminé pouvant être choisi
			for (int i = 0; i < this.getPotionTermine().size(); i++) {
				if ((this.getPotionTermine().get(i) != p)) {
					if (this.getPotionTermine().get(i).getEtat() == "utilisé")
						System.out.println(this.getPotionTermine().get(i).getType() + " "+ i );
				}
			}
			
			//selesctionner la potion souhaitée
			Scanner sc = new Scanner(System.in);
			System.out.println("Veuillez selectionner la potion souhaitée : (sa commence a 0) ");
			int i = sc.nextInt();
			Potion pc =  this.getPotionTermine().get(i);
			
			//reppaser la potion en etat terminé
			pc.prevEtat();
			
			//passer la potion sable du temps en terminé
			p.nextEtat();
			
			//réutilliser la fonction avec la potion choisi
			this.utiliserPotion(pc);
			
		}
		else if (p.getType() == "Baume de viscosité suprême") {
			//A modifier dans la vue
			
			//permet de voir les billes de chaque glissière
			this.window.getDistributeur().afficheLigne();
			
			//permet de pouvoir demander la bille a retirer
			Scanner sc = new Scanner(System.in);
			System.out.println("Veuillez selectionner la ligne souhaitée : (sa commence a 0) ");
			int i = sc.nextInt();
			System.out.println("Veuillez selectionner le numéro de la bille souhaitée : (sa commence a 0) ");
			int j = sc.nextInt();
			
			//garder la bille en mémoire
			Bille b = this.window.getDistributeur().getLignes().get(i).getBilles().get(j);
			
			//creation d'une liste pour garder la numero de la bille
			List<Integer> lby = new ArrayList<Integer>();
			lby.add(j);
			int taille = this.window.getDistributeur().getLignes().get(i).getBilles().size();
			
			//chercher les billes apres celle prise de même couleurs jusqu'a qu'elle ne soit pas de la même couleur
			for (int k = j+1 ; k < taille ; k++) {
				if(this.window.getDistributeur().getLignes().get(i).getBilles().get(k).getCouleur() == b.getCouleur()) {
					lby.add(k);
				}
				else {
					k = taille;
				}
			}
			
			//chercher les billes avant celle prise de même couleurs jusqu'a qu'elle ne soit pas de la même couleur
			for (int l = 0 ; l < j ; l++) {
				if(this.window.getDistributeur().getLignes().get(i).getBilles().get(j-l-1).getCouleur() == b.getCouleur()) {
					lby.add(j-l-1);
				}
				else {
					l = j;
				}
			}
			
			//trier la liste pour pouvoir les retirer les une apres les autre
			Collections.sort(lby);
			
			//retirer une a une avec la position de la premiere car une fois retiré les bills redecende 
			for (int m = 0 ; m < lby.size() ; m++) {
				this.main.addAll(this.window.getDistributeur().retirerBilleEffet(i,lby.get(0)));
			}
			//passe la potion en utilisé
			p.nextEtat();
		}
		else if (p.getType() == "Filtre de lavamancie") {
			
			//permet de voir les billes de chaque glissière
			this.window.getDistributeur().afficheLigne();
			
			
			//demander la bille souhaité
			Scanner sc = new Scanner(System.in);
			System.out.println("Veuillez selectionner la ligne souhaitée : (sa commence a 0) ");
			int i = sc.nextInt();
			System.out.println("Veuillez selectionner le numéro de la bille souhaitée : (sa commence a 0) ");
			int j = sc.nextInt();
			
			//pour conserver la couleur choisi
			String couleur = this.window.getDistributeur().getLignes().get(i).getBilles().get(j).getCouleur();
			
			// pour garder la position de la bille et des prochaines
			List<Integer> ly = new ArrayList<Integer>();
			ly.add(j);
			boolean ok = false;
			int c = 1;
			int nc = 0;
			String mot;
			// tourne tant qu'il reste des bille de même couleur sur la ligne et que le joueur veut selectionner des billes
			while (!ok) {
				
				//verifie si il n'a pas retirer 5 billes deja
				if (c != 5) {
					
					//permet de verifier la presence de bille de même couleur
					for (int k = 0; k < this.window.getDistributeur().getLignes().get(i).getBilles().size() ; k++) {
						if (!ly.contains(k)) {
							if (this.window.getDistributeur().getLignes().get(i).getBilles().get(k).getCouleur() == couleur) {
								nc = nc + 1;
							}
						}
					}
					
					//passe si il en reste au moins une
					if (nc - c != 0) {
						
						//demande au joueur si il veut en retirer
						System.out.println("Voulez vous retirez une autre bille ? oui/non ");
						mot = sc.next();
						System.out.println(mot);
						
						//si oui il choisi et on ajoute la position de la bille dans la liste
						if (mot.equals("oui")) {
							System.out.println("Veuillez selectionner le numéro de la bille souhaitée : (sa commence a 0) ");
							j = sc.nextInt();
							if (this.window.getDistributeur().getLignes().get(i).getBilles().get(j).getCouleur() != couleur) {
								System.out.println("Erreur, cette bille n'est pas de la bonne couleur \n");
							}
							else {
								ly.add(j);
								c = c + 1;
							}
						}
						
						//si non on met fin a la boucle
						else if (mot.equals("non")) {
							ok = true;
						}
						
						//en cas d'erreur on lui signale
						else {
							System.out.println("Erreur, veuillez bien mettre soit oui soit non comme réponse ");
						}
					}
					// si il n'u a plus de bille on termine la boucle
					else {
						ok = true;
					}
					
				}
				//si le compteur de bille que le joueur a choisi atteint le max on arrete la boucle
				else {
					ok = true;
				}
			}
			Collections.sort(ly);
			// remmettre les billes dans la reserve
			for (int l = 0; l < ly.size(); l++) {
				System.out.println(this.window.getDistributeur().getLignes().get(i).getBilles().get(ly.get(l)));
			}
			//passe la potion en utilisé
			p.nextEtat();
		}
		else {
			System.out.println("Ce type de potion n'existe pas");
		}
	}
	
	
	public void recevoirPCompetence() throws RemoteException {
		if(!this.window.getTasJetonCompetence().isEmpty()) {
			jetonsCompetence.addJeton(this.window.getTasJetonCompetence().prendreJeton());
			if(this.window.getTasJetonCompetence().isEmpty()) {
				this.window.FinirPartie();
			}
		}else {
			this.window.FinirPartie();
		}
	}
	public void placerBille(Bille b,int numPotion) throws RemoteException{
		
		Potion p = this.getPotionPaillasse().get(numPotion);
		if(!p.isFinish()) {
			if (!this.joyeux) {
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
			}
			else {
				Scanner sc = new Scanner(System.in);
				System.out.println(p.toString());
				System.out.println("Veuillez selectionner la couleur de l'emplacement a completer : ");
				String c = sc.next();
				p.placerBilleJ(b,c);
			}
			
			//le met en terminer s'il n'y a plus de trou vide
			if(p.getTrouNoir()==0 && p.getTrouBleu()==0 && p.getTrouJaune()==0 && p.getTrouRouge()==0){
				if(p.getEtat().equals("piochée")) {
					p.nextEtat();
					
					
					this.potionTerminer.getPotion().add(p);
					this.paillasse.getPotions().remove(p);
					List<Bille> bille = p.getBilles();
					
					//enlever les billes de la potion
					p.getBilles().removeAll(p.getBilles());
					
					//mettre les billes dans le distributeur
					this.window.distribuer(bille);
					
					//verifie si une des conditions est vérifié
					
					this.verifCondition();
					
					//surement devoir mettre le piochage par rapport a la vue
					
				}
			}
		}else {
			//ne devrai pas arriver
		}
		
	}

	public void verifCondition() throws RemoteException {
		Integer nbJetonCompetence=0;
		List<Potion> pot = new ArrayList<Potion>(this.getPotionTermine());
		
		//verif de chaque puissance
		while(!pot.isEmpty()) {
			Potion p1 = pot.remove(0);
			Integer nbPuissance=1;
			int i=0;
			
			while(i<pot.size() && nbPuissance!=3) {
				if(pot.get(i).getPuissance() == p1.getPuissance()) {
					nbPuissance+=1;
					pot.remove(i);
				}else {
					i++;
				}
				
			}
			if(nbPuissance.equals(3)) {
				nbJetonCompetence++;
			}
		}
		
		//verif de chaque puissance differente
		pot = new ArrayList<Potion>(this.getPotionTermine());
		while(!pot.isEmpty()) {
			Potion p1 = pot.remove(0);
			Integer nbPuissanceDiff=1;
			int i=0;
			
			while(i<pot.size() && nbPuissanceDiff!=5) {
				if(pot.get(i).getPuissance() != p1.getPuissance()) {
					nbPuissanceDiff+=1;
					pot.remove(i);
				}else {
					i++;
				}
				
			}
			if(nbPuissanceDiff.equals(5)) {
				nbJetonCompetence++;
			}
		}
		
		//calcul du nombre de nouveau jeton de competence
		nbJetonCompetence-=this.jetonsCompetence.getNbElement();
		for(int i=0;i<nbJetonCompetence;i++) {
			this.recevoirPCompetence();
		}
	}


	public void placerBille(Bille b) throws RemoteException {
		if(this.reserve.getBilles().size()<3) {
			this.reserve.getBilles().add(b);
		}else {
			//reserve pleine : plus de place dans la réserve (vue)
		}
	}
	public void prendreJetonCoupDePouce() throws RemoteException{
		if(!window.getTasJetonCoupDePouce().isEmpty()) {
			jetonsCoupDePouce.addJeton(window.getTasJetonCoupDePouce().prendreJeton());
		}else {
			System.out.println("plus de jeton coup de pouce !");
		}
	}
	//////////////////////////////
	public String getNom() throws RemoteException{
		return nom;
	}
	public Reserve getReserve() throws RemoteException{
		return reserve;
	}
	public List<Potion> getPotionTermine() throws RemoteException{
		return this.potionTerminer.getPotion();
	}
	public List<Potion> getPotionPaillasse()throws RemoteException {
		return this.paillasse.getPotions();
	}
	public List<Bille> getMain() throws RemoteException{
		return main;
	}
	///////////////////////////////////////////
	public void PrendrePotion(int numPioche)throws RemoteException {
		if(this.paillasse.getPotions().size()<2) {
			if(!this.window.getPioche().get(numPioche).isEmpty()) {
				
				this.paillasse.placerPotion(this.window.getPioche().get(numPioche).retirerPotion());
				this.paillasse.getPotions().get(this.paillasse.getPotions().size()-1).nextEtat();
				//verifie si la partie se termine
				this.window.piocheVide();
			}else {
				//lui dire qu'il doit choisir autre chose ?
			}
		}
	}
	public void setScore(int score) throws RemoteException{
		this.score=score;
	}
	public void refreshScore() throws RemoteException{
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


	public void remettreBille() throws RemoteException{
		this.window.distribuer(main);
	}
	
	public void retirerBille(int ligne,int bille) throws RemoteException{
		this.main.addAll(this.window.getDistributeur().retirerBille(ligne, bille));
	}
	
}
