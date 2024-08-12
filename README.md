# Aplicação de Gerenciamento de Eventos

Este projeto é uma aplicação de gerenciamento de eventos construída com Java 17 e Quarkus. A aplicação permite criar, visualizar, atualizar e excluir eventos, além de associá-los a instituições.

## Pre-requisitos para executar aplicação
* Java 17
* [IntelliJ](https://www.jetbrains.com/idea/download/#section=linux)

## Tecnologias Utilizadas
* Java 17: Linguagem de programação.
* Quarkus: Framework para construir aplicações Java modernas e nativas na nuvem.
* Hibernate ORM: Framework para mapeamento objeto-relacional.
* PostgreSQL: Banco de dados relacional utilizado para persistência.
* Flyway: Ferramenta de migração de banco de dados.
* Lombok: Biblioteca para reduzir o boilerplate no código Java.

## Funcionalidades

* Gerenciamento de Eventos: Criação, edição, exclusão e listagem de eventos.
* Associação a Instituições: Cada evento é associado a uma instituição, e uma instituição pode ter vários eventos.
* Validação de Dados: Uso de validações como @NotNull e @NotBlank para garantir a consistência dos dados.
* Validação de Date: A cada 1 minuto é verificado as datas de inicio e fim do evento para alteração do status.

## Iniciar aplicação

Você pode executar o aplicativo usando o comando:

```shell script
./mvnw compile quarkus dev
```

> **_Obs:_**  Depois de executada você pode acessar o [Swagger](http://localhost:8080/q/dev/) da aplicação!

## Considerações Finais
Esta aplicação foi desenvolvida com foco em fornecer um sistema de gerenciamento de eventos simples, mas eficaz, utilizando as melhores práticas do desenvolvimento Java com Quarkus. 

Contribuições e sugestões são bem-vindas!
