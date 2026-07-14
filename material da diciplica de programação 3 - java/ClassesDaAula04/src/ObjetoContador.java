
public class ObjetoContador {
	public static void main(String [] args) {
		Contador c = new Contador();
		System.out.println("Valor inicial: " + c.getCont());
		c.incrementar();
		c.incrementar();
		System.out.println("Valor atual: " + c.getCont());
		c.somar(10);
		System.out.println("Valor atual: " + c.getCont());
	}
}
