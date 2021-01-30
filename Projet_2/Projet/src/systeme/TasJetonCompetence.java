package systeme;

public class TasJetonCompetence extends TasJeton {

	public TasJetonCompetence(int nbJeton) {
		super();
		for(int i=0;i<nbJeton;i++) {
			this.addJeton(new JetonCompetence());
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
