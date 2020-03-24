# API Spring Boot PostgreSQL

[![Docker](https://img.shields.io/badge/docker-latest-green)](https://www.docker.com/)
[![Postgres](https://img.shields.io/badge/postgres-latest-green)](https://www.postgresql.org/)

Scripts em SQL para criar as tabelas e migrar os dados para um banco PostgreSQL e executar em um container docker.

## Criação do contêiner docker

```
## Download do repositório oficial
$ docker pull postgres

## Execução do contêiner
$ docker run --name some-postgres -p 5480:5432 -e POSTGRES_PASSWORD=postgres -d postgres
```

## Ambiente PSQL
```
## Instalação do ambiente psql CLI interface da linha de comando
$ sudo apt install postgresql
```

## Migração dos dados
```
## Criação do banco de dados para a migração
$ createdb -h 0.0.0.0 -p 5480 -U postgres db_users "Dados para o controle de usuários na api spring boot"

## Alterando as permissões (exemplo)
$ sudo chmod 777 -R /home/abner/spring-vue-auth/api-auth/db

## Criação do usuario Postgres para a API e migração dos dados em csv
$ psql -h 0.0.0.0 -p 5480 -U postgres -d db_users -f create_tables.sql
```