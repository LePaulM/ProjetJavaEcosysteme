package ecosysteme;

public class Neige extends Case{

	public Neige(int[] position) {
		super(5, true, false, position);
	}
	
	public Neige(int typeOccupation, boolean estvide, boolean cadavre, int[] position) {
		super(5, estvide, cadavre, position);
	}

	@Override
	public int getTypeOccupation() {
		return 5;
	}

	
}
