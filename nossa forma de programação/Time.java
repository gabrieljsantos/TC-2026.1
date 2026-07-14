package r;

import java.util.Date;

public class Time {
	private String nome;
	private Date dtNascimento;
	private Tecnico tecnico;
	private Jogador[] jogadores;
	
	public Time(String nome, Date dtNascimento, Tecnico tecnico, Jogador[] jogadores) {
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.tecnico = tecnico;
		this.jogadores = jogadores;
	}
	
	

}
