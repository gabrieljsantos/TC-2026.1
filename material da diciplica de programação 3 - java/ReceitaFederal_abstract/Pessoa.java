
public abstract class Pessoa {
	private String nome;
	private String endereco;
	private double rendaBruta;
	
	public Pessoa() {
		
	}
	
	public Pessoa(String nome, String endereco, 
			double rendaBruta) {
		this.nome = nome;
		this.endereco = endereco;
		this.rendaBruta = rendaBruta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public double getRendaBruta() {
		return rendaBruta;
	}

	public void setRendaBruta(double rendaBruta) {
		this.rendaBruta = rendaBruta;
	}
	
	public abstract double calculaImposto();
	
	public String toString() {
		return "Nome: " + nome + "\n" +
				"Endereço: " + endereco + "\n" +
				"Renda bruta: " + rendaBruta + "\n";
	}
}
