package br.com.alura.Literalura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RespostaLivros(
        @JsonProperty("count") int count,
        @JsonProperty("results") List<DadosLivro> results
) {
}
