# Literalura 🚩

Desafio da Alura baseada no curso "Praticando Spring Boot: Challenge LiterAlura"

## Objetivo 📜

Criar uma aplicação CLI de uma livraria, onde o usuário pode adicionar livros, procurar autores vivos em um determinado ano e listar livros em um determinado idioma. Além disso, esses dados são persistidos em um banco de dados SQL. 

A API que disponibiliza os dados do livro vem do site https://gutendex.com/ (os detalhes de como funciona a requisição estão lá no site do desenvolvedor).

## Ferramentas e tecnologias 👨‍💻

- JAVA 17
- Spring Initializr
    - Spring Data JPA
    - PostgreSQL Driver
    - Spring Boot 3.3.5
- PostgreSQL
- Postman
- Jackson 2.16.2
- Maven
- Gutendex (https://gutendex.com/)

## Resultados 🎁

![Alt text](/src/img/result.PNG)

## Referências 📚

- https://gutendex.com/
- https://trello.com/b/eLc9Sj1A/literalura-challenge-java
- https://stackoverflow.com/questions/51923591/how-to-retrieve-a-value-from-an-array-inside-of-a-json-object-using-jackson
- https://www.baeldung.com/jackson-json-node-tree-model
- https://jenkov.com/tutorials/java-json/jackson-jsonnode.html#jsonnode-vs-objectnode
- https://www.concretepage.com/jackson-api/jackson-jsonproperty-and-jsonalias-example
- https://www.devmedia.com.br/introducao-ao-jackson-objectmapper/43174
- https://mkyong.com/java/jackson-convert-json-array-string-to-list/
- https://www.baeldung.com/spring-data-exists-query
- https://docs.spring.io/spring-data/jpa/reference/#repositories
- https://www.youtube.com/watch?v=vOJdflliU_E
- https://dev.to/darkmavis1980/the-returning-clause-in-sql-11k2

## Atualizações 🕐

- 2024/11/27 - Primeira versão do aplicativo

## Pendências 🚨

- Melhorar To String de livros para a opção "Listar Livros Registrados"
- Outra forma de fazer inserção de Livro dentro de uma lista de livros de um Autor já existente
- Transformar em uma aplicação WEB

Caso queira se desafiar ainda mais e proporcionar aos usuários uma experiência mais rica e personalizada, existem diversas funcionalidades interessantes que você pode explorar:
- Gerando estatísticas: Começamos as sugestões de funcionalidades opcionais lembrando da classe DoubleSummaryStatistics, usada para obter dados estatísticos de um objeto Java. É possível obter esses dados seja de consultas na API ou no banco de dados.
- Top 10 livros mais baixados: Assim como foi apresentado no curso Java: trabalhando com lambdas, streams e Spring Framework, é possível apresentar os dados dos 10 livros mais baixados, sendo uma consulta diretamente feita na API ou no banco de dados.
- Buscar autor por nome: Se você deu uma olhada no site da API, é possível realizar a busca por livro ou autor com a consulta feita com search? - no entanto, neste caso, desafiamos você a realizar a consulta por nome de autor no banco de dados criado para nosso projeto.
- Listar autores com outras consultas: Aqui deixamos como sugestão implementar outras consultas com os atributos de ano de nascimento e falecimento dos autores. Sinta-se livre para explorar e implementar essas características adicionais.
Desafie-se a implementar essas características e transforme seu projeto em uma ferramenta ainda mais poderosa e versátil!