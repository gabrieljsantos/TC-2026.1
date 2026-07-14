
public class Funcionario {
	private String nome;
	private String cpf;
	private double horas;
	private double valorHora;
	
	public Funcionario() {
		
	}
	
	public Funcionario(String nome, String cpf, 
				double horas, double valorHora) {
		this.nome = nome;
		this.cpf =  cpf;
		this.horas = horas;
		this.valorHora = valorHora;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getHoras() {
		return horas;
	}

	public void setHoras(double horas) {
		this.horas = horas;
	}

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}
	
	public double calcularSalario() {
		return horas*valorHora;
	}
	
	public void incrementarHoras(double valor) {
		horas += valor;
	}
	
	public void decrementarHoras(double valor) {
		horas -= valor;
	}
	
	public void aumentarValorHora(double porc) {
		valorHora += (porc/100)*valorHora;
	}
}
