package systeme;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Distributeur {
	private List<Ligne> lignes;
	
	public Distributeur() {
		lignes=new ArrayList<Ligne>();
		Integer nbNoir=20;
		Integer nbBleue=20;
		Integer nbRouge=20;
		Integer nbJaune=20;
		
		for(int i=0;i<5;i++) {
			Ligne l = new Ligne(nbNoir,nbBleue,nbRouge,nbJaune);
			lignes.add(l);
			
			for(int j=0;j<l.getBilles().size();j++) {
				if(l.getBilles().get(j).getCouleur().equals("Noir")) {
					nbNoir-=1;
					
				}else if(l.getBilles().get(j).getCouleur().equals("Bleue")) {
					nbBleue-=1;
					
				}else if(l.getBilles().get(j).getCouleur().equals("Rouge")) {
					nbRouge-=1;
					
				}else if(l.getBilles().get(j).getCouleur().equals("Jaune")) {
					nbJaune-=1;
					
				}
			}
		}
	}
	
	public List<Bille> retirerBille(int ligne,int bille) {
		List<Bille> listbille = new ArrayList<Bille>();
		if(!this.lignes.get(ligne).getBilles().isEmpty()) {
			
			Bille b = this.lignes.get(ligne).retirerBille(bille);
			if(bille-1>=0) {
				listbille.addAll(this.retirerBillePercut(ligne,bille-1));
			}
			listbille.add(b);
			
		}else {
			System.out.println("il n'y a pas de bille dans la ligne");
		}
		return listbille;
	}
	
	public List<Bille> retirerBillePercut(int ligne,int bille) {
		List<Bille> listBille = new ArrayList<Bille>();
		//listBille.add(b1);
		//renvoie la liste des billes récupéré pour le mettre dans la main du joueur
		if(bille+1<this.lignes.get(ligne).getBilles().size() && this.lignes.get(ligne).getBilles().get(bille).getCouleur().equals(this.lignes.get(ligne).getBilles().get(bille+1).getCouleur())) {
			
			String coul = this.lignes.get(ligne).getBilles().get(bille).getCouleur();
			int i=1;
			while( bille-i>=0 && this.lignes.get(ligne).getBilles().get(bille-i).getCouleur().equals(coul)) {
				listBille.add(this.lignes.get(ligne).getBilles().get(bille-i));
				i=i+1;
			}
			int j=2;
			while(bille+j<this.lignes.get(ligne).getBilles().size() && this.lignes.get(ligne).getBilles().get(bille+j).getCouleur().equals(coul) ) {
				listBille.add(this.lignes.get(ligne).getBilles().get(bille+j));
				j=j+1;
			}
			listBille.add(this.lignes.get(ligne).getBilles().get(bille+1));
			listBille.add(this.lignes.get(ligne).getBilles().get(bille));
			
			
			
			//System.out.println(listBille);
			//System.out.println(this.lignes.get(ligne));
			this.lignes.get(ligne).getBilles().removeAll(listBille);
			
			if(bille-i>=0) {
				listBille.addAll(this.retirerBillePercut(ligne, bille-i));
			}
			
			//this.lignes.get(ligne).getBilles().remove(b1);
	
			return listBille;
		}else {
			return listBille;
		}
		
	}

	public void distribuer(List<Bille> billes) {
		Random r = new Random();
		for(int i=0;i<billes.size();i++) {
			int ligne = r.nextInt(5);
			this.lignes.get(ligne).ajouterBille(billes.get(i));
		}
		
	}
	
	public static void main(String[] args) {
	 	//test du retirage de bille
		Distributeur dis = new Distributeur();
		System.out.println(dis.lignes.get(0));
		Scanner sc = new Scanner(System.in);
		//int ligne =sc.nextInt();
		int bille = sc.nextInt();
		List<Bille> bill = dis.retirerBille(0, bille);
		System.out.println("ligne modifier = "+dis.lignes.get(0));
		System.out.println("main = "+bill);
	}
	
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

}
