
public class Aluno {
	private String nome;
	private int matricula;
	private double valorMensalidade;
	
	public Aluno() {
		
	}
	
	public Aluno(String nome, int matricula, 
			double valorMensalidade) {
		this.nome = nome;
		this.matricula = matricula;
		this.valorMensalidade = valorMensalidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public double getValorMensalidade() {
		return valorMensalidade;
	}

	public void setValorMensalidade(double valorMensalidade) {
		this.valorMensalidade = valorMensalidade;
	}
	
	public double pagar(int dia) {
		if(dia <= 5) {
			return valorMensalidade - valorMensalidade * 0.05;
		}
		else if (dia > 5 && dia <= 10) {
			return valorMensalidade;
		}
		else {
			return valorMensalidade * 1.1;
		}
	}
	
	public String toString() {
		return "Nome: " + nome + "\n" +
				"Matricula: " + matricula + "\n" +
				"Valor mensalidade: " + valorMensalidade + "\n";
		
	}
}
