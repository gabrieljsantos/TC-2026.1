package br.ufs.principal;

import br.ufs.modelo.Aluno;
import br.ufs.calculos.CalculadoraNotas;

public class Main {

	public static void main(String[] args) {
		Aluno a = new Aluno("Thais", 6, 8.5);
		System.out.println(a.toString());
		System.out.println("Média: " + 
		      CalculadoraNotas.calcularMedia(a));
		if(CalculadoraNotas.verificaAprovacao(a)) {
			System.out.println("O aluno está aprovado!");
		}
		else {
			System.out.println("O aluno está reprovado!");
		}

	}

}
