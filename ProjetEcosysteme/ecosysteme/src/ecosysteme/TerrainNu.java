package ecosysteme;

public class TerrainNu extends Case{
	
	public TerrainNu(int[] position) {
		super(6, true, false, position);
	}

	public TerrainNu(int typeOccupation, boolean estvide, boolean cadavre, int[] position) {
		super(6, estvide, cadavre, position);
	}

	@Override
	public int getTypeOccupation() {
		return 6;
	}

	
}
