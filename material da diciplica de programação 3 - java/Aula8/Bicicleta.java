
public class Bicicleta implements EmissaoCarbono{
	private int numRodas;
	
	public Bicicleta() {
		
	}
	
	public Bicicleta(int numRodas) {
		this.numRodas = numRodas;
	}
	
	public int getNumRodas() {
		return numRodas;
	}

	public void setNumRodas(int numRodas) {
		this.numRodas = numRodas;
	}
	
	@Override
	public String toString() {
		return "Bicicleta [numRodas=" + numRodas + "]";
	}

	@Override
	public double quantidadeEmitida() {
		return 0;
	}

}
