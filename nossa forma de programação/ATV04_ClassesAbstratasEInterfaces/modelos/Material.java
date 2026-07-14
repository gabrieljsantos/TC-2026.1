package modelos;

public abstract class Material {

    protected String codigo;
    private String titulo;
    public String autor;

    public Material(String codigo, String titulo, String autor) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
    }

    public void exibirDados() {
        System.out.println("Dados: " + codigo + " " + titulo + " " + autor);
    }

    public abstract void exibirDetalhes();

    public String getTitulo() {
        return this.titulo;
    }
}