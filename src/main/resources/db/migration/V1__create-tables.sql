CREATE TABLE medicos (
    id BIGSERIAL PRIMARY KEY,
    crm VARCHAR(20) NOT NULL,
    nome VARCHAR(150) NOT NULL,
    especialidade VARCHAR(50) NOT NULL,

    rua VARCHAR(150),
    cep VARCHAR(20),
    numero INTEGER,
    complemento VARCHAR(150)
);

CREATE TABLE pacientes (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,

    cpf VARCHAR(14) UNIQUE NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,

    rua VARCHAR(150),
    cep VARCHAR(20),
    numero INTEGER,
    complemento VARCHAR(150)
);

CREATE TABLE consultas (
    id BIGSERIAL PRIMARY KEY,

    medico_id BIGINT NOT NULL,
    paciente_id BIGINT NOT NULL,

    data TIMESTAMP NOT NULL,
    status VARCHAR(50) NOT NULL,

    CONSTRAINT fk_consulta_medico
        FOREIGN KEY (medico_id)
        REFERENCES medicos(id),

    CONSTRAINT fk_consulta_paciente
        FOREIGN KEY (paciente_id)
        REFERENCES pacientes(id)
);