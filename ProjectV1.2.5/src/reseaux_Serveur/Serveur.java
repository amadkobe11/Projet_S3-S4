package reseaux_Serveur;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import interfaces.MoninterfaceAnn;

public class Serveur implements MoninterfaceAnn {
		public int nb =0;
		@Override
		public int donneMoiport() throws RemoteException {
			int port =2009+this.accremente();
			return port;
		}
		private int accremente() {
			int p = this.nb;
			this.nb+=1;
			return p;
		}
		public static void main(String[] args) {
			try {
				MoninterfaceAnn monint = new Serveur();
				try {
					/* if(System.getSecurityManager() ==null){
					 * 	System.setSecurityManager(new SecurityManager());
					 * }
					 */
					MoninterfaceAnn skeleton = (MoninterfaceAnn) UnicastRemoteObject.exportObject(monint,2020);
					String name = new String("rmi://serveurTestA");
					Registry registry = LocateRegistry.createRegistry(2020);
					registry.rebind(name, skeleton);
					System.out.println("Serveur Annuaire Waiting...");
				}catch(java.rmi.server.ExportException e) {
					try {
						e.printStackTrace();
						UnicastRemoteObject.unexportObject(monint, true);
						System.out.println("Relancer le serveur...");
					}catch(Exception f) {f.printStackTrace();}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}catch(Exception g ) {
				g.printStackTrace();
			}
		}

	
}
