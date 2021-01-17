package reseaux_Client;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Client extends Thread {
	
	private Socket socket;
	private Listener lis;
	
	public Socket connexion(String host,String port) throws Exception {
		Socket socket = new Socket(host,Integer.parseInt(port));
		System.out.println("Socket = "+socket);
		return socket;
	}
	
	public void run(){
		try {
			//changer le localhost par l'adresse ip
			socket = this.connexion("127.0.0.1", "1290");
			
			lis = new Listener(socket);
	
			lis.start();
			
		}catch(Exception e) {
			
		}
		
	}
	//permet d'envoyer les données du jeu (potentiellement changer par les objet du system)
	public void envoyer(int numJoueur,int score,int nbJetonCoupDePouce,int nbJetonCompetence,int nbBille1,List<String> couleurL1,int nbBille2,List<String> couleurL2,int nbBille3,List<String> couleurL3,int nbBille4,List<String> couleurL4,int nbBille5,List<String> couleurL5) {
		try {
			
			PrintWriter brOut = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
			
			brOut.println(numJoueur);
			brOut.println(score);
			brOut.println(nbJetonCoupDePouce);
			brOut.println(nbJetonCompetence);
			brOut.println(nbBille1);
			
			for(int i =0;i<nbBille1;i++) {
				brOut.println(couleurL1.get(i));
			}
			brOut.println(nbBille2);
			for(int i =0;i<nbBille2;i++) {
				brOut.println(couleurL2.get(i));
			}
			brOut.println(nbBille3);
			for(int i =0;i<nbBille3;i++) {
				brOut.println(couleurL3.get(i));
			}
			brOut.println(nbBille4);
			for(int i =0;i<nbBille4;i++) {
				brOut.println(couleurL4.get(i));
			}
			brOut.println(nbBille5);
			for(int i =0;i<nbBille5;i++) {
				brOut.println(couleurL5.get(i));
			}
			
		} catch (IOException e) {
	
		}
		
	}
	//main pour tester l'envoie de donnée
	public static void main(String [] args) throws Exception{
		Client clientInt=new Client();
		
		clientInt.start();
		
		Client c2 = new Client();
		c2.start();
		
		List<String> couleurL1 = new ArrayList<String>();
		couleurL1.add("Noir");
		couleurL1.add("Bleu");
		couleurL1.add("Rouge");
		couleurL1.add("Jaune");
		couleurL1.add("Noir");
		
		List<String> couleurL2 = new ArrayList<String>();
		couleurL2.add("Bleu");
		couleurL2.add("Bleu");
		couleurL2.add("Rouge");
		couleurL2.add("Jaune");
		couleurL2.add("Noir");
		
		List<String> couleurL3 = new ArrayList<String>();
		couleurL3.add("Rouge");
		couleurL3.add("Jaune");
		couleurL3.add("Rouge");
		couleurL3.add("Jaune");
		couleurL3.add("Noir");
		
		List<String> couleurL4 = new ArrayList<String>();
		couleurL4.add("Bleu");
		couleurL4.add("Jaune");
		couleurL4.add("Rouge");
		couleurL4.add("Jaune");
		couleurL4.add("Noir");
		
		List<String> couleurL5 = new ArrayList<String>();
		couleurL5.add("Bleu");
		couleurL5.add("Jaune");
		couleurL5.add("Rouge");
		couleurL5.add("Jaune");
		
		Thread.sleep(200);
		c2.envoyer(2, 20, 3, 5, 5, couleurL1, 5, couleurL2, 5, couleurL3, 5, couleurL4, 4, couleurL5);
		
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public Listener getLis() {
		return lis;
	}

	public void setLis(Listener lis) {
		this.lis = lis;
	}
	
	
	
}
