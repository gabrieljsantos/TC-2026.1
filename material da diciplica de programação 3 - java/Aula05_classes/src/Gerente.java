
public class Gerente extends Funcionario{
	private String setor;
	
	public Gerente() {
		
	}
	
	public Gerente(String nome, String cpf, 
			double salario, String setor) {
		super(nome, cpf, salario);
		this.setor = setor;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}
	
	public String toString() {
		return super.toString() + "Setor: " + setor + "\n";
	}
	
	public double bonificacao() {
		return getSalario() * 0.15;
	}
	
	
	
	
	
	
	
	

}
