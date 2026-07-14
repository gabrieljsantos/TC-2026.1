
public class Carro implements EmissaoCarbono{
	private int combustivel; //1 - gasolina ou alcool; 2 - eletrico; 3 - diesel
	private int kms;
	
	public Carro() {
		
	}
	
	public Carro(int combustivel, int kms) {
		this.combustivel = combustivel;
		this.kms = kms;
	}
	
	public int getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(int combustivel) {
		this.combustivel = combustivel;
	}

	public int getKms() {
		return kms;
	}

	public void setKms(int kms) {
		this.kms = kms;
	}

	
	
	@Override
	public String toString() {
		return "Carro [combustivel=" + combustivel + 
				", kms=" + kms + "]";
	}

	@Override
	public double quantidadeEmitida() {
		if(combustivel == 1) {
			return 96 * kms;
		}
		else if(combustivel == 2) {
			return 53 * kms;
		}
		else if(combustivel == 3) {
			return 171 * kms;
		}
		return 0;
	}

}
