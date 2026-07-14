
public class TestaPessoa {
	public static void main(String [] args) {
		Empregado p1 = new Empregado("Paulo Andrade",
				"Rua F1, 150", "9878-0099", 1 , 4500, 5);
		Fornecedor p2 = new Fornecedor("Casa das Tintas",
				"Rua 10, 2", "8987-0988", 10000, 35000);
		System.out.println("Empregado: ");
		System.out.println(p1.dadosEmpregado());
		System.out.println("Salário: " + p1.calcularSalario());
		System.out.println("Fornecedor: ");
		System.out.println(p2.dadosFornecedor());
		System.out.println("Saldo: " + p2.obterSaldo());
	}
}
