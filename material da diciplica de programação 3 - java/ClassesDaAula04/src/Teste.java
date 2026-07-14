
public class Teste {
	public static void main(String [] args) {
		Pessoa p = new Pessoa("Liliane", "333.555.333-00");
		Aluno a = new Aluno();
		a.setNome("Pedro");
		a.setAnoIngresso(2022);
		a.setCpf("908.098.000-99");
		a.setMatricula(16726553);
		
		System.out.println("Dados da pessoa:" );
		System.out.println(p.dadosPessoa());
		
		System.out.println("Dados do aluno:");
		System.out.println(a.dadosAluno());
	}
}
