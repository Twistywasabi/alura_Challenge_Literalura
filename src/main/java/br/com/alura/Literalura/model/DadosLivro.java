package br.com.alura.Literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivro(

        @JsonProperty("title") String title,
        @JsonProperty("languages") List<String> languages,
        @JsonProperty("authors") List<DadosAutor> authors,
        @JsonProperty("download_count") int downloadNumber

        ) {
}
