package reseaux_Serveur;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class GestionServeur extends Thread {
	private Socket soc;
	
	private Serveur serv;
	
	
	public GestionServeur(Socket soc, Serveur serv) {
		this.soc = soc;
		this.serv = serv;
	}

	public void run(){
				try {
					BufferedReader brin = new BufferedReader(new InputStreamReader(soc.getInputStream()));
					
					PrintWriter brOut = new PrintWriter(new BufferedWriter(new OutputStreamWriter(soc.getOutputStream())),true);
					
					ServeurRead sr = new ServeurRead(brin,this);
					sr.start();
					while(true) {
						
						attente();
						brOut.println(serv.getNumJoueur());
						brOut.println(serv.getScore());
						brOut.println(serv.getNbJetonCoupDePouce());
						brOut.println(serv.getNbJetonCompetence());
						
						brOut.println(serv.getNbBille1());
						for(int i =0;i<serv.getNbBille1();i++) {
							brOut.println(serv.getCouleurL1().get(i));
						}
						brOut.println(serv.getNbBille2());
						for(int i =0;i<serv.getNbBille2();i++) {
							brOut.println(serv.getCouleurL2().get(i));
						}
						brOut.println(serv.getNbBille3());
						for(int i =0;i<serv.getNbBille3();i++) {
							brOut.println(serv.getCouleurL3().get(i));
						}
						brOut.println(serv.getNbBille4());
						for(int i =0;i<serv.getNbBille4();i++) {
							brOut.println(serv.getCouleurL4().get(i));
						}
						brOut.println(serv.getNbBille5());
						for(int i =0;i<serv.getNbBille5();i++) {
							brOut.println(serv.getCouleurL5().get(i));
						}
						
						
					}
				}catch(Exception e) {
					//System.out.println(e);
				}
				
	}
	//attend qu'une donnée soit reçue
	private synchronized void attente() {
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	//termine l'attente
	public synchronized void attenteTerminer() {
		notifyAll();
	}

	public Socket getSoc() {
		return soc;
	}

	public Serveur getServ() {
		return serv;
	}

	public void setSoc(Socket soc) {
		this.soc = soc;
	}

	public void setServ(Serveur serv) {
		this.serv = serv;
	}
	
	
	
	
	
}