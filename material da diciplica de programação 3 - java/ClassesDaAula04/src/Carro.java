
public class Carro {
	private String modelo;
	private double km;
	
	private static int totalCarros;
	private static double metaKm;
	
	public Carro() {
		totalCarros++;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getKm() {
		return km;
	}

	public void setKm(double km) {
		this.km = km;
	}

	public static int getTotalCarros() {
		return totalCarros;
	}

	public static void setTotalCarros(int totalCarros) {
		Carro.totalCarros = totalCarros;
	}

	public static double getMetaKm() {
		return metaKm;
	}

	public static void setMetaKm(double metaKm) {
		Carro.metaKm = metaKm;
	}
	
	public void rodar(double km) {
		this.km += km;
	}
	
	public static void alterarMeta(double meta) {
		metaKm = meta;
	}
}
