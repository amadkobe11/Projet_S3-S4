package reseaux_Serveur;

import java.io.BufferedReader;

public class ServeurRead extends Thread {
	private BufferedReader brin;
	private GestionServeur gs;
	
	public ServeurRead(BufferedReader brin,GestionServeur gs) {
		this.brin = brin;
		this.gs=gs;
	}

	public void run() {
		while(true) {
			try {
				Serveur s=gs.getServ();
				String numJoueurS=brin.readLine();
				s.setNumJoueur(Integer.valueOf(numJoueurS));
				s.setScore(Integer.valueOf(brin.readLine()));
					
				s.setNbJetonCoupDePouce(Integer.valueOf(brin.readLine()));
				s.setNbJetonCompetence(Integer.valueOf(brin.readLine()));
					
				s.setNbBille1(Integer.valueOf(brin.readLine()));
				for(int i=0;i<s.getNbBille1();i++) {
					s.getCouleurL1().add(brin.readLine());
				}
					
				s.setNbBille2(Integer.valueOf(brin.readLine()));
				for(int i=0;i<s.getNbBille2();i++) {
					s.getCouleurL2().add(brin.readLine());
				}
					
				s.setNbBille3(Integer.valueOf(brin.readLine()));
				for(int i=0;i<s.getNbBille3();i++) {
					s.getCouleurL3().add(brin.readLine());
				}
					
				s.setNbBille4(Integer.valueOf(brin.readLine()));
				for(int i=0;i<s.getNbBille4();i++) {
					s.getCouleurL4().add(brin.readLine());
				}
					
				s.setNbBille5(Integer.valueOf(brin.readLine()));
				for(int i=0;i<s.getNbBille5();i++) {
					s.getCouleurL5().add(brin.readLine());
				}
				s.reveillerGS();
			} catch (Exception e) {
				//e.printStackTrace();
			}
		}
	}
}
