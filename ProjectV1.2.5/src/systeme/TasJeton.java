package systeme;

import java.util.ArrayList;
import java.util.List;

public abstract class TasJeton extends Tas {
	private List<Jeton> jetons;
	
	public TasJeton() {
		this.jetons=new ArrayList<Jeton>();
	}
	public void addJeton(Jeton j) {
		this.jetons.add(j);
	}
	public void retirerJeton() {
		jetons.remove(jetons.size());
	}
	public Jeton prendreJeton() {
		return jetons.remove(jetons.size()-1);
	}
	public List<Jeton> getJetons() {
		return jetons;
	}
	
	
	
}
