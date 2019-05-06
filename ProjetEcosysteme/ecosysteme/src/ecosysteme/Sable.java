package ecosysteme;

public class Sable extends Case{

	public Sable(int[] position) {
		super(4, true, false, position);
	}
	
	public Sable(int typeOccupation, boolean estvide, boolean cadavre, int[] position) {
		super(4, estvide, cadavre, position);
	}

	@Override
	public int getTypeOccupation() {
		return 4;
	}
	
	


}
