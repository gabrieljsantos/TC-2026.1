
public class ObjetoCarro {
	public static void main(String [] args) {
		Carro c1 = new Carro();
		c1.setTipo("Ferrari");
		c1.setCor("vermelha");
		c1.setPlaca("KJH0987");
		c1.setNum_portas(4);
		
		System.out.println("Tipo: " + c1.getTipo());
		System.out.println("Cor: " + c1.getCor());
		System.out.println("Placa: " + c1.getPlaca());
		System.out.println("Número de portas: " + 
								c1.getNum_portas());
		c1.liga();
		c1.acelera();
		c1.frea();
		c1.desliga();
		
		Carro c2 = new Carro("Porshe", "Prata",
					"LKI009", 2);
		
		System.out.println("Tipo: " + c2.getTipo());
		System.out.println("Cor: " + c2.getCor());
		System.out.println("Placa: " + c2.getPlaca());
		System.out.println("Número de portas: " + 
								c2.getNum_portas());
		
		
	}
}
