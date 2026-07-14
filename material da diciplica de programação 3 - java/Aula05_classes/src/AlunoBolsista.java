
public class AlunoBolsista extends Aluno{
	private double desconto;
	
	public AlunoBolsista() {
		
	}
	
	public AlunoBolsista(String nome, int matricula,
			double valorMensalidade, double desconto) {
		super(nome, matricula, valorMensalidade);
		this.desconto = desconto;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
	
	public double pagar(int dia) {
		if(dia <= 15) {
			return getValorMensalidade() - getValorMensalidade()*(desconto/100);
		}
		return getValorMensalidade();
	}
	
	public String toString() {
		return super.toString() + "Desconto: " + desconto + "\n";
	}

}
