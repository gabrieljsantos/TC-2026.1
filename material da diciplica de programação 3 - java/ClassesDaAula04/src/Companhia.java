import java.util.ArrayList;

public class Companhia {
	private String nome;
	private String cnpj;
	private ArrayList<Funcionario> funcionarios = 
			new ArrayList<Funcionario>();
	
	public Companhia() {
		
	}
	
	public Companhia(String nome, String cnpj, 
				ArrayList<Funcionario> funcionarios) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.funcionarios = funcionarios;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public ArrayList<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	public void addFuncionario(Funcionario f) {
		funcionarios.add(f);
	}
	
	public String buscarFuncionario(String nome) {
		for(int i = 0; i < funcionarios.size();i++) {
			if(nome.equalsIgnoreCase(
					funcionarios.get(i).getNome())) {
				return funcionarios.get(i).getNome() + " " +
						funcionarios.get(i).getCpf() + " " +
						funcionarios.get(i).getHoras() + " " +
						funcionarios.get(i).getValorHora();
			}
		}
		
		return "Funcionário não encontrado!";
		
	}
	
	public double totalGastoComSalario() {
		double total = 0;
		for(int i = 0; i < funcionarios.size(); i++) {
			total += funcionarios.get(i).calcularSalario();
		}
		return total;
	}
	
}
