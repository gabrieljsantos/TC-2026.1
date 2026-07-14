
public class ObjetoPessoa {
	public static void main(String [] args) {
		Pessoa p1 = new Pessoa("Maria Silva",
				"092.093.098-00", 1.55, 20);
		Pessoa p2 = new Pessoa("Mario Reis",
				"094.222.124-45", 1.90, 30);
		
		System.out.println("Pessoa 1:");
		System.out.println(p1.dadosPessoa());
		System.out.println("Pessoa 2:");
		System.out.println(p2.dadosPessoa());
	}
}
