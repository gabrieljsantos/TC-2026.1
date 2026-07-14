
public class Contador {
	private int cont = 0;

	public int getCont() {
		return cont;
	}

	public void setCont(int cont) {
		this.cont = cont;
	}
	
	public void zerar() {
		cont = 0;
	}
	
	public void incrementar() {
		cont++;
	}
	
	public void decrementar() {
		cont--;
	}
	
	public void somar(int valor) {
		cont += valor;
	}
	
	public void subtrair(int valor) {
		cont -= valor;
	}
}
