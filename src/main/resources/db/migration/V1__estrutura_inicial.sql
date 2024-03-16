CREATE DATABASE frogpay;

CREATE TABLE IF NOT EXISTS public.tb_pessoa
(
    id uuid,
    nome character varying(50),
    cpf character varying(50),
    data_nascimento date,
    ativo boolean,
    data_criacao timestamp with time zone,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.endereco
(
    id uuid,
    id_pessoa uuid,
    uf_estado character varying(2),
    cidade character varying(500),
    bairro character varying(500),
    logradouro character varying(500),
    numero character varying(20),
    complemento character varying(500),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.tb_dados_bancarios
(
    id uuid,
    id_pessoa uuid,
    codigo_banco character varying(20),
    agencia character varying(20),
    conta character varying(20),
    digito_conta character varying,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.tb_loja
(
    id uuid,
    id_pessoa uuid,
    nome_fantasia character varying(500),
    razao_social character varying(500),
    cnpj character varying(50),
    data_abertura date,
    PRIMARY KEY (id)
);



ALTER TABLE IF EXISTS public.tb_dados_bancarios
    ADD CONSTRAINT id_pessoa FOREIGN KEY (id_pessoa)
    REFERENCES public.tb_pessoa (id) MATCH SIMPLE
    ON UPDATE CASCADE
    ON DELETE CASCADE
    NOT VALID;


ALTER TABLE IF EXISTS public.tb_loja
    ADD CONSTRAINT id_pessoa FOREIGN KEY (id_pessoa)
    REFERENCES public.tb_pessoa (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;




ALTER TABLE IF EXISTS public.endereco
    ADD CONSTRAINT id_pessoa FOREIGN KEY (id_pessoa)
    REFERENCES public.tb_pessoa (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;
