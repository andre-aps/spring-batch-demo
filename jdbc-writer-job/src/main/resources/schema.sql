DROP TABLE IF EXISTS cliente;

CREATE TABLE cliente (
    nome TEXT,
    idade INT,
    email VARCHAR(50) PRIMARY KEY,
    faixa_salarial DOUBLE PRECISION
);

DROP TABLE IF EXISTS conta;

CREATE TABLE conta (
    id SERIAL PRIMARY KEY,
    tipo VARCHAR(10) CHECK (tipo IN ('PRATA','OURO','PLATINA','DIAMANTE')),
    limite DOUBLE PRECISION,
    cliente_id VARCHAR(50)
);