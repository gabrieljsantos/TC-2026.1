
public class TestaReceitaFederal {
	public static void main(String [] args) {
		ReceitaFederal rf = new ReceitaFederal();
		PessoaFisica p2 = new PessoaFisica("Pedro Silva", "Rua das Flores, 20",
				5500, "302.098.290-00");
		PessoaJuridica p3 = new PessoaJuridica("Industria Arco-Iris", "Rua 100, 1", 
				100000, "20.182.807/0004-42");
		rf.adicionarPessoa(p2);
		rf.adicionarPessoa(p3);
		rf.dadosPessoas();
		System.out.println("Total de imposto: " + rf.qntImposto());
		System.out.println("Imposto da empresa Arco-Iris: " + rf.impostoPessoa("Industria Arco-Iris"));
		System.out.println("Quantidade de pessoas físicas: " + rf.qntPessoasFisicas());
		System.out.println("Quantidade de pessoas jurídicas: " + rf.qntPessoasJuridicas());
		
		Pessoa p4 = new PessoaFisica("Carlos", "Aracaju-Se", 
				7000, "096.987.937-00");
		System.out.println(p4.toString());
		System.out.println(((PessoaFisica)p4).getCpf());
		
		System.out.println("\nPessoas cadastradas:");
		rf.dadosPessoas();
		
	}
}
