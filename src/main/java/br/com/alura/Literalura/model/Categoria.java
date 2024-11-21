package br.com.alura.Literalura.model;

public enum Categoria {
    INGLES("en"),
    PORTUGUES("pt"),
    ESPANHOL("es"),
    FRANCES("fr");

    private String categoriaGutendex;

    Categoria(String categoriaGutendex){
        this.categoriaGutendex = categoriaGutendex;
    }

    public static Categoria fromString(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaGutendex.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }

}
