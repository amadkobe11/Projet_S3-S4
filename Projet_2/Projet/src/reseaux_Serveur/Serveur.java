package reseaux_Serveur;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Serveur {
	private List<GestionServeur> gs;
	
	//valeur par défaut à changer quand on fera le systeme du jeu (peut aussi être changer par les objets)
	private Integer numJoueur=0;
	private Integer score = 0;
	
	private Integer nbJetonCoupDePouce = 0;
	private Integer nbJetonCompetence = 0;
	
	private Integer nbBille1 = 0;
	private List<String> couleurL1=new ArrayList<String>();
	
	private Integer nbBille2 = 0;
	private List<String> couleurL2=new ArrayList<String>();
	
	private Integer nbBille3 = 0;
	private List<String> couleurL3=new ArrayList<String>();
	
	private Integer nbBille4 = 0;
	private List<String> couleurL4=new ArrayList<String>();
	
	private Integer nbBille5 = 0;
	private List<String> couleurL5=new ArrayList<String>();
	
	
	public Serveur() {
		this.gs = new ArrayList<GestionServeur>();
		try {
			ServerSocket s = new ServerSocket(Integer.parseInt("1290"));
			System.out.println("Serveur_ecoute");
			System.out.flush();
			//crée des gestion serveur pour chaque client
			while(true) {
				Socket soc = s.accept();
				System.out.println("socket acceptée");
				GestionServeur gs = new GestionServeur(soc,this);
				this.getGs().add(gs);
				gs.start();
			}
		}catch(Exception e) {
			
		}
	}



	public List<GestionServeur> getGs() {
		return gs;
	}


	//lancement du serveur par le main
	public static void main(String [] args) throws Exception{
		Serveur ser = new Serveur();
		
		
	}



	public void reveillerGS() {
		for(int i=0;i<gs.size();i++) {
			gs.get(i).attenteTerminer();
		}
		
	}



	public Integer getNumJoueur() {
		return numJoueur;
	}



	public void setNumJoueur(Integer numJoueur) {
		this.numJoueur = numJoueur;
	}



	public Integer getScore() {
		return score;
	}



	public void setScore(Integer score) {
		this.score = score;
	}



	public Integer getNbJetonCoupDePouce() {
		return nbJetonCoupDePouce;
	}



	public void setNbJetonCoupDePouce(Integer nbJetonCoupDePouce) {
		this.nbJetonCoupDePouce = nbJetonCoupDePouce;
	}



	public Integer getNbJetonCompetence() {
		return nbJetonCompetence;
	}



	public void setNbJetonCompetence(Integer nbJetonCompetence) {
		this.nbJetonCompetence = nbJetonCompetence;
	}



	public Integer getNbBille1() {
		return nbBille1;
	}



	public void setNbBille1(Integer nbBille1) {
		this.nbBille1 = nbBille1;
	}



	public List<String> getCouleurL1() {
		return couleurL1;
	}



	public void setCouleurL1(List<String> couleurL1) {
		this.couleurL1 = couleurL1;
	}



	public Integer getNbBille2() {
		return nbBille2;
	}



	public void setNbBille2(Integer nbBille2) {
		this.nbBille2 = nbBille2;
	}



	public List<String> getCouleurL2() {
		return couleurL2;
	}



	public void setCouleurL2(List<String> couleurL2) {
		this.couleurL2 = couleurL2;
	}



	public Integer getNbBille3() {
		return nbBille3;
	}



	public void setNbBille3(Integer nbBille3) {
		this.nbBille3 = nbBille3;
	}



	public List<String> getCouleurL3() {
		return couleurL3;
	}



	public void setCouleurL3(List<String> couleurL3) {
		this.couleurL3 = couleurL3;
	}



	public Integer getNbBille4() {
		return nbBille4;
	}



	public void setNbBille4(Integer nbBille4) {
		this.nbBille4 = nbBille4;
	}



	public List<String> getCouleurL4() {
		return couleurL4;
	}



	public void setCouleurL4(List<String> couleurL4) {
		this.couleurL4 = couleurL4;
	}



	public Integer getNbBille5() {
		return nbBille5;
	}



	public void setNbBille5(Integer nbBille5) {
		this.nbBille5 = nbBille5;
	}



	public List<String> getCouleurL5() {
		return couleurL5;
	}



	public void setCouleurL5(List<String> couleurL5) {
		this.couleurL5 = couleurL5;
	}



	public void setGs(List<GestionServeur> gs) {
		this.gs = gs;
	}
	
	
}
