package modelos;

import interfaces.Emprestavel;

public class Revista extends Material implements Emprestavel {

    private int edicao;


    public Revista(int edicao, String codigo, String titulo, String autor) {

        super(codigo, titulo, autor);

        this.edicao = edicao;

    }


    @Override
    public void exibirDetalhes() {

        super.exibirDados();

        System.out.println("Edição: " + edicao);

    }


    @Override
    public void emprestar() {

        System.out.println("Revista emprestada");

    }


    @Override
    public void devolver() {

        System.out.println("Revista devolvida");

    }
}