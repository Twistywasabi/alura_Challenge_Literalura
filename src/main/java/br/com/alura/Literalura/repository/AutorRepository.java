package br.com.alura.Literalura.repository;

import br.com.alura.Literalura.model.Autor;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    boolean existsByNomeContainingIgnoreCase(String nomeAutor);

}
