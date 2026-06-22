# 📝 Projeto Todo List

Sistema de gerenciamento de tarefas desenvolvido para estudos de desenvolvimento Full Stack utilizando Spring Boot, SQL Server e Nuxt.

## 🚀 Tecnologias Utilizadas

### Backend

* Java 17+
* Spring Boot 3
* Spring Data JPA
* Hibernate
* Bean Validation
* Lombok
* SQL Server
* Maven

### Frontend

* Nuxt 4
* Vue 3
* Pinia
* Bootstrap 5
* Sass

## 📂 Estrutura do Projeto

```text
projeto-todolist
├── todolist/           # Backend Spring Boot
├── todolist-front/     # Frontend Nuxt
└── README.md
```

## ⚙️ Configuração do Banco de Dados

Criar um banco chamado:

```sql
CREATE DATABASE dt_todolist;
```

Configuração utilizada no backend:

```properties
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=dt_todolist;encrypt=true;trustServerCertificate=true
spring.datasource.username=sa
spring.datasource.password=SuaSenha

spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver

spring.jpa.database-platform=org.hibernate.dialect.SQLServerDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## ▶️ Executando o Backend

Entrar na pasta:

```bash
cd todolist
```

Instalar dependências:

```bash
mvn clean install
```

Executar aplicação:

```bash
mvn spring-boot:run
```

Ou:

```bash
./mvnw spring-boot:run
```

A API estará disponível em:

```text
http://localhost:8080
```

## ▶️ Executando o Frontend

Entrar na pasta:

```bash
cd todolist-front
```

Instalar dependências:

```bash
npm install
```

Executar em modo desenvolvimento:

```bash
npm run dev
```

A aplicação estará disponível em:

```text
http://localhost:3000
```

## 📌 Funcionalidades

* Cadastro de usuários
* Atualização de usuários
* Exclusão de usuários
* Cadastro de tarefas
* Atualização de tarefas
* Exclusão de tarefas
* Controle de status das tarefas
* Integração Frontend e Backend através de API REST

## 📚 Objetivo do Projeto

Este projeto foi desenvolvido com foco em aprendizado de:

* Arquitetura REST
* Spring Boot
* JPA/Hibernate
* SQL Server
* Vue 3
* Nuxt 4
* Pinia
* Integração entre frontend e backend

## 🎓 Créditos e Referências

Este projeto foi desenvolvido com base nos conhecimentos adquiridos no curso introdutório de Java com Spring Boot da Rocketseat.

Curso realizado:
https://app.rocketseat.com.br/jornada/java-com-spring-boot-curso-introdutorio/sala/minicurso-java/grupo/minicurso-java/aula/tabela-de-task

Durante o curso foram abordados conceitos como:

* Criação de APIs REST
* Spring Boot
* Persistência de dados com JPA
* Estruturação de projetos backend
* Boas práticas de desenvolvimento

O projeto foi adaptado e expandido por Bruno Neves para fins de aprendizado e prática.

## 👨‍💻 Autor

Bruno Neves

Curso: Ciência da Computação

GitHub:
https://github.com/bruno-b-neves
