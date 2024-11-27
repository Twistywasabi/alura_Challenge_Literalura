package br.com.alura.Literalura.principal;

import br.com.alura.Literalura.model.*;
import br.com.alura.Literalura.repository.AutorRepository;
import br.com.alura.Literalura.service.ConsumoApi;
import br.com.alura.Literalura.service.ConverteDados;

import java.util.*;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private DadosLivro dadosLivro;
    private DadosAutor dadosAutor;
    private List<Livro> listaLivros;
    private List<Autor> listaAutor;
    private AutorRepository repositorio;

    public Principal(AutorRepository repositorio) {

        this.repositorio = repositorio;

    }

    public void exibeMenu() {
        listaLivros = repositorio.listaLivrosBanco();
        listaAutor = repositorio.findAll();
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
                switch (opcao) {
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
                        listarAutoresVivos();
                        break;
                    case 5:
                        listarLivrosIdioma();
                        break;
                    case 0:
                        System.out.println("Saindo do sistema ...");
                        break;
                    default:
                        System.out.println("Não existe essa opção, tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Só vale caracteres numéricos de 0 a 5, tente novamente.");
                leitura.nextLine();
            }

        }
    }

    private void buscarLivroTitulo() {
        ConsumoApi consumoApi = new ConsumoApi();
        ConverteDados conversor = new ConverteDados();
        System.out.println("Digite um livro para ser procurado");
        String livroProcurado = leitura.nextLine();
        String json = consumoApi.obterDados("https://gutendex.com/books/?search=" + livroProcurado.replace(" ", "+"));
        try {
            RespostaLivros resposta = conversor.obterDados(json, RespostaLivros.class);
            dadosLivro = resposta.results().get(0);
            dadosAutor = dadosLivro.authors().get(0);
            Livro livroEncontrado = new Livro(dadosLivro);
            Autor autorEncontrado = new Autor(dadosAutor);
            autorEncontrado.adicionarLivro(livroEncontrado);
            livroEncontrado.adicionarAutor(autorEncontrado);
            Optional<Autor> autorJaRegistrado = repositorio.findByNomeContainingIgnoreCase(autorEncontrado.getNome());
            if (autorJaRegistrado.isPresent()) {
                List<Livro> livrosBanco = repositorio.livrosJaRegistrados(livroEncontrado.getTitulo());
                if (livrosBanco.isEmpty()) {
                    repositorio.inserirLivroAutorExistente(livroEncontrado.getTitulo(), livroEncontrado.getLingua().toString(), livroEncontrado.getNumeroDownload(), autorJaRegistrado.get().getId());
                    System.out.println("Livro adicionado");

                } else {
                    System.out.println("Livro Já existe no banco de dados");
                }
            } else {
                repositorio.save(autorEncontrado);
                System.out.println("Autor e livro adicionado");
            }

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Nenhum livro encontrado");
        }
    }


    private void listarLivrosRegistrados() {
        listaLivros = repositorio.listaLivrosBanco();
        listaLivros.forEach(System.out::println);

    }

    private void listarAutoresRegistrados() {
        listaAutor = repositorio.findAll();
        System.out.println("Lista de Autores: ");
        for (int i = 0; i < listaAutor.stream().count(); i++) {
            System.out.println("");
            System.out.println("****************************************");
            System.out.println("Nome: " + listaAutor.get(i).getNome());
            System.out.println("Ano de nascimento: " + listaAutor.get(i).getAnoNascimento());
            System.out.println("Ano de falecimento: " + listaAutor.get(i).getAnoFalecimento());
            System.out.println("Livros: ");
            for (int j = 0; j < listaAutor.get(i).getLivros().stream().count(); j++) {
                System.out.println("* " + listaAutor.get(i).getLivros().get(j).getTitulo());
            }
            System.out.println("****************************************");
        }
    }

    private void listarAutoresVivos() {
        System.out.println("Insira o ano que deseja pesquisar: ");
        try {

            int anoPesquisado = leitura.nextInt();
            leitura.nextLine();
            List<Autor> listaAutoresVivos = listaAutor.stream().filter(a -> a.getAnoNascimento() <= anoPesquisado && a.getAnoFalecimento() >= anoPesquisado).toList();
            if (listaAutoresVivos.isEmpty()) {
                System.out.println("Não existe autores vivos nesse ano no banco de dados, tente novamente");
            } else {
                System.out.println("Autores vivos em '" + anoPesquisado + "': ");
                for (int i = 0; i < listaAutoresVivos.stream().count(); i++) {
                    System.out.println("");
                    System.out.println("****************************************");
                    System.out.println("Nome: " + listaAutoresVivos.get(i).getNome());
                    System.out.println("Ano de nascimento: " + listaAutoresVivos.get(i).getAnoNascimento());
                    System.out.println("Ano de falecimento: " + listaAutoresVivos.get(i).getAnoFalecimento());
                    System.out.println("****************************************");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Coloque somente números, não use letras");
            leitura.nextLine();
        }
    }

    private void listarLivrosIdioma() {
        String menuIdiomas = """
                Insira o idioma para realizar a busca:
                es -  espanhol
                en - inglês
                fr - francês
                pt - português
                """;
        System.out.println(menuIdiomas);
        try {

            String idiomaSelecionado = leitura.nextLine();
            Categoria categoriaSelecionado = Categoria.fromString(idiomaSelecionado);
            List<Livro> listaLivrosIdiomaSelecionado = listaLivros.stream().filter(l -> l.getLingua().equals(categoriaSelecionado)).toList();
            if (listaLivrosIdiomaSelecionado.isEmpty()) {
                System.out.println("Não existe livros nesse idioma, tente novamente");
            } else {
                System.out.println("Livros em '" + categoriaSelecionado + "': ");
                listaLivrosIdiomaSelecionado.forEach(System.out::println);
                System.out.println("Quantidade de livros em " + categoriaSelecionado + ": " + listaLivrosIdiomaSelecionado.stream().count());
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Só vale as opções listadas no menu, tente novamente");
        }

    }


}




