package interfaces;

import java.rmi.*;
import java.util.List;

import systeme.Bille;
import systeme.Potion;

public interface Joueurinterface extends Remote {
	public void utiliserPotion(Potion p) throws RemoteException;
	public void recevoirPCompetence() throws RemoteException;
	public void placerBille(Bille b,int numPotion) throws RemoteException;
	public void placerBille(Bille b) throws RemoteException;
	public void prendreJetonCoupDePouce() throws RemoteException;
	public List<Potion> getPotionTermine() throws RemoteException;
	public List<Potion> getPotionPaillasse() throws RemoteException;
	public void PrendrePotion(int numPioche) throws RemoteException;
	public void setScore(int score) throws RemoteException;
	public void refreshScore() throws RemoteException;
	public void remettreBille() throws RemoteException;
	public void retirerBille(int ligne,int bille) throws RemoteException;
	public List<Bille> getMain() throws RemoteException;
}
