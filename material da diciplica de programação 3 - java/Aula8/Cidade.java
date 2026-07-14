import java.util.ArrayList;
public class Cidade {
	private ArrayList<EmissaoCarbono> elementos = new 
			ArrayList<EmissaoCarbono>();
	
	public void adicionar(EmissaoCarbono c) {
		elementos.add(c);
	}
	
	public double calculaEmissaoMensal() {
		double total = 0;
		for(int i = 0; i < elementos.size(); i++) {
			total += elementos.get(i).quantidadeEmitida();
		}
		return total;
	}
}
