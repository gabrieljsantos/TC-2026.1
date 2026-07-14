package br.ufs.calculos;

import br.ufs.modelo.Aluno;

public class CalculadoraNotas {
	public static double calcularMedia(Aluno a) {
		return (a.getNota1() + a.getNota2())/2;
	}
	
	public static boolean verificaAprovacao(Aluno a) {
		if(calcularMedia(a) >= 5) {
			return true;
		}
		return false;
	}
}
