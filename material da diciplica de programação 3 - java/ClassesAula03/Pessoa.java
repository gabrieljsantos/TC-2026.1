
public class Pessoa {
	private String nome;
	private String cpf;
	private double altura;
	private int idade;
	
	public Pessoa() {
		
	}
	
	public Pessoa(String nome, String cpf, 
					double altura, int idade) {
		this.nome = nome;
		this.cpf = cpf;
		this.altura = altura;
		this.idade = idade;
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

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public void andar() {
		System.out.println("Pessoa andando...");
	}
	
	public String dadosPessoa() {
		return "Nome: " + nome + "\n" +
				"CPF: " + cpf + "\n" +
				"Altura: " + altura + "\n" +
				"Idade: " + idade + "\n";
	}
}
