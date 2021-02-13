package systeme;

import java.util.ArrayList;
import java.util.List;

public class test {
	
	
	//Test distributeur
	
	/*public static void main(String[] args) {
 	//test du retirage de bille
	Distributeur dis = new Distributeur();
	System.out.println(dis.lignes.get(0));
	Scanner sc = new Scanner(System.in);
	//int ligne =sc.nextInt();
	int bille = sc.nextInt();
	List<Bille> bill = dis.retirerBille(0, bille);
	System.out.println("ligne modifier = "+dis.lignes.get(0));
	System.out.println("main = "+bill);
}*/

/*public static void main(String[] args) {
 	//test de distribution des billes
	Distributeur dis = new Distributeur();
	
	List<Bille> bill = new ArrayList<Bille>();
	
	bill.add(new Bille("N"));
	bill.add(new Bille("J"));
	bill.add(new Bille("R"));
	bill.add(new Bille("B"));
	dis.distribuer(bill);
	System.out.println(dis.lignes);
}*/
	
	//test joueur
	
	/*faire test:
	 * - jeton competence (tester fin de partie aussi) fait
	 * - jeton coup de pouce fait
	 * - refresh score fait
	 * - prendre potion (tester fin de partie aussi) fait
	 * - placer bille dans potions ~~
	 * - placer bille dans reserve fait
	 * - faire test des conditions
	 */
	
	/*//jeton competence (tester fin de partie aussi)
	public static void main(String[] args) throws RemoteException {
		List<String> pj = new ArrayList<String>();
		List<String> nj = new ArrayList<String>();
		List<String> pb = new ArrayList<String>();
		
		pj.add("Gaylord");
		pj.add("Amadou");
		pj.add("Adrien");
		
		nj.add("Delporte");
		nj.add("Gacko");
		nj.add("Chauvency");
		
		pb.add("Filtre de lavamancie");
		pb.add("Baume de viscosité suprême");
		
		System.out.println("commencement");
		
		WindowGame wg = new WindowGame(4,"Bryan","Moreau",pj,nj,pb);
		
		Joueur j = wg.getJoueurPropri();
		
		wg.setTasJetonCompetence(new TasJetonCompetence(2));
		
		j.recevoirPCompetence();
		
		j.recevoirPCompetence();
		
		System.out.println(j.jetonsCompetence);
	}*/
	
	/*//jeton coup de pouce
	public static void main(String[] args) throws RemoteException {
		List<String> pj = new ArrayList<String>();
		List<String> nj = new ArrayList<String>();
		List<String> pb = new ArrayList<String>();
		
		pj.add("Gaylord");
		pj.add("Amadou");
		pj.add("Adrien");
		
		nj.add("Delporte");
		nj.add("Gacko");
		nj.add("Chauvency");
		
		pb.add("Filtre de lavamancie");
		pb.add("Baume de viscosité suprême");
		
		System.out.println("commencement");
		
		WindowGame wg = new WindowGame(4,"Bryan","Moreau",pj,nj,pb);
		
		Joueur j = wg.getJoueurPropri();
		
		
		j.prendreJetonCoupDePouce();
		
		j.prendreJetonCoupDePouce();
		
		System.out.println(j.jetonsCoupDePouce);
	}*/
	
	/*//calcul du score
	public static void main(String[] args) throws RemoteException {
		List<String> pj = new ArrayList<String>();
		List<String> nj = new ArrayList<String>();
		List<String> pb = new ArrayList<String>();
		
		pj.add("Gaylord");
		pj.add("Amadou");
		pj.add("Adrien");
		
		nj.add("Delporte");
		nj.add("Gacko");
		nj.add("Chauvency");
		
		pb.add("Filtre de lavamancie");
		pb.add("Baume de viscosité suprême");
		
		System.out.println("commencement");
		
		WindowGame wg = new WindowGame(4,"Bryan","Moreau",pj,nj,pb);
		
		Joueur j = wg.getJoueurPropri();
		
		//à zero
		System.out.println( "score = "+ j.score);
		
		j.recevoirPCompetence();
		
		j.PrendrePotion(0);
		
		j.paillasse.getPotions().get(0).nextEtat();
		
		j.potionTerminer.getPotion().add(j.paillasse.getPotions().remove(0));
		
		System.out.println(j.getPotionTermine().get(0));
		
		j.prendreJetonCoupDePouce();
		
		j.refreshScore();
		
		System.out.println("score = "+ j.score);
	}*/
	
	/*//prendre potion (tester fin de partie aussi)
	  public static void main(String[] args) throws RemoteException {
		List<String> pj = new ArrayList<String>();
		List<String> nj = new ArrayList<String>();
		List<String> pb = new ArrayList<String>();
		
		pj.add("Gaylord");
		pj.add("Amadou");
		pj.add("Adrien");
		
		nj.add("Delporte");
		nj.add("Gacko");
		nj.add("Chauvency");
		
		pb.add("Filtre de lavamancie");
		pb.add("Baume de viscosité suprême");
		
		System.out.println("commencement");
		
		WindowGame wg = new WindowGame(4,"Bryan","Moreau",pj,nj,pb);
		
		Joueur j = wg.getJoueurPropri();
		
		j.PrendrePotion(0);
		j.PrendrePotion(1);
		System.out.println("Potions : "+j.getPotionPaillasse());
		j.PrendrePotion(2);
		System.out.println("Potions : "+j.getPotionPaillasse());
		
		//vidage des pioches pour le test de fin de partie
		for(int i=1;i<wg.getPioche().size();i++) {
			wg.getPioche().get(i).getPotion().clear();
		}
		for(int ji=1;ji<wg.getPioche().get(0).getPotion().size();ji++) {
			wg.getPioche().get(0).getPotion().remove(ji);
		}
		//enleve une des potion qu'il a
		j.getPotionPaillasse().remove(0);
		//prend la derniere potion
		j.PrendrePotion(0);
		
	}
	
	//placement potion
	  public static void main(String[] args) throws RemoteException {
		List<String> pj = new ArrayList<String>();
		List<String> nj = new ArrayList<String>();
		List<String> pb = new ArrayList<String>();
		
		pj.add("Gaylord");
		pj.add("Amadou");
		pj.add("Adrien");
		
		nj.add("Delporte");
		nj.add("Gacko");
		nj.add("Chauvency");
		
		pb.add("Filtre de lavamancie");
		pb.add("Baume de viscosité suprême");
		
		System.out.println("commencement");
		
		WindowGame wg = new WindowGame(4,"Bryan","Moreau",pj,nj,pb);
		
		Joueur j = wg.getJoueurPropri();
		
		j.PrendrePotion(0);
		System.out.println(j.getPotionPaillasse().get(0));
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("combien de noir :");
		int noir = sc.nextInt();
		System.out.println("combien de rouge :");
		int rouge = sc.nextInt();
		System.out.println("combien de bleu :");
		int bleu = sc.nextInt();
		System.out.println("combien de jaune :");
		int jaune = sc.nextInt();
		
		//placement de toute les billes
		for(int i=0;i<noir;i++) {
			j.placerBille(new Bille("Noir"), 0);
		}
		for(int i=0;i<bleu;i++) {
			j.placerBille(new Bille("Bleue"), 0);
		}
		for(int i=0;i<jaune;i++) {
			j.placerBille(new Bille("Jaune"), 0);
		}
		for(int i=0;i<rouge;i++) {
			j.placerBille(new Bille("Rouge"), 0);
		}
		System.out.println("potion paillasse : "+j.getPotionPaillasse());
		System.out.println("potion terminée : "+j.getPotionTermine());
		
	}
	
	
	//placer bille dans reserve
	 public static void main(String[] args) throws RemoteException {
	
		List<String> pj = new ArrayList<String>();
		List<String> nj = new ArrayList<String>();
		List<String> pb = new ArrayList<String>();
		
		pj.add("Gaylord");
		pj.add("Amadou");
		pj.add("Adrien");
		
		nj.add("Delporte");
		nj.add("Gacko");
		nj.add("Chauvency");
		
		pb.add("Filtre de lavamancie");
		pb.add("Baume de viscosité suprême");
		
		System.out.println("commencement");
		
		WindowGame wg = new WindowGame(4,"Bryan","Moreau",pj,nj,pb);
		
		Joueur j = wg.getJoueurPropri();
		
		j.placerBille(new Bille("Noir"));
		j.placerBille(new Bille("Jaune"));
		j.placerBille(new Bille("Rouge"));
		j.placerBille(new Bille("Bleue"));
		
		System.out.println(j.reserve.getBilles());
		
	}*/
	
	/*//teste des conditions
	public static void main(String[] args) throws RemoteException {
		
		List<String> pj = new ArrayList<String>();
		List<String> nj = new ArrayList<String>();
		List<String> pb = new ArrayList<String>();
		
		pj.add("Gaylord");
		pj.add("Amadou");
		pj.add("Adrien");
		
		nj.add("Delporte");
		nj.add("Gacko");
		nj.add("Chauvency");
		
		pb.add("Filtre de lavamancie");
		pb.add("Baume de viscosité suprême");
		
		System.out.println("commencement");
		
		WindowGame wg = new WindowGame(4,"Bryan","Moreau",pj,nj,pb);
		
		Joueur j = wg.getJoueurPropri();
		
		j.recevoirPCompetence();
		//score à 4
		
		j.getPotionTermine().add(new Potion("Potion test",2,0,0,0,0));
		j.getPotionTermine().add(new Potion("Potion test2",2,0,0,0,0));
		j.getPotionTermine().add(new Potion("Potion test3",2,0,0,0,0));
		
		j.getPotionTermine().add(new Potion("Potion test4",3,0,0,0,0));
		//j.getPotionTermine().add(new Potion("Potion test4",3,0,0,0,0));
		//j.getPotionTermine().add(new Potion("Potion test4",3,0,0,0,0));
		j.getPotionTermine().add(new Potion("Potion test5",4,0,0,0,0));
		j.getPotionTermine().add(new Potion("Potion test6",5,0,0,0,0));
		j.getPotionTermine().add(new Potion("Potion test7",6,0,0,0,0));
		
		/*j.getPotionTermine().add(new Potion("Potion test4",7,0,0,0,0));
		j.getPotionTermine().add(new Potion("Potion test4",8,0,0,0,0));
		j.getPotionTermine().add(new Potion("Potion test4",9,0,0,0,0));
		j.getPotionTermine().add(new Potion("Potion test4",10,0,0,0,0));
		j.getPotionTermine().add(new Potion("Potion test4",11,0,0,0,0));
		
		j.verifCondition();
		
		j.refreshScore();
		System.out.println(j.score);
		
	}*/
	
	
	//windowgame
	
	/*
	public static void main(String[] args) throws Exception {
		//test pour l'effet de potion et la pioche
		List<String> pj = new ArrayList<String>();
		List<String> nj = new ArrayList<String>();
		List<String> pb = new ArrayList<String>();
		
		pj.add("Gaylord");
		pj.add("Amadou");
		pj.add("Adrien");
		
		nj.add("Delporte");
		nj.add("Gacko");
		nj.add("Chauvency");
		
		pb.add("Filtre de lavamancie");
		pb.add("Baume de viscosité suprême");
		
		System.out.println("commencement");
		
		WindowGame wg = new WindowGame(4,"Bryan","Moreau",pj,nj,pb);
		
		//test pioche
		/*for(int i=0;i<wg.pioche.size();i++) {
			System.out.println(wg.pioche.get(i));
		}
		
		System.out.println("Fini");
		
		Potion p = new Potion("Potion d'attraction magnétique", 7, 0, 0, 0, 0);
		//Potion p1 = new Potion("Baume de viscosité suprême", 7, 0, 0, 0, 0);
		p.nextEtat();
		p.nextEtat();
		//p1.nextEtat();
		//p1.nextEtat();
		//p1.nextEtat();
		wg.getAutreJoueur().get(0).getPotionTermine().add(p);
		//wg.getAutreJoueur().get(0).getPotionTermine().add(p1);
		wg.getAutreJoueur().get(0).utiliserPotion(p);
		System.out.println(wg.getAutreJoueur().get(0).getMain());
		
		
		test potion de joie prismatique
		
		/*Potion p = new Potion("Potion de joie prismatique", 7, 0, 0, 0, 0);
		Potion p1 = new Potion("Baume de viscosité suprême", 7, 1, 1, 1, 0);
		p.nextEtat();
		p.nextEtat();
		p1.nextEtat();
		//p1.nextEtat();
		//p1.nextEtat();
		wg.getAutreJoueur().get(0).getPotionTermine().add(p);
		List<Bille> lb = new ArrayList<Bille>();
		lb.add(new Bille("Noir"));
		lb.add(new Bille("Noir"));
		lb.add(new Bille("Noir"));
		wg.getAutreJoueur().get(0).getReserve().setBilles(lb);
		System.out.println(wg.getAutreJoueur().get(0).getReserve().getBilles().toString());
		wg.getAutreJoueur().get(0).getPotionPaillasse().add(p1);
		
		wg.getAutreJoueur().get(0).utiliserPotion(p);
		System.out.println(wg.getAutreJoueur().get(0).getMain());
		
		
		test potion iltre d'amour aveugle
		
		
		/*
		Potion p = new Potion("Elixir d'amour aveugle", 7, 0, 0, 0, 0);
		p.nextEtat();
		p.nextEtat();
		wg.getAutreJoueur().get(0).getPotionTermine().add(p);
		List<Bille> lb = new ArrayList<Bille>();
		lb.add(new Bille("Noir"));
		lb.add(new Bille("Noir"));
		lb.add(new Bille("Bleu"));
		List<Bille> lb1 = new ArrayList<Bille>();
		lb1.add(new Bille("Rouge"));
		lb1.add(new Bille("Noir"));
		lb1.add(new Bille("Noir"));
		wg.getAutreJoueur().get(1).getReserve().setBilles(lb);
		wg.getAutreJoueur().get(2).getReserve().setBilles(lb1);
		System.out.println(wg.getAutreJoueur().get(1).getReserve().getBilles().toString());
		System.out.println(wg.getAutreJoueur().get(2).getReserve().getBilles().toString());
		wg.getAutreJoueur().get(0).utiliserPotion(p);
		System.out.println(wg.getAutreJoueur().get(0).getMain());
		
	}
	*/

}
