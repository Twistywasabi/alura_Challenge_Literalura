package br.com.alura.Literalura.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class Livro {
    private String titulo;
    //@Enumerated(EnumType.STRING)
    private Categoria lingua;
    private Autor autor;
    private int numeroDownload;

    public Livro(){}

    public Livro(DadosLivro dadosLivro) {
        this.titulo = dadosLivro.title();
        this.lingua = Categoria.fromString(dadosLivro.languages().get(0));
        this.numeroDownload = dadosLivro.downloadNumber();
    }

    public void adicionarAutor(Autor autorAdicionado) {
        this.autor = autorAdicionado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Categoria getLingua() {
        return lingua;
    }

    public void setLingua(Categoria lingua) {
        this.lingua = lingua;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
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
                ", autor='" + autor.getNome() + '\'' +
                ", numeroDownload=" + numeroDownload;
    }
}




