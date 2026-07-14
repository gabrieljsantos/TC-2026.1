import java.util.ArrayList;

public class ReceitaFederal {
	private ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	public ReceitaFederal() {
		
	}
	
	public ReceitaFederal(ArrayList<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	public void adicionarPessoa(Pessoa p) {
		boolean achou = false;
		for(int i = 0; i < pessoas.size(); i++) {
			if(p instanceof PessoaFisica && 
					pessoas.get(i) instanceof PessoaFisica) {
				if(((PessoaFisica)pessoas.get(i)).getCpf().
						equals(((PessoaFisica)p).getCpf())){
					achou = true;
				}
			}
			else if (p instanceof PessoaJuridica && 
					pessoas.get(i) instanceof PessoaJuridica) {
				if(((PessoaJuridica)pessoas.get(i)).getCnpj()
						.equals(((PessoaJuridica)p).getCnpj())){
					achou = true;
				}	
			}
		}
		if(!achou) {
			pessoas.add(p);
		}
	}
	
	public void removePessoa(String nome) {
		boolean achou = false;
		for(int i = 0; i < pessoas.size(); i++) {
			if(pessoas.get(i).getNome().equalsIgnoreCase(nome)) {
				pessoas.remove(i);
				System.out.println("Pessoa removida com sucesso!");
				achou = true;
			}
		}
		if(!achou) {
			System.out.println("Pessoa não encontrada!");
		}
	}
	
	public int qntPessoasFisicas() {
		int qnt = 0;
		for(int i = 0; i < pessoas.size(); i++) {
			if(pessoas.get(i) instanceof PessoaFisica) {
				qnt++;
			}				
		}
		return qnt;
	}
	
	public int qntPessoasJuridicas() {
		int qnt = 0;
		for(int i = 0; i < pessoas.size(); i++) {
			if(pessoas.get(i) instanceof PessoaJuridica) {
				qnt++;
			}				
		}
		return qnt;
	}
	
	public double impostoPessoa(String nome) {
		for(int i = 0; i < pessoas.size(); i++) {
			if(pessoas.get(i).getNome().equalsIgnoreCase(nome)) {
				return pessoas.get(i).calculaImposto();
			}
		}
		return -1;
	}
	
	public double qntImposto() {
		double valor = 0;
		for(int i = 0; i < pessoas.size(); i++) {
			valor += pessoas.get(i).calculaImposto();
		}
		return valor;
	}
	
	public void dadosPessoas() {
		for(int i = 0; i < pessoas.size(); i++) {
			System.out.println("Pessoa " + (i + 1) + ":");
			System.out.println(pessoas.get(i).toString());
		}
	}
	
	
	
}
