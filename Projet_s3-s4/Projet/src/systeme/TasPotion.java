package systeme;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TasPotion extends Tas {
	private List<Potion> potions;
	
	public TasPotion() {
		this.potions=new ArrayList<Potion>();
	}
	
	public Potion retirerPotion() {
		return potions.remove(potions.size()-1);
	}
	
	public void melangerPotion() {
		Collections.shuffle(potions);
	}
	public List<Potion> getPotion() {
		return this.potions;
	}

	@Override
	public boolean isEmpty() {
		return potions.isEmpty();
	}

	@Override
	public int getNbElement() {
		return potions.size();
	}
}
