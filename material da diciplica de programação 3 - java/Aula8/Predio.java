
public class Predio implements EmissaoCarbono{
	private int numPessoas;
	private boolean renovavel;
	private int numLampadas;
	private int numArCondicionado;
	
	public Predio() {
		
	}
	
	public Predio(int numPessoas, boolean renovavel,
			int numLampadas, int numArCondicionado) {
		this.numPessoas = numPessoas;
		this.renovavel = renovavel;
		this.numLampadas = numLampadas;
		this.numArCondicionado = numArCondicionado;
	}
	
	public int getNumPessoas() {
		return numPessoas;
	}

	public void setNumPessoas(int numPessoas) {
		this.numPessoas = numPessoas;
	}

	public boolean isRenovavel() {
		return renovavel;
	}

	public void setRenovavel(boolean renovavel) {
		this.renovavel = renovavel;
	}

	public int getNumLampadas() {
		return numLampadas;
	}

	public void setNumLampadas(int numLampadas) {
		this.numLampadas = numLampadas;
	}

	public int getNumArCondicionado() {
		return numArCondicionado;
	}

	public void setNumArCondicionado(int numArCondicionado) {
		this.numArCondicionado = numArCondicionado;
	}

	@Override
	public double quantidadeEmitida() {
		double uso =  14.4 * numLampadas + 10 * numPessoas
				+ 100 * numArCondicionado;
		if(renovavel) {
			return uso / 2;
		}
		else {
			return uso;
		}
	}

	@Override
	public String toString() {
		return "Predio [numPessoas=" + numPessoas + 
				", renovavel=" + renovavel + 
				", numLampadas=" + numLampadas +
				", numArCondicionado=" + numArCondicionado + 
				"]";
	}
	
	

}
