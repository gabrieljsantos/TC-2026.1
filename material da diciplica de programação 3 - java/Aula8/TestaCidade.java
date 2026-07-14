
public class TestaCidade {
	public static void main(String [] args) {
		Cidade cidade = new Cidade();
		Carro c = new Carro(1, 45);
		Predio p = new Predio(100, false, 500, 50);
		Bicicleta b = new Bicicleta(2);
		
		cidade.adicionar(c);
		cidade.adicionar(p);
		cidade.adicionar(b);
		
		System.out.println("Quantidade mensal de carbono"
				+ " emitido: " + cidade.calculaEmissaoMensal());
	}
}
