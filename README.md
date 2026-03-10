# 💻 Sobre o projeto
O projeto de clínica foi feito para colocar em prática meus conhecimentos do curso de Domain-Driven Design da plataforma Alura. A ideia é utilizar a arquitetura de DDD ao invés da convencional arquitetura projetada para a persistência.
O Domain-Driven Design preza pelo foco no domínio do negócio, nas classes centrais do sistema. Ao invés de projetar e codificar focando na persistência dos dados, eu arquiteto o sistema com base naquilo que suas principais classes representam (como suas regras de negócio, objetos de valor, etc).

---

# 🛠 Stack utilizada
As seguintes tecnologias foram utilizadas no desenvolvimento da API Rest do projeto:
* `Java` v.21
* `Spring Boot`
* `Spring Data JPA`
* `Postgres`
* `Flyway`
* `JWT`
* `Docker`

---

# 📓 Funcionalidades

- [x] Cadastro de pacientes e médicos;
- [x] Agendamento de consultas;
- [x] Busca de consultas, pacientes e médicos;
- [x] Cancelamento de consultas;

---

## ⚙️ Endpoints

A API expõe os seguintes *endpoints* a partir da *base URL* `localhost:8080`:

Médicos
* `GET /medicos`
* `POST /medicos`
* `GET /medicos/{id}`
* `PUT /medicos/{id}`
* `DELETE /medicos/{id}`

Pacientes
* `GET /pacientes`
* `POST /pacientes`
* `GET /pacientes/{id}`
* `PUT /pacientes/{id}`
* `DELETE /pacientes/{id}`

Consultas
* `POST /consultas`
* `GET /consultas/{id}`
* `DELETE /consultas/{id}`
---

# ▶ Como executar

Subir dependências:

```docker-compose up -d```

Rodar no terminal:

```mvnw spring-boot:run```

Acessar a API a partir da URL:

``http://localhost:8081``
