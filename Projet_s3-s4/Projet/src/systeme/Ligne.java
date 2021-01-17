package systeme;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ligne {
	private List<Bille> billes;
	
	public Ligne(int nbNoir,int nbBleue,int nbRouge,int nbJaune) {
		billes=new ArrayList<Bille>();
		Random r = new Random();
		for(int i=0;i<16;i++) {
			
			int result = r.nextInt(4);
			
			if(result ==0 && nbNoir>0) {
				billes.add(new Bille("Noir"));
				nbNoir=nbNoir-1;
				
			}else if(result == 1 && nbBleue>0) {
				billes.add(new Bille("Bleue"));
				nbBleue=nbBleue-1;
			}else if(result == 2 && nbRouge>0) {
				billes.add(new Bille("Rouge"));
				nbRouge=nbRouge-1;
			}else if(result == 3 && nbJaune>0) {
				billes.add(new Bille("Jaune"));
				nbJaune=nbJaune-1;
			}else {
				i=i-1;
			}
			
		}
		
	}
	public Bille retirerBille(int billeNb) {
		return this.getBilles().remove(billeNb);
	}
	public void ajouterBille(Bille b) {
		billes.add(b);
	}
	
	//getter
	public List<Bille> getBilles() {
		return billes;
	}
	//setter
	public void setBilles(List<Bille> billes) {
		this.billes = billes;
	}
	@Override
	public String toString() {
		return "Ligne [billes=" + billes + "]";
	}
	
	
	
}
