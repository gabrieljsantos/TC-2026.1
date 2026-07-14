
public class Fornecedor extends Pessoa {

	private double valorCredito;
	private double valorDebito;
	
	public Fornecedor() {
		
	}
	
	public Fornecedor(String nome, String endereco, 
				String telefone, double valorCredito, double valorDebito) {
		super(nome, endereco, telefone);
		this.valorCredito = valorCredito;
		this.valorDebito = valorDebito;
	}

	public double getValorCredito() {
		return valorCredito;
	}

	public void setValorCredito(double valorCredito) {
		this.valorCredito = valorCredito;
	}

	public double getValorDebito() {
		return valorDebito;
	}

	public void setValorDebito(double valorDebito) {
		this.valorDebito = valorDebito;
	}
	
	public double obterSaldo() {
		return valorCredito - valorDebito;
	}
	
	public String dadosFornecedor() {
		return dadosPessoa() + 
				"Valor débito: " + valorDebito + "\n" +
				"Valor crédito: " + valorCredito + "\n";
	}
}
