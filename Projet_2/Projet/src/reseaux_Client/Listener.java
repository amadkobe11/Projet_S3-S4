package reseaux_Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Listener extends Thread {
	private Integer numJoueur;
	private Integer score;
	private Integer nbJetonCoupDePouce;
	private Integer nbJetonCompetence;
	
	private Integer nbBilleL1;
	private List<String> couleurL1;
	
	private Integer nbBilleL2;
	private List<String> couleurL2;
	
	private Integer nbBilleL3;
	private List<String> couleurL3;
	
	private Integer nbBilleL4;
	private List<String> couleurL4;
	
	private Integer nbBilleL5;
	private List<String> couleurL5;
	
	private BufferedReader brin;
	
	public Listener(Socket socket) {
		try {
			this.brin=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
		} catch (IOException e) {
			e.printStackTrace();
		};
	}
	
	public void run() {
		try {
			boolean ok=true;
			while(ok) {
				String numJoueurS=brin.readLine();
				if(numJoueurS!=null) {
					numJoueur=Integer.valueOf(numJoueurS);
					score = Integer.valueOf(brin.readLine());
					
					nbJetonCoupDePouce = Integer.valueOf(brin.readLine());
					nbJetonCompetence = Integer.valueOf(brin.readLine());
					
					nbBilleL1 = Integer.valueOf(brin.readLine());
					couleurL1=new ArrayList<String>();
					for(int i=0;i<nbBilleL1;i++) {
						couleurL1.add(brin.readLine());
					}
					
					nbBilleL2 = Integer.valueOf(brin.readLine());
					couleurL2=new ArrayList<String>();
					for(int i=0;i<nbBilleL2;i++) {
						couleurL2.add(brin.readLine());
					}
					
					nbBilleL3 = Integer.valueOf(brin.readLine());
					couleurL3=new ArrayList<String>();
					for(int i=0;i<nbBilleL3;i++) {
						couleurL3.add(brin.readLine());
					}
					
					nbBilleL4 = Integer.valueOf(brin.readLine());
					couleurL4=new ArrayList<String>();
					for(int i=0;i<nbBilleL4;i++) {
						couleurL4.add(brin.readLine());
					}
					
					nbBilleL5 = Integer.valueOf(brin.readLine());
					couleurL5=new ArrayList<String>();
					for(int i=0;i<nbBilleL5;i++) {
						couleurL5.add(brin.readLine());
					}
					//faire pour qu'il fasse quelque chose avec (systeme du jeu)
					
					
					//test
					System.out.println(score);
					System.out.println(couleurL5);
				}else {
					ok=false;
					System.out.println("Le serveur ses fermer");
				}
			}
		} catch (IOException e) {
			
		}
	}
}
