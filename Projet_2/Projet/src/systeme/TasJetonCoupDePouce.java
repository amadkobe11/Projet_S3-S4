package systeme;

public class TasJetonCoupDePouce extends TasJeton {

	public TasJetonCoupDePouce() {
		super();
		for(int i=0;i<100;i++) {
			this.addJeton(new JetonCoupDePouce());
		}
	}
	
	public TasJetonCoupDePouce(int nbJeton) {
		super();
		for(int i=0;i<nbJeton;i++) {
			this.addJeton(new JetonCoupDePouce());
		}
	}
	
	@Override
	public boolean isEmpty() {
		return this.getJetons().isEmpty();
	}

	@Override
	public int getNbElement() {
		return this.getJetons().size();
	}

}
