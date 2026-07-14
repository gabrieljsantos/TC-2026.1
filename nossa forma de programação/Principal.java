package r;

public class Principal {

	public static void main(String[] args) {
		Funcionario fun = new Funcionario(100, "Jose", 5000);
		
		fun.atualizarSalario(20);

		System.out.println(fun.calcularSalario());
		
	}
	
	
}
