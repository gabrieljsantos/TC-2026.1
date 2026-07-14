
public class ObjetoCalculadora {
	public static void main(String [] args) {
		Calculadora c = new Calculadora();
		c.setX(4);
		c.setY(2);
		System.out.println("Soma: " + c.soma());
		System.out.println("Subtração: " + c.subtracao());
		System.out.println("Multiplicação: " + c.multiplicacao());
		System.out.println("Divisão: " + c.divisao());
	}
}
