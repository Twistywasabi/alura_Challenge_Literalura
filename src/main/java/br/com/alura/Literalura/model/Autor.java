package br.com.alura.Literalura.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nome;
    private int anoNascimento;
    private int anoFalecimento;
    @OneToMany(mappedBy = "autor",cascade = CascadeType.ALL)
    private List<Livro> livros = new ArrayList<>();

    public Autor(){};

    public Autor(DadosAutor dadosAutor) {
        this.nome = dadosAutor.name();
        this.anoNascimento = dadosAutor.birthYear();
        this.anoFalecimento = dadosAutor.deathYear();
    }

    public void adicionarLivro(Livro livroAdicionado){
        livros.add(livroAdicionado);
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

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    @Override
    public String toString() {
        return "nome='" + nome + '\'' +
                ", anoNascimento=" + anoNascimento +
                ", anoFalecimento=" + anoFalecimento /*+
                ", livros='" + livros.get(0).getTitulo()+ '\''*/;
    }
}
