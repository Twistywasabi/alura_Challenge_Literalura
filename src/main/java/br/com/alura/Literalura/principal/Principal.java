package br.com.alura.Literalura.principal;

import br.com.alura.Literalura.model.*;
import br.com.alura.Literalura.service.ConsumoApi;
import br.com.alura.Literalura.service.ConverteDados;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private DadosLivro dadosLivro;
    private List<Livro> listaLivros = new ArrayList<>();
    private List<Autor> listaAutor = new ArrayList<>();
    private DadosAutor dadosAutor;

    public void exibeMenu() {
        var opcao = -1;

        String menu = """
                
                -----------------------------
                Escolha o número de sua opção: 
                
                1 - Buscar livro pelo título
                2 - Listar livros registrados
                3 - Listar autores registrados
                4 - Listar autores vivos em um determinado ano
                5 - Listar livros em um determinado idioma
                0 - Sair
                -----------------------------
                """;

        while (opcao != 0) {
            System.out.println(menu);
            try {
                opcao = leitura.nextInt();
                leitura.nextLine();
                switch (opcao){
                    case 1:
                        buscarLivroTitulo();
                        break;
                    case 2:
                        listarLivrosRegistrados();
                        break;
                    case 3:
                        listarAutoresRegistrados();
                        break;
                    case 4:
                        System.out.println("Caso 4");
                        break;
                    case 5:
                        System.out.println("Caso 5");
                        break;
                    case 0:
                        System.out.println("Saindo do sistema ...");
                        break;
                    default:
                        System.out.println("Não existe essa opção, tente novamente.");
                }
            } catch (InputMismatchException e) {
                leitura.nextLine();
                System.out.println("Só vale caracteres numéricos de 0 a 5, tente novamente.");
            }

        }
    }




    private void buscarLivroTitulo() {
        ConsumoApi consumoApi = new ConsumoApi();
        ConverteDados conversor = new ConverteDados();
        System.out.println("Digite um livro para ser procurado");
        String livroProcurado = leitura.nextLine();
        String json = consumoApi.obterDados("https://gutendex.com/books/?search=" + livroProcurado.replace(" ", "+"));
        System.out.println(json);
        try {
            RespostaLivros resposta = conversor.obterDados(json, RespostaLivros.class);
            dadosLivro = resposta.results().get(0);
            System.out.println(dadosLivro);
            Livro livroEncontrado = new Livro(dadosLivro);
            listaLivros.add(livroEncontrado);
            dadosAutor = dadosLivro.authors().get(0);
            Autor autorEncontrado = new Autor(dadosAutor);
            autorEncontrado.adicionarLivro(livroEncontrado);
            listaAutor.add(autorEncontrado);
            System.out.println("Livro adicionado");

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Nenhum livro encontrado");
        }
    }

    private void listarLivrosRegistrados() {
        System.out.println(listaLivros);
    }
    private void listarAutoresRegistrados() {
        System.out.println(listaAutor);
    }

}
