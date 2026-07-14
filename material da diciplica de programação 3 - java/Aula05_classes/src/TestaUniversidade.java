
public class TestaUniversidade {
	public static void main(String [] args) {
		Aluno a1 = new Aluno("Mario", 102, 550);
		Aluno a2 = new Aluno("Paula", 103, 600);
		AlunoBolsista a3 = new AlunoBolsista("Angela",
				104, 1000, 30);
		Universidade uv = new Universidade();
		uv.adicionarAluno(a1);
		uv.adicionarAluno(a2);
		uv.adicionarAluno(a3);
		System.out.println("Mensalidade Paula (dia 04)" +
							uv.valorMensalidade(a2, 4));
		System.out.println("Valor recebido no dia 04: " +
							uv.receitaUniversidade(4));
	}
}
