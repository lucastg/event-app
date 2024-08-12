CREATE SEQUENCE tb_eventos_seq START 1;
CREATE TABLE tb_eventos (
    id SERIAL NOT NULL,
    nome VARCHAR(255) NOT NULL,
    data_inicial TIMESTAMP NOT NULL,
    data_final TIMESTAMP NOT NULL,
    ativo BOOLEAN NOT NULL,
    id_instituicao INTEGER NOT NULL,
    CONSTRAINT fk_instituicao FOREIGN KEY (id_instituicao) REFERENCES tb_instituicao (id)
);