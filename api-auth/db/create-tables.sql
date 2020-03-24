-- Criação de usuário para o banco de dados

CREATE USER api_user WITH PASSWORD 'springisawesome';

-- Criação da tabela para o controle de usuários

CREATE TABLE public.users
(
    id bigint NOT NULL,
    codigo bigint NOT NULL,
    nome character varying(200) COLLATE pg_catalog."default" NOT NULL,
    cargo character varying(30) COLLATE pg_catalog."default" NOT NULL,
    email character varying(50) COLLATE pg_catalog."default" NOT NULL,
    senha character varying(8) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT users_id_pk PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.users
    OWNER TO api_user;

--- Copiando os dados dos usuários para o banco de dados a partir de um arquivo em csv

\COPY public.users FROM '/home/abner/spring-vue-auth/api-auth/db/users.csv' DELIMITER ';' CSV HEADER;
