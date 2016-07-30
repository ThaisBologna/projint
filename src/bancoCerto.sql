CREATE TABLE public.login
(
  id SERIAL NOT NULL ,
  login character varying(30) NOT NULL,
  senha character varying(30) NOT NULL,
  email character varying(50) NOT NULL,
  tipo character varying(10) NOT NULL,
  CONSTRAINT login_pkey PRIMARY KEY (id),
  CONSTRAINT login_email_key UNIQUE (email),
  CONSTRAINT login_login_key UNIQUE (login)
);

CREATE TABLE public.usuario
(
  id_usuario serial NOT NULL,
  id integer,
  nome character varying(100) NOT NULL,
  datanasc date NOT NULL,
  cidade character varying(50) NOT NULL,
  sexo character varying(20) NOT NULL,
  telefone character varying(20) NOT NULL,
  CONSTRAINT usuario_pkey PRIMARY KEY (id_usuario),
  CONSTRAINT usuario_id_fkey FOREIGN KEY (id)
      REFERENCES public.login (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);
CREATE TABLE public.banda
(
  id_banda serial NOT NULL,
  id integer,
  nome character varying(100) NOT NULL,
  descricao character varying(300) NOT NULL,
  telefone character varying(50) NOT NULL,
  estilo character varying(20) NOT NULL,
  CONSTRAINT banda_pkey PRIMARY KEY (id_banda),
  CONSTRAINT banda_id_fkey FOREIGN KEY (id)
      REFERENCES public.login (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE public.empresa
(
  id_empresa serial NOT NULL,
  id integer,
  nome character varying(100) NOT NULL,
  razao character varying(100) NOT NULL,
  descricao character varying(300) NOT NULL,
  telefone character varying(20) NOT NULL,
  localizacao character varying(100) NOT NULL,
  horafunc character varying(50) NOT NULL,
  tipoemp character varying(20) NOT NULL,
  tipolocal character varying(20) NOT NULL,
  CONSTRAINT empresa_pkey PRIMARY KEY (id_empresa),
  CONSTRAINT empresa_id_fkey FOREIGN KEY (id)
      REFERENCES public.login (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);


CREATE TABLE public.evento
(
  id_evento serial NOT NULL,
  id_empresa integer,
  id_banda integer,
  nome character varying(100) NOT NULL,
  cidade character varying(100) NOT NULL,
  horario TIMESTAMP NOT NULL,
  descricao character varying(500) NOT NULL,
  regiao character varying(50) NOT NULL,
  endereço character varying(200) NOT NULL,
  preco double precision,
  status character varying(25) NOT NULL,
  imagem character varying(5) NOT NULL,
  CONSTRAINT evento_pkey PRIMARY KEY (id_evento),
  CONSTRAINT evento_id_banda_fkey FOREIGN KEY (id_banda)
      REFERENCES public.banda (id_banda) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT evento_id_empresa_fkey FOREIGN KEY (id_empresa)
      REFERENCES public.empresa (id_empresa) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

ALTER TABLE empresa RENAME COLUMN nome TO nome_empresa;
ALTER TABLE usuario RENAME COLUMN nome TO nome_usuario;
ALTER TABLE banda RENAME COLUMN nome TO nome_banda;
ALTER TABLE evento RENAME COLUMN nome TO nome_evento;

create table cidades(
	id_cidade serial,
	cidade varchar(50),
	primary key(id_cidade)
	);
	
INSERT INTO cidades (cidade)
VALUES	('Campinas'),
	('Hortolândia'),
        ('Paulínia'),
	('Nova Odessa'),
	('Indaituba'),
	('Valinhos'),
	('Vinhedo'),
	('Sumaré');
