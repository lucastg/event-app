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

## Iniciar aplicação

Você pode executar o aplicativo usando o comando:

```shell script
./mvnw compile quarkus dev
```

> **_Obs:_**  Depois de executada você pode acessar o [Swagger](http://localhost:8080/q/dev/) da aplicação!