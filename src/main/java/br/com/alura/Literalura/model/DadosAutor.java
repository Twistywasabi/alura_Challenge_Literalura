package br.com.alura.Literalura.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DadosAutor(

        @JsonProperty("name") String name,
        @JsonProperty("birth_year") Integer birthYear,
        @JsonProperty("death_year") Integer deathYear

) {
}
