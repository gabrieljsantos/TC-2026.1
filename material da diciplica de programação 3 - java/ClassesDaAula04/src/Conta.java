
public class Conta {
	private String tipo;
	private String numero;
	private String nome;
	private double saldo;
	
	public Conta() {
		
	}
	
	public Conta(String tipo, String numero, String nome, double saldo) {
		this.tipo = tipo;
		this.numero = numero;
		this.nome = nome;
		this.saldo = saldo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	private void sacar(double valor) {
		saldo -= valor;
	}
	
	private void depositar(double valor) {
		saldo += valor;
	}
	
	private String dadosConta() {
		return "Tipo:  " + tipo + "\n" +
				"Número: " + numero + "\n" +
				"Nome: " + nome + "\n" +
				"Saldo: " + saldo + "\n";
	}
}
