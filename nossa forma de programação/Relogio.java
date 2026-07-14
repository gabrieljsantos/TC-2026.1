package r;

public class Relogio {
	private int segundos = 0;
	private int hora = 0;
	private int minutos = 0;

	public void aumentarSegundos() {
		segundos++;
		ajustarHorario();
	}

	public boolean acertarHora(int hora, int minutos, int segundos) {
		if (hora > 23 || minutos > 59 || segundos > 59) {
			return false;
		} else {
			this.hora = hora;
			this.minutos = minutos;
			this.segundos = segundos;
			return true;
		}
	}

	public boolean acertarHora(int hora) {
		if (hora > 23) {
			return false;
		} else {
			this.hora = hora;
			return true;
		}
	}

	private void ajustarHorario() {
		if (segundos == 60) {
			segundos = 0;
			minutos++;
			if (minutos == 60) {
				minutos = 0;
				hora++;
				if (hora == 24) {
					hora = 0;
				}
			}
		}
	}

	public void mostrarHora() {
		System.out.println(hora + ":" + minutos + ":" + segundos);
	}

	public static void main(String[] args) {
		Relogio rel = new Relogio();
		rel.acertarHora(20, 50, 50);

		try {
			int cont = 0;
			while (true) {
				Thread.sleep(1000);
				rel.aumentarSegundos();
				cont++;
				if (cont == 300) {
					rel.mostrarHora();
					cont = 0;
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
