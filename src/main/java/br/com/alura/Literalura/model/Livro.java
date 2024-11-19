package br.com.alura.Literalura.model;

public class Livro {
    private String titulo;
    private String lingua;
    private String autor;
    private int numeroDownload;

    public Livro(){}

    public Livro(DadosLivro dadosLivro) {
        this.titulo = dadosLivro.title();
        this.lingua = dadosLivro.languages().get(0);
        this.autor = dadosLivro.authors().get(0).name();
        this.numeroDownload = dadosLivro.downloadNumber();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLingua() {
        return lingua;
    }

    public void setLingua(String lingua) {
        this.lingua = lingua;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumeroDownload() {
        return numeroDownload;
    }

    public void setNumeroDownload(int numeroDownload) {
        this.numeroDownload = numeroDownload;
    }

    @Override
    public String toString() {
        return "titulo='" + titulo + '\'' +
                ", lingua='" + lingua + '\'' +
                ", autor='" + autor + '\'' +
                ", numeroDownload=" + numeroDownload;
    }
}




