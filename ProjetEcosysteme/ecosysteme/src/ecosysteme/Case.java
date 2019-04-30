package ecosysteme;

public class Case {
	
	private int typeOccupation;
	private boolean estVide;
	private boolean cadavre;
	private int position[];
	
	public Case() {};
	
	public int getTypeOccupation() {
		return typeOccupation;
	}

	public boolean isEstvide() {
		return estVide;
	}

	public boolean isCadavre() {
		return cadavre;
	}

	public int[] getPosition() {
		return position;
	}
	
	public int getX() {
		// TODO Auto-generated method stub
		return position[0];
	}

	public int getY() {
		// TODO Auto-generated method stub
		return position[1];
	}
	

	public Case(int typeOccupation, boolean estvide, boolean cadavre, int[] position) {
		super();
		this.typeOccupation = typeOccupation;
		this.estVide = estvide;
		this.cadavre = cadavre;
		this.position = position;
	}

	public void setEstVide(boolean b) {
		// TODO Auto-generated method stub
		this.estVide = b;
	}


	
}
