# Cadastro de Usuários API

API REST simples para cadastro e autenticação de usuários usando
**Spring Boot**, **Spring Security**, **JWT** e **PostgreSQL**.

## Tecnologias

-   Java
-   Spring Boot
-   Spring Security
-   JWT
-   Spring Data JPA
-   PostgreSQL
-   Lombok

## Funcionalidades

-   Criar usuário
-   Login com JWT
-   Buscar usuário por email
-   Deletar usuário
-   Cadastro de endereços e telefones



### Criar usuário

POST /usuario

### Login

POST /usuario/login

### Buscar usuário

GET /usuario?email=email@exemplo.com

### Deletar usuário

DELETE /usuario/{email}

## Banco de dados

Configuração no `application.properties`:

spring.datasource.url=jdbc:postgresql://localhost:5432/db_usuario
spring.datasource.username=postgres spring.datasource.password=1234

spring.jpa.hibernate.ddl-auto=update

mvn spring-boot:run

## Autor

Brenno Albuquerque
