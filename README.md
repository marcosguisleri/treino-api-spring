# 💪 FitFlow API

> API REST para gerenciamento de treinos e exercícios de academia, desenvolvida com Spring Boot.

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![Status](https://img.shields.io/badge/Status-Em%20desenvolvimento-yellow?style=for-the-badge)

---

## 📋 Sobre o projeto

O **FitFlow** é uma API REST desenvolvida como projeto de estudo para o gerenciamento de treinos de academia. A proposta é permitir que alunos tenham seus treinos organizados com nome, exercícios, séries, repetições e dias da semana, eliminando a confusão de papéis e fichas físicas.

O projeto está sendo desenvolvido ao longo de uma pós-graduação em desenvolvimento backend com foco na stack Java, aplicando boas práticas de mercado desde a modelagem do banco até a arquitetura da API.

---

## 🗂️ Modelagem do banco de dados

```
tb_alunos         tb_treinos              tb_treino_exercicios     tb_exercicios
─────────         ──────────              ────────────────────     ─────────────
id           ←── aluno_id (FK)      ┌─── treino_id (FK)           id
nome             id              ───┤    id                    ───→ nome
dta_nascimento   nome               └─── exercicio_id (FK)         grupo_muscular
dta_matricula    dias_semana              series
status                                   repeticoes
                                         ordem
```

**Relacionamentos:**
- `tb_alunos` → `tb_treinos` — Um aluno pode ter vários treinos **(1:N)**
- `tb_treinos` ↔ `tb_exercicios` — Um treino tem vários exercícios e um exercício pode aparecer em vários treinos **(N:M)**, resolvido via `tb_treino_exercicios`

---

## 🚀 Tecnologias utilizadas

| Tecnologia | Finalidade |
|---|---|
| Java 17 | Linguagem principal |
| Spring Boot 3.x | Framework principal |
| Spring Data JPA | Mapeamento objeto-relacional |
| Spring Validation | Validação de requisições |
| PostgreSQL 16 | Banco de dados relacional |
| Docker + Docker Compose | Ambiente de banco de dados local |
| Lombok | Redução de boilerplate |
| Maven | Gerenciamento de dependências |

---

## ⚙️ Pré-requisitos

- [Java 17+](https://adoptium.net/)
- [Docker Desktop](https://www.docker.com/products/docker-desktop/)
- [Maven 3.8+](https://maven.apache.org/)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/) (recomendado)

---

## 🐳 Subindo o banco de dados

O banco de dados roda via Docker. Com o Docker Desktop aberto, execute na raiz do projeto:

```bash
docker-compose up -d
```

Para parar:

```bash
docker-compose down
```

---

## 🔧 Configuração local

O projeto usa o padrão de duas camadas de configuração para proteger credenciais.

O arquivo `application.properties` contém os placeholders:

```properties
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
```

Crie um arquivo `application-local.properties` na mesma pasta (já ignorado pelo `.gitignore`) com suas credenciais reais:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/fitflow
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

Nas configurações de execução do IntelliJ, ative o profile `local`:

```
Active profiles: local
```

---

## ▶️ Executando o projeto

```bash
mvn spring-boot:run
```

A API estará disponível em `http://localhost:8080`.

---

## 📁 Estrutura do projeto

```
src/main/java/br/dev/guisleri/treinoapispring/
├── controller/       # Endpoints REST
├── dto/              # Objetos de transferência de dados (request e response)
│   ├── request/
│   └── response/
├── model/            # Entidades JPA
│   └── enums/        # Enumerações (GrupoMuscular, DiaSemana)
├── repository/       # Interfaces Spring Data JPA
└── service/          # Regras de negócio
```

---

## 🔗 Endpoints

> Em construção. A documentação completa via Swagger será adicionada em breve.

| Método | Rota | Descrição |
|---|---|---|
| `POST` | `/alunos` | Cadastrar aluno |
| `GET` | `/alunos` | Listar alunos |
| `GET` | `/alunos/{id}` | Buscar aluno por ID |
| `PUT` | `/alunos/{id}` | Atualizar aluno |
| `DELETE` | `/alunos/{id}` | Remover aluno |
| `POST` | `/treinos` | Cadastrar treino |
| `GET` | `/treinos/{id}` | Buscar treino com exercícios |
| `POST` | `/exercicios` | Cadastrar exercício |
| `GET` | `/exercicios` | Listar exercícios |

---

## 📌 Boas práticas aplicadas

- Conventional Commits para padronização do histórico Git
- Configuração segura com separação de credenciais via Spring Profiles
- DTOs separados por responsabilidade (request / response)
- Enums para valores controlados (`GrupoMuscular`, `DiaSemana`)
- Entidade associativa para relacionamentos N:M com atributos extras

---

## 👨‍💻 Autor

Desenvolvido por **Marcos Guisleri** como projeto de estudo durante a pós-graduação em desenvolvimento backend.

[![GitHub](https://img.shields.io/badge/GitHub-guisleri-181717?style=flat-square&logo=github)](https://github.com/guisleri)
