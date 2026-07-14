
public class TestaFuncionario {
	public static void main(String [] args) {
		Gerente f1 = new Gerente("Carlos", "098.666.987-00",
							10000, "TI");
		System.out.println("Bonificacao: " + f1.bonificacao());
		Funcionario f2 = new Funcionario("Maria", 
				"220.343.22-00", 1500);
		ControleGastos cg = new ControleGastos();
		System.out.println("Total gasto: " + cg.getTotalGastos());
		cg.adicionaBonificacao(f1);
		System.out.println("Total gasto: " + cg.getTotalGastos());
		cg.adicionaBonificacao(f2);
		System.out.println("Total gasto: " + cg.getTotalGastos());
	}
}
