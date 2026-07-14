package modelos;

import interfaces.Emprestavel;

public class Livro extends Material implements Emprestavel {

    private int n_capitulos;
    private int capitulo_aberto;

    public Livro(int n_capitulos, String codigo, String titulo, String autor) {
        super(codigo, titulo, autor);

        this.n_capitulos = n_capitulos;
        this.capitulo_aberto = 0;
    }


    @Override
    public void exibirDetalhes() {
        super.exibirDados();
        System.out.println("Número de capítulos: " + n_capitulos);
    }


    public int getCapitulo_aberto() {
        return this.capitulo_aberto;
    }


    public void setCapitulo_aberto(int x) {

        if (x > this.n_capitulos) {
            this.capitulo_aberto = n_capitulos;
        } else {
            this.capitulo_aberto = x;
        }

    }


    @Override
    public void emprestar() {
        System.out.println("Livro emprestado");
    }


    @Override
    public void devolver() {
        System.out.println("Livro devolvido");
    }
}