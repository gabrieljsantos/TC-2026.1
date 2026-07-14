
public class TestaCarro {
	public static void main(String [] args) {
		System.out.println("Total de carros: " 
						+Carro.getTotalCarros());
		System.out.println("Meta de quilometragem: " 
						+ Carro.getMetaKm());
		Carro c1 = new Carro();
		Carro c2 = new Carro();
		System.out.println("Total de carros: " 
					+Carro.getTotalCarros());
		Carro.setMetaKm(100);
		c2.setMetaKm(200);
		System.out.println("Total de carros: " 
					+Carro.getMetaKm());
		Carro.setMetaKm(150);
		System.out.println("Total de carros: " 
					+Carro.getMetaKm());
		
	}
}
