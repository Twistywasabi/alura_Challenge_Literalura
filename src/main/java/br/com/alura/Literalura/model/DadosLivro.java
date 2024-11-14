package br.com.alura.Literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DadosLivro(
        @JsonAlias("title") String titulo,
        @JsonAlias("name") String autor,
        @JsonAlias("languages") String idioma,
        @JsonAlias("download_count") long numeroDownload) {
}
