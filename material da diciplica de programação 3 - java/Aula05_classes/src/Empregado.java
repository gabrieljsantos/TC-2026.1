
public class Empregado extends Pessoa{
	private int codSetor;
	private double salarioBase;
	private double imposto;
	
	public Empregado() {
		
	}
	
	public Empregado(String nome, String endereco, 
				String telefone, int codSetor, double salarioBase,
				double imposto) {
		super(nome, endereco, telefone);
		this.codSetor = codSetor;
		this.salarioBase = salarioBase;
		this.imposto = imposto;
	}

	public int getCodSetor() {
		return codSetor;
	}

	public void setCodSetor(int codSetor) {
		this.codSetor = codSetor;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public double getImposto() {
		return imposto;
	}

	public void setImposto(double imposto) {
		this.imposto = imposto;
	}
	
	public double calcularSalario() {
		return salarioBase - salarioBase*(imposto/100);
	}
	
	public String dadosEmpregado() {
		return dadosPessoa() +
				"Código setor: " + codSetor + "\n" +
				"Salário base: " + salarioBase + "\n" +
				"Imposto: " + imposto + "\n";
	}
	
}
