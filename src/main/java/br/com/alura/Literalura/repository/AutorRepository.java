package br.com.alura.Literalura.repository;

import br.com.alura.Literalura.model.Autor;
import br.com.alura.Literalura.model.Categoria;
import br.com.alura.Literalura.model.Livro;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    boolean existsByNomeContainingIgnoreCase(String nomeAutor);
    Optional<Autor> findByNomeContainingIgnoreCase(String nomeAutor);

    @Query("SELECT l FROM Autor a JOIN a.livros l WHERE l.titulo ILIKE :titulo1")
    List<Livro> livrosJaRegistrados(String titulo1);

    @Query(value = "INSERT INTO livros (lingua, numero_download, titulo, autor_id) VALUES (:lingua, :numeroDownload, :titulo, :id) RETURNING autor_id", nativeQuery = true)
    void inserirLivroAutorExistente(String titulo, String lingua, int numeroDownload, Long id);

    @Query("SELECT l FROM Autor a JOIN a.livros l")
    List<Livro> listaLivrosBanco();

}
