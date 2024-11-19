package br.com.alura.Literalura.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Autor {
    private String nome;
    private int anoNascimento;
    private int anoFalecimento;
    private List<String> livros;

    public Autor(){};

    public Autor(DadosAutor dadosAutor) {
        this.nome = dadosAutor.name();
        this.anoNascimento = dadosAutor.birthYear();
        this.anoFalecimento = dadosAutor.deathYear();
        this.livros = new ArrayList<>();
    }

    public void adicionarLivro(Livro livroAdicionado){
        livros.add(livroAdicionado.getTitulo());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public int getAnoFalecimento() {
        return anoFalecimento;
    }

    public void setAnoFalecimento(int anoFalecimento) {
        this.anoFalecimento = anoFalecimento;
    }

    public List<String> getLivros() {
        return livros;
    }

    public void setLivros(List<String> livros) {
        this.livros = livros;
    }

    @Override
    public String toString() {
        return "nome='" + nome + '\'' +
                ", anoNascimento=" + anoNascimento +
                ", anoFalecimento=" + anoFalecimento +
                ", livros=" + livros;
    }
}
