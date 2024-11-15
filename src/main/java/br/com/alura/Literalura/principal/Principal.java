package br.com.alura.Literalura.principal;

import br.com.alura.Literalura.model.DadosLivro;
import br.com.alura.Literalura.service.ConsumoApi;
import br.com.alura.Literalura.service.ConverteDados;

import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);


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
            opcao = leitura.nextInt();
            leitura.nextLine();
            switch (opcao){
                case 1:
                    System.out.println("Caso 1");
                    buscarLivroTitulo();
                    break;
                case 2:
                    System.out.println("Caso 2");
                    break;
                case 3:
                    System.out.println("Caso 3");
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
        }
    }

    private void buscarLivroTitulo() {
        ConverteDados conversor = new ConverteDados();
        ConsumoApi consumoApi = new ConsumoApi();
        String json = consumoApi.obterDados("https://gutendex.com/books/?search=dom+casmurro");
        System.out.println(json);
        DadosLivro dadosLivro = conversor.obterDados(json, DadosLivro.class);
        System.out.println(dadosLivro);
    }
}
