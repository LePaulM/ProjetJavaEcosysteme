package ecosysteme;

public class Montagne extends Case{

	public Montagne(int[] position) {
		super(7, true, false, position);
	}
	
	public Montagne(int typeOccupation, boolean estvide, boolean cadavre, int[] position) {
		super(7, estvide, cadavre, position);
	}

	@Override
	public int getTypeOccupation() {
		return 7;
	}

	

}
