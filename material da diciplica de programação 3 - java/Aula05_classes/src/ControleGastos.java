
public class ControleGastos {
	private double totalGastos = 0;
	
	public double getTotalGastos() { 
		return totalGastos;
	}
	
	public void adicionaBonificacao(Funcionario f) {
		totalGastos += f.bonificacao();
	}
}
