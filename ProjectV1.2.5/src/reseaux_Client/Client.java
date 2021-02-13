package reseaux_Client;

import java.rmi.registry.*;
import java.util.List;

import interfaces.Joueurinterface;
import interfaces.MoninterfaceAnn;
import systeme.Bille;

public class Client extends Thread {
	
	public static void main(String[] args) {
		try {
			/* if(System.getSecurityManager() ==null){
			 * 	System.setSecurityManager(new SecurityManager());
			 * }
			 */
			//récupération du port
			String nameAnn = new String("rmi://serveurTestA");
			Registry registryAnn = LocateRegistry.getRegistry("192.168.10.101",2020);
			MoninterfaceAnn roAnn = (MoninterfaceAnn) registryAnn.lookup(nameAnn);
			
			int port = roAnn.donneMoiport();
			
			String name = new String("rmi://serveurProprietaire");
			Registry registry = LocateRegistry.getRegistry("192.168.10.101",port);
			Joueurinterface ro = (Joueurinterface) registry.lookup(name);
			ro.retirerBille(0, 2);
			List<Bille> lb =ro.getMain();
			System.out.println(lb);
		}catch(Exception e) {
				e.printStackTrace();
		}
}
	
	
}
