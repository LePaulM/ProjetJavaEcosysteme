package ecosysteme;

public abstract class Case {
	
	private /*abstract*/ int typeOccupation;//pk quand jmets abstract il gueule
	private boolean estVide;
	private boolean cadavre;
	private int position[];
	
	
	
	public Case(int typeOccupation, boolean estvide, boolean cadavre, int[] position) {
		super();
		this.typeOccupation = typeOccupation;
		this.estVide = estvide;
		this.cadavre = cadavre;
		this.position = position;
	}
	/*
	public int getTypeOccupation() {
		return typeOccupation;
	}
*/
	public boolean getEstvide() {
		return estVide;
	}

	public boolean getCadavre() {
		return cadavre;
	}

	public int[] getPosition() {
		return position;
	}
	
	public int getX() {
		return position[0];
	}

	public int getY() {
		return position[1];
	}

	public void setEstVide(boolean b) {
		// TODO Auto-generated method stub
		this.estVide = b;
	}

	public abstract int getTypeOccupation();// mettre les return ''sable, ou 0 etc'' dans les classes filles
	
}
